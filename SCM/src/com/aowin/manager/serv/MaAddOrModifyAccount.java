package com.aowin.manager.serv;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aowin.dao.AccountUserDao;
import com.aowin.manager.model.AccountMessage;

public class MaAddOrModifyAccount extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account=request.getParameter("addAccount");
		if(!("".equals(account)||account==null)) {//已存在账号--修改--获取该账户信息
			ArrayList<AccountMessage> amList=AccountUserDao.getAccountSql(" and usermodel.Account='"+account+"'");
			AccountMessage am=amList.get(0);
			StringBuffer sb=new StringBuffer();
			for(int i=1;i<amList.size();i++) {
				sb.append(amList.get(i).getModelName());
			}
			am.setModelName(am.getModelName()+sb);
			request.setAttribute("amList", amList);
		}
		request.getRequestDispatcher("pmanage/th_modify.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
