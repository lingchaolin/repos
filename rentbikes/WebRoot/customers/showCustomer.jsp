<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'showCustomer.jsp' starting page</title>
  </head>
  
  <body>
    <TABLE>
<TR>
	<TD>序号：</TD>
	<TD>身份证：</TD>
	<TD>姓名：</TD>
	<TD>性别：</TD>
	<TD>电话：</TD>
	<TD>职业：</TD>
	<TD>操作：</TD>
</TR>
<c:forEach items="${ list}" var="list">
<TR>
	<TD>${list.id}</TD>
	<TD>${list.identity }</TD>
	<TD>${list.custname }</TD>
	<TD>
		<c:if test="${list.sex== 1}">男</c:if>
		<c:if test="${list.sex== 0}">女</c:if>
	</TD>
	<TD>${list.phone }</TD>
	<TD>${list.career }</TD>
	<TD>
		<a href="/auto_lease/ShowCustomerByIdServlet?id=${list.id }&code=show">查看</a>
		<a href="/auto_lease/ShowCustomerByIdServlet?id=${list.id }&code=update">修改</a>
		<a href="/auto_lease/DeleteCustomerServlet?id=${list.id }">删除</a>
	</TD>
</TR>
</c:forEach>
</TABLE>
	<div >
		<c:if test="${page ==1}">首页</c:if>
    	<c:if test="${page > 1}"><a href="/auto_lease/ShowAllCustomerServlet?page=1">首页</a></c:if>
    	<c:if test="${page ==1}">上一页</c:if>
    	<c:if test="${page > 1}"><a href="/auto_lease/ShowAllCustomerServlet?page=${page-1 }">上一页</a></c:if>
    	<c:if test="${page == maxpage}">下一页</c:if>
    	<c:if test="${page < maxpage}"><a href="/auto_lease/ShowAllCustomerServlet?page=${page+1 }">下一页</a></c:if>
    	<c:if test="${page == maxpage}">末页</c:if>
    	<c:if test="${page < maxpage}"><a href="/auto_lease/ShowAllCustomerServlet?page=${maxpage }">末页</a></c:if>
    </div>
  </body>
  <a href="customers/addCustomer.jsp">添加客户</a>
</html>
