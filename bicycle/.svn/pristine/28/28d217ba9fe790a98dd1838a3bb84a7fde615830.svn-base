<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
%> 
<table width="100%" border="0" align="center" cellspacing="1">
	<tr>
		<td align="center" class="title1">车辆id</td>
		<td align="center" class="title1">车辆编号</td>
		<td align="center" class="title1">车辆状态</td>
		<td align="center" class="title1">所在车桩</td>
		<td align="center" class="title1">车辆销毁日期</td>

		<td align="center" class="title1">操作人</td>
		<td align="center" class="title1">操作时间</td>
		<td align="center" class="title1">租车卡ID</td>
		<td align="center" class="title1">备注</td>
		
		<td align="center" class="title1">操作</td>
	
		
	</tr>
	<c:forEach items="${stationBike}" var="c">
		<tr>
			<td align="center">${c.bicycleID }</td>
			<td align="center">${c.bicycleCode }</td>
			<td align="center">${c.status }</td>
			<td align="center">${c.pileID }</td>
			<td align="center">${c.destroyDate }</td>

			<td align="center">${c.userID }</td>
			<td align="center">${c.operatorTime }</td>
			<td align="center">${c.cardID }</td>
			<td align="center">${c.remark }</td>
			
			

			

			<td align="center">
			输入卡号: <input type="text" id="cardID" />
			<input type="button" value="租车" onclick="" /></a>
			<input type="button" value="车辆维修调出" onclick="bikeMaintainOut(${c.bicycleID })" /></a>
			<input type="button" value="车辆调出" onclick="" /></a>
			</td>
		</tr>
	</c:forEach>
	<tr>
		<td class="title2"></td>
	</tr>
</table>

