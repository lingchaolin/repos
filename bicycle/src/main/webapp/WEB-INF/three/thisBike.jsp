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
<script type="text/javascript" src="jquery-1.8.1.min.js"></script>
<script type="text/javascript"
	src="script/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	
	function bikeMaintainOut(bikeID,obj) {
		var cardID = document.getElementById('cardID').value;
		location.href = '/bicycle/spring/bikeMaintainOut?bikeID=' + bikeID+ '&cardID=' + cardID;
	}
	
	
</script>
<style>
#formDiv {
	margin-left: 600px;
}
</style>
<title>车点车辆信息</title>
</head>
<body>
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
	<table width="100%" border="0" align="center" cellspacing="1">
	<tr>
		<td align="center" class="title1">车辆id</td>
		<td align="center" class="title1">车辆编号</td>
		<td align="center" class="title1">车辆状态</td>
		<td align="center" class="title1">所在车桩</td>
		
		
		<td align="center" class="title1">操作</td>
	
		
	</tr>
		<tr>
			<td align="center">${thisBike.bicycleId }</td>
			<td align="center">${thisBike.bicycleCode }</td>
			<td align="center">${thisBike.status }</td>
			<td align="center">${thisBike.pileId }</td>

			<td align="center">
			输入卡号: <input type="text" id="cardID" />
			<input type="button" value="租车" onclick="" />
			<input type="button" value="车辆维修调出" onclick="bikeMaintainOut(${thisBike.bicycleId },this)" />
			<input type="button" value="车辆调出" onclick="" />
			</td>
		</tr>
	<tr>
		<td class="title2"></td>
	</tr>
</table>
</body>
</html>