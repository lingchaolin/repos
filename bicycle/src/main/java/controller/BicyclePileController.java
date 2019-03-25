package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageInfo;

import model.BicycleDeal;
import model.BicycleDeploy;
import model.Bicycle_pile;
import model.Card;
import service.IBicyclePileService;

@Controller
public class BicyclePileController {
	@Autowired
	private IBicyclePileService bicyclePileService;

	@RequestMapping("/bicycle/select")
	public String selectBicycle(int current, Model model) {
		PageInfo<Bicycle_pile> page = bicyclePileService.selectBicycle(current);
		List<Bicycle_pile> list = page.getList();
		String type = null;
		for (Bicycle_pile c : list) {
			switch (c.getStatus()) {
			case 1:
				type = "有车";
				break;
			case 2:
				type = "无车";
				break;
			}
			c.setTurn(type);
		}
		model.addAttribute("page", page);
		return "/WEB-INF/BicycleOut-layer.jsp";

	}

	@RequestMapping("/bicycleOut/Out")
	public void Out(int pileId, Card card, HttpSession session, HttpServletResponse resp) throws IOException {
		BicycleDeploy bd = new BicycleDeploy();

		BicycleDeal bDeal = new BicycleDeal();
		String userid = (String) session.getAttribute("userid");
		int id = Integer.parseInt(userid);
		bDeal.setUserId(id);
		String result = bicyclePileService.OutBicycle(pileId, card, bd, bDeal);

		if (result == null) {
			PrintWriter out = resp.getWriter();
			out.write("ok");
			out.flush();
			out.close();
		}
	}

	@RequestMapping("/pile/empty")
	public void selectEmpty(HttpServletResponse response) throws IOException {
		response.setContentType("text/plain;charset=utf-8");
		List<Bicycle_pile> bList = bicyclePileService.selectEmpty();
		StringBuffer sb = new StringBuffer();
		sb.append(JSONArray.toJSONString(bList));
		PrintWriter out = response.getWriter();
		out.print(sb.toString());
		out.flush();
		out.close();
	}
}
