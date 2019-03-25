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
import com.aowin.proxy.AccountProxy;
import com.aowin.proxy.DaoInterface;
import com.aowin.proxy.GetAccountMessService;

public class MaDeleteAccount extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account=request.getParameter("accountNo");
		//�ж��Ƿ����ɾ�����ɹ���/���۵�
		AccountUserDao aud=AccountUserDao.getInstance();
		DaoInterface dao=new GetAccountMessService();
		DaoInterface proxy=new AccountProxy(dao).getInstance();
//		if(aud.isSomainUnFinish(account)||aud.isPomainUnFinish(account)) {
		if(proxy.isSomainExist(account)||proxy.isPomainExist(account)) {
			PrintWriter out=response.getWriter();
			out.print("<html>");
			out.print("<head>");
			out.print("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">");
			out.print("</head>");
			out.print("<body>");
			out.print("���û�����ض���δ�˽ᣬ�޷�ɾ��!");
			out.print("</body>");
			out.print("</html>");
			out.flush();
			out.close();
			return;
		}
		AccountUserDao.deleteAccountFromScmuser(account);
		AccountUserDao.deleteAccountFromUsermodel(account);
		response.sendRedirect("MaGetAccountMessage");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
