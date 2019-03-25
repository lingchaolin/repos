package dao;

import org.apache.ibatis.annotations.Select;

import model.RepairRecord;

public interface RepairRecordMapper {
	//添加维修信息
	
	public int addRepairRecord(RepairRecord repairRecord);
	
	//查询修理失败的维修信息ID
	@Select("select RECORD_ID from REPAIR_RECORD where BICYCLE_ID=#{bikeId} and REPAIR_RESULT=2")
	public Integer selectFailureId(Integer bikeId);
}
