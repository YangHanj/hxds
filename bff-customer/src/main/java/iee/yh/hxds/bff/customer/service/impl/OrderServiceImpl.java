package iee.yh.hxds.bff.customer.service.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.IdUtil;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import iee.yh.common.util.R;
import iee.yh.hxds.bff.customer.controller.form.CreateNewOrderForm;
import iee.yh.hxds.bff.customer.controller.form.EstimateOrderMileageAndMinuteForm;
import iee.yh.hxds.bff.customer.controller.form.InsertOrderForm;
import iee.yh.hxds.bff.customer.feign.MpsServiceApi;
import iee.yh.hxds.bff.customer.feign.OdrServiceApi;
import iee.yh.hxds.bff.customer.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @author yanghan
 * @date 2022/6/30
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private MpsServiceApi mpsServiceApi;
    @Resource
    private OdrServiceApi odrServiceApi;
    @Transactional
    @Override
    @LcnTransaction
    public int createNewOrder(CreateNewOrderForm form) {
        Long customerId = form.getCustomerId();
        String startPlace = form.getStartPlace();
        String startPlaceLatitude = form.getStartPlaceLatitude();
        String startPlaceLongitude = form.getStartPlaceLongitude();
        String endPlace = form.getEndPlace();
        String endPlaceLatitude = form.getEndPlaceLatitude();
        String endPlaceLongitude = form.getEndPlaceLongitude();
        String favourFee = form.getFavourFee();

        /**
         * 【重新预估里程和时间】
         * 虽然下单前，系统会预估里程和时长，但是有可能顾客在下单页面停留时间过长，
         * 然后再按下单键，这时候路线和时长可能都有变化，所以需要重新预估里程和时间
         */
        EstimateOrderMileageAndMinuteForm form_1 = new EstimateOrderMileageAndMinuteForm();
        form_1.setMode("driving");
        form_1.setStartPlaceLatitude(startPlaceLatitude);
        form_1.setStartPlaceLongitude(startPlaceLongitude);
        form_1.setEndPlaceLatitude(endPlaceLatitude);
        form_1.setEndPlaceLongitude(endPlaceLongitude);
        R r = mpsServiceApi.estimateOrderMileageAndMinute(form_1);
        HashMap map = (HashMap) r.get("result");
        String mileage = MapUtil.getStr(map, "mileage");
        int minute = MapUtil.getInt(map, "minute");

        /**
         * TODO 创建新订单,价格计算,后续采用规则引擎
         */
        //*************模拟**************
        String chargeRuleId = "1";
        Short baseMileage = 8;
        String baseMileagePrice = "40";
        String exceedMileagePrice = "4";
        Short baseMinute = 10;
        String exceedMinutePrice = "1.0";
        Short baseReturnMileage = 8;
        String exceedReturnPrice = "1";
        String expectsFee = "";
        if(Integer.parseInt(mileage) - 8 > 0){
            expectsFee = (Integer.parseInt(mileage) * 5 - 8 * 4 + Integer.parseInt(baseMileagePrice)) + "";
        }else{
            expectsFee = baseMileagePrice;
        }
        //******************************

        /**
         * TODO 搜索合适的接单司机
         */

        /**
         * TODO 如果存在适合接单的司机就创建订单,否则不创建
         */

        /**
         * 生成订单记录
         */
        InsertOrderForm form_4 = new InsertOrderForm();
        //UUID字符串，充当订单号，微信支付时候会用上
        form_4.setUuid(IdUtil.simpleUUID());
        form_4.setCustomerId(customerId);
        form_4.setStartPlace(startPlace);
        form_4.setStartPlaceLatitude(startPlaceLatitude);
        form_4.setStartPlaceLongitude(startPlaceLongitude);
        form_4.setEndPlace(endPlace);
        form_4.setEndPlaceLatitude(endPlaceLatitude);
        form_4.setEndPlaceLongitude(endPlaceLongitude);
        form_4.setExpectsMileage(mileage);
        form_4.setExpectsFee(expectsFee); // 预估代价费用
        form_4.setFavourFee(favourFee);
        form_4.setDate(new DateTime().toDateStr());
        form_4.setChargeRuleId(Long.parseLong(chargeRuleId)); // 规则ID
        form_4.setCarPlate(form.getCarPlate());
        form_4.setCarType(form.getCarType());
        form_4.setBaseMileage(baseMileage); // 基础里程
        form_4.setBaseMileagePrice(baseMileagePrice); // 基础里程价格
        form_4.setExceedMileagePrice(exceedMileagePrice); // 超出基础里程的价格
        form_4.setBaseMinute(baseMinute); // 基础分钟
        form_4.setExceedMinutePrice(exceedMinutePrice); // 超出基础分钟的价格
        form_4.setBaseReturnMileage(baseReturnMileage); // 基础返程里程（公里）
        form_4.setExceedReturnPrice(exceedReturnPrice); // 超出基础返程里程的价格

        r = odrServiceApi.insertOrder(form_4);
        String orderId = MapUtil.getStr(r, "result");

        //TODO  发送通知给符合条件的司机抢单
        return 0;
    }
}
