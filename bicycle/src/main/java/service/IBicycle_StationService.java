package service;

import com.github.pagehelper.PageInfo;
import model.Bicycle_pile;
import model.Bicycle_station;

import java.util.List;

public interface IBicycle_StationService {
	public List<Bicycle_station> selectStation();

	PageInfo showStation(Integer pageNum);

	void addBicyleStaion(Bicycle_station bicycle_station,List<Bicycle_pile> list);

}
