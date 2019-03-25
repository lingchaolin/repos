<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'showCstomerById.jsp' starting page</title>
  </head>
  <body>
    <form name="form" method="post"/>
<TABLE align="center">
<TR>
	<TD>高级查询：</TD>
	<TD></TD>
</TR>
<TR>
	<TD>身份证：</TD>
	<TD>${vo.identity }</TD>
</TR>
<TR>
	<TD>姓名：</TD>
	<TD>${vo.custname}</TD>
</TR>
<TR>
	<TD>性别：</TD>
	<TD>
		<c:if test="${vo.sex ==1 }">男</c:if>
		<c:if test="${vo.sex ==0 }">女</c:if>
	</TD>
</TR>
<TR>
	<TD>地址：</TD>
	<TD>${vo.address }</TD>
</TR>
<TR>
	<TD>电话：</TD>
	<TD>${vo.phone }</TD>
</TR>
<TR>
	<TD>职业：</TD>
	<TD>${vo.career }</TD>
</TR>
<TR>
	<TD>密码：</TD>
	<TD>${vo.password }</TD>
</TR>
<TR>
	<TD><input type="button" value="返回" onclick="javascript:history.go(-1);" ></TD>
	<td>&nbsp;</td></TR>
</TABLE>
  </body>
  <a href="addCustomer.jsp">添加客户</a>
</html>
