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
<script type="text/javascript"
	src="<%=path%>/card/script/jquery-1.8.1.min.js"></script>
<script type="text/javascript"
	src="<%=path%>/card/script/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
function goPage(pageNumber){
	var pileId=$("#pile_id").val();
	var params = {
			"current":pageNumber,
			"pileId":pileId
		}
	$("#dataList").load("<%=path%>/spring/bicycle/select", params)
	}
	
	function Out(pileId) {		
		var cardCode=prompt("输入卡号");
		var params = {
			"cardCode" : cardCode
		}
			$.post("<%=path%>/spring/card/Out", params,function(data){
				if(data=="ok"){
					var param={
							"pileId":pileId,
							"cardCode" : cardCode
					}
					$.post("<%=path%>/spring/bicycleOut/Out", param,function(data){
						if(data=="ok"){
							alert("调出成功");
							var current = $("#page").text();
							goPage(current);
						}else{
							alert("调出失败");
						}
					});
					
				}else{
					alert("没有权限，或者卡号不存在");
				}
			});	
		}
	function back(){
		window.location.href="<%=path%>/card/map.jsp";
	}
</script>
<style>
#formDiv {
	margin-left: 600px;
}

#back {
	margin-left: 900px;
}
</style>
<title>办卡业务</title>
</head>
<body onload="goPage(1)">
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td nowrap class="title1">您的位置：工作台面－－车辆调入调出</td>
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
	<div id="dataList"></div>
	<input id="back" type="button" value="返回地图" onclick="back()" />
</body>
</html>