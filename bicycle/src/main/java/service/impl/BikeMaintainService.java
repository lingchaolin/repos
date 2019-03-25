package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.BicycleDealMapper;
import dao.BicycleDeployMapper;
import dao.BicycleInfoMapper;
import dao.BicyclePileMapper;
import dao.Card_info_recordMapper;
import dao.RepairRecordMapper;
import model.BicycleDeal;
import model.BicycleDeploy;
import model.BicycleInfo;
import model.RepairRecord;
import service.IBikeMaintainService;
import util.DateUtil;
@Service
public class BikeMaintainService implements IBikeMaintainService{
	@Autowired
	private Card_info_recordMapper cardInfoRecordMapper;
	
	@Autowired
	private BicycleInfoMapper bicycleInfoMapper;
	
	@Autowired
	private BicyclePileMapper bicyclePileMapper;

	@Autowired
	private BicycleDeployMapper bicycleDeployMapper;

	@Autowired
	private RepairRecordMapper repairRecordMapper;
	
	@Autowired
	private BicycleDealMapper bicycleDealMapper;
	
	
	@Override
	@Transactional
	public String BikeMaintainOut(String cardID,String bikeID) {
		//通过卡ID  查找卡类型
		String cardType = cardInfoRecordMapper.selectCardType(Integer.parseInt(cardID));
		Integer pileID = bicycleInfoMapper.selectPileId(Integer.parseInt(bikeID));
		//判断是否为类型5 调度卡
		if("5".equals(cardType)) {
			//修改车辆状态 清空车桩ID  车辆维修调出
			int a = bicycleInfoMapper.bikeMaintain(Integer.parseInt(bikeID));	
			if(a != 1) {
				//如果修改失败 跑出异常
				throw new RuntimeException("车辆维修调出失败");
			}
			a = bicyclePileMapper.emptyBicyclePile(bikeID);
			if(a != 1) {
				//如果修改失败 跑出异常
				throw new RuntimeException("车桩状态修改失败");
			}
			//查询出自行车所在车桩的ID
			//当前调出时间
			String fromTime = DateUtil.currentTime();
			BicycleDeploy bicycleDeploy = new BicycleDeploy();
			bicycleDeploy.setBicycleId(Integer.parseInt(bikeID));
			bicycleDeploy.setFromCardId(Integer.parseInt(cardID));
			bicycleDeploy.setFromPileId(pileID);
			bicycleDeploy.setFromTime(fromTime);
			bicycleDeploy.setFromReason("6");
			bicycleDeploy.setStatus("5");
			// 添加车辆调配明细
			a = bicycleDeployMapper.addBicycleDeploy(bicycleDeploy);
			if(a != 1) {
				//如果修改失败 跑出异常
				throw new RuntimeException("添加车辆调配明细失败");
			}
			BicycleDeal bicycleDeal = new BicycleDeal();
			bicycleDeal.setBicycleId(Integer.parseInt(bikeID));
			bicycleDeal.setPileId(pileID);
			bicycleDeal.setCardId(Integer.parseInt(cardID));
			bicycleDeal.setDealType("6");
			bicycleDeal.setRecordId(bicycleDeploy.getDeployId());
			bicycleDeal.setDealName("维修调出");
			bicycleDeal.setCreateTime(fromTime);
			bicycleDeal.setIdFee("0");
			bicycleDeal.setChgMoney(0.0);
			bicycleDeal.setUserId(1);
			//添加业务流水
			a = bicycleDealMapper.addBicycleDeal(bicycleDeal);
			a = bicycleDeal.getDealId();
		}else {
			return "卡类型不匹配";
		}
		return null;
	}
	//车辆维修调入
	@Override
	@Transactional
	public String bikeMaintainIn(String cardID,String bicycleID,String pileId,String stationId) {
		//通过卡ID  查找卡类型
		String cardType = cardInfoRecordMapper.selectCardType(Integer.parseInt(cardID));
		if("5".equals(cardType)) {
			
			//车辆维修入桩后 修改车辆状态
			Integer deployId = bicycleDeployMapper.getBicycleDeployId(Integer.parseInt(bicycleID));
			BicycleInfo bicycleInfo = new BicycleInfo();
			bicycleInfo.setBicycleId(Integer.parseInt(bicycleID));
			bicycleInfo.setPileId(Integer.parseInt(pileId));
			int a = bicycleInfoMapper.maintainBikeIn(bicycleInfo);
			if(a != 1) {
				throw new RuntimeException("车辆状态修改失败");
			}
			a = bicyclePileMapper.maintainInPile(bicycleInfo);
			if(a != 1) {
				throw new RuntimeException("车桩状态修改失败");
			}
			BicycleDeploy bicycleDeploy = new BicycleDeploy();
			bicycleDeploy.setBicycleId(Integer.parseInt(bicycleID));
			bicycleDeploy.setToCardId(Integer.parseInt(cardID));
			bicycleDeploy.setToPileId(Integer.parseInt(pileId));
			bicycleDeploy.setToTime(DateUtil.currentTime());
			bicycleDeploy.setToReason("7");
			//车辆维修入桩后 修改车辆调配信息  加入调入信息
			Integer b = bicycleDeployMapper.inBikeUpdateBicycleDeploy(bicycleDeploy);
			if(b == null) {
				throw new RuntimeException("车辆调配修改失败");
			}
			BicycleDeal bicycleDeal = new BicycleDeal();
			bicycleDeal.setBicycleId(Integer.parseInt(bicycleID));
			bicycleDeal.setPileId(Integer.parseInt(pileId));
			bicycleDeal.setCardId(Integer.parseInt(cardID));
			bicycleDeal.setDealType("7");
			bicycleDeal.setRecordId(deployId);
			bicycleDeal.setDealName("维修调入");
			bicycleDeal.setCreateTime(DateUtil.currentTime());
			bicycleDeal.setIdFee("0");
			bicycleDeal.setChgMoney(0.0);
			bicycleDeal.setUserId(1);
			//添加业务流水
			a = bicycleDealMapper.addBicycleDeal(bicycleDeal);
		}else {
			return "卡类型不匹配";
		}
		return null;
	}
	
