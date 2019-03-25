package dao;

import org.apache.ibatis.annotations.Select;

import model.Card_info_record;

public interface Card_info_recordMapper {
	public int insertInfoRecord(Card_info_record cir);
@Select("select CARD_TYPE from CARD where CARD_ID=#{cardID}")
	
	public String selectCardType(int cardID);
}
