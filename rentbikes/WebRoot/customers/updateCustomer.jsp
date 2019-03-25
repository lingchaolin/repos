<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'updateCustomer.jsp' starting page</title>
  </head>
  <body>
    <form name="form" method="post" action="/auto_lease/UpdateCustomerServlet"/>
<TABLE align="center">
<TR>
	<TD>高级查询</TD>
	<TD></TD>
</TR>
<TR>
	<TD>身份证：</TD>
	<TD><input name="identity" value="${vo.identity }"/></TD>
</TR>
<TR>
	<TD>姓名：</TD>
	<TD><input name="custname" value="${vo.custname }"/></TD>
</TR>
<TR>
	<TD>性别：</TD>
	<TD>
		<SELECT NAME="sex" id="sex">
			<option value="${vo.sex}">
				<c:if test="${vo.sex==1}">男</c:if>
				<c:if test="${vo.sex==0}">女</c:if>
			</option>
			<option value="1">男</option>
			<option value="0">女</option>
		</SELECT>
	</TD>
</TR>
<TR>
	<TD>地址：</TD>
	<TD><input name="address" value="${vo.address }"/></TD>
</TR>
<TR>
	<TD>电话：</TD>
	<TD><input name="phone" value="${vo.phone }"/></TD>
</TR>
<TR>
	<TD>职业：</TD>
	<TD><input name="career" value="${vo.career }"/></TD>
</TR>
<TR>
	<TD>密码：</TD>
	<TD><input name="password" value="${vo.password }"/></TD>
</TR>
<TR>
	<TD></TD>
	<TD><input type="submit" value="提交"></TD>
</TR>
</TABLE>
</form>
  </body>
</html>
