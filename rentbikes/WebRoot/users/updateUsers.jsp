<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'updateUsers.jsp' starting page</title>
  </head>
  <body>
    <form name="form" action="UpdateUserServlet" method="post">
<TABLE align="center">
<TR>
	<TD>登录名：</TD>
	<TD><input name="username" value="${usersVo.username }"/></TD>
</TR>
<TR>
	<TD>身份证：</TD>
	<TD><input name="identity" value="${usersVo.identity }"/></TD>
</TR>
<TR>
	<TD>姓名：</TD>
	<TD><input name="fullname" value="${usersVo.fullname }"/></TD>
</TR>
<TR>
	<TD>性别：</TD>
	<TD>
		<SELECT name="sex" id="sex">
			<option value="${usersVo.sex}">
				<c:if test="${usersVo.sex ==1}">男 </c:if>
				<c:if test="${usersVo.sex ==0}">女 </c:if>
			</option>
			<option value="1">男</option>
			<option value="0">女</option>
		</SELECT>
	</TD>
</TR>
<TR>
	<TD>地址：</TD>
	<td><input name="address" value="${usersVo.address }"/></td>
</TR>
<TR>
	<TD>联系电话：</TD>
	<TD><input name="phone" value="${usersVo.phone }"/></TD>
</TR>
<TR>
	<TD>职位：</TD>
	<TD><input name="position" value="${usersVo.position }"/></TD>
</TR>
<TR>
	<TD>用户类型：</TD>
	<TD>
		<SELECT name="userlevel" id="role">
			<option value="${usersVo.userlevel}">
				<c:if test="${usersVo.userlevel eq 'admin'}">管理员</c:if>
				<c:if test="${usersVo.userlevel eq 'service'}">服务人员</c:if>
				<c:if test="${usersVo.userlevel eq 'user'}">普通客户</c:if>
			</option>
			<option value="admin">管理员</option>
			<option value="service">服务人员</option>
			<option value="user">普通客户</option>
		</SELECT>
	</TD>
</TR>
<TR>
	<TD><input type="submit" value="提交"></TD>
</TR>
</TABLE>
</form>
  </body>
</html>
