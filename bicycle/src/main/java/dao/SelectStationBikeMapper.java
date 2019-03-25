package dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import model.BicycleInfo;
import model.Bicycle_pile;
import model.Bicycle_station;

public interface SelectStationBikeMapper {
	@Select("select bi.bicycle_id bicycleID,bi.bicycle_code bicycleCode,bi.status,bi.pile_id pileID,bi.DESTORY_DATE destroyDate,"
			+ "bi.USER_ID userID,bi.OPERATOR_TIME operatorTime,bi.CARD_ID cardID,bi.REMARK remark from\r\n" + 
			"          BICYCLE_INFO bi,BICYCLE_PILE bp,BICYCLE_STATION bs \r\n" + 
			"  where \r\n" + 
			"          bs.station_id=bp.station_id and bp.pile_id=bi.pile_id and bs.longitude=#{longitude} and bs.latitude=#{latitude}")
	public List<BicycleInfo> selectStationBike(Bicycle_station bicycleStation);
	
	//查询车点的所有车桩
	@Select("select \r\n" + 
			"       PILE_ID pileId,bp.STATION_ID stationId,PILE_CODE pileCode,STATUS,BICYCLE_ID bicycleId\r\n" + 
			"from \r\n" + 
			"       BICYCLE_PILE bp,BICYCLE_STATION bs \r\n" + 
			"where bs.station_id=bp.station_id and bs.longitude=#{longitude} and bs.latitude=#{latitude}")
	public List<Bicycle_pile> selectPile(Bicycle_station bicycleStation);
	
	//查询车桩上的车
	@Select("select \r\n" + 
			"       bi.bicycle_id bicycleID,bi.bicycle_code bicycleCode,bi.status,bi.pile_id pileID \r\n" + 
			"from\r\n" + 
			"        BICYCLE_INFO bi\r\n" + 
			"where \r\n" + 
			"        bi.BICYCLE_ID=#{bikeID}")
	public BicycleInfo selectThisBike(String bikeID);
}
