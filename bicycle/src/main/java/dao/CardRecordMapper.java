package dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import model.Card_record;
import model.Time;

public interface CardRecordMapper {

    int addCardRecord(Card_record cardRecord);
    
    public List<Card_record> selectDate(Time time);
    
    @Select("select sum(chg_monthly_money+chg_wallet_money) chgWalletMoney from card_record where fee_type=1")
    public Card_record selectData();
    @Select("select sum(chg_monthly_money+chg_wallet_money) chgWalletMoney,count(*) recordId from card_record where fee_type=1 and card_id=#{#cardId}")
    public Card_record selectOneData(int cardId);
    @Select("select fee_type feeType ,(nvl(chg_monthly_money,0)+nvl(chg_wallet_money,0)) chgMonthlyMoney,create_time createTime from card_record where card_id=#{cardId} order by create_time desc   ")
    public List<Card_record> selectCardRecond(int cardId);
}
