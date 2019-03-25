<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath();
	pageContext.setAttribute("path", path);
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.8.1.min.js"></script>
<script type="text/javascript">
	
	function bikeMaintainIn(pileId,stationId,bicycleID,obj) {
		var cardID = obj.parentNode.firstElementChild.value;
		location.href = '/bicycle/spring/maintainBikeIn?bicycleID=' 
				+ bicycleID + '&pileId=' + pileId + '&stationId=' + stationId 
				+ '&cardID=' + cardID;
	}
</script>
<title>Insert title here</title>
</head>
<body>
	<div id="dataList">
		<table width="100%" border="0" align="center" cellspacing="1">
	<tr>
		<td align="center" class="title1">当前车点</td>
		<td align="center" class="title1">当前车桩</td>
		<td align="center" class="title1">车辆id</td>
		<td align="center" class="title1">车辆编号</td>
		<td align="center" class="title1">车辆状态</td>
		
		
		<td align="center" class="title1">操作</td>
	
		
	</tr>
	<c:forEach items="${maintainBike}" var="c">
		<tr>
		
			<td align="center">${stationId }</td>
			<td align="center">${pileId }</td>
			<td align="center">${c.bicycleId }</td>
			<td align="center">${c.bicycleCode }</td>
			<td align="center">${c.status }</td>
			

			<td align="center">
				输入卡号: <input type="text" id="cardID" />
				<input type="button" value="车辆维修调入" onclick="bikeMaintainIn(${pileId },${stationId },${c.bicycleId },this)" /></a>
			</td>
		</tr>
	</c:forEach>
	
</table>
	</div>
</body>
</html>