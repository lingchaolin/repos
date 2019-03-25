package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import dao.CardRecordMapper;
import model.Card;
import model.Card_record;
import model.Time;
import service.ICardRecordService;

@Service
public class CardRecordService implements ICardRecordService {
	@Autowired
	private CardRecordMapper cardRecordMapper;

	@Override
	public List<Card_record> selectDate(Time time) {

		return cardRecordMapper.selectDate(time);
	}

	@Override
	public List<Card_record> selectCardRecord(int cardId) {
		
		
		List<Card_record> cList = cardRecordMapper.selectCardRecond(cardId);
	
		return cList;
	}

}
