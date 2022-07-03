package iee.yh.hxds.odr.service.impl;

import cn.hutool.core.map.MapUtil;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import iee.yh.common.exception.HxdsException;
import iee.yh.hxds.odr.db.dao.OrderBillDao;
import iee.yh.hxds.odr.db.dao.OrderDao;
import iee.yh.hxds.odr.db.pojo.OrderBillEntity;
import iee.yh.hxds.odr.db.pojo.OrderEntity;
import iee.yh.hxds.odr.service.OrderService;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author yanghan
 * @date 2022/6/25
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private OrderBillDao orderBillDao;

    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public HashMap searchDriverTodayBusinessData(long driverId) {
        HashMap result = orderDao.searchDriverTodayBusinessData(driverId);
        String duration = MapUtil.getStr(result, "duration");
        if (duration == null){
            duration = "0";
        }
        result.replace("duration",duration);

        String income = MapUtil.getStr(result, "income");
        if (income == null){
            income = "0.00";
        }
        result.replace("income",income);
        return result;
    }

    @Override
    @Transactional
    @LcnTransaction
    public String insertOrder(OrderEntity orderEntity, OrderBillEntity billEntity) {
        int insert = orderDao.insert(orderEntity);
        if (insert == 1){
            // 通过uuid获取主键id
            String id = orderDao.searchOrderIdByUUID(orderEntity.getUuid());
            // 插入订单费用
            billEntity.setOrderId(Long.parseLong(id));
            int insert1 = orderBillDao.insert(billEntity);
            if (insert1 == 1){
                // 缓存数据进入redis，配合司机抢单
                redisTemplate.opsForValue().setIfAbsent("order#"+id,"none",15, TimeUnit.MINUTES);
                return id;
            }else
                throw new HxdsException("保存新账单失败");
        }else
            throw new HxdsException("保存新订单失败");
    }

    @Override
    @Transactional
    @LcnTransaction
    public String acceptNewOrder(long driverId, long orderId) {
        // redis不存在抢单的新订单就代表抢单失败
        if(!redisTemplate.hasKey("order#"+orderId)){
            return "抢单失败!";
        }
        // 执行redis事务
        redisTemplate.execute(new SessionCallback() {
            @Override
            public Object execute(RedisOperations operations) throws DataAccessException {
                // 获取新订单记录的Version
                operations.watch("order#"+orderId);
                // 本地缓存redis操作
                operations.multi();
                // 把新订单缓存的Value设置成抢单司机的ID
                operations.opsForValue().set("order#"+orderId,driverId);
                // 执行redis事务,如果事务提交失败会自动抛出异常
                return operations.exec();
            }
        });
        //抢单成功之后，删除Redis中的新订单，避免让其他司机参与抢单
        redisTemplate.delete("order#" + orderId);
        //更新订单记录，添加上接单司机ID和接单时间
        HashMap param = new HashMap() {{
            put("driverId", driverId);
            put("orderId", orderId);
        }};
        int rows = orderDao.acceptNewOrder(param);
        if (rows != 1) {
            throw new HxdsException("接单失败，无法更新订单记录");
        }
        return "接单成功";
    }

}
