package dao;

import org.apache.ibatis.annotations.Param;

import java.util.Map;

//车辆费用统计
public interface BicycleStaMapper {

//    Integer bicycleCount(@Param("startDay") String startDay, @Param("endDay") String endDay);
//
//    Integer bicycleRecordCount(@Param("startDay") String startDay, @Param("endDay") String endDay);
//
//    Integer repairRecordCount(@Param("startDay") String startDay, @Param("endDay") String endDay);

    Map bicycleSta(@Param("startDay") String startDay, @Param("endDay") String endDay);

    Map bicycleInfoSta(Integer bicycleId);
}
