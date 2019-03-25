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
			"card_id":$("#card_id").val(),
			"card_code":$("#card_code").val(),
			"card_type":$("#card_type").val()
		}
	$("#dataList").load("<%=path%>/spring/card/select", params);
	}
	function loss(cardId) {
		if (confirm("确认挂失吗？")) {
			var str=prompt("挂失原因");
		var params = {
			"cardId" : cardId,
			"remark":str
		}
			$.post("<%=path%>/spring/card/loss", params,function(data){
				if(data=="ok"){
			var current = $("#page").text();
			goPage(current);
					
				}
			});
		}
	}
	function deleteCard(cardId) {
		if (confirm("确认注销吗？")) {
			var str=prompt("注销原因");
		var params = {
			"cardId":cardId,
			"remark":str
		}
			$.post("<%=path%>/spring/card/deleteCard", params,function(data){
				if(data=="ok"){
					var current = $("#page").text();
					goPage(current);
							
						}
			});
		}
			
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
margin-left: 900px;
}
</style>
<title>办卡业务</title>
</head>
<body onload="goPage(1)">
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td nowrap class="title1">您的位置：工作台面－－办卡业务</td>
		</tr>
	</table>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="30px" nowrap class="toolbar">&nbsp;</td>
			<td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)"
				onMouseOut="OMOU(event)" onClick="location='<%=path%>/card/turnCardAdd.jsp'"><img
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
		卡id: <input type="text" id="card_id" /> 
		卡号: <input type="text" id="card_code" />
		卡类型: <input type="text" id="card_type" />
		
		<input type="button" value="查询" onclick="goPage(1)" />
	</div>
	<div id="dataList"></div>
	<input id="back" type="button" value="返回地图" onclick="back()" />
</body>
</html>