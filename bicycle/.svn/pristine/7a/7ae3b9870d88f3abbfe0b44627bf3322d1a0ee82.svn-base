package service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.BicycleDealMapper;
import dao.BicyclePileMapper;
import dao.Bicycle_stationMapper;
import model.BicycleDeal;
import model.Bicycle_pile;
import model.Bicycle_station;
import service.IBikeStationServlce;
import util.DateUtil;
@Service
public class BikeStationService<V> implements IBikeStationServlce{
	
	@Autowired
	private Bicycle_stationMapper bicycle_stationMapper;
	
	@Autowired
	private BicycleDealMapper bicycleDealMapper;
	
	@Autowired
	private BicyclePileMapper bicyclePileMapper;
	//查询所有车点
	@Override
	public List<Bicycle_station> selectStation(Bicycle_station bicycleStation) {
		
		List<Bicycle_station> listBicycle_station = bicycle_stationMapper.selectStationByName(bicycleStation);
		
		return listBicycle_station;
	}
	
	//车点信息统计
	@Override
	public Map stationCount(String stationId) {
		List<Bicycle_pile> listBicycle_pile = bicyclePileMapper.selectPileBysStationID(stationId);
		List<Map> listBicycleDealType = bicycleDealMapper.selectBicycleDealType(Integer.parseInt(stationId));
		//车桩数量
		int pileNum = listBicycle_pile.size();
		//总的车辆借出数
		int bikeBorrowNum = 0;
		//总的车辆还入数
		int bikeRepayNum = 0;
		//总的车辆调出数(包括车辆维修调出)
		int bikeOutNum = 0;
		//总的车辆调入数(包括车辆维修调入)
		int bikeInNum = 0;
		
		//循环取出所有的类型
		for(int x=0;x<listBicycleDealType.size();x++) {
			Map resMap = listBicycleDealType.get(x);
			String str = (String) resMap.get("dealType");
			if("2".equals(str)) {
				bikeBorrowNum =  Integer.parseInt(String.valueOf(resMap.get("typeSum")));
			}else if("3".equals(str)) {// ==3表示还入
				bikeRepayNum =  Integer.parseInt(String.valueOf(resMap.get("typeSum")));
			}else if("4".equals(str) || "6".equals(str)) { //调出或维修调出
				bikeOutNum +=  Integer.parseInt(String.valueOf(resMap.get("typeSum")));
			}else if("5".equals(str) || "7".equals(str)) {
				bikeInNum +=  Integer.parseInt(String.valueOf(resMap.get("typeSum")));
			}
		}
		//循环查询每个车桩的业务流水表
		/*for(Bicycle_pile bp:listBicycle_pile) {
			List<BicycleDeal> listBicycleDeal = bicycleDealMapper.selectBicycleDealByPileId(bp.getPileId());
			for(BicycleDeal bd:listBicycleDeal) {
				if(bd.getDealType() == 2) { //==2表示租出
					bikeBorrowNum++;
				}else if(bd.getDealType() == 3) {// ==3表示还入
					bikeRepayNum++;
				}else if(bd.getDealType() == 4 || bd.getDealType() == 6) { //调出或维修调出
					bikeOutNum++;
				}else if(bd.getDealType() == 5 || bd.getDealType() == 7) {
					bikeInNum++;
				}
			}
		}*/
		
		Map stationCountMap = new HashMap();
		stationCountMap.put("pileNum", pileNum);
		stationCountMap.put("bikeBorrowNum", bikeBorrowNum);
		stationCountMap.put("bikeRepayNum", bikeRepayNum);
		stationCountMap.put("bikeOutNum", bikeOutNum);
		stationCountMap.put("bikeInNum", bikeInNum);
		//获取车点运行时间
		String runTime = bicycle_stationMapper.selectStationDate(Integer.parseInt(stationId));
		//获得当前时间
		String time = DateUtil.createDate();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		double a = 0;
		try {
			Date date1 = format.parse(runTime);
			Date date2 = format.parse(time);
			a = -(double) ((date1.getTime() - date2.getTime()) / (1000*3600*24));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//总的车辆借出数(日均)
		double bikeBorrowNumAverage = bikeBorrowNum/a;
		//总的车辆还入数(日均)
		double bikeRepayNumAverage = bikeRepayNum/a;
		//总的车辆调出数(包括车辆维修调出)(日均)
		double bikeOutNumAverage = bikeOutNum/a;
		//总的车辆调入数(包括车辆维修调入)(日均)
		double bikeInNumAverage = bikeInNum/a;
		
		stationCountMap.put("bikeBorrowNumAverage", bikeBorrowNumAverage);
		stationCountMap.put("bikeRepayNumAverage", bikeRepayNumAverage);
		stationCountMap.put("bikeOutNumAverage", bikeOutNumAverage);
		stationCountMap.put("bikeInNumAverage", bikeInNumAverage);

		return stationCountMap;
	}
	
}
