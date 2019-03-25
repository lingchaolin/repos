package com.aowin.manager.serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aowin.dao.AccountUserDao;
import com.aowin.manager.model.AccountMessage;

public class MaCheckAccountRepeat extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account=request.getParameter("userAccount");
		ArrayList<AccountMessage> amList=AccountUserDao.getAccountSql(" and usermodel.Account='"+account+"'");
		PrintWriter out=response.getWriter();
		if("".equals(account)) {
			out.print("none");
		}else if(amList.size()>=1) {
			out.print("no");
		}else {
			out.print("yes");
		}
		out.flush();
		out.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
