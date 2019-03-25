package service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import model.BicycleDeal;
import model.BicycleDeploy;
import model.Bicycle_pile;
import model.Card;

public interface IBicyclePileService {
	public PageInfo<Bicycle_pile> selectBicycle(int current);

	public String OutBicycle(int pileId, Card card,BicycleDeploy bd,BicycleDeal bDeal);
	
	public List<Bicycle_pile> selectEmpty();
}
