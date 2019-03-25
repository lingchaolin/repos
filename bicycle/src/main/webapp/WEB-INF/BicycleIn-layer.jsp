<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
%>
<table width="100%" border="0" align="center" cellspacing="1">
	<tr>
		<td class="title1">车辆id</td>
		<td class="title1">车辆编号</td>
		<td class="title1">车辆状态</td>
		<td class="title1">所在车桩</td>
		<td class="title1">车辆销毁日期</td>

		<td class="title1">操作人</td>
		<td class="title1">操作时间</td>
		<td class="title1">租车卡id</td>

		<td class="title1">备注</td>
		<td class="title1">操作</td>

	</tr>
	<c:forEach items="${page.list}" var="c">
		<tr>
			<td align="center">${c.bicycleId }</td>
			<td align="center">${c.bicycleCode }</td>
			<td align="center">${c.status}</td>
			<td align="center">${c.pileId}</td>

			<td align="center">${c.destroyDate }</td>
			<td align="center">${c.userId}</td>
			<td align="center">${c.operatorTime }</td>
			<td align="center">${c.cardId}</td>
			<td align="center">${c.remark }</td>
			<td align="center">	
			
		   <input type="button" value="调入" onclick="In('${c.bicycleId }')" /></td>
		
		</tr>
	</c:forEach>
	<tr>
		<td class="title2"></td>
	</tr>
</table>

<%@ include file="page.jsp"%>