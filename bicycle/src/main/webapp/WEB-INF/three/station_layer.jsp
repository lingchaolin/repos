<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
%> 
<table width="100%" border="0" align="center" cellspacing="1">
	<tr>
		<td align="center" class="title1">车点id</td>
		<td align="center" class="title1">车点编号</td>
		<td align="center" class="title1">车点名称</td>
		<td align="center" class="title1">车点车桩数量</td>
		<td align="center" class="title1">地址</td>
		
		<td align="center" class="title1">操作</td>
	
		
	</tr>
	<c:forEach items="${listBicycle_station}" var="c">
		<tr>
			<td align="center">${c.stationId }</td>
			<td align="center">${c.stationCode }</td>
			<td align="center">${c.stationName }</td>
			<td align="center">${c.bicyclePileNum }</td>
			<td align="center">${c.address }</td>

			<td align="center">
			
				<input type="button" value="车点使用率信息统计分析" onclick="stationCount(${c.stationId },this)" />
			</td>
		</tr>
	</c:forEach>
	<tr>
		<td class="title2"></td>
	</tr>
</table>

