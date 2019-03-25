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

public class MaGetAccountMessage extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountUserDao aud=AccountUserDao.getInstance();
		
		DaoInterface dao=new GetAccountMessService();
		DaoInterface proxy=new AccountProxy(dao).getInstance();
		ArrayList<AccountMessage> sizeList=proxy.selectSizeSql();
		ArrayList<AccountMessage> amList=proxy.selectSql("",0);
		
		Page page=new Page();
		page.setTotalNum(sizeList.size());
		page.setCurrentPage(1);
		HttpSession session=request.getSession();
		
		String account=(String) session.getAttribute("user");
//		String userName=aud.getUserName(account);
		String userName=proxy.selectUserName(account);
		session.setAttribute("userName", userName);
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
		//根据存入的账户获取用户名
		session.setAttribute("AccountPageNum", page);
		request.setAttribute("amList", amList);
		request.getRequestDispatcher("pmanage/th.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
