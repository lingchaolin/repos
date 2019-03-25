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
<script language="javascript" src="<%=path%>/card/script/common.js"></script>
<script type="text/javascript" src="<%=path%>/card/script/jquery-1.8.1.min.js"></script>
<script type="text/javascript"
	src="<%=path%>/card/script/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
function goPage(pageNumber){
	var params = {
			"current":pageNumber,
			"name":$("#name").val()
		}
	$("#dataList").load("<%=path%>/spring/card/selectCurrent", params);
	}
	function back(){
		window.location.href="<%=path%>/card/map.jsp";
	}
	
	function cop(){
		$("#data").load("<%=path%>/spring/card/data");
	}
	function show(cardId){
		var params={
				"cardId":cardId
		}
		$("#data2").load("<%=path%>/spring/card/Onedata",params);
		$("#data3").load("<%=path%>/spring/card/cardRecord",params);
		$("#hhh").show();
	}
	function hide(){
		$("#hhh").hide();
	}
</script>
<style>
#formDiv {
	margin-left: 600px;
}
#back{
margin-left: 900px;
}
</style>
<title>办卡业务</title>
</head>
<body onload="goPage(1),cop()">
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td nowrap class="title1">您的位置：工作台面－－办卡业务</td>
		</tr>
	</table>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="30px" nowrap class="toolbar">&nbsp;</td>
			<td nowrap class="toolbar">&nbsp;</td>
			<td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)"
				onMouseOut="OMOU(event)">未审核单据</td>
			<td width="20px" nowrap class="toolbar">|</td>
			<td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)"
				onMouseOut="OMOU(event)">审核中单据</td>
			<td width="20px" nowrap class="toolbar">|</td>
			<td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)"
				onMouseOut="OMOU(event)">已审核单据</td>
			<td width="20px" nowrap class="toolbar">|</td>
			<td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)"
				onMouseOut="OMOU(event)">被退回单据</td>
			<td width="20px" nowrap class="toolbar">|</td>
		</tr>
	</table>
	<div id="formDiv">
		
		姓名: <input type="text" id="name" />
		
		<input type="button" value="查询" onclick="goPage(1)" />
	</div>
	<div id="dataList"></div>
	<h1>实时所有卡数据统计</h1>
	<div id="data"></div>
	
	<div id="hhh" style="display:none">
	<h1 id="h1">单卡数据统计</h1>
	<div id="data2"></div>
	<h1 id="h1">消费记录</h1>
	<div id="data3"></div>
	<input  type="button" value="关闭" onclick="hide()" />
	</div>
	<input id="back" type="button" value="返回地图" onclick="back()" />
</body>
</html>