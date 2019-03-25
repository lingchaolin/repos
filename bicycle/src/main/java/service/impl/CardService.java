package service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import dao.BicycleRecordMapper;
import dao.CardMapper;
import dao.CardRecordMapper;
import dao.Card_info_recordMapper;
import model.BicycleRecord;
import model.Card;
import model.Card_info_record;
import model.Card_record;
import service.ICardService;

@Service
public class CardService implements ICardService {
	@Autowired
	private CardMapper cardMapper;
	@Autowired
	private Card_info_recordMapper card_info_recordMapper;
	@Autowired
	private CardRecordMapper cardRecordMapper;
	@Autowired 
	private BicycleRecordMapper bicycleRecordMapper;

	@Override
	public PageInfo<Card> selectCard(int current, Map map) {
		PageHelper.startPage(current, 1);
		List<Card> cList = cardMapper.selectCard(map);
		PageInfo<Card> page = new PageInfo<Card>(cList);
		return page;
	}

	@Override
	@Transactional
	public String insertCard(Card card, Card_info_record cir) {
		Card card1 = cardMapper.selectIsCard(card.getCardId());
		if (card1 !=null) {
			return "error";
		}
		int row2 = cardMapper.insertCard(card);
		if (row2 == 0) {
			throw new RuntimeException("凉凉");
		}
		int row1 = card_info_recordMapper.insertInfoRecord(cir);
		if (row1 == 0) {
			throw new RuntimeException("凉凉");
		}
		return null;
	}

	@Override
	public Card selectUpdateCard(int cardId) {
		Card card = cardMapper.selectUpdateCard(cardId);
		return card;
	}

	@Override
	public int updateCard(Card card) {
		return cardMapper.updateCard(card);

	}

	@Override
	public String updateStatus(int cardId,Card_info_record cir) {
		int row1=cardMapper.updateStatus(cardId);
		if(row1==0) {
			throw new RuntimeException("凉凉");
		}
		int row2=card_info_recordMapper.insertInfoRecord(cir);
		if(row2==0) {
			throw new RuntimeException("凉凉");
		}
		return null;

		
	}

	@Override
	@Transactional
	public String deleteCard(int cardId, Card_info_record cir, Card_record cr) {
		int row3 = cardMapper.deleteCard(cardId);
		if (row3 == 0) {
			throw new RuntimeException("凉凉");
		}
		int row2 = card_info_recordMapper.insertInfoRecord(cir);
		if (row2 == 0) {
			throw new RuntimeException("凉凉");
		}
		int row1 = cardRecordMapper.addCardRecord(cr);
		if (row1 == 0) {
			throw new RuntimeException("凉凉");
		}
		return null;
	}

	@Override
	public Card selectOneCard(String card_code) {
		Card card = cardMapper.selectOneCard(card_code);
		return card;
	}

	@Override
	@Transactional
	public String updateMoney(Card card,Card_record cr) {
		int row1= cardMapper.updateMoney(card);
		if (row1 == 0) {
			throw new RuntimeException("凉凉");
		}
		int row2=cardRecordMapper.addCardRecord(cr);
		if (row2 == 0) {
			throw new RuntimeException("凉凉");
		}
		return null;
	}

	@Override
	public Card selectYesCardCode(String cardCode) {
		
		return cardMapper.selectOneCard(cardCode);
	}

	@Override
	public PageInfo<Card> selectCurrentCard(int current, Map map) {
		PageHelper.startPage(current, 2);
		List<Card> cList = cardMapper.selectCurrentCard(map);
		PageInfo<Card> page = new PageInfo<Card>(cList);
		return page;
	}


	@Override
	public Card selectDataOne() {
		
		return cardMapper.selectCardCount();
	}

	@Override
	public BicycleRecord selectDataTwo() {
		
		return bicycleRecordMapper.selectData();
	}

	@Override
	public Card_record seelctDataThree() {
		
		return cardRecordMapper.selectData();
	}

	@Override
	public Card selectDataOneone(int cardId) {
		// TODO Auto-generated method stub
		return cardMapper.selectOne(cardId);
	}

	@Override
	public BicycleRecord selectDataOneTwo(int cardId) {
		// TODO Auto-generated method stub
		return bicycleRecordMapper.selectOneData(cardId);
	}

	@Override
	public Card_record seelctDataOneThree(int cardId) {
		// TODO Auto-generated method stub
		return cardRecordMapper.selectOneData(cardId);
	}

}
