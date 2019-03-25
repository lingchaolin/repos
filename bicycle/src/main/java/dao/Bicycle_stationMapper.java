package dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import model.Bicycle_station;

public interface Bicycle_stationMapper {
	public List<Bicycle_station> selectStation();
	@Select("select RUN_TIME from BICYCLE_STATION where STATION_ID=#{stationId}")
	public String selectStationDate(Integer stationId);
	
	public List<Bicycle_station> selectStationByName(Bicycle_station bicycle_station);
}

