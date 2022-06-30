package iee.yh.hxds.odr.service.impl;

import cn.hutool.core.map.MapUtil;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import iee.yh.common.exception.HxdsException;
import iee.yh.hxds.odr.db.dao.OrderBillDao;
import iee.yh.hxds.odr.db.dao.OrderDao;
import iee.yh.hxds.odr.db.pojo.OrderBillEntity;
import iee.yh.hxds.odr.db.pojo.OrderEntity;
import iee.yh.hxds.odr.service.OrderService;
import org.springframework.data.redis.core.RedisTemplate;
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

}
