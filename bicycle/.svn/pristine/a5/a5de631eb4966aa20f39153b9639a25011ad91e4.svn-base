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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript">
	
	function scrapBike(bikeID) {
		location.href = '/bicycle/spring/scrapBike?bikeID=' + bikeID;
	}
</script>
<title>Insert title here</title>
</head>
<body>
	<div id="dataList">
		<table width="100%" border="0" align="center" cellspacing="1">
	<tr>
		<td align="center" class="title1">车桩数量</td>
		<td align="center" class="title1">总的车辆借出数</td>
		<td align="center" class="title1">日均车辆借出数</td>
		<td align="center" class="title1">总的车辆还入数</td>
		<td align="center" class="title1">日均车辆还入数</td>
		<td align="center" class="title1">总的车辆调出数(包括车辆维修调出)</td>
		<td align="center" class="title1">日均车辆调出数(包括车辆维修调出)</td>
		<td align="center" class="title1">总的车辆调入数(包括车辆维修调入)</td>
		<td align="center" class="title1">日均车辆调入数(包括车辆维修调入)</td>
	</tr>
		<tr>
			<td align="center">${stationCountMap.pileNum }</td>
			<td align="center">${stationCountMap.bikeBorrowNum }</td>
			<td align="center">${stationCountMap.bikeBorrowNumAverage }</td>
			<td align="center">${stationCountMap.bikeRepayNum }</td>
			<td align="center">${stationCountMap.bikeRepayNumAverage }</td>
			<td align="center">${stationCountMap.bikeOutNum }</td>
			<td align="center">${stationCountMap.bikeOutNumAverage }</td>
			<td align="center">${stationCountMap.bikeInNum }</td>
			<td align="center">${stationCountMap.bikeInNumAverage }</td>
		</tr>
	
</table>
	</div>
</body>
</html>