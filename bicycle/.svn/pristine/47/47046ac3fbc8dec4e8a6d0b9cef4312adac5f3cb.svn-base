package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.SelectStationBikeMapper;
import model.BicycleInfo;
import model.Bicycle_pile;
import model.Bicycle_station;
import service.ISelectStationBikeService;
@Service
public class SelectStationBikeService implements ISelectStationBikeService{
	@Autowired
	private SelectStationBikeMapper selectStationBikeMapper;
	//根据经度纬度调用mapper查询所有在桩的自行车
	@Override
	public List<BicycleInfo> selectBike(Bicycle_station bicycleStation) {
		List<BicycleInfo> listBicycleInfo = selectStationBikeMapper.selectStationBike(bicycleStation);
		for(BicycleInfo bf:listBicycleInfo) {
			if("3".equals(bf.getStatus())) {
				bf.setStatus("在桩");
			}
		}
		return listBicycleInfo;
	}
	//根据车点查询车桩
	@Override
	public List<Bicycle_pile> selectPile(Bicycle_station bicycleStation) {
		List<Bicycle_pile> listBicycle_pile = selectStationBikeMapper.selectPile(bicycleStation);
		
		
		return listBicycle_pile;
	}
	
	//根据车桩查询车辆
	@Override
	public BicycleInfo selectThisBike(String bikeID) {
		BicycleInfo bicycleInfo = selectStationBikeMapper.selectThisBike(bikeID);
		if("3".equals(bicycleInfo.getStatus())) {
			bicycleInfo.setStatus("在桩");
		}
		return bicycleInfo;
	}

}
