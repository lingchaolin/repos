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
		<td align="center" class="title1">车辆id</td>
		<td align="center" class="title1">车辆编号</td>
		<td align="center" class="title1">车辆状态</td>
		<td align="center" class="title1">所在车桩</td>
		
		
		<td align="center" class="title1">操作</td>
	
		
	</tr>
	<c:forEach items="${maintainBike}" var="c">
		<tr>
			<td align="center">${c.bicycleID }</td>
			<td align="center">${c.bicycleCode }</td>
			<td align="center">${c.status }</td>
			<td align="center">${c.pileID }</td>

			<td align="center">
			
				<input type="button" value="报废" onclick="scrapBike(${c.bicycleID })" /></a>
			</td>
		</tr>
	</c:forEach>
	
</table>
	</div>
</body>
</html>