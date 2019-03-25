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
import com.aowin.sell.model.QueryMoneyModel;
import com.aowin.util.TimeConvert;

public class ConsortiumQuery extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String startTime=request.getParameter("stDate");
		String endTime=request.getParameter("edDate");
		String payIO=request.getParameter("payIO");
		String payType=request.getParameter("payTp");
		String orderNo=request.getParameter("orderNo");
		StringBuffer sb=new StringBuffer();
		if(!"".equals(startTime)) {
			startTime=TimeConvert.Convert(startTime);
		}
		if(!"".equals(endTime)) {
			endTime=TimeConvert.Convert(endTime);
		}
		if(startTime!=null&&!"".equals(startTime)) {
			sb.append(" and paytime >'"+startTime+"'");
		}
		if(endTime!=null&&!"".equals(endTime)) {
			sb.append(" and paytime <'"+endTime+"'");
		}
		if(!"".equals(payType)&&payType!=null) {
			sb.append(" and paytype='"+payType+"'");
		}
		ConsortiumUserDao cud=new ConsortiumUserDao();
		ArrayList<QueryMoneyModel> qmmList=null;
//		int size=0;
		if("收入".equals(payIO)) {//选择销售单查找
			if(!("".equals(orderNo))) {
				sb.append(" and soid like '%"+payType+"%'");
			}
			String str=String.valueOf(sb);
//			size=cud.getInMoneySoaminNum(str);
			qmmList=cud.getInMoneySoamin(str);//初始页面为1
		}else if("支出".equals(payIO)) {//选择采购单查找
			if(!("".equals(orderNo))) {
				sb.append(" and poid like '%"+payType+"%'");
			}
			String str=String.valueOf(sb);
			System.out.println(str);
			qmmList=cud.getOutMoneyPoamin(str);
		}
		request.setAttribute("qmmList", qmmList);
		/**在上边添加判断，若传过来page，根据page的内容查询，否则默认从0开始查询*/
		request.getRequestDispatcher("pmoney/resultmoney.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
