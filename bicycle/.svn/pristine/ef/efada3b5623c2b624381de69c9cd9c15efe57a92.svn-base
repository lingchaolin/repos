package dao;

import model.Card;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface CardMapper {
	public List<Card> selectCard(Map map);

	@Select("select* from card where card_id=#{cardId}")
	public Card selectIsCard(int cardId);

	@Select("select status from card where card_id=#{cardId}")
	int cardStatus(int cardId);

	@Select("select frozen_money + wallet_money from card where card_id=#{cardId}")
	double cardMoney(int cardId);

	@Select("select wallet_money from card where card_id=#{cardId}")
	double walletMoney(int cardId);

	@Select("select frozen_money from card where card_id=#{cardId}")
	double frozenMoney(int cardId);

	@Update("update card set wallet_money=wallet_money + #{walletMoney} where card_id=#{cardId}")
	void changeWalletMoney(@Param("cardId") int cardId,@Param("walletMoney") double walletMoney);

	@Update("update card set frozen_money=frozen_money + #{frozenMoney} where card_id=#{cardId}")
	void changeFrozenMoney(@Param("cardId") int cardId,@Param("frozenMoney") double frozenMoney);
	
	public List<Card> selectCurrentCard(Map map);

	public int insertCard(Card card);

	public int updateCard(Card card);

	public Card selectUpdateCard(int cardId);

	public Card selectOneCard(String card_code);
	@Update("update card set status=2 where card_id=#{cardId}")
	public int updateStatus(int cardId);

	@Update("update card set monthly_money='',wallet_money='',frozen_money=frozen_money+monthly_money+wallet_money, status=2,zxbj=1 where card_id=#{cardId}")
	public int deleteCard(int cardId);

	public int updateMoney(Card card);

	@Select("select card_id cardId from card where card_code=#{cardCode}")
	public int selectCardId(String cardCode);

	// 统计租车卡中张数 现冻结金额，现可用余额
	@Select("select count(*) cardId ,sum(monthly_money+wallet_money) monthlyMoney,sum(frozen_money) frozenMoney from card where card_type=1 or card_type=2 or card_type=3")
	public Card selectCardCount();

	// 统计单个的card 现冻结金额，现可用余额
	@Select("select sum(monthly_money+wallet_money) monthlyMoney,sum(frozen_money) frozenMoney from card where card_id=#{cardId}")
	public Card selectOne(int cardId);
}
