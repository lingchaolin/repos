package service;

import java.util.List;

import org.springframework.ui.Model;

import model.BicycleInfo;
import model.RepairRecord;

public interface IBikeMaintainService {
	//调出维修车辆
	
	public String BikeMaintainOut(String cardID,String bikeID);
	
	//报废车辆
	public String scrapBike(String bikeID);
	
	//查询维修 调出的车
	
	public  List<BicycleInfo> selectMaintainBike();
	
	//添加维修信息
	
	public int addRepairRecord(RepairRecord repairRecord);

	//查询状态为维修调出并且维修成功可以调入车桩的车
	public List<BicycleInfo> selectCanMaintainInBike();
	
	//查询可以报废的车辆
	public List<BicycleInfo> selectCanScrapBike();
	
	//车辆维修调入
	public String bikeMaintainIn(String cardID, String bicycleID, String pileId, String stationId);
}
