<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
%> 
<table width="100%" border="0" align="center" cellspacing="1">
	<tr>
		<td align="center" class="title1">车桩id</td>
		<td align="center" class="title1">车点id</td>
		<td align="center" class="title1">车桩编号</td>
		<td align="center" class="title1">车桩状态</td>
		<td align="center" class="title1">车辆id</td>
		
		<td align="center" class="title1">操作</td>
	
		
	</tr>
	<c:forEach items="${stationPile}" var="c">
		<tr>
			<td align="center">${c.pileId }</td>
			<td align="center">${c.stationId }</td>
			<td align="center">${c.pileCode }</td>
			<td align="center">${c.status }</td>
			<td align="center">${c.bicycleId }</td>

			<td align="center">
			
				<input type="button" value="查看车辆"   onclick="selectThisBike(${c.bicycleId },this)" />
				<input type="button" value="还车" onclick="selectThisBike(${c.bicycleId },this)" />
				<input type="button" value="调入" onclick="" />
				<input type="button" value="车辆维修调入" onclick="canMiantainIn(${c.pileId },${c.stationId },this)" />
			</td>
		</tr>
	</c:forEach>
	<tr>
		<td class="title2"></td>
	</tr>
</table>

