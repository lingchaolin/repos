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
	<TD>���</TD>
	<TD>��¼��</TD>
	<TD>���֤</TD>
	<TD>����</TD>
	<TD>�Ա�</TD>
	<TD>ְλ</TD>
	<TD>�û�����</TD>
	<TD>����</TD>
</TR>
<c:forEach items="${list}" var="list">
<TR>
	<TD>${list.id }</TD>
	<TD>${list.username }</TD>
	<TD>${list.identity }</TD>
	<TD>${list.fullname }</TD>
	<TD>
	<c:if test="${list.sex ==1}">��</c:if>
	<c:if test="${list.sex ==0}">Ů</c:if>
	</TD>
	<TD>${list.position }</TD>
	<TD>
		<c:if test="${list.userlevel eq 'admin'}">����Ա</c:if>
		<c:if test="${list.userlevel eq 'service'}">������Ա</c:if>
		<c:if test="${list.userlevel eq 'user'}">��ͨ�ͻ�</c:if>
	</TD>
	<TD>
		<a href="ShowUserByIDServlet?id=${list.id }&code=show">�鿴</a>
		<a href="ShowUserByIDServlet?id=${list.id }&code=update"">�޸�</a>
		<a href="DeleteUserServlet?id=${list.id }">ɾ��</a>
	</TD>
</TR>
</c:forEach>

</TABLE>
	<div align="center">
		<c:if test="${page ==1}">��ҳ</c:if>
    	<c:if test="${page > 1}"><a href="ShowUsersServlet?page=1">��ҳ</a></c:if>
    	<c:if test="${page ==1}">��һҳ</c:if>
    	<c:if test="${page > 1}"><a href="ShowUsersServlet?page=${page-1 }">��һҳ</a></c:if>
    	<c:if test="${page == maxpage}">��һҳ</c:if>
    	<c:if test="${page < maxpage}"><a href="ShowUsersServlet?page=${page+1 }">��һҳ</a></c:if>
    	<c:if test="${page == maxpage}">ĩҳ</c:if>
    	<c:if test="${page < maxpage}"><a href="ShowUsersServlet?page=${maxpage }">ĩҳ</a></c:if>
    </div>
  </body>
</html>
