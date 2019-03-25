package com.aowin.sell.serv;

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
import com.aowin.keeper.model.MainModle;
import com.aowin.manager.model.AccountMessage;
import com.aowin.manager.model.Page;

public class ConsortiumExpend extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String poid=request.getParameter("getStockNo");
		//获取付款方式//获取状态
		ConsortiumUserDao cud=new ConsortiumUserDao();
		MainModle pmm=cud.getPoidMessSql(poid);
		String payType=pmm.getPayType();
		String status=pmm.getStatus();
		HttpSession session=request.getSession();
		/*session.setAttribute("user", "111");*/
		String payUser=(String) session.getAttribute("user");
		//时间
		Calendar cal=Calendar.getInstance();
		cal.setTimeInMillis(System.currentTimeMillis());
		String payTime=cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH)+1)+"-"+cal.get(Calendar.DATE)+" "+cal.get(Calendar.HOUR_OF_DAY)+":"+cal.get(Calendar.MINUTE)+":"+cal.get(Calendar.SECOND);
		if("预付款到发货".equals(payType)&&"新单据".equals(status)) {
			cud.modifyPrePoamin(poid,payTime,payUser);
		}else if("款到发货".equals(payType)&&"新单据".equals(status)){
			cud.modifyNormPoamin(poid,payTime,payUser);
		}else {//满足条件-->了结
			cud.modifyNormPoamin(poid,payTime,payUser);
//			cud.modifyEndPoamin(poid,payTime,payUser);//了结不归我们管
		}
		int getPayType=0;
		if("预付款到发货".equals(payType)) {
			getPayType=130;
		}else if("款到发货".equals(payType)) {
			getPayType=120;
		}else if("货到付款".equals(payType)) {
			getPayType=110;
		}
		request.getRequestDispatcher("ConsortiumShowPurchaseMain?getPayType="+getPayType).forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
