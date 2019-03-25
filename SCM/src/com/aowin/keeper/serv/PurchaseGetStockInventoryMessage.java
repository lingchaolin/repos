package com.aowin.keeper.serv;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aowin.dao.PurchaseUserDao;
import com.aowin.keeper.model.ForInventoryShowModel;
import com.aowin.manager.model.Page;

public class PurchaseGetStockInventoryMessage extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ForInventoryShowModel> limList=PurchaseUserDao.getInvMessageLim(0);
		ArrayList<ForInventoryShowModel> sizeList=PurchaseUserDao.getInventoryShowMessageSql();
		Page invPage=new Page();
		invPage .setTotalNum(sizeList.size());
		invPage.setCurrentPage(1);
		HttpSession session=request.getSession();
		//System.out.println("size:"+sizeList.size());
		session.setAttribute("invPage", invPage);
		request.setAttribute("limList", limList);
		request.getRequestDispatcher("pkeep/count.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
