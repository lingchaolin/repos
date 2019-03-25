package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import dao.BicycleDealMapper;
import dao.BicycleDeployMapper;
import dao.BicycleInfoMapper;
import dao.BicyclePileMapper;
import dao.CardMapper;
import model.BicycleDeal;
import model.BicycleDeploy;
import model.Bicycle_pile;
import model.Card;
import service.IBicyclePileService;
import util.DateUtil;

@Service
public class BicyclePileService implements IBicyclePileService {
	@Autowired
	private BicyclePileMapper bicyclePileMapper;
	@Autowired
	private BicycleInfoMapper bicycleInfoMapper;
	@Autowired
	private BicycleDeployMapper bicycleDeployMapper;
	@Autowired
	private BicycleDealMapper bicycleDealMapper;

	@Autowired
	private CardMapper cardMapper;

	@Override
	public PageInfo<Bicycle_pile> selectBicycle(int current) {
		PageHelper.startPage(current, 1);
		List<Bicycle_pile> bList = bicyclePileMapper.selectBicycle();
		PageInfo<Bicycle_pile> page = new PageInfo<Bicycle_pile>(bList);
		return page;
	}

	@Override
	@Transactional
	public String OutBicycle(int pileId, Card card, BicycleDeploy bd, BicycleDeal bDeal) {
		int cardId = cardMapper.selectCardId(card.getCardCode());
		int bicycleId=bicyclePileMapper.selectBicycleIdByPileId(pileId);
		int row1 = bicycleInfoMapper.updateStatus(pileId);
		if (row1 == 0) {
			throw new RuntimeException("凉凉");
		}
		int row2 = bicyclePileMapper.update(pileId);
		if (row2 == 0) {
			throw new RuntimeException("凉凉");
		}
		bd.setFromCardId(cardId);
		bd.setBicycleId(bicycleId);
		bd.setFromPileId(pileId);
		bd.setFromTime(DateUtil.currentTime());
		bd.setFromReason("4");
		int row3 = bicycleDeployMapper.insertBicycleRecord(bd);
		if (row3 == 0) {
			throw new RuntimeException("凉凉");
		}
		String now=DateUtil.currentTime();
		BicycleDeploy dbc = bicycleDeployMapper.selectDeployId(now);
		bDeal.setRecordId(dbc.getDeployId());
		bDeal.setCreateTime(now);
		bDeal.setDealType("4");
		bDeal.setDealName("普通调出");
		bDeal.setIdFee("0");
		bDeal.setChgMoney(0.0);
		bDeal.setPileId(pileId);
		bDeal.setBicycleId(bicycleId);
		int row4 = bicycleDealMapper.addBicycleDeal(bDeal);
		if (row4 == 0) {
			throw new RuntimeException("凉凉");
		}
		return null;
	}

	@Override
	public List<Bicycle_pile> selectEmpty() {
		
		return bicyclePileMapper.selectEmpty();
	}

}
