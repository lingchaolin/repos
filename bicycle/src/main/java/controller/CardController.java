package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;

import model.BicycleRecord;
import model.Card;
import model.Card_info_record;
import model.Card_record;
import service.ICardService;
import util.DateUtil;

@Controller
public class CardController {
	@Autowired
	private ICardService cardService;

	@RequestMapping("/card/select")
	public String selectCard(int current, @RequestParam Map map, Model model) {
		PageInfo<Card> page = cardService.selectCard(current, map);
		List<Card> list = page.getList();
		String type = null;
		String change = null;
		for (Card c : list) {
			switch (c.getCardType()) {
			case 1:
				type = "A卡";
				break;
			case 2:
				type = "D卡";
				break;
			case 3:
				type = "市民卡/社保卡";
				break;
			case 4:
				type = "员工卡";
				break;
			case 5:
				type = "维修调度卡";
				break;
			}
			if (c.getStatus() != null && !"".equals(c.getStatus())) {
				switch (c.getStatus()) {
				case 1:
					change = "正常";
					break;
				case 2:
					change = "锁定";
					break;
				}
			}
			c.setTurn(type);
			c.setChange(change);
		}
		model.addAttribute("page", page);
		return "/WEB-INF/card-layer.jsp";

	}

	@RequestMapping("/card/add")
	public void insertCard(Card card, HttpSession session, HttpServletResponse resp) throws IOException {
		String userid = (String) session.getAttribute("userid");
		int id = Integer.parseInt(userid);
		int type = card.getCardType();
		switch (type) {
		case 1:
			break;
		case 2:
			card.setMonthlyMoney(0.0);
			break;
		case 3:
			break;
		case 4:
			card.setMonthlyMoney(0.0);
			card.setWalletMoney(0.0);
			;
			break;
		case 5:
			card.setMonthlyMoney(0.0);
			card.setWalletMoney(0.0);
			;
			break;
		}
		Card_info_record cir = new Card_info_record();
		cir.setCardId(card.getCardId());
		cir.setCreateTime(DateUtil.currentTime());
		cir.setInfoType(1.0);
		cir.setUserId(id);
		card.setStatus(1);
		String result = cardService.insertCard(card, cir);
		if (result == null) {
			PrintWriter out = resp.getWriter();
			out.write("ok");
			out.flush();
			out.close();
		}
		if ("error".equals(result)) {
			PrintWriter out = resp.getWriter();
			out.write("id");
			out.flush();
			out.close();
		}

	}

	@RequestMapping("/card/change")
	public String selectUpdateCard(int cardId, Model model) {
		Card card = cardService.selectUpdateCard(cardId);
		model.addAttribute("card", card);
		return "/WEB-INF/cardUpdate.jsp";
	}

	@RequestMapping("/card/update")
	public void updateCard(Card card, HttpServletResponse resp) throws IOException {
		int type = card.getCardType();
		switch (type) {
		case 1:
			break;
		case 2:
			card.setMonthlyMoney(0.0);
			break;
		case 3:
			break;
		case 4:
			card.setMonthlyMoney(0.0);
			card.setWalletMoney(0.0);
			break;
		case 5:
			card.setMonthlyMoney(0.0);
			card.setWalletMoney(0.0);
			break;
		}
		int row = cardService.updateCard(card);
		if (row == 1) {
			PrintWriter out = resp.getWriter();
			out.write("ok");
			out.flush();
			out.close();
		}
	}

	@RequestMapping("/card/loss")
	public void updateStatus(int cardId, String remark, HttpSession session, HttpServletResponse resp)
			throws IOException {
		String userid = (String) session.getAttribute("userid");
		int id = Integer.parseInt(userid);
		Card_info_record cir = new Card_info_record();
		cir.setCardId(cardId);
		cir.setCreateTime(DateUtil.currentTime());
		cir.setInfoType(2.0);
		cir.setUserId(id);
		cir.setRemark(remark);
		String result = cardService.updateStatus(cardId, cir);
		if (result == null) {
			PrintWriter out = resp.getWriter();
			out.write("ok");
			out.flush();
			out.close();
		}
	}

