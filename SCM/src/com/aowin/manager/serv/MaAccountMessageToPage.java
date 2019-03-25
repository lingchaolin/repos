package com.aowin.manager.serv;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aowin.dao.AccountUserDao;
import com.aowin.manager.model.AccountMessage;
import com.aowin.manager.model.Page;
import com.aowin.proxy.AccountProxy;
import com.aowin.proxy.DaoInterface;
import com.aowin.proxy.GetAccountMessService;

public class MaAccountMessageToPage extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num=request.getParameter("changePageInput");
		HttpSession session=request.getSession();
		Page page=(Page) session.getAttribute("AccountPageNum");
		ArrayList<AccountMessage> amList = null;
		AccountUserDao aud=AccountUserDao.getInstance();
		DaoInterface dao=new GetAccountMessService();
		DaoInterface proxy=new AccountProxy(dao).getInstance();
		if("尾页".equals(num)) {
			amList=proxy.selectSql("",(page.getTotalPage()-1)*5);
			page.setCurrentPage(page.getTotalPage());
		}else if("首页".equals(num)) {
			amList=proxy.selectSql("",0);
			page.setCurrentPage(1);
		}else if("上一页".equals(num)) {
			amList=proxy.selectSql("",(page.getCurrentPage()-2)*5);
			page.setCurrentPage(page.getCurrentPage()-1);
		}else if("下一页".equals(num)) {
			amList=proxy.selectSql("",(page.getCurrentPage())*5);
			page.setCurrentPage(page.getCurrentPage()+1);
		}else {//除此之外的只有跳转页面
			page.setCurrentPage(Integer.parseInt(num.trim()));
			amList=proxy.selectSql("",(page.getCurrentPage()-1)*5);
		}
		//展示全部权限
		for(int i=0;i<amList.size();i++) {
//			ArrayList<String> list=aud.getAuthName(amList.get(i).getAccount());
			ArrayList<String> list=proxy.selectAuthName(amList.get(i).getAccount());
			StringBuffer sb=new StringBuffer();
			for(int j=0;j<list.size();j++) {
				sb.append(list.get(j));
				if(j<list.size()-1) {
					sb.append(",");
				}
			}
			String str=String.valueOf(sb);
			amList.get(i).setModelName(str);
		}
		session.setAttribute("AccountPageNum", page);//装回session
		request.setAttribute("amList", amList);
		request.getRequestDispatcher("pmanage/th.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
