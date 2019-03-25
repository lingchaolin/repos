package com.aowin.keeper.serv;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.aowin.dao.PurchaseUserDao;
import com.aowin.keeper.model.ForInventoryShowModel;

public class PurchaseToQueryInStockServ extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productCode=request.getParameter("productCode");
		String productName=request.getParameter("productName");
		String startNum=request.getParameter("startNum");
		String endNum=request.getParameter("endNum");
		StringBuffer sb=new StringBuffer();
		sb.append(" and stock.ProductCode like '%"+productCode+"%'");
		sb.append(" and stock.name like '%"+productName+"%'");
		sb.append(" and num>="+startNum);
		if(!(endNum==null||"".equals(endNum))){
			sb.append(" and num<="+endNum);
		}
		String str=String.valueOf(sb);
		ArrayList<ForInventoryShowModel> fList=PurchaseUserDao.getQueryShowMessageSql(str);
		request.setAttribute("fList", fList);
		request.getRequestDispatcher("pkeep/query.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
