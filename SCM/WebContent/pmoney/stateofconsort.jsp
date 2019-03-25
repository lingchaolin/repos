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
	function clearPage(){//清理页面内容
		
	}
	function setYear(){
		var yy=document.getElementById("years");
		document.getElementById("getyear").value=yy.options[yy.selectedIndex].value;
	}
	function setMonth(){
		var mm=document.getElementById("months");
		document.getElementById("getmonth").value=mm.options[mm.selectedIndex].value;
	}
	function setextend(){//设置付款
		document.getElementById("gettype").value="付款明细";
		subform();
	}
	function setreceipt(){//收款
		document.getElementById("gettype").value="收款明细";
		subform();
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
		if(document.getElementById("gettype").value==""){
			document.getElementById("gettype").value="付款明细";
		}
		document.getElementById("getmoneyform").submit();
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
    <td width="20px" nowrap class="toolbar">|</td>
    <td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)"><span onclick="setextend()">付款明细</span></td>
    <td width="20px" nowrap class="toolbar">|</td>
    <td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)"><span onclick="setreceipt()">收款明细</span></td>
    <td width="20px" nowrap class="toolbar">|</td>
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
		<th class="title1" width="25%" >收款总金额</th>
		<th class="title1" width="25%" >付款总金额</th>
		<th class="title1" width="25%" >收款交易次数</th>
		<th class="title1" width="25%" >付款交易次数</th>
  	</tr>
  	<tr>
  		<td>${mmRece.money}</td>
  		<td>${mmExpd.time}</td>
  		<td>${mmRece.money}</td>
  		<td>${mmExpd.time}</td>
  	</tr>
	</table>
		<form action="ConsortiumGetMoneyMessage" id="getmoneyform">
			<input type="hidden" id="getyear" name="getyear" value="${yeartime}"/>
			<input type="hidden" id="getmonth" name="getmonth" value="${monthtime}"/>
			<input type="hidden" id="gettype" name="gettype" value="${type}" }/><!--默认为付款明细-->
		</form>
		<br/>
		<div id="hiddiv" >
			<table width="100%"  border="0" align="center" cellspacing="1">
				<tr>
					<c:choose>
						<c:when test="${mesType=='收款明细'}">
							<th class="title1" width="16%" >销售单号</th>
							<th class="title1" width="16%" >销售单日期</th>
							<th class="title1" width="16%" >收款日期</th>
							<th class="title1" width="16%" >收款金额</th>
							<th class="title1" width="16%" >经手人</th>
							<th class="title1" width="16%" >处理状态</th>
						</c:when>
						<c:when test="${mesType=='付款明细'}">
							<th class="title1" width="16%" >采购单号</th>
							<th class="title1" width="16%" >采购单日期</th>
							<th class="title1" width="16%" >付款日期</th>
							<th class="title1" width="16%" >付款金额</th>
							<th class="title1" width="16%" >经手人</th>
							<th class="title1" width="16%" >处理状态</th>
						</c:when>
					</c:choose>
			  	</tr>
			  	<c:forEach items="${mmList}" var="per" varStatus="status">
			  		<tr>
			  			<td align="center" width="16%" >${per.noid}</td>
			  			<td align="center" width="16%" >${per.createTime}</td>
			  			<td align="center" width="16%" >${per.payTime}</td>
			  			<td align="center" width="16%" >${per.total}</td>
			  			<td align="center" width="16%" >${per.payUser}</td>
			  			<td align="center" width="16%" >${per.status}</td>
			  		</tr>
			  	</c:forEach>
			</table>
		</div>
		
	<%-- <table width="100%"  border="0" align="center" cellspacing="1">
	  <tr>
	    <td class="title1">产品编号</td>
		<td class="title1">产品名称</td>
	    <td class="title1">当前库存</td>
       	<td class="title1">采购在途数</td>
       	<td class="title1">预销售数</td>
	  </tr>
	  <c:forEach items="${requestScope.fList }" var="per">
	  <tr>
	    <td align="center"><a onclick="setCode(this)">${per.productcode }</a></td>
	    <td align="center">${per.name }</td>
		<td align="center">${per.num }</td>
    	<td align="center">${per.ponum }</td>
		<td align="center">${per.sonum} </td>
	  </tr>
	  </c:forEach>
	</table>
	<br/>
	<div id="hiddenDiv" style="display:none;">
	<table width="100%"  border="0" align="center" cellspacing="1" id="addTab" >
	  <tr><!--分页  -->
	    <td class="title1">入库时间</td>
		<td class="title1">相关采购单号</td>
	    <td class="title1">入库经手人</td>
       	<td class="title1">入库数量</td>
       	<td class="title1">入库类型</td>
	  </tr>
	</table> --%>
	</div>
</body>
</html>
