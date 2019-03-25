package com.aowin.manager.serv;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.buf.UDecoder;

import com.aowin.dao.AccountUserDao;
import com.aowin.manager.model.AccountMessage;

public class MaAddOrModifyAccountToSql extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account=request.getParameter("userAccount");//AccountMessage
		String name=request.getParameter("accountName");
		String createDate=request.getParameter("jzrq");
		/*String status=request.getParameter("y");*/
		String status=request.getParameterValues("y")[0];
		String[] modelName=request.getParameterValues("auth");
		AccountMessage am=null;
	
		ArrayList<AccountMessage> amList=AccountUserDao.getAccountSql(" and usermodel.Account='"+account+"'");
		if(amList.size()>=1) {//有该账号--修改
			//删除旧权限，添加新权限
			AccountUserDao.deleteAccountSqlUsermodel(amList.get(0));
			for(int i=0;i<modelName.length;i++) {
				am=new AccountMessage(account, name, createDate, status, modelName[i]);
				AccountUserDao.addAccountSqlUsermodel(am);
			}
			AccountUserDao.modifyAccountSqlScmuser(am);
			
		}else {//没有该账号--增加
			for(int i=0;i<modelName.length;i++) {
				am=new AccountMessage(account, name, createDate, status, modelName[i]);
				AccountUserDao.addAccountSqlUsermodel(am);
			}
			AccountUserDao.addAccountSqlScmuser(am);
		}
		response.sendRedirect("MaGetAccountMessage");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
