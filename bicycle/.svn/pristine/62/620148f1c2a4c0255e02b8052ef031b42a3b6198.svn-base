package service;

import java.util.Map;

import com.github.pagehelper.PageInfo;

import model.BicycleRecord;
import model.Card;
import model.Card_info_record;
import model.Card_record;

public interface ICardService {
	public PageInfo<Card> selectCard(int current, Map map);

	public String insertCard(Card card, Card_info_record cir);

	public Card selectUpdateCard(int cardId);

	public int updateCard(Card card);

	public String updateStatus(int cardId, Card_info_record cir);

	public String deleteCard(int cardId, Card_info_record cir, Card_record cr);

	public Card selectOneCard(String cardCode);

	public String updateMoney(Card card, Card_record cr);

	public Card selectYesCardCode(String cardCode);

	public PageInfo<Card> selectCurrentCard(int current, Map map);

	public Card selectDataOne();

	public BicycleRecord selectDataTwo();

	public Card_record seelctDataThree();

	public Card selectDataOneone(int cardId);

	public BicycleRecord selectDataOneTwo(int cardId);

	public Card_record seelctDataOneThree(int cardId);

}
