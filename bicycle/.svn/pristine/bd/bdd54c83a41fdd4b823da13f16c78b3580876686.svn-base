<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script language="javascript" src="script/common.js"></script>
<script type="text/javascript" src="js/jquery-1.8.1.min.js"></script>
<script type="text/javascript"
	src="script/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	function goPage(pageNumber) {
		var address = $("#address").val();
		var stationName = $("#stationName").val();
		var http = new XMLHttpRequest();
		http.open("get", "/bicycle/spring/selectStationByName?address="
				+ address + "&stationName=" + stationName, true);
		http.send();
		var massage;
		http.onreadystatechange = function() {

			if (http.readyState == 4) {
				if (http.status == "200") {
					massage = http.responseText;
					document.getElementById("dataList").innerHTML = massage;
				}
			}
		}
		return massage;
	}
	function stationCount(stationId,obj) {
		location.href = '/bicycle/spring/stationCount?stationId=' + stationId;
	}
	
	
</script>
<style>
#formDiv {
	margin-left: 600px;
}
</style>
<title>车点车辆信息</title>
</head>
<body onload="goPage(1)">
	
	<div id="formDiv">
		    车点地址: <input type="text" id="address" />
		    车点名称: <input type="text" id="stationName" />
		  <input type="button" value="查询"	onclick="goPage(1)" />
	</div>
	<div id="dataList"></div>
</body>
</html>