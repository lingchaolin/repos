package com.aowin.bicycle.hire.dao;

import com.aowin.bicycle.maintenance.pojo.Card;
import com.aowin.bicycle.maintenance.pojo.CardFlowRecord;
import com.aowin.bicycle.purchase.pojo.BicycleInfo;

public interface BicycleHireDao {
	
	//插入车辆租还记录表
	public int insertBicycleRecord() throws Exception;
	
	
	//查询车辆状态信息
	public BicycleInfo selectBicycleStatus() throws Exception;
	
	
	
	//校验卡是否有效，校验卡中金额是否充足(>=200元).	校验卡是否已经租车
	public Card selectCardStatus() throws Exception;
	
	
	
	//修改车桩状态
	public int updateBicycleStation() throws Exception;
	
	//修改租车卡信息
	public int updateCard() throws Exception;
	
	
	//插入卡费用流水表
	public int insertCardFlowRecord(CardFlowRecord cardflowrecord) throws Exception;
	
	
	//修改车辆租还记录表
	public int updateBicycleRecord() throws Exception;
	
	
	
	
	
	
}
