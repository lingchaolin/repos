package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import model.BicycleInfo;
import model.Bicycle_pile;
import model.Bicycle_station;
import service.ISelectStationBikeService;

@Controller
public class SelectStationBikeController {
	
	@Autowired
	private ISelectStationBikeService selectStationBikeService;
	//查询车点的车
	@RequestMapping(value="/selectBike",produces= {"text/plain;charset=utf-8"})
	public String selectBike(Model model,Bicycle_station bicycleStation) {
		List<BicycleInfo> listBicycleInfo = selectStationBikeService.selectBike(bicycleStation);
		model.addAttribute("stationBike", listBicycleInfo);
		return "/WEB-INF/three/stationBike_layer.jsp";
	}
	
	//查询车点的车桩
	@RequestMapping(value="/selectPile",produces= {"text/plain;charset=utf-8"})
	public String selectPile(Model model,Bicycle_station bicycleStation) {
		List<Bicycle_pile> listBicycle_pile = selectStationBikeService.selectPile(bicycleStation);
		model.addAttribute("stationPile", listBicycle_pile);
		
		return "/WEB-INF/three/stationPile_layer.jsp";
	}
	
	//查询车桩的车
	@RequestMapping(value="/selectThisBike",produces= {"text/plain;charset=utf-8"})
	public String selectThisBike(String bikeID,Model model) {
		BicycleInfo bicycleInfo = selectStationBikeService.selectThisBike(bikeID);
		model.addAttribute("thisBike", bicycleInfo);
		return "/WEB-INF/three/thisBike.jsp";
	}
}
