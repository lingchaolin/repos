<%@ page language="java" import="com.cn.users.*" pageEncoding="gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'showUsers.jsp' starting page</title>
  </head>
  <body>
    <TABLE align="center">
<TR>
	<TD>序号</TD>
	<TD>登录名</TD>
	<TD>身份证</TD>
	<TD>姓名</TD>
	<TD>性别</TD>
	<TD>职位</TD>
	<TD>用户类型</TD>
	<TD>操作</TD>
</TR>
<c:forEach items="${list}" var="list">
<TR>
	<TD>${list.id }</TD>
	<TD>${list.username }</TD>
	<TD>${list.identity }</TD>
	<TD>${list.fullname }</TD>
	<TD>
	<c:if test="${list.sex ==1}">男</c:if>
	<c:if test="${list.sex ==0}">女</c:if>
	</TD>
	<TD>${list.position }</TD>
	<TD>
		<c:if test="${list.userlevel eq 'admin'}">管理员</c:if>
		<c:if test="${list.userlevel eq 'service'}">服务人员</c:if>
		<c:if test="${list.userlevel eq 'user'}">普通客户</c:if>
	</TD>
	<TD>
		<a href="ShowUserByIDServlet?id=${list.id }&code=show">查看</a>
		<a href="ShowUserByIDServlet?id=${list.id }&code=update"">修改</a>
		<a href="DeleteUserServlet?id=${list.id }">删除</a>
	</TD>
</TR>
</c:forEach>

</TABLE>
	<div align="center">
		<c:if test="${page ==1}">首页</c:if>
    	<c:if test="${page > 1}"><a href="ShowUsersServlet?page=1">首页</a></c:if>
    	<c:if test="${page ==1}">上一页</c:if>
    	<c:if test="${page > 1}"><a href="ShowUsersServlet?page=${page-1 }">上一页</a></c:if>
    	<c:if test="${page == maxpage}">下一页</c:if>
    	<c:if test="${page < maxpage}"><a href="ShowUsersServlet?page=${page+1 }">下一页</a></c:if>
    	<c:if test="${page == maxpage}">末页</c:if>
    	<c:if test="${page < maxpage}"><a href="ShowUsersServlet?page=${maxpage }">末页</a></c:if>
    </div>
  </body>
</html>
