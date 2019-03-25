package com.aowin.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aowin.dao.AccountUserDao;

public class AuthFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse resp=(HttpServletResponse)response;
		String uri=req.getRequestURI();
		String account=(String) req.getSession().getAttribute("user");
		//System.out.println("account:"+account);
		System.out.println(uri);
		String auth=null;
		boolean flag=false;
		AccountUserDao aud=AccountUserDao.getInstance();
		if(uri.startsWith("/SCM/pmanage")||uri.startsWith("/SCM/Ma")) {
			auth="01";
			flag=!aud.getAuth(account, auth);//查一下是否有对应的权限
		}else if(uri.startsWith("/SCM/pkeep")||uri.startsWith("/SCM/Purchase")) {
			auth="03";
			flag=!(aud.getAuth(account, auth)||aud.getAuth(account, "01"));
		}else if(uri.startsWith("/SCM/pmoney")||uri.startsWith("/SCM/Consortium")) {
			auth="04";
			flag=!(aud.getAuth(account, auth)||aud.getAuth(account, "01"));
		}
		if(uri.startsWith("/SCM/Sets")||uri.startsWith("/SCM/title.jsp")||uri.startsWith("/SCM/catalog.htm")) {//这个页面免过滤
			flag=false;
		}
		if(flag) {
			PrintWriter out=response.getWriter();
			out.print("<html>");
			out.print("<head>");
			out.print("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">");
			out.print("</head>");
			out.print("<body>");
			out.print("权限不足");
			out.print("</body>");
			out.print("</html>");
			out.flush();
			out.close();
			return;
		}
		chain.doFilter(request, response);
	}


}
