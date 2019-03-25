<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
%> 
<table width="100%" border="0" align="center" cellspacing="1">
	<tr>
		<td class="title1">日期</td>
		<td class="title1">消费类型</td>
		<td class="title1">金额</td>
	</tr>
	<c:forEach items="${list}" var="c">
		<tr>
			<td align="center">${c.createTime }</td>
			<td align="center">${c.turn }</td>
			<td align="center">${c.chgMonthlyMoney }</td>
			<td align="center"></td>
		</tr>
	</c:forEach>
	<tr>
		<td class="title2"></td>
	</tr>
</table>
