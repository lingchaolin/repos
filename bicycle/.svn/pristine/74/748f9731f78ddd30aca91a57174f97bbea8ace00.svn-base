package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import model.BicycleInfo;
import model.Bicycle_pile;

public interface BicyclePileMapper {
	int hasbicycle(int pileId);

	/*void pileRented(int pileId);*/

	@Select("select bicycle_id from bicycle_pile where pile_id=#{pileId}")
	int selectBicycleIdByPileId(int pileId);

	public List<Bicycle_pile> selectBicycle();

	@Update("update bicycle_pile set status=2,bicycle_id='' where pile_id=#{pileId} ")
	public int update(int pileId);

	@Update("update bicycle_pile set status=1,bicycle_id=#{bicycleId} where pile_id=#{pileId} ")
	public int updateStatus(Bicycle_pile bp);
	
	@Select("select pile_id pileId,bicycle_pile.* from bicycle_pile where status=2")
	public List<Bicycle_pile> selectEmpty();
	
	 @Update("update bicycle_pile set status=2,bicycle_id=null where pile_id=#{pileId}")
	void pileRented(int pileId);

	    @Update("update bicycle_pile set status=1,bicycle_id=#{bicycleId} where pile_id=#{pileId}")
	    void pileReturned(@Param("pileId") int pileId,@Param("bicycleId") int bicycleId);

	  /*  @Select("select bicycle_id from bicycle_pile where pile_id=#{pileId}")
	    int selectBicycleIdByPileId(int pileId);
*/
	    void addBicyclePile(List<Bicycle_pile> list);

	    @Update("update BICYCLE_PILE set status=2,BICYCLE_ID=null where BICYCLE_ID=#{bikeID}")
	    public int emptyBicyclePile(String bikeID);

	    //修理后的车辆入桩
	    @Update("update BICYCLE_PILE set status=1,BICYCLE_ID=#{bicycleID} where PILE_ID=#{pileID}")
	    public int maintainInPile(BicycleInfo bicycleInfo);

	    //根据车点id查询该车点所有的车桩
	    @Select("select \r\n" +
				"       PILE_ID pileId,bp.STATION_ID stationId,PILE_CODE pileCode,STATUS,BICYCLE_ID bicycleId\r\n" +
				"from \r\n" +
				"       BICYCLE_PILE bp \r\n" +
				"where bp.station_id=#{stationId}")
		public List<Bicycle_pile> selectPileBysStationID(String stationId);
	
}
