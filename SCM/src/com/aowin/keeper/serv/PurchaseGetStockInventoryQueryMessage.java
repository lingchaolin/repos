package com.aowin.keeper.serv;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.aowin.dao.PurchaseUserDao;
import com.aowin.keeper.model.ForInventoryShowModel;

public class PurchaseGetStockInventoryQueryMessage extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ForInventoryShowModel> fList=PurchaseUserDao.getInventoryShowMessageSql();
		request.setAttribute("fList", fList);
		request.getRequestDispatcher("pkeep/query.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
