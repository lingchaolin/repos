package com.aowin.statement.serv;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aowin.dao.StatementUserDao;
import com.aowin.statement.model.MoneyIOModel;
import com.aowin.statement.model.StockNumModel;

public class PurchaseGetStockNumMessage extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String year=request.getParameter("getyear");
		int month=Integer.parseInt(request.getParameter("getmonth"));//---paytime
		String startTime=year+"-"+(month+1)+"-1 00:00:00";
		StatementUserDao sud=new StatementUserDao();
		ArrayList<StockNumModel> oriList=sud.getStockMessage();//得到库存量
		ArrayList<StockNumModel> inList=sud.getStockMessageIn(startTime);//得到入库数量
		ArrayList<StockNumModel> outList=sud.getStockMessageOut(startTime);//得到出库数量
/*		System.out.println("oriList:"+oriList.size());
		System.out.println("inList:"+inList.size());
		System.out.println("outList:"+outList.size());*/
		int stockNum=0;
		for(int i=0;i<oriList.size();i++) {
			int inSize=inList.size();
			int outSize=outList.size();
			int num=oriList.get(i).getNum();
			if(i<inSize) {
				num-=inList.get(i).getNum();
			}
			if(i<outSize) {
				num+=outList.get(i).getNum();
			}
			oriList.get(i).setNum(num);
			stockNum+=num;
		}
		request.setAttribute("stockNum", stockNum);
		request.setAttribute("oriList",oriList);
		request.setAttribute("yeartime",year);
		request.setAttribute("monthtime",month);
		request.getRequestDispatcher("pkeep/stocknum.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
