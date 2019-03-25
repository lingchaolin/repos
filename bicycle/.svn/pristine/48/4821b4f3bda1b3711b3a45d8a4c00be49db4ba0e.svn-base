package controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Bicycle_station;
import service.IBikeStationServlce;
@Controller
public class BikeStationController {
	
	@Autowired
	private IBikeStationServlce bikeStationService;
	
	//按条件查询对应的车点信息
	@RequestMapping(value="/selectStationByName",produces= {"text/plain;charset=utf-8"})
	public String selectStationByName(Bicycle_station bicycleStation,Model model) {
		List<Bicycle_station> listBicycle_station = bikeStationService.selectStation(bicycleStation);
		model.addAttribute("listBicycle_station", listBicycle_station);
		return "/WEB-INF/three/station_layer.jsp";
	}
	
	//车点 车辆信息统计
	@RequestMapping(value="/stationCount",produces= {"text/plain;charset=utf-8"})
	public String stationCount(String stationId,Model model) {
		Map stationCountMap = bikeStationService.stationCount(stationId);
		model.addAttribute("stationCountMap", stationCountMap);
		return "/WEB-INF/three/stationCount.jsp";		
	}
	
}
