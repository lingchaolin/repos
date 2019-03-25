package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;

import model.BicycleDeal;
import model.BicycleDeploy;
import model.BicycleInfo;
import model.Bicycle_pile;
import model.Card;
import service.IBicycleInfoService;

@Controller
public class BicycleInfoController {
	@Autowired
	private IBicycleInfoService bicycleInfoService;

	@RequestMapping("/bicycleIn/select")
	public String selectPileIdBicycle(int current, Model model) {
		PageInfo<BicycleInfo> page = bicycleInfoService.selectPileIdBicycle(current);
		model.addAttribute("page", page);
		return "/WEB-INF/BicycleIn-layer.jsp";
	}

	@RequestMapping("/bicycleIn/In")
	public void In(BicycleInfo bi, Card card, HttpSession session, HttpServletResponse resp) throws IOException {
		BicycleDeploy bd = new BicycleDeploy();
		Bicycle_pile bp = new Bicycle_pile();
		BicycleDeal bDeal = new BicycleDeal();
		String userid = (String) session.getAttribute("userid");
		int id = Integer.parseInt(userid);
		bDeal.setUserId(id);
		String result = bicycleInfoService.BicycleIn(bi, bp, card, bd, bDeal);

		if (result == null) {
			PrintWriter out = resp.getWriter();
			out.write("ok");
			out.flush();
			out.close();
		}
	}

}
