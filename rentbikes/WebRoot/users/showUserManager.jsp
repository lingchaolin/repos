<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'showUserManager.jsp' starting page</title>
  </head>
  <body>
    <form name="form" action="" method="post">
<TABLE align="center">
<TR>
	<TD></TD>
	<TD>高级查询</TD>
</TR>
<TR>
	<TD>登录名：</TD>
	<TD>${usersVo.username }</TD>
</TR>
<TR>
	<TD>身份证：</TD>
	<TD>${usersVo.identity }</TD>
</TR>
<TR>
	<TD>姓名：</TD>
	<TD>${usersVo.fullname }</TD>
</TR>
<TR>
	<TD>性别：</TD>
	<TD>
				<c:if test="${usersVo.sex ==1}">男 </c:if>
				<c:if test="${usersVo.sex ==0}">女 </c:if>
	</TD>
</TR>
<TR>
	<TD>地址：</TD>
	<td>${usersVo.address }</td>
</TR>
<TR>
	<TD>联系电话：</TD>
	<TD>${usersVo.phone }</TD>
</TR>
<TR>
	<TD>职位：</TD>
	<TD>${usersVo.position }</TD>
</TR>
<TR>
	<TD>用户类型：</TD>
	<TD>
				<c:if test="${usersVo.userlevel eq 'admin'}">管理员</c:if>
				<c:if test="${usersVo.userlevel eq 'service'}">服务人员</c:if>
				<c:if test="${usersVo.userlevel eq 'user'}">普通客户</c:if>
	</TD>
</TR>
<TR>
	<TD>用户密码：</TD>
	<td>${usersVo.password }</td>
</TR>
<TR>
	<TD><input type="button" value="返回" onclick="javascript:history.go(-1);" ></TD>
	<td>&nbsp;</td>
</TR>
</TABLE>
</form>
  </body>
</html>
