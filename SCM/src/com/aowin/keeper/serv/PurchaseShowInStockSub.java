package com.aowin.keeper.serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.aowin.dao.PurchaseUserDao;
import com.aowin.keeper.model.SubModel;
import com.aowin.sell.model.SubModelNew;

public class PurchaseShowInStockSub extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String poid=request.getParameter("poid");
		ArrayList<SubModelNew> smnList=PurchaseUserDao.getPoitemStockSql(poid);
		StringBuffer buffer=new StringBuffer();
		buffer.append("[");
		for(int i=0;i<smnList.size();i++) {
			buffer.append("{");
			buffer.append("'productCode':'"+smnList.get(i).getProductCode()+"',");
			buffer.append("'name':'"+smnList.get(i).getName()+"',");
			buffer.append("'unitName':'"+smnList.get(i).getUnitname()+"',");
			buffer.append("'num':'"+smnList.get(i).getNum()+"',");
			buffer.append("'unitPrice':'"+smnList.get(i).getUnitPrice()+"',");
			buffer.append("'itemPrice':'"+smnList.get(i).getItemPrice()+"',");
			buffer.append("}");
			if(i!=smnList.size()-1) {
				buffer.append(",");
			}
		}
		buffer.append("]");
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
