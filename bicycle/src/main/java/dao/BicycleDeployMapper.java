package dao;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import model.BicycleDeploy;

public interface BicycleDeployMapper {
	public int addBicycleDeploy(BicycleDeploy bicycleDeploy);

	public int insertBicycleRecord(BicycleDeploy bd);

	@Select("select deploy_id deployId,bicycle_deploy.* from bicycle_deploy where from_time=#{fromTime}")
	public BicycleDeploy selectDeployId(String now);
	
	@Select("select deploy_id deployId,bicycle_deploy.* from bicycle_deploy where to_time=#{toTime}")
	public BicycleDeploy selectToDeployId(String now);
	//写入车辆调入信息到车辆调配信息中
		@Update("update \r\n" + 
				"       BICYCLE_DEPLOY b \r\n" + 
				"set \r\n" + 
				"       b.to_pile_id=#{toPileId},b.to_card_id=#{toCardId},b.to_time=#{toTime},b.to_reason=#{toReason}\r\n" + 
				"where \r\n" + 
				"       b.deploy_id=(select \r\n" + 
				"                      bd.deploy_id \r\n" + 
				"                    from  \r\n" + 
				"                      BICYCLE_DEPLOY bd \r\n" + 
				"                    where \r\n" + 
				"                      bd.bicycle_id=#{bicycleId} and bd.to_pile_id is null)")
		public Integer inBikeUpdateBicycleDeploy(BicycleDeploy bicycleDeploy);
		
		//根据车辆id查询未填写调入信息的车辆调配信息id
		@Select("select \r\n" + 
				"      bd.deploy_id \r\n" + 
				"from  \r\n" + 
				"      BICYCLE_DEPLOY bd \r\n" + 
				"where \r\n" + 
				"      bd.bicycle_id=#{bikeId} and bd.to_pile_id is null")
		public Integer getBicycleDeployId(Integer bikeId);
		
	

}
