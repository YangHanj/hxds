package iee.yh.hxds.dr.db.dao;

import iee.yh.hxds.dr.db.pojo.DriverSettingsEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * @Entity com.example.hxdsdr.db.pojo.DriverSettingsEntity
 */
@Mapper
public interface DriverSettingsDao {
    /**
     * 插入司机的设定
     * @param entity :
     * <br/>{ <br/>
     *   "autoAccept": 1, //自动抢单<br/>
     *   "orientation": "", //定向接单<br/>
     *   "listenService": true,  //自动听单<br/>
     *   "orderDistance": 0, //代驾订单预估里程不限，司机不挑订单<br/>
     *   "rangeDistance": 5  //接收距离司机5公里以内的代驾单<br/>
     * }
     * @return
     */
    int insertDriverSettings(DriverSettingsEntity entity);
}




