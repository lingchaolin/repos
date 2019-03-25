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
	function txtreset(){
		document.getElementById("i").value="";
		document.getElementById("i2").value="";
		document.getElementById("i3").value="";
		document.getElementById("i4").value="";
	}
	function txtSubmit(){
		var reg=/^\d*$/;
		var str=document.getElementById("i3").value;
		if(!reg.test(str)){
			alert("请输入正确的数字");
			return;
		}
		var last=document.getElementById("i4").value;
		if(!(reg.test(last)||reg=="")){
			alert("请输入正确的数字");
			return;
		}
		if(parseInt(str)<0){
			alert("请输入正确的数字");
			return;
		}
		document.getElementById("productCode").value=document.getElementById("i").value;
		document.getElementById("productName").value=document.getElementById("i2").value;
		document.getElementById("startNum").value=document.getElementById("i3").value;
		document.getElementById("endNum").value=document.getElementById("i4").value;
		document.getElementById("queryForm").submit();
	}
</script>
</head>

<body>
<div id="m">
<table width="100%"  border="0" cellpadding="0" cellspacing="0" id="m">
  <tr>
    <td nowrap class="title1">您的位置：工作台面－－产品管理--查询</td>
  </tr>
</table>
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="40px" nowrap class="toolbar"><img src="images/search.gif"><a href="pkeep/querygoods.jsp">查询</a></td>
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
	     <td align="center">产品编号：</td>
	     <td><input type="text" name="i" id="i"></td>
    </tr>
    <tr>
	     <td align="center"> 产品名称：</td>
	     <td><input type="text" name="i2" id="i2"></td>
     </tr>
     <td align="center">数量范围：</td>
     <td>
		<input type="text" size="2px" name="i3" value="0" id="i3">~ 
        <input type="text" size="2px" name="i4" id="i4"> 
	 </td>
	 </tr>
	<tr>
		<td colspan="2" align="center">
			<input type="button"  name="i2" id="i2" onclick="txtreset()" value="重置"> 
	      	<input type="button"  name="i2" id="i2" onclick="txtSubmit()" value="查询"> 
   		</td>
	</tr>
</table>
</div>
	<form action="PurchaseToQueryInStockServ" id="queryForm">
		<input type="hidden" id="productCode" name="productCode"/>
		<input type="hidden" id="productName" name="productName"/>
		<input type="hidden" id="startNum" name="startNum"/>
		<input type="hidden" id="endNum" name="endNum"/>
	</form>
<iframe width=174 height=189 name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="../common/calendar/ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; left:-500px; top:0px;"></iframe>
</body>
</html>
