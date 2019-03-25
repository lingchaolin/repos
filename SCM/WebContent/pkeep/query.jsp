<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>提货</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="css/style.css" rel="stylesheet" type="text/css">
<style type="text/css">
	#addTab td{text-align:center;}
</style>
<script language="javascript" src="script/common.js"></script>
<script language="javascript" type="text/javascript">
	function jumpToChange(obj){
		var paroductCode=obj.parentNode.parentNode.cells[0].innerHTML;
		var stockNum=obj.parentNode.parentNode.cells[2].innerHTML;
		location="gztm/changeCount.jsp?productCode="+paroductCode+"&stockNum="+stockNum ;
	}
	function setCode(obj){
		document.getElementById("getProductCode").value=obj.innerHTML;
		document.getElementById("hiddenDiv").style.display="block";
		getRecord();
	}
	function setType(obj){
		document.getElementById("getRecordType").value=obj.innerHTML;
		if(document.getElementById("getProductCode")==""){
			return;
		}
		read();
		getRecord();
	}
	function getRecord(){
		var tab=document.getElementById("addTab");
		while(tab.rows.length>1){
			tab.deleteRow(1);
		}
		var httpRequest=new XMLHttpRequest;
		httpRequest.open("GET","PurchaseGetInStockRecordServ?productCode="+document.getElementById("getProductCode").value+"&recordType="+document.getElementById("getRecordType").value,true);
		httpRequest.onreadystatechange=function(){//可以将方法提取出来
			if(httpRequest.readyState==4){
				if(httpRequest.status==200){
					var jsonstr=httpRequest.responseText;
					var stus=eval("("+jsonstr+")");
					for(var i=0;i<stus.length;i++){
						var tr = tab.insertRow(-1);
						tr.insertCell(0).innerHTML=stus[i].stockTime;
						tr.insertCell(1).innerHTML=stus[i].orderCode;
						tr.insertCell(2).innerHTML=stus[i].createUser;
						tr.insertCell(3).innerHTML=stus[i].stockNum;
						tr.insertCell(4).innerHTML=stus[i].stockType;
					}
				}
			}
		};
		httpRequest.send(null);
	}
	
	function read(){
		var type=document.getElementById("getRecordType").value;
		var table=document.getElementById("addTab");
		if(type=="出库记录信息"){
			table.rows[0].cells[0].innerHTML="出库时间";
			table.rows[0].cells[2].innerHTML="出库经手人";
			table.rows[0].cells[3].innerHTML="出库数量";
			table.rows[0].cells[4].innerHTML="出库类型";
		}else{
			table.rows[0].cells[0].innerHTML="入库时间";
			table.rows[0].cells[2].innerHTML="入库经手人";
			table.rows[0].cells[3].innerHTML="入库数量";
			table.rows[0].cells[4].innerHTML="入库类型";
		}
	}
</script>
<%	String path=request.getContextPath();
String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath %>">

</head>
<body>
		<input type="hidden" id="getProductCode" name="getProductCode"/>
		<input type="hidden" id="getRecordType" name="getRecordType" value="入库记录信息"/>
	<table width="100%"  border="0" cellpadding="0" cellspacing="0">
	  <tr>
	    <td nowrap class="title1">您的位置：工作台面－－库存查询</td>
	  </tr>
	</table>
	<table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="40px" nowrap class="toolbar"><img src="images/search.gif"><a href="pkeep/querygoods.jsp">查询</a></td>
    <td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)">&nbsp;</td>
	    <td width="75%" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)">&nbsp;</td> 
    <td width="20px" nowrap class="toolbar">|</td>
    <td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)"><span onclick="setType(this)">入库记录信息</span></td>
    <td width="20px" nowrap class="toolbar">|</td>
    <td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)"><span onclick="setType(this)">出库记录信息</span></td>
    <td width="20px" nowrap class="toolbar">|</td>
  </tr>
</table>
	<table width="100%"  border="0" align="center" cellspacing="1">
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
	<div id="hiddenDiv" style="display:none;" ><!-- -->
	<table width="100%"  border="0" align="center" cellspacing="1" id="addTab" >
	  <tr>
	    <td class="title1">入库时间</td>
		<td class="title1">相关采购单号</td>
	    <td class="title1">入库经手人</td>
       	<td class="title1">入库数量</td>
       	<td class="title1">入库类型</td>
	  </tr>
	</table>
	</div>
</body>
</html>