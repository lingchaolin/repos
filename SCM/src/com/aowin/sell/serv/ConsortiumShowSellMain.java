package com.aowin.sell.serv;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aowin.dao.ConsortiumUserDao;
import com.aowin.dao.PurchaseUserDao;
import com.aowin.keeper.model.MainModle;
import com.aowin.manager.model.AccountMessage;
import com.aowin.manager.model.Page;

public class ConsortiumShowSellMain extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String payType="��������";
		String str=request.getParameter("getPayType");
		if("110".equals(str)) {
			payType="��������";
		}else if("120".equals(str)) {
			payType="�����";
		}else if("130".equals(str)) {
			payType="Ԥ�������";
		}
		ArrayList<MainModle> smsmList=new ConsortiumUserDao().getSomainStockSql(payType);
		request.setAttribute("smsmList", smsmList);
		request.getRequestDispatcher("pmoney/inMoney.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
