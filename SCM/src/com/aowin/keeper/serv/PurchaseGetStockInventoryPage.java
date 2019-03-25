package com.aowin.keeper.serv;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aowin.dao.AccountUserDao;
import com.aowin.dao.PurchaseUserDao;
import com.aowin.keeper.model.ForInventoryShowModel;
import com.aowin.manager.model.AccountMessage;
import com.aowin.manager.model.Page;

public class PurchaseGetStockInventoryPage extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num=request.getParameter("changePageInput");
		HttpSession session=request.getSession();
		Page invPage=(Page) session.getAttribute("invPage");
		ArrayList<ForInventoryShowModel> limList = null;
		if("尾页".equals(num)) {
			limList=PurchaseUserDao.getInvMessageLim((invPage.getTotalPage()-1)*5);
			invPage.setCurrentPage(invPage.getTotalPage());
		}else if("首页".equals(num)) {
			limList=PurchaseUserDao.getInvMessageLim(0);
			invPage.setCurrentPage(1);
		}else if("上一页".equals(num)) {
			limList=PurchaseUserDao.getInvMessageLim((invPage.getCurrentPage()-2)*5);
			invPage.setCurrentPage(invPage.getCurrentPage()-1);
		}else if("下一页".equals(num)) {
			limList=PurchaseUserDao.getInvMessageLim((invPage.getCurrentPage())*5);
			invPage.setCurrentPage(invPage.getCurrentPage()+1);
		}else {//除此之外的只有跳转页面
			invPage.setCurrentPage(Integer.parseInt(num.trim()));
			limList=PurchaseUserDao.getInvMessageLim((invPage.getCurrentPage()-1)*5);
		}
		session.setAttribute("invPage", invPage);
		request.setAttribute("limList", limList);
		request.getRequestDispatcher("pkeep/count.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
