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

<script language="javascript" src="script/common.js" ></script>
<script type="text/javascript" src="script/productDiv.js" ></script>
<script language="javascript" type="text/javascript">
function toLast(){//   2
	document.getElementById("changePageInput").value="尾页";
	document.getElementById("changePageForm").submit();
}
function toFirst(){//    0
	document.getElementById("changePageInput").value="首页";
	document.getElementById("changePageForm").submit();
}
function toPrevious(){//    -1
	var t=document.getElementById("thisPage").innerHTML;
	var s=document.getElementById("sumPages").innerHTML;
	if(t<=1){
		alert("已经到第一页了");
		return;
	}
	document.getElementById("changePageInput").value="上一页";
	document.getElementById("changePageForm").submit();
}
function toNext(){//    +1
	var t=document.getElementById("thisPage").innerHTML;
	var s=document.getElementById("sumPages").innerHTML;
	if(t>=s){
		alert("已经到最后一页了");
		return;
	}
	document.getElementById("changePageInput").value="下一页";
	document.getElementById("changePageForm").submit();
}
function jumpPage(){
		var reg=/^[1-9]\d*$/;
		var str=document.getElementById("jumpValue").value;
		if(reg.test(str)){
			var sumPage=document.getElementById("sumPages").innerHTML;
			if(str<=sumPage&&str>=1){
				document.getElementById("changePageInput").value=str;
				document.getElementById("changePageForm").submit();
			}else{
				alert("请输入正确的页码");
				return;
			}
		}else{
			alert("请输入正确的页码");
			return;
		}
}
</script>
</head>

<body>
<div id="m">
<table width="100%"  border="0" cellpadding="0" cellspacing="0" id="m">
  <tr>
    <td nowrap class="title1">您的位置：工作台面－－产品管理--收支查询</td>
  </tr>
</table>
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="40px" nowrap class="toolbar"><img src="images/search.gif"><a href="gztm/querymoney.jsp">查询</a></td>
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
		<table width="100%"  border="0" align="center" cellspacing="1" class="c">
  <tr>
    <td class="title1">付款(收款)日期</td>
    <td class="title1">相关单据号</td>
	<td class="title1">付款(收款)金额</td>
    <td class="title1">经手人</td>
    <td class="title1">单据付款方式</td>
  </tr>
 	<c:forEach items="${requestScope.qmmList }" var="per" varStatus="status">
  	<tr>
	    <td align="center">${per.payTime }</td> 
	    <td align="center">${per.noid }</td>
		<td align="center">${per.total }</td>
	    <td align="center">${per.payUser }</td>
	    <td align="center">${per.payType }</td>
    </tr>
  </c:forEach> 
</table>
<%-- <table id="pageTab" cellspacing="0">
	<tr>
		<td width="30%"></td>
		<td width="5%"><a id="firstPage" onclick="toFirst()">首页</a></td>
		<td width="5%"><a id="previousPage" onclick="toPrevious()">上一页</a></td>
		<td width="10%"><a id="nowPage" >第<span id="thisPage">${MoneyPageNum.currentPage }</span>页/共<span id="sumPages">${MoneyPageNum.totalPage }</span>页</a></td>
		<td width="10%"><a id="jumpPage" >跳转到第<input id="jumpValue" onkeyup="if(event.keyCode==13){jumpPage();return false;}" size="1" type="text"/>页&nbsp;</a></td>
		<td width="5%"><a id="nextPage" onclick="toNext()">下一页</a></td>
		<td width="5%"><a id="lastPage" onclick="toLast()">尾页</a></td>
			<form action="amtp" id="changePageForm">
			<input type="hidden" id="changePageInput" name="changePageInput"/>
			</form>
		</td>
		<td width="30%"></td>
	</tr>
</table> --%>
</div>
<iframe width=174 height=189 name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="../common/calendar/ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; left:-500px; top:0px;"></iframe>
</body>
</html>
