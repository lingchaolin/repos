package com.aowin.statement.serv;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aowin.dao.ConsortiumUserDao;
import com.aowin.dao.PurchaseUserDao;
import com.aowin.dao.StatementUserDao;
import com.aowin.keeper.model.MainModle;
import com.aowin.manager.model.AccountMessage;
import com.aowin.manager.model.Page;
import com.aowin.statement.model.MoneyIOModel;
import com.aowin.statement.model.MoneyMessageModel;

public class ConsortiumGetMoneyMessage extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String year=request.getParameter("getyear");
		int month=Integer.parseInt(request.getParameter("getmonth"));//---paytime
		String type=request.getParameter("gettype");
		String startTime=year+"-"+month+"-1 00:00:00";
		String endTime=year+"-"+(month+1)+"-1 00:00:00";
		StatementUserDao sud=new StatementUserDao();
		ArrayList<MoneyMessageModel> mmList=null;
		MoneyIOModel mmExpd=sud.getStatPomainStockSql(startTime, endTime);//付款
		MoneyIOModel mmRece=sud.getStatSomainStockSql(startTime, endTime);
		if("付款明细".equals(type)) {
			mmList=sud.getStatConsortPomainMess(startTime, endTime);
		}else if("收款明细".equals(type)){
			mmList=sud.getStatConsortSomainMess(startTime, endTime);
		}
//		System.out.println(mmList.size());
		request.setAttribute("mesType", type);
		request.setAttribute("mmExpd", mmExpd);
		request.setAttribute("mmRece", mmRece);
		request.setAttribute("mmList",mmList);
		request.setAttribute("yeartime",year);
		request.setAttribute("monthtime",month);
		request.getRequestDispatcher("pmoney/stateofconsort.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
