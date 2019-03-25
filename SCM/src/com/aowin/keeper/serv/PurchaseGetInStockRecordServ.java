package com.aowin.keeper.serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aowin.dao.PurchaseUserDao;
import com.aowin.keeper.model.SubModel;
import com.aowin.keeper.model.RecordModel;
import com.aowin.manager.model.AccountMessage;
import com.aowin.manager.model.Page;

public class PurchaseGetInStockRecordServ extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//PoMainUserDao pmud=new PoMainUserDao();
		String productCode=request.getParameter("productCode");
		String recordType=request.getParameter("recordType");
		StringBuffer buffer=new StringBuffer();
		if("入库记录信息".equals(recordType)) {
			ArrayList<RecordModel>	list=PurchaseUserDao.getRecordInStockSql(productCode);
			buffer.append("[");
			for(int i=0;i<list.size();i++) {
				buffer.append("{");
				buffer.append("'stockTime':'"+list.get(i).getStockTime()+"',");
				buffer.append("'orderCode':'"+list.get(i).getOrderCode()+"',");
				buffer.append("'createUser':'"+list.get(i).getCreateUser()+"',");
				buffer.append("'stockNum':'"+list.get(i).getStockNum()+"',");
				buffer.append("'stockType':'"+list.get(i).getStockType()+"',");
				buffer.append("}");
				if(i!=list.size()-1) {
					buffer.append(",");
				}
			}
			buffer.append("]");
		}else if("出库记录信息".equals(recordType)) {
			ArrayList<RecordModel> list=PurchaseUserDao.getOutStockRecordSql(productCode);
			buffer.append("[");
			for(int i=0;i<list.size();i++) {
				buffer.append("{");
				buffer.append("'stockTime':'"+list.get(i).getStockTime()+"',");
				buffer.append("'orderCode':'"+list.get(i).getOrderCode()+"',");
				buffer.append("'createUser':'"+list.get(i).getCreateUser()+"',");
				buffer.append("'stockNum':'"+list.get(i).getStockNum()+"',");
				buffer.append("'stockType':'"+list.get(i).getStockType()+"',");
				buffer.append("}");
				if(i!=list.size()-1) {
					buffer.append(",");
				}
			}
			buffer.append("]");
		}
		response.setCharacterEncoding("utf-8");
		response.setContentType("utf-8");
		PrintWriter out=response.getWriter();
		out.print(buffer);
		out.flush();
		out.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
