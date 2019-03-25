package com.aowin.bicycle.purchase.dao;

import java.util.List;

import com.aowin.bicycle.hire.pojo.BicycleDeal;
import com.aowin.bicycle.purchase.pojo.BicycleInfo;
import com.aowin.bicycle.purchase.pojo.BicycleMainOrder;
import com.aowin.bicycle.purchase.pojo.BicycleOrderDetail;

public interface PurchaseDao {
	
	//添加车辆主信息单
	public int insertBicycleMainOrder(BicycleMainOrder mainorder) throws Exception;
	
	
	//添加车辆明细信息单
	
	public int insertBicycleOrderDetail(List<BicycleOrderDetail> list) throws Exception;
	
	
	//插入车辆状态信息表
	public int insertBicycleInfo(List<BicycleInfo> list) throws Exception;
	
	
	//修改车辆状态信息表
	public int updateBicycleInfo(List<BicycleInfo> list) throws Exception;
	
	
	
	//插入车辆业务流水表
	public int insertBicycleDeal(List<BicycleDeal> list) throws Exception;
	
	
	
	
	
	//查询购入未入桩车辆
	public List<BicycleInfo> selectNoPileBicycleInfo() throws Exception;
	
	
	
	//插入车辆调配明细表
	public int insertBicycleDeploy() throws Exception;
	
	
	
	
	
}
