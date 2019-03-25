package service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import dao.BicyclePileMapper;
import dao.BicycleStationMapper;
import model.Bicycle_pile;
import model.Bicycle_station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.IBicycle_StationService;
import util.DateUtil;

import java.util.List;

@Service
public class Bicycle_StationService implements IBicycle_StationService {
	@Autowired
	private BicycleStationMapper bicycleStationMapper;
	@Autowired
	private BicyclePileMapper bicyclePileMapper;

	@Override
	public List<Bicycle_station> selectStation() {
		List<Bicycle_station> bList = bicycleStationMapper.showBicycleStation();
		return bList;
	}

	@Override
	public PageInfo showStation(Integer pageNum) {
		PageHelper.startPage(pageNum,5);
		List<Bicycle_station> bList = bicycleStationMapper.showBicycleStation();
		PageInfo page = new PageInfo(bList);
		return page;
	}

	@Override
	@Transactional
	public void addBicyleStaion(Bicycle_station bicycle_station,List<Bicycle_pile> list) {
		//封装车点
		String time = DateUtil.getNow();
		String code = DateUtil.getNum();
		bicycle_station.setStationCode(code);
		bicycle_station.setBuildTime(time);
		bicycle_station.setRunTime(time);
		bicycle_station.setCreateTime(time);

		bicycleStationMapper.addBicycleStation(bicycle_station);

		//封装车桩
		for (Bicycle_pile i:list) {
			i.setStationId(bicycle_station.getStationId());
			i.setPileCode(code);
			i.setOperatorTime(time);
		}
		bicyclePileMapper.addBicyclePile(list);
	}




}
