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
import model.BicycleInfo;
import model.Bicycle_pile;
import model.Card;
import service.IBicycleInfoService;
import util.DateUtil;

@Service
public class BicycleInfoService implements IBicycleInfoService {
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
	public PageInfo<BicycleInfo> selectPileIdBicycle(int current) {
		PageHelper.startPage(current, 2);
		List<BicycleInfo> cList = bicycleInfoMapper.selectPileIdBicycle();
		PageInfo<BicycleInfo> page = new PageInfo<BicycleInfo>(cList);
		return page;
	}


	@Override
	@Transactional
	public String BicycleIn(BicycleInfo bi,Bicycle_pile bp,Card card, BicycleDeploy bd, BicycleDeal bDeal) {
		int cardId = cardMapper.selectCardId(card.getCardCode());
		int row1 = bicycleInfoMapper.updateInStatus(bi);
		if (row1 == 0) {
			throw new RuntimeException("凉凉");
		}
		bp.setBicycleId(bi.getBicycleId());
		bp.setPileId(bi.getPileId());
		int row2 = bicyclePileMapper.updateStatus(bp);
		if (row2 == 0) {
			throw new RuntimeException("凉凉");
		}
		bd.setToCardId(cardId);
		bd.setBicycleId(bi.getBicycleId());
		bd.setToPileId(bi.getPileId());
		bd.setToTime(DateUtil.currentTime());
		bd.setToReason("5");
		int row3 = bicycleDeployMapper.insertBicycleRecord(bd);
		if (row3 == 0) {
			throw new RuntimeException("凉凉");
		}
		String now=DateUtil.currentTime();
		BicycleDeploy dbc = bicycleDeployMapper.selectToDeployId(now);
		bDeal.setRecordId(dbc.getDeployId());
		bDeal.setCreateTime(now);
		bDeal.setDealType("5");
		bDeal.setDealName("普通调入");
		bDeal.setIdFee("0");
		bDeal.setChgMoney(0.0);
		bDeal.setPileId(bi.getBicycleId());
		bDeal.setBicycleId(bi.getPileId());
		int row4 = bicycleDealMapper.addBicycleDeal(bDeal);
		if (row4 == 0) {
			throw new RuntimeException("凉凉");
		}
		return null;
	}

}
