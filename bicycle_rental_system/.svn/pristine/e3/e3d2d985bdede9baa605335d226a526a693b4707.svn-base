package com.aowin.bicycle.schedule.dao;

import java.util.List;

import com.aowin.bicycle.purchase.pojo.BicycleInfo;
import com.aowin.bicycle.repair.pojo.BicycleRepairRecord;

public interface BicycleDeployDao {
	
	//查询是否有调动权限
	public boolean isUser() throws Exception;
	
	
	//查询状态为普通调出的车辆
	public List<BicycleInfo> isPlainSchedule() throws Exception;
	
	
	//查询车桩是否有车
	public boolean isBicyclePileHasBicycle() throws Exception;
	
	
	//修改车辆调配明细
	public int updateBicycleDeploy() throws Exception;
	
	
	
	//查询修理结果为修理失败的的车辆
	public List<BicycleRepairRecord> selectRepairedFail() throws Exception;
	
	
	
}
