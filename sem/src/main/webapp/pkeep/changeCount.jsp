<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%	String path=request.getContextPath();
String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath %>">
<title>提货</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script language="javascript" src="script/common.js" ></script>
<script type="text/javascript" src="script/productDiv.js" ></script>
<script language="javascript" type="text/javascript">
 	var productCode;
 	var stockNum;;
	function readURL(obj){
		var str=window.location.href;
		var str1=str.split("?")[1];//?
		//var str10=parseInt(str1.split("&")[0]);//&
		var str10=str1.split("&")[0];//&
		var str11=str1.split("&")[1];//&
		productCode=str10.split("=")[1];
		stockNum=str11.split("=")[1];
	}
	function resetClear(){
		document.getElementById("changeNum").value="";
		document.getElementById("typeSelect").selectedIndex=0;
		document.getElementById("jzrq").value="";
	}
	function report(){
		//检查
		var IO=document.getElementById("typeSelect");//变化类型
		document.getElementById("changeTypeForm").value=IO.options[IO.selectedIndex].value;
		var changeTp=document.getElementById("changeTypeForm").value;
		var num=document.getElementById("changeNum").value;
		var reg=/^\d*$/;
		if(reg.test(num)){
			var number=parseInt(num);
			if(number<0||(number>stockNum&&changeTp=="损耗")){
				document.getElementById("changeNum").value="";
				alert("请输入在库存范围内的数值");
				return;
			}else{
				document.getElementById("changeNumForm").value=number;
			}
		}else{
			document.getElementById("changeNum").value="";
			alert("请输入正确的数值");
			return;
		}
		
		var reason=document.getElementById("jzrq").value;
		if(reason!=""&&reason!=null){
			document.getElementById("changeReasonForm").value=reason;
		}else{
			alert("请输入损益原因");
			return;
		}
		document.getElementById("getProductCode").value=productCode; 
		document.getElementById("getStockNum").value=stockNum; 
		document.getElementById("addForm").submit();
	}
</script>
</head>
<body onload="readURL()">
	<form action="PurchaseAddToCheckStock" id="addForm">
		<input type="hidden" id="getProductCode" name="getProductCode"/>
		<input type="hidden" id="getStockNum" name="getStockNum"/>
		<input type="hidden" id="changeNumForm" name="changeNumForm"/>
		<input type="hidden" id="changeTypeForm" name="changeTypeForm"/>
		<input type="hidden" id="changeReasonForm" name="changeReasonForm"/>
	</form>
	<div id="m">
<table width="100%"  border="0" cellpadding="0" cellspacing="0" id="m">
  <tr>
    <td nowrap class="title1">您的位置：工作台面－－库存盘点</td>
  </tr>
</table>
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="30px" nowrap class="toolbar">&nbsp;</td>
<!--     <td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="window.open('th_detail.htm')"><img src="images/new.gif">新增</td>
    <td width="20px" nowrap class="toolbar">|</td>
    <td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="query()"><img src="images/search.gif">查询</td> -->
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

<div id="add">
	<table width="100%"  border="0" align="center" cellspacing="1" class="c">
  <tr>
    <td align="center">变化数量</td>
    <td align="center"><input type="text" id="changeNum" name="changeNum"></td>
	</tr>
  <tr>
    <td align="center">变化类型</td>
    <td align="center">
    	<select id="typeSelect">
    		<option>损耗</option>
    		<option>盘余</option>
    	</select>
    </td>
	</tr>
  <tr>
    <td align="center">损益原因</td>
    <td align="center">
    	<input name="jzrq" type="text" size="15" id="jzrq">
      <!-- <span class="requred_symbol">*</span>
      <a href="javascript:void(0)" onClick="gfPop.fPopCalendar(document.all.jzrq);return false;">
      <img name="popcal"  src="images/selectDate.gif" width="15" height="12" border="0" alt=""></a> -->
    </td>
	</tr>
  	<tr>
    	<td align="center" colspan="2">
    	<input type="reset" onclick="resetClear()" value="重置"/> &nbsp;
    	<input type="submit" onclick="report()" value="提交"/>
    	</td>
	</tr>
</table>
</div>
<iframe width=174 height=189 name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="common/calendar/ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; left:-500px; top:0px;"></iframe>
</body>
</html>