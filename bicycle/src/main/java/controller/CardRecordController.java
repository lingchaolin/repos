package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;

import model.Card;
import model.Card_record;
import model.Time;
import service.ICardRecordService;

@Controller
public class CardRecordController {
	@Autowired
	private ICardRecordService cardRecordService;
	@RequestMapping("/card/Date")
	public void selectDate(Time time,HttpServletResponse resp) throws IOException {
		List<Card_record> list = cardRecordService.selectDate(time);
		if(list.size()==0) {
			PrintWriter out = resp.getWriter();
			out.write("ok");
			out.flush();
			out.close();
		}
		else {
			PrintWriter out = resp.getWriter();
			out.write("no");
			out.flush();
			out.close();
		}
	}
	@RequestMapping("/card/cardRecord")
	public String selectRecord(int cardId,Model model) throws IOException {
		 List<Card_record> list = cardRecordService.selectCardRecord(cardId);	
		String type = null;
		for (Card_record c : list) {
			switch (c.getFeeType()) {
			case 1:
				type = "充值";
				break;
			case 2:
				type = "租车";
				break;
			case 3:
				type = "消费";
				break;
			case 4:
				type = "提款";
				break;
			case 5:
				type = "钱包转冻结";
				break;
			}
			c.setTurn(type);
		}
		model.addAttribute("list",list);
		return "/WEB-INF/CurrentCardCount-layer4.jsp";

	}
}
