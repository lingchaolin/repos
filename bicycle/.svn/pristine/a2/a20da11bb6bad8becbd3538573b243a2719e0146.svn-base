package dao;

import model.BicycleRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface BicycleRecordMapper {


    int addBicycleRecord(BicycleRecord bicycleRecord);

    @Select("select record_id recordId,bicycle_id bicycleId,card_id cardId,rent_time rentTime,rent_pile_id rentPileId" +
            ",return_time returnTime,return_pile_id returnPileId,money,remark from bicycle_record where bicycle_id=#{bicycleId} and return_time is null")
    BicycleRecord selectUncompletedRecord(Integer bicycleId);

    @Update("update bicycle_record set money=#{rentFee},return_pile_id=#{pileId},return_time=#{returnTime} where record_id=#{recordId}")
    void returnBicycle(
            @Param("recordId") Integer recordId
            ,@Param("rentFee") double rentFee
            ,@Param("pileId") Integer pileId
            ,@Param("returnTime") String returnTime);
    
  //租车记录的卡张数 总消费金额 总租车小时数，总租车次数。平均租车次数 
    @Select("select recordId,money,rentTime,bicycleId ,bicycleId/decode(recordId,0,1) remark from(select count(DISTINCT card_id) recordId, sum(money) money,sum((to_date(return_time,'yyyy/mm/dd hh24:mi:ss')- to_date(rent_time,'yyyy/mm/dd hh24:mi:ss'))*24) rentTime, count(*) bicycleId from bicycle_record)")
    public BicycleRecord selectData();
    
    //单个卡记录 总消费金额  总租车小时数，总租车次数，单次租车时间
    @Select("select rentTime,money,bicycleId,money/decode(bicycleId,0,1) remark from(select sum(money) rentTime,sum((to_date(return_time,'yyyy/mm/dd hh24:mi:ss')- to_date(rent_time,'yyyy/mm/dd hh24:mi:ss'))*24) money, \n" + 
    		"count(card_id) bicycleId from bicycle_record where card_id=#{#cardId})")
    public BicycleRecord selectOneData(int cardId);
    
}
