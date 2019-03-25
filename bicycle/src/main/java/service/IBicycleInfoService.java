package service;

import com.github.pagehelper.PageInfo;

import model.BicycleDeal;
import model.BicycleDeploy;
import model.BicycleInfo;
import model.Bicycle_pile;
import model.Card;

public interface IBicycleInfoService {
	public PageInfo<BicycleInfo> selectPileIdBicycle(int current);

	public String BicycleIn(BicycleInfo bi,Bicycle_pile bp,Card card, BicycleDeploy bd, BicycleDeal bDeal);
}
