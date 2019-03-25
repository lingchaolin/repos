<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
%> 
<table width="100%" border="0" align="center" cellspacing="1">
	<tr>
		<td class="title1">车桩id</td>
		<td class="title1">车点id</td>
		<td class="title1">车桩供应商</td>
		<td class="title1">车桩编号</td>
		<td class="title1">状态</td>

		<td class="title1">安装日期</td>
		<td class="title1">拆解日期</td>
		<td class="title1">操作人</td>
		
		<td class="title1">操作时间</td>
		<td class="title1">所存车辆</td>
		<td class="title1">备注</td>
		<td class="title1">操作</td>
		
	</tr>
	<c:forEach items="${page.list}" var="c">
		<tr>
			<td align="center">${c.pileId }</td>
			<td align="center">${c.stationId }</td>
			<td align="center">${c.venderId}</td>
			<td align="center">${c.pileCode}</td>

			<td align="center">${c.turn }</td>
			<td align="center">${c.installTime }</td>
			<td align="center">${c.disassemblyTime }</td>
			<td align="center">${c.userId}</td>
			<td align="center">${c.operatorTime }</td>
			<td align="center">${c.bicycleId }</td>
			<td align="center">${c.remark }</td>

			<td align="center">	
			<c:if test="${c.status==1}">
			<input type="button" value="调出" onclick="Out('${c.pileId }')" />
			</c:if>
			</td>
		</tr>
	</c:forEach>
	<tr>
		<td class="title2"></td>
	</tr>
</table>

<%@ include file="page.jsp"%>