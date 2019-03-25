package com.aowin.keeper.serv;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.aowin.dao.PurchaseUserDao;
import com.aowin.keeper.model.MainModle;

public class PurchaseShowInStockMain extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//PoMainUserDao ud=new PoMainUserDao();
		String  payType="货到付款";//默认显示的付款方式，可修改
		String str=request.getParameter("getPayType");
		if("110".equals(str)) {
			payType="货到付款";
		}else if("120".equals(str)) {
			payType="款到发货";
		}else if("130".equals(str)) {
			payType="预付款到发货";
		}
		ArrayList<MainModle> pmsmList=PurchaseUserDao.getShowInstockMain(payType);
		request.setAttribute("pmsmList", pmsmList);
		request.getRequestDispatcher("pkeep/instock.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
