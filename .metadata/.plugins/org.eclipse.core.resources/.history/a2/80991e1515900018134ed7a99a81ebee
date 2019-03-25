<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>提货</title>
<% 	String path=request.getContextPath();
		String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		%>
		<base href="<%=basePath %>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<style type="text/css">
	td{text-align:center;}
</style>
<script language="javascript" src="script/common.js"></script>
<script language="javascript" type="text/javascript">

function onlo(){
	var yy=document.getElementById("years");
	var op=document.createElement("option");
	op.innerHTML="";
	yy.appendChild(op);
	var mm=document.getElementById("months");
	var op2=document.createElement("option");
	mm.appendChild(op2);
	//添加空白项
	for(var i=2010;i<2030;i++){
		var opo=document.createElement("option");
		opo.innerHTML=i;
		yy.appendChild(opo);
	}
	for(var i=1;i<13;i++){
		var opo=document.createElement("option");
		opo.innerHTML=i;
		mm.appendChild(opo);
	}
	var year=document.getElementById("getyear").value;
	var month=document.getElementById("getmonth").value;
	 if(year!=""){
		for(var i=0;i<yy.options.length;i++){
			if(yy.options[i].innerHTML==year){
				yy.selectedIndex=i;
				break;
			}
		}
	} 
	if(month!=""){
		for(var i=0;i<mm.options.length;i++){
			if(mm.options[i].innerHTML==month){
				mm.selectedIndex=i;
				break;
			}
		}
	} 
}
	function setYear(){
		var yy=document.getElementById("years");
		document.getElementById("getyear").value=yy.options[yy.selectedIndex].value;
	}
	function setMonth(){
		var mm=document.getElementById("months");
		document.getElementById("getmonth").value=mm.options[mm.selectedIndex].value;
	}
	//查看报表按钮
	function watchstmt(){
		var flag=subform();
		if(flag=="noy"){
			alert("请选择年份");
		}else if(flag=="nom"){
			alert("请选择月份");
		}
	}
	function subform(){//判断年月是否为空
  		if(document.getElementById("getyear").value==""){
			return "noy";
		}
		if(document.getElementById("getmonth").value==""){
			return "nom";
		}
		document.getElementById("getnumform").submit();
	}
</script>
</head>
<body onload="onlo()">
	<table width="100%"  border="0" cellpadding="0" cellspacing="0">
	  <tr>
	    <td nowrap class="title1">您的位置：工作台面－－月度收支报表</td>
	  </tr>
	</table>
	<table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)">&nbsp;</td>
	    <td width="75%" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)">&nbsp;</td> 
    <td width="20px" nowrap class="toolbar"></td>
    <td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)"></td>
    <td width="20px" nowrap class="toolbar"></td>
    <td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)"></td>
    <td width="20px" nowrap class="toolbar"></td>
  </tr>
</table>
<table width="100%"  border="0" align="center" cellspacing="0">
	<tr>
		<td width="35%" ></td>
	  	<td width="10px" align="center">
	  		<select id="years" onchange="setYear()"></select>年
	  	</td>
	  	<td width="10px" align="center">
	  		<select id="months" onchange="setMonth()"></select>月
	  	</td>
	  	<td width="10px" align="center">
	  		<input type="button" value="查看报表" onclick="watchstmt()"/>
	  	</td>
	  	<td width="35%" ></td>
  	</tr>
</table>
<br/>
<table width="100%"  border="0" align="center" cellspacing="1" >
	<tr>
		<th class="title1" width="25%" >产品总库存数:</th>
		<th class="title1" width="25%" >${stockNum}</th>
		<th class="title1" width="25%" ></th>
		<th class="title1" width="25%" ></th>
  	</tr>
	</table>
		<form action="PurchaseGetStockNumMessage" id="getnumform">
			<input type="hidden" id="getyear" name="getyear" value="${yeartime}"/>
			<input type="hidden" id="getmonth" name="getmonth" value="${monthtime}"/>
		</form>
		<br/>
		<div id="hiddiv" >
			<table width="100%"  border="0" align="center" cellspacing="1">
			<c:if test="${not empty oriList}">
				<tr>
							<th class="title1" width="16%" >产品编号</th>
							<th class="title1" width="16%" >产品名称</th>
							<th class="title1" width="16%" >库存数</th>
			  	</tr>
		  	</c:if>
			  	<c:forEach items="${oriList}" var="per" varStatus="status">
			  		<tr>
			  			<td align="center" width="16%" >${per.productCode}</td>
			  			<td align="center" width="16%" >${per.name}</td>
			  			<td align="center" width="16%" >${per.num}</td>
			  		</tr>
			  	</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>
