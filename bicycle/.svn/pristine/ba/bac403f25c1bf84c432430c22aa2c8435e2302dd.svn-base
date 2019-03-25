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
		var longitude = $("#longitude").val();
		var latitude = $("#latitude").val();
		var http = new XMLHttpRequest();
		http.open("get", "/bicycle/spring/selectPile?longitude="
				+ longitude + "&latitude=" + latitude, true);
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
	function bikeMaintainOut(bikeID,obj) {
		var cardID = $(obj.parentNode).find("input").eq(0).val();
		location.href = '/bicycle/spring/bikeMaintainOut?bikeID=' + bikeID+ '&cardID=' + cardID;
	}
	
	function selectThisBike(bikeID,obj) {
		location.href = '/bicycle/spring/selectThisBike?bikeID=' + bikeID;
	}
	//车辆维修调入
	function canMiantainIn(pileId,stationId,obj){
		location.href = '/bicycle/spring/selectCanMaintainInBike?pileId=' + pileId+ '&stationId=' + stationId;
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
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td nowrap class="title1">您的位置：车点－－车点车辆信息</td>
		</tr>
	</table>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="30px" nowrap class="toolbar">&nbsp;</td>
			<td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)"
				onMouseOut="OMOU(event)"
				onClick="location='<%=path%>/spring/card/add'"><img
				src="images/new.gif"></td>
			<td nowrap class="toolbar">&nbsp;</td>
			<td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)"
				onMouseOut="OMOU(event)"></td>
			<td width="20px" nowrap class="toolbar">|</td>
			<td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)"
				onMouseOut="OMOU(event)"></td>
			<td width="20px" nowrap class="toolbar">|</td>
			<td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)"
				onMouseOut="OMOU(event)"></td>
			<td width="20px" nowrap class="toolbar">|</td>
			<td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)"
				onMouseOut="OMOU(event)"></td>
			<td width="20px" nowrap class="toolbar">|</td>
		</tr>
	</table>
	<div id="formDiv">
		经度: <input type="text" id="longitude" />
		 纬度: <input type="text" id="latitude" />
		  <input type="button" value="查询"	onclick="goPage(1)" />
	</div>
	<div id="dataList"></div>
</body>
</html>