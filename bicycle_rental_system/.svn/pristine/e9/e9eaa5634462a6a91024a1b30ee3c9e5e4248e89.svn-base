package com.aowin.bicycle.repair.dao;

import java.util.List;

import com.aowin.bicycle.purchase.pojo.BicycleInfo;
import com.aowin.bicycle.repair.pojo.BicycleRepairRecord;

public interface BicycleRepairDao {
	
	//判断是否维修人员
	public boolean selectIsRepairer(Integer cardid) throws Exception;
	
	
	//查询已经维修调出的车辆
	public List<BicycleInfo> selectBicycleIsCheckout() throws Exception;
	
	
	
	//写修理记录
	public int insertBicycleRepairRecord(BicycleRepairRecord record) throws Exception;
	
	//查询已经维修完成的车辆
	public List<BicycleInfo> selectBicycleIsRepaired() throws Exception;
	
	
	
	
}
