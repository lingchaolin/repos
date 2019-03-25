<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>提货</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script language="javascript" src="script/common.js"></script>
<script language="javascript" type="text/javascript">
	function jumpToChange(obj){
		var paroductCode=obj.parentNode.parentNode.cells[0].innerHTML;
		var stockNum=obj.parentNode.parentNode.cells[2].innerHTML;
		location="pkeep/changeCount.jsp?productCode="+paroductCode+"&stockNum="+stockNum ;
	}
	
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
<!-- </script> -->
<%	String path=request.getContextPath();
String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath %>">

</head>
<body>
	<table width="100%"  border="0" cellpadding="0" cellspacing="0">
	  <tr>
	    <td nowrap class="title1">您的位置：工作台面－－库存盘点</td>
	  </tr>
	</table>
	<table width="100%"  border="0" cellpadding="0" cellspacing="0">
	  <tr>
	    <td width="30px" nowrap class="toolbar">&nbsp;</td>
	 <!--    <td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="window.open('th_detail.htm')"><img src="images/new.gif">新增</td>
	    <td width="20px" nowrap class="toolbar">|</td>
	    <td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="query()"><img src="images/search.gif">查询</td>
		<td nowrap class="toolbar">&nbsp;</td>
	    <td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)">未审核单据</td>
	    <td width="20px" nowrap class="toolbar">|</td>
	    <td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)">审核中单据</td>
	    <td width="20px" nowrap class="toolbar">|</td>
	    <td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)">已审核单据</td>
	    <td width="20px" nowrap class="toolbar">|</td>
	    <td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)">被退回单据</td>
	    <td width="20px" nowrap class="toolbar">|</td> -->
	  </tr>
	</table>
	<table width="100%"  border="0" align="center" cellspacing="1">
	  <tr>
	    <td class="title1">产品编号</td>
		<td class="title1">产品名称</td>
	    <td class="title1">当前库存</td>
       	<td class="title1">采购在途数</td>
       	<td class="title1">预销售数</td>
    	<td class="title1">操作</td>
	  </tr>
	  <c:forEach items="${requestScope.limList }" var="per">
	  <tr>
	    <td align="center">${per.productcode }</td>
	    <td align="center"><span href="th_detail.htm" target="_blank">${per.name }</span></td>
		<td align="center">${per.num }</td>
    	<td align="center">${per.ponum }</td>
		<td align="center">${per.sonum} </td>
	    <td align="center"><a onclick="jumpToChange(this)">盘点</a></td>
	  </tr>
	  </c:forEach>
	</table>
<table id="pageTab" cellspacing="0">
		<tr>
		<td width="30%"></td>
		<td width="5%"><a id="firstPage" onclick="toFirst()">首页</a></td>
		<td width="5%"><a id="previousPage" onclick="toPrevious()">上一页</a></td>
		<td width="10%"><a id="nowPage" >第<span id="thisPage">${invPage.currentPage }</span>页/共<span id="sumPages">${invPage.totalPage }</span>页</a></td>
		<td width="10%"><a id="jumpPage" >跳转到第<input id="jumpValue" onkeyup="if(event.keyCode==13){jumpPage();return false;}" size="1" type="text"/>页&nbsp;</a></td>
		<td width="5%"><a id="nextPage" onclick="toNext()">下一页</a></td>
		<td width="5%"><a id="lastPage" onclick="toLast()">尾页</a></td>
			<form action="PurchaseGetStockInventoryPage" id="changePageForm"><input type="hidden" id="changePageInput" name="changePageInput"/></form>
		</td>
		<td width="30%"></td>
	</tr>
</table>
</body>
</html>