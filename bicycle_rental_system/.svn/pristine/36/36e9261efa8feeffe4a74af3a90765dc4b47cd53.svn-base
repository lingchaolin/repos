package com.aowin.bicycle.maintenance.dao;

import java.util.List;

import com.aowin.bicycle.maintenance.pojo.BicycleCatagory;
import com.aowin.bicycle.maintenance.pojo.BicyclePile;
import com.aowin.bicycle.maintenance.pojo.BicycleStation;

public interface BicycleMaintenanceDao {
	
	//查询车点内的车桩信息
	public List<BicyclePile> selectBicyclePileOfStation(BicycleStation station) throws Exception;
	
	
	//查询车点信息
	public List<BicycleStation> selectBicycleStation(BicycleStation station) throws Exception;
	
	
	//修改租车点信息
	public int updateBicycleStation(BicycleStation station) throws Exception;
	
	
	//修改车点内车桩的信息
	public int updateBicyclePile(BicyclePile pile) throws Exception;
	
	
	//注销租车点
	public int withdrawBicycleStation(BicyclePile pile) throws Exception;
	
	
	
	
	//查询车辆类型信息
	public List<BicycleCatagory> selectBicycleCatagory() throws Exception;
	
	
	//修改车辆类型信息
	public int updateBicycleCatagory(BicycleCatagory catagory) throws Exception;
	
	//新增车辆类型信息
	public int insertBicycleCatagory(BicycleCatagory catagory) throws Exception;
	
	
	//删除车辆类型信息
	public int deleteBicycleCatagory(BicycleCatagory catagory) throws Exception;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
