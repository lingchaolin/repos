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

public class MaQueryAccount extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account=request.getParameter("userAccount");
		String name=request.getParameter("accountName");
		String[] status=request.getParameterValues("y");
		String[] auths=request.getParameterValues("auth");
		StringBuffer sb=new StringBuffer();
		if(!"".equals(account)) {
			sb.append(" and scmuser.account like '%"+account+"%'");
		}
		if(!"".equals(name)) {
			sb.append(" and name like '%"+name+"%'");
		}
		if(status!=null) {
			sb.append(" and (");
			for(int i=0;i<status.length;i++) {
				sb.append(" status="+status[i]);
				if(i<status.length-1) {
					sb.append(" or ");
				}
			}
			sb.append(")");
		}
		
		if(auths!=null) {System.out.println("执行");
			sb.append(" and (");
			for(int i=0;i<auths.length;i++) {
				sb.append(" usermodel.modelcode="+auths[i]);
				if(i<auths.length-1) {
					sb.append(" or ");
				}
			}
			sb.append(")");
		}
		String str=new String(sb);
		System.out.println("str="+str);
		AccountUserDao aud=AccountUserDao.getInstance();
		//ArrayList<AccountMessage> amList=aud.getAccountSingleSql(str);
		ArrayList<AccountMessage> amList=new GetAccountMessService().selectSizeSql();
		//展示全部权限
		DaoInterface dao=new GetAccountMessService();
		DaoInterface proxy=new AccountProxy(dao).getInstance();
		for(int i=0;i<amList.size();i++) {
//			ArrayList<String> list=AccountUserDao.getAuthName(amList.get(i).getAccount());
			ArrayList<String> list=proxy.selectAuthName(amList.get(i).getAccount());
			StringBuffer ssb=new StringBuffer();
			for(int j=0;j<list.size();j++) {
				ssb.append(list.get(j));
				if(j<list.size()-1) {
					ssb.append(",");
				}
			}
			String str2=String.valueOf(ssb);
			amList.get(i).setModelName(str2);
		}
		request.setAttribute("amList", amList);
		request.getRequestDispatcher("pmanage/th2.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