	@RequestMapping("/card/deleteCard")
	public void deleteCard(int cardId, String remark, HttpSession session, HttpServletResponse resp)
			throws IOException {
		Card card = cardService.selectUpdateCard(cardId);
		String userid = (String) session.getAttribute("userid");
		int id = Integer.parseInt(userid);

		Card_info_record cir = new Card_info_record();
		cir.setCardId(cardId);
		cir.setCreateTime(DateUtil.currentTime());
		cir.setInfoType(3.0);
		cir.setUserId(id);
		cir.setRemark(remark);

		Card_record cr = new Card_record();
		cr.setCardId(cardId);
		cr.setFeeType(5);
		cr.setChgMonthlyMoney(card.getMonthlyMoney());
		cr.setChgWalletMoney(card.getWalletMoney());
		Double count = card.getMonthlyMoney();
		if (count == null) {
			count = 0.0;
		}
		Double count1 = card.getWalletMoney();
		if (count1 == null) {
			count1 = 0.0;
		}
		cr.setChgFrozenMoney(count + count1);
		cr.setCreateTime(DateUtil.currentTime());
		cr.setUserId(id);
		cr.setRemark(remark);
		cr.setZxbj(1);

		String result = cardService.deleteCard(cardId, cir, cr);
		if (result == null) {
			PrintWriter out = resp.getWriter();
			out.write("ok");
			out.flush();
			out.close();
		}
	}

	@RequestMapping("/card/selectOne")
	public String selectOneCard(String card_code, Model model) {
		Card c = cardService.selectOneCard(card_code);
		String type = null;
		String change = null;
		switch (c.getCardType()) {
		case 1:
			type = "A卡";
			break;
		case 2:
			type = "D卡";
			break;
		case 3:
			type = "市民卡/社保卡";
			break;
		case 4:
			type = "员工卡";
			break;
		case 5:
			type = "维修调度卡";
			break;
		}
		if (c.getStatus() != null && !"".equals(c.getStatus())) {
			switch (c.getStatus()) {
			case 1:
				change = "正常";
				break;
			case 2:
				change = "锁定";
				break;
			}
		}
		c.setTurn(type);
		c.setChange(change);
		model.addAttribute("c", c);
		return "/WEB-INF/InsertCard-layer.jsp";
	}

	@RequestMapping("/card/updateMoney")
	public void updateMoney(Card card, HttpSession session, HttpServletResponse resp) throws IOException {
		String userid = (String) session.getAttribute("userid");
		int id = Integer.parseInt(userid);

		Card_record cr = new Card_record();
		cr.setCardId(card.getCardId());
		cr.setFeeType(1);
		cr.setChgMonthlyMoney(card.getMonthlyMoney());
		cr.setChgWalletMoney(card.getWalletMoney());
		cr.setCreateTime(DateUtil.currentTime());
		cr.setUserId(id);

		String result = cardService.updateMoney(card, cr);
		if (result == null) {
			PrintWriter out = resp.getWriter();
			out.write("ok");
			out.flush();
			out.close();
		}
	}

	@RequestMapping("/card/Out")
	public void selectCardCode(String cardCode, HttpServletResponse resp) throws IOException {
		Card card = cardService.selectOneCard(cardCode);
		if (card.getCardType() == 4) {
			PrintWriter out = resp.getWriter();
			out.write("ok");
			out.flush();
			out.close();
		}
	}

	@RequestMapping("/card/selectCurrent")
	public String selectCurrentCard(int current, @RequestParam Map map, Model model) {
		PageInfo<Card> page = cardService.selectCurrentCard(current, map);
		List<Card> list = page.getList();
		String type = null;
		String change = null;
		for (Card c : list) {
			switch (c.getCardType()) {
			case 1:
				type = "A卡";
				break;
			case 2:
				type = "D卡";
				break;
			case 3:
				type = "市民卡/社保卡";
				break;
			}
			if (c.getStatus() != null && !"".equals(c.getStatus())) {
				switch (c.getStatus()) {
				case 1:
					change = "正常";
					break;
				case 2:
					change = "锁定";
					break;
				}
			}
			c.setTurn(type);
			c.setChange(change);
		}
		model.addAttribute("page", page);
		return "/WEB-INF/CurrentCardCount-layer.jsp";
	}

	@RequestMapping("/card/data")
	public String selectData(Model model) {
		Card card = cardService.selectDataOne();
		Card_record cr = cardService.seelctDataThree();
		BicycleRecord br = cardService.selectDataTwo();
		model.addAttribute("a", cr);
		model.addAttribute("b", br);
		model.addAttribute("c", card);

		return "/WEB-INF/CurrentCardCount-layer2.jsp";

	}

	@RequestMapping("/card/Onedata")
	public String selectOneData(int cardId, Model model) {
		Card card = cardService.selectDataOneone(cardId);
		Card_record cr = cardService.seelctDataOneThree(cardId);
		BicycleRecord br = cardService.selectDataOneTwo(cardId);
			model.addAttribute("a", cr);
			model.addAttribute("b", br);
			model.addAttribute("c", card);
			return "/WEB-INF/CurrentCardCount-layer3.jsp";
		
	}
}