<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>查询</title>
<% 	String path=request.getContextPath();
		String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		%>
		<base href="<%=basePath %>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/style.css" rel="stylesheet" type="text/css">

<link type="text/css" href="css/jquery-ui-1.8.17.custom.css" rel="stylesheet" />
     <link type="text/css" href="css/jquery-ui-timepicker-addon.css" rel="stylesheet" />
    <script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
	<script type="text/javascript" src="js/jquery-ui-1.8.17.custom.min.js"></script>
	<script type="text/javascript" src="js/jquery-ui-timepicker-addon.js"></script>
    <script type="text/javascript" src="js/jquery-ui-timepicker-zh-CN.js"></script>

<script language="javascript" src="script/common.js" ></script>
<script type="text/javascript" src="script/productDiv.js" ></script>
<script language="javascript" type="text/javascript">

	$(function () {
	    $(".ui_timepicker").datetimepicker({
	        showSecond: true,
	        timeFormat: 'hh:mm:ss',
	        stepHour: 1,
	        stepMinute: 1,
	        stepSecond: 1
	    })
	})
	function txtreset(){
		document.getElementById("stdatetime").value="";
		document.getElementById("eddatetime").value="";
		document.getElementById("i3").value="";
		document.getElementById("payInout").selectedIndex=0;
		document.getElementById("payType").selectedIndex=0;
	}
	function txtSubmit(){
		//document.getElementById("hid1").style.display="none";
		document.getElementById("stDate").value=document.getElementById("stdatetime").value;
		document.getElementById("edDate").value=document.getElementById("eddatetime").value;
		var IO=document.getElementById("payInout");//收支类型
		document.getElementById("payIO").value=IO.options[IO.selectedIndex].value;
		var Type=document.getElementById("payType");//付款方式
		document.getElementById("payTp").value=Type.options[Type.selectedIndex].value;
		document.getElementById("orderNo").value=document.getElementById("i3").value;//相关单据号
		document.getElementById("subForm").submit();
	}
</script>
</head>

<body>
	<form action="ConsortiumQuery" id="subForm">
		<input type="hidden" id="stDate" name="stDate"/>
		<input type="hidden" id="edDate" name="edDate"/>
		<input type="hidden" id="payIO" name="payIO"/>
		<input type="hidden" id="payTp" name="payTp"/>
		<input type="hidden" id="orderNo" name="orderNo"/>
	</form>
<div id="m">
<table width="100%"  border="0" cellpadding="0" cellspacing="0" id="m">
  <tr>
    <td nowrap class="title1">您的位置：工作台面－－产品管理--收支查询</td>
  </tr>
</table>
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="40px" nowrap class="toolbar"><img src="images/search.gif"><a href="pmoney/querymoney.jsp">查询</a></td>
	<td nowrap class="toolbar">&nbsp;</td>
    <td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)">&nbsp;</td>
    <td width="20px" nowrap class="toolbar">&nbsp;</td>
    <td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)">&nbsp;</td>
    <td width="20px" nowrap class="toolbar">&nbsp;</td>
    <td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)">&nbsp;</td>
    <td width="20px" nowrap class="toolbar">&nbsp;</td>
    <td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)">&nbsp;</td>
    <td width="20px" nowrap class="toolbar">&nbsp;</td>
  </tr>
		</table>
		<div id="hid1">
		<table width="100%"  border="0" align="center" cellspacing="1" class="c">
		   	<tr>
			     <td align="center">日期段：</td>
			     <td>
			        <input type="text" id="stdatetime" name="stdatetime" class="ui_timepicker" value="">~ 
			        <input type="text" id="eddatetime" name="eddatetime" class="ui_timepicker" value="">
			     </td>
		    </tr>
		    <tr>
			     <td align="center"> 收支类型：</td>
			     <td>
				     <select id="payInout" >
			     		<option>收入</option>
			     		<option>支出</option>
			     	</select>
			     </td>
		     </tr>
		     <td align="center">付款方式：</td>
		     <td>
		     	<select id="payType" >
		     		<option></option>
		     		<option>货到付款</option>
		     		<option>款到发货</option>
		     		<option>预付款到发货</option>
		     	</select>
			 </td>
			 </tr>
			   </tr>
		     <td align="center">相关单据号：</td>
		     <td>
				<input type="text" name="i3" id="i3">
			 </td>
			 </tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button"   onclick="txtreset()" value="重置"> 
			      	<input type="button"   onclick="txtSubmit()" value="查询"> 
		   		</td>
			</tr>
		</table>
		</div>
</div>
<iframe width=174 height=189 name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="../common/calendar/ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; left:-500px; top:0px;"></iframe>
</body>
</html>
