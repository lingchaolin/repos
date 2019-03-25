package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import model.BicycleInfo;

public interface BicycleInfoMapper {

    BicycleInfo selectBicycleByCard(int cardId);

    void bicycleRented(@Param("bicycleId")int bicycleId, @Param("cardId")int cardId);
    
    @Update("update bicycle_info set status=4,pile_id='' where pile_id=#{pileId}")
    public int updateStatus(int pileId);
    
    public List<BicycleInfo> selectPileIdBicycle();
    
    @Update("update bicycle_info set status=5,pile_id=#{pileId} where bicycle_id=#{bicycleId}")
    public int updateInStatus(BicycleInfo bi);
    
    List allBicycleInfo(Map map);


    void bicycleReturned(@Param("bicycleId")int bicycleId, @Param("pileId")int pileId);

    //将车桩清空 状态改为5车辆维修调出
    @Update("update bicycle_info set\n" +
    		"            status=5,pile_id=null\n" +
    		"        where\n" +
    		"            bicycle_id=#{bikeID}")
    public int bikeMaintain(Integer bikeID);

    //查询车桩ID
    @Select("select PILE_ID from BICYCLE_INFO where BICYCLE_ID=#{bikeID}")
     public Integer selectPileId(int bikeID);

    //查询维修 调出的车
    @Select("select bi.bicycle_id bicycleID,bi.bicycle_code bicycleCode,bi.status,bi.pile_id pileID,bi.DESTORY_DATE destroyDate,\n" +
    		"    bi.USER_ID userID,bi.OPERATOR_TIME operatorTime,bi.CARD_ID cardID,bi.REMARK remark "
    		+ " from BICYCLE_INFO bi "
    		+ "where STATUS=5")
    public List<BicycleInfo> selectMaintainBike();

    //查询状态为维修调出并且维修成功可以调入车桩的车
    @Select("select \n" +
    		"    bi.bicycle_id bicycleID,bi.bicycle_code bicycleCode,bi.status,bi.pile_id pileID,bi.DESTORY_DATE destroyDate,\n" +
    		"    bi.USER_ID userID,bi.OPERATOR_TIME operatorTime,bi.CARD_ID cardID,bi.REMARK remark \n" +
    		"from\n" +
    		"    BICYCLE_INFO bi,REPAIR_RECORD rd\n" +
    		"where\n" +
    		"    bi.status='5' and bi.bicycle_id=rd.bicycle_id and rd.repair_result='1'")
    public List<BicycleInfo> selectCanMaintainInBike();

    //查询可以报废的车辆
    @Select("select \n" +
    		"    bi.bicycle_id bicycleID,bi.bicycle_code bicycleCode,bi.status,bi.pile_id pileID,bi.DESTORY_DATE destroyDate,\n" +
    		"    bi.USER_ID userID,bi.OPERATOR_TIME operatorTime,bi.CARD_ID cardID,bi.REMARK remark \n" +
    		"from\n" +
    		"    BICYCLE_INFO bi,REPAIR_RECORD rd\n" +
    		"where\n" +
    		"    bi.status='5' and bi.bicycle_id=rd.bicycle_id and rd.repair_result='2'")
    public List<BicycleInfo> selectCanScrapBike();

    //报废车辆 修改车辆 的状态为 6报废
    @Update("update bicycle_info set\n" +
    		"            status=6,pile_id=null\n" +
    		"        where\n" +
    		"            bicycle_id=#{bikeID}")
    public int scrapBike(Integer bikeID);

  //报废车辆 修改车辆 的状态为 7维修调入(应该改成3 在桩)
    @Update("update bicycle_info set\n" +
    		"            status=3,pile_id=#{pileID}\n" +
    		"        where\n" +
    		"            bicycle_id=#{bicycleID}")
    public int maintainBikeIn(BicycleInfo bicycleInfo);

}
