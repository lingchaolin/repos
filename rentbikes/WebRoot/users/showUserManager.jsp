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
	<TD>�߼���ѯ</TD>
</TR>
<TR>
	<TD>��¼����</TD>
	<TD>${usersVo.username }</TD>
</TR>
<TR>
	<TD>���֤��</TD>
	<TD>${usersVo.identity }</TD>
</TR>
<TR>
	<TD>������</TD>
	<TD>${usersVo.fullname }</TD>
</TR>
<TR>
	<TD>�Ա�</TD>
	<TD>
				<c:if test="${usersVo.sex ==1}">�� </c:if>
				<c:if test="${usersVo.sex ==0}">Ů </c:if>
	</TD>
</TR>
<TR>
	<TD>��ַ��</TD>
	<td>${usersVo.address }</td>
</TR>
<TR>
	<TD>��ϵ�绰��</TD>
	<TD>${usersVo.phone }</TD>
</TR>
<TR>
	<TD>ְλ��</TD>
	<TD>${usersVo.position }</TD>
</TR>
<TR>
	<TD>�û����ͣ�</TD>
	<TD>
				<c:if test="${usersVo.userlevel eq 'admin'}">����Ա</c:if>
				<c:if test="${usersVo.userlevel eq 'service'}">������Ա</c:if>
				<c:if test="${usersVo.userlevel eq 'user'}">��ͨ�ͻ�</c:if>
	</TD>
</TR>
<TR>
	<TD>�û����룺</TD>
	<td>${usersVo.password }</td>
</TR>
<TR>
	<TD><input type="button" value="����" onclick="javascript:history.go(-1);" ></TD>
	<td>&nbsp;</td>
</TR>
</TABLE>
</form>
  </body>
</html>
