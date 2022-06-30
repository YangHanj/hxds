package iee.yh.hxds.mps.service;

import java.util.HashMap;

/**
 * @author yanghan
 * @date 2022/6/29
 */
public interface MapService {
    /**
     *
     * @param mode 出行方式
     * @param startPlaceLatitude 起点纬度坐标
     * @param startPlaceLongitude 起点经度坐标
     * @param endPlaceLatitude 终点纬度坐标
     * @param endPlaceLongitude 终点经度坐标
     * @return
     */
    HashMap estimateOrderMileageAndMinute(
            String mode,
            String startPlaceLatitude,
            String startPlaceLongitude,
            String endPlaceLatitude,
            String endPlaceLongitude
    );

    /**
     *
     * @param startPlaceLatitude 起点纬度坐标
     * @param startPlaceLongitude 起点经度坐标
     * @param endPlaceLatitude 终点纬度坐标
     * @param endPlaceLongitude 终点经度坐标
     * @return
     */
    public HashMap calculateDriveLine(String startPlaceLatitude,
                                      String startPlaceLongitude,
                                      String endPlaceLatitude,
                                      String endPlaceLongitude);
}
