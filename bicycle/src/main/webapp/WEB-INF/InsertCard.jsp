<%@page import="util.DateUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String startTime = DateUtil.currentMonth();
	String endTime = DateUtil.nextMonth();
	pageContext.setAttribute("startTime", startTime);
	pageContext.setAttribute("endTime", endTime);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script language="javascript" src="<%=path%>/card/script/common.js"></script>
<script type="text/javascript"
	src="<%=path%>/card/script/jquery-1.8.1.min.js"></script>
<script type="text/javascript"
	src="<%=path%>/card/script/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
function goPage(pageNumber){
	if($("#card_code").val()==""){
		alert("没有查询条件");
		return;
	}
	var params = {
			"card_code":$("#card_code").val()
		}
	$("#dataList").load("<%=path%>/spring/card/selectOne", params,function(){
		cop();
	});
	$("#walletMoney").val("");
	$("#monthlyMoney").val("");
	}
	function cop() {
		var type = $("#type").val();
		if (type == 1) {
			$("#money").show();
			$("#month").show();
			$("#wallet").show();
			$("#btn").show();
		}
		if (type == 2) {
			$("#money").show();
			$("#month").hide();
			$("#wallet").show();
			$("#btn").show();
		}
		if (type == 3) {
			$("#money").show();
			$("#month").show();
			$("#wallet").show();
			$("#btn").show();
		}
		if (type == 4) {
			$("#money").hide();
			$("#month").hide();
			$("#wallet").hide();
			$("#btn").hide();
			alert("此卡不能充值");
		}
		if (type == 5) {
			$("#money").hide();
			$("#month").hide();
			$("#wallet").hide();
			$("#btn").hide();
			alert("此卡不能充值");
		}
	}
	function addMoney() {
	var wallet=$("#walletMoney").val();
	var month=$("#monthlyMoney").val();
	var status=$("#status").text();
	var param={
			"startTime":$("#start").val(),
			"endTime":$("#end").val()
	}
	$.get("<%=path%>/spring/card/Date", param, function(data) {
			
		if (wallet == "" && month == "") {
			alert("没有充值项");
		} else if (wallet != "" && wallet % 50 != 0 || wallet >= 500) {
			alert("钱包每次充值金额为50的倍数，总金额不大于500");
		} else if (month!=""&&month % 5 != 0) {
			alert("月票充值金额为5的倍数");
		} else if (month!=""&&data == "ok" && month < 50) {
			alert("这是您这个月第一次充月票，不能低于50元");
		}else if(status=="锁定"){
			alert("锁定状态卡不能充值");
		}else{
			var params={
					"cardId":$("#cardId").text(),
					"cardCode" :$("#card_code").val(),
					"monthlyMoney":month,
					"walletMoney":wallet
			}
			$.get("<%=path%>/spring/card/updateMoney", params, function(
						data) {
					if (data == "ok") {
						alert("充值成功");
						$("#walletMoney").val("");
						$("#monthlyMoney").val("");
						goPage(1);
					}
				});
			}
		})
	}
	function back(){
		window.location.href="<%=path%>/card/map.jsp";
	}
</script>
<style>
#formDiv {
	margin-left: 600px;
}
#back{
margin-left: 700px;
}
</style>
<title>充值业务</title>
</head>
<body onload="cop()">
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td nowrap class="title1">您的位置：工作台面－－充值业务</td>
		</tr>
	</table>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="30px" nowrap class="toolbar">&nbsp;</td>
			<td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)"
				onMouseOut="OMOU(event)"
				onClick="location='<%=path%>/card/turnCardAdd.jsp'"><img
				src="images/new.gif">新增</td>
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
		卡号:<input type="text" id="card_code" /> <input type="button"
			value="查询" onclick="goPage(1)" /></br>

		<div id="money" style="display: none">充值金额：</div>
		<div id="month" style="display: none">
			月票：<input type="text" id="monthlyMoney" />
		</div>
		<div id="wallet" style="display: none">
			钱包：<input type="text" id="walletMoney" />
		</div>
		<div id="btn" style="display: none">
			<input type="button" value="充值" onclick="addMoney()" />
		</div>

	</div>
	<input type="hidden" id="start" value="${startTime}" />
	<input type="hidden" id="end" value="${endTime}" />

	<div id="dataList"></div>
	<input id="back" type="button" value="返回地图" onclick="back()" />
</body>
</html>