	//查询状态为维修调出并且维修成功可以调入车桩的车
	public List<BicycleInfo> selectCanMaintainInBike(){
		List<BicycleInfo> listBicycleInfo = bicycleInfoMapper.selectCanMaintainInBike();
		for(BicycleInfo bf:listBicycleInfo) {
			if("5".equals(bf.getStatus())) {
				bf.setStatus("维修调出并且维修成功可以调入");
			}
		}
		return listBicycleInfo;
		
	}

	
	//查询维修 调出的车
	@Override
	public List<BicycleInfo> selectMaintainBike() {
		List<BicycleInfo> listBicycleInfo = bicycleInfoMapper.selectMaintainBike();
		for(BicycleInfo bf:listBicycleInfo) {
			if("5".equals(bf.getStatus())) {
				bf.setStatus("维修调出");
			}
		}
		return listBicycleInfo;
	}
	//添加维修信息
	@Override
	@Transactional
	public int addRepairRecord(RepairRecord repairRecord) {
		//赋值当前时间 调用添加维修信息的mapper方法
		repairRecord.setRepairDate(DateUtil.createDate());
		repairRecord.setOperatorTime(DateUtil.currentTime());
		repairRecord.setUserId(1);
		int a = repairRecordMapper.addRepairRecord(repairRecord);
		if(a != 1) {
			throw new RuntimeException("添加维修信息失败");
		}
		return 1;
	}
	
	//查询可以报废的车辆
	public List<BicycleInfo> selectCanScrapBike() {
		List<BicycleInfo> listBicycleInfo = bicycleInfoMapper.selectCanScrapBike();
		for(BicycleInfo bf:listBicycleInfo) {
			if("5".equals(bf.getStatus())) {
				bf.setStatus("维修调出并且维修失败");
			}
		}
		return listBicycleInfo;
	}
	//报废车辆
	@Transactional
	public String scrapBike(String bikeID) {
		//报废车辆  修改车辆状态为9 报废
		int a = bicycleInfoMapper.scrapBike(Integer.parseInt(bikeID));	
		if(a != 1) {
			//如果修改失败 跑出异常
			throw new RuntimeException("车辆报废失败");
		}
		Integer deployId = repairRecordMapper.selectFailureId(Integer.parseInt(bikeID));
		BicycleDeal bicycleDeal = new BicycleDeal();
		bicycleDeal.setBicycleId(Integer.parseInt(bikeID));
		bicycleDeal.setPileId(0);
		bicycleDeal.setCardId(0);
		bicycleDeal.setDealType("9");
		bicycleDeal.setRecordId(deployId);
		bicycleDeal.setDealName("报废");
		bicycleDeal.setCreateTime(DateUtil.currentTime());
		bicycleDeal.setIdFee("0");
		bicycleDeal.setChgMoney(0.0);
		bicycleDeal.setUserId(1);
		//添加业务流水
		a = bicycleDealMapper.addBicycleDeal(bicycleDeal);
		return null;
	}
	
}