package iee.yh.hxds.mps.service;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author yanghan
 * @date 2022/7/1
 */
public interface DriverLocationService {

    /**
     * 缓存司机定位
     * @param param
     */
    void updateLocationCache(Map param);

    /**
     * 移除司机缓存定位
     * @param driverId
     */
    void removeLocationCache(long driverId);

    /**
     * 查询附近接单司机
     * @param startPlaceLatitude 起点坐标
     * @param startPlaceLongitude 起点坐标
     * @param endPlaceLatitude 终点坐标
     * @param endPlaceLongitude 终点坐标
     * @param mileage 总里程
     * @return
     */
    ArrayList searchBefittingDriverAboutOrder(double startPlaceLatitude,
                                              double startPlaceLongitude,
                                              double endPlaceLatitude,
                                              double endPlaceLongitude,
                                              double mileage);
}


