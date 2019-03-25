<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'showBike.jsp' starting page</title>
<script>
function submitForm()
{
	parent.right.location.href = "UpdateBikeServlet";
}
</script>
  </head>
  
  <body>
    <TABLE align="center" width="80%">
<TR>
	<TD>车号</TD>
	<TD>颜色</TD>
	<TD>价值</TD>
	<TD>租金</TD>
	<TD>押金</TD>
	<TD>租用情况</TD>
	<TD>操作</TD>
</TR>
<c:forEach items="${list}" var="list">
<TR>
	<TD>${list.bikenumber}</TD>
	<TD>${list.color }</TD>
	<TD>${list.price }</TD>
	<TD>${list.rentprice }</TD>
	<TD>${list.deposit }</TD>
	<TD>
		<c:if test="${list.isrenting ==0}">未出租</c:if>
		<c:if test="${list.isrenting ==1}">已出租</c:if>
	</TD>
	<TD>
	<a href="/auto_lease/QueryByIdServlet?id=${list.id }&code=select">查看</a>
	<a href="/auto_lease/QueryByIdServlet?id=${list.id }&code=update">修改</a>
	<a href="/auto_lease/DeleteBikeServet?id=${list.id }">删除</a></TD>
</TR>
</c:forEach>
</TABLE>
	<div align="center">
		<c:if test="${page ==1}">首页</c:if>
    	<c:if test="${page > 1}"><a href="/auto_lease/ShowBikesServlet?page=1">首页</a></c:if>
    	<c:if test="${page ==1}">上一页</c:if>
    	<c:if test="${page > 1}"><a href="/auto_lease/ShowBikesServlet?page=${page-1 }">上一页</a></c:if>
    	<c:if test="${page == maxpage}">下一页</c:if>
    	<c:if test="${page < maxpage}"><a href="/auto_lease/ShowBikesServlet?page=${page+1 }">下一页</a></c:if>
    	<c:if test="${page == maxpage}">末页</c:if>
    	<c:if test="${page < maxpage}"><a href="/auto_lease/ShowBikesServlet?page=${maxpage }">末页</a></c:if>
    </div>
  </body>
</html>
