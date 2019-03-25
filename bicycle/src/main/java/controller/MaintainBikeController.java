package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.BicycleInfo;
import model.RepairRecord;
import service.IBikeMaintainService;

@Controller
public class MaintainBikeController {
	@Autowired
	private IBikeMaintainService bikeMaintainService;
	
	//车辆维修调出
	@RequestMapping(value="/bikeMaintainOut",produces= {"text/plain;charset=utf-8"})
	@ResponseBody
	public String bikeMaintainOut(String cardID,String bikeID) {
		String rs = bikeMaintainService.BikeMaintainOut(cardID, bikeID);
		if(rs == null) {
			return "车辆维修调出成功";
		}
		return rs;
	}
	
	//查询维修 调出的车
	@RequestMapping(value="/selectMaintainBike",produces= {"text/plain;charset=utf-8"})
	public String selectMaintainBike(Model model){
		List<BicycleInfo> listBicycleInfo = bikeMaintainService.selectMaintainBike();
		model.addAttribute("maintainBike", listBicycleInfo);
		return "/WEB-INF/three/selectMaintainBike.jsp";
	}
	
	//查询状态为维修调出并且维修成功可以调入车桩的车
	@RequestMapping(value="/selectCanMaintainInBike",produces= {"text/plain;charset=utf-8"})
	public String selectCanMaintainInBike(Model model,String pileId,String stationId){
		List<BicycleInfo> listBicycleInfo = bikeMaintainService.selectCanMaintainInBike();
		model.addAttribute("maintainBike", listBicycleInfo);
		model.addAttribute("pileId", pileId);
		model.addAttribute("stationId", stationId);
		
		return "/WEB-INF/three/selectCanMaintainInBike.jsp";
	}
	
	

	//跳转到填写维修信息
	@RequestMapping(value="/maintainMessage",produces= {"text/plain;charset=utf-8"})
	public String maintainMessage(String bikeID,Model model) {
		model.addAttribute("bikeID", bikeID);
		return "/WEB-INF/three/maintainMessage.jsp";
	}
	
	//车辆维修调入
	@RequestMapping(value="/maintainBikeIn",produces= {"text/plain;charset=utf-8"})
	@ResponseBody
	public String maintainBikeIn(String cardID,String bicycleID,String pileId,String stationId,Model model) {
		String str = bikeMaintainService.bikeMaintainIn(cardID, bicycleID, pileId, stationId);
		if(str==null) {
			return "车辆维修调入成功";
		}
		return str;
	}
	
	//填写修理信息
	
	@RequestMapping(value="/addRepairRecord",produces= {"text/plain;charset=utf-8"})
	@ResponseBody
	public String addRepairRecord(RepairRecord repairRecord,Model model) {
		int a = bikeMaintainService.addRepairRecord(repairRecord);
		if(a == 1) {
			return "维修信息添加成功";
			
		}
		return "维修信息添加失败";
	}
	
	//查询可以报废的车辆
	@RequestMapping(value="/canScrapBike",produces= {"text/plain;charset=utf-8"})
	public String selectCanScrapBike(Model model) {
		List<BicycleInfo> listBicycleInfo = bikeMaintainService.selectCanScrapBike();
		model.addAttribute("maintainBike", listBicycleInfo);
		return "/WEB-INF/three/selectCanScrapBike.jsp";
		
	}
	
	//报废车辆
	@RequestMapping(value="/scrapBike",produces= {"text/plain;charset=utf-8"})
	@ResponseBody
	public String scrapBike(String bikeID,Model model) {
		String rs = bikeMaintainService.scrapBike(bikeID);
		if(rs==null) {
			return "车辆报废成功";
		}
		return rs;
	}
	
}
