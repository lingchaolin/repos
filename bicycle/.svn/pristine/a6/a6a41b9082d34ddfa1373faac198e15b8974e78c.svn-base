package service;

import java.util.List;

import model.BicycleInfo;
import model.Bicycle_pile;
import model.Bicycle_station;

public interface ISelectStationBikeService {
	
	//根据bicycleStation中的坐标属性查找在庄的自行车
	public List<BicycleInfo> selectBike(Bicycle_station bicycleStation);
	
	//根据车点查询车桩
	
	public List<Bicycle_pile> selectPile(Bicycle_station bicycleStation);
	
	//根据车桩查询车辆
	
	public BicycleInfo selectThisBike(String bikeID);
}
