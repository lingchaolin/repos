<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>出库</title>
<% 	String path=request.getContextPath();
		String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		%>
		<base href="<%=basePath %>">
<link href="css/style.css" rel="stylesheet" type="text/css">
<style type="text/css">
	#getPoitemMess td{text-align:center;}
</style>
<script language="javascript" src="script/common.js"></script>
<script language="javascript" type="text/javascript">
		function getMoneyFirst(){
			document.getElementById("getPayType").value="110";
			document.getElementById("getPayTypeForm").submit();
		}
		function getPreMoneyFirst(){
			document.getElementById("getPayType").value="130";
			document.getElementById("getPayTypeForm").submit();
		}
		function giveGoodFirst(){
			document.getElementById("getPayType").value="120";
			document.getElementById("getPayTypeForm").submit();
		}
		function outStock(obj){
			if(window.confirm("确定要将该销售单出库吗？")){
				document.getElementById("getOutStock").value=obj.parentNode.parentNode.cells[0].children[0].innerHTML;
				document.getElementById("getOutStockForm").submit();
			}
		}
		function ajax_getPoitem(obj){
			document.getElementById("poitemMessage").style.display="block";
			var tab=document.getElementById("getPoitemMess");
			while(tab.rows.length>1){
				tab.deleteRow(1);
			}
			var poid=obj.innerHTML;
			var httpRequest=new XMLHttpRequest;
			httpRequest.open("GET","PurchaseShowOutStockSub?soid="+poid,true);
			httpRequest.onreadystatechange=function(){
				if(httpRequest.readyState==4){
					if(httpRequest.status==200){
						var jsonstr=httpRequest.responseText;
						var stus=eval("("+jsonstr+")");
						for(var i=0;i<stus.length;i++){
							var tr = tab.insertRow(-1);
							tr.insertCell(0).innerHTML=stus[i].productCode;
							tr.insertCell(1).innerHTML=stus[i].name;
							tr.insertCell(2).innerHTML=stus[i].unitName;
							tr.insertCell(3).innerHTML=stus[i].num;
							tr.insertCell(4).innerHTML=stus[i].unitPrice;
							tr.insertCell(5).innerHTML=stus[i].itemPrice;
						}
					}
				}
			}
			httpRequest.send(null); 
		}
</script>
</head>
<body>
<table  width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td nowrap class="title1">您的位置：工作台面－－出库登记</td>
  </tr>
</table>
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
<!--     <td width="30px" nowrap class="toolbar">&nbsp;</td>
    <td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="window.open('th_detail.htm')"><img src="../images/new.gif">新增</td>
    <td width="20px" nowrap class="toolbar">|</td>
    <td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="query()"><img src="../images/search.gif">查询</td>
	<td nowrap class="toolbar">&nbsp;</td>-->
    <td width="75%" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)">&nbsp;</td> 
    <td width="20px" nowrap class="toolbar">|</td>
    <td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)"><span onclick="giveGoodFirst()">款到发货</span></td>
    <td width="20px" nowrap class="toolbar">|</td>
    <td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)"><span onclick="getPreMoneyFirst()">预付款到发货</span></td>
    <td width="20px" nowrap class="toolbar">|</td>
    <td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)"><span onclick="getMoneyFirst()">货到付款</span></td>
    <td width="20px" nowrap class="toolbar">|</td>
  </tr>
</table>
	<form action="PurchaseShowOutStockMain" id="getPayTypeForm"><!--付款方式-->
		<input type="hidden" id="getPayType" name="getPayType"/>
	</form>
	<form action="PurchaseChangeOutStockServ" id="getOutStockForm"><!--进行入库操作的的单号-->
		<input type="hidden" id="getOutStock" name="getOutStock"/>
	</form>
<table width="100%"  border="0" align="center" cellspacing="1">
  <tr>
    <td class="title1">销售单编号</td>
    <td class="title1">创建时间</td>
	<td class="title1">客户名称</td>
	<td class="title1">创建用户</td>
    <td class="title1">附加费用</td>
    <td class="title1">产品总价格</td>
    <td class="title1">销售单总价格</td>
    <td class="title1">付款方式</td>
    <td class="title1">最低预付款金额</td>
    <td class="title1">处理状态</td>
    <td class="title1">操作</td>
  </tr>
<c:forEach items="${requestScope.soList}" var="per" varStatus="status">
<tr>
    <td align="center"><a onclick="ajax_getPoitem(this)">${per.noid}</a></td>
    <td align="center">${per.createTime}</td>
	<td align="center">${per.outerName}</td>
	<td align="center">${per.userName}</td>
    <td align="center">${per.tipFee}</td>
    <td align="center">${per.productTotal}</td>
    <td align="center">${per.toTotal}</td>
    <td align="center">${per.payType}</td>
    <td align="center">${per.prePayFee}</td>
    <td align="center">${per.status}</td>
    <td align="center"><span onclick="outStock(this)">出库</span></td>
  </tr>
  </c:forEach>
    <tr>
  	<td class="title2"></td>
  </tr>
</table>
<br/>
	 <div id="poitemMessage"  style="display: none">
		<table width="100%"  border="0" align="center" id="getPoitemMess" cellspacing="1"  >
		  <tr>
		    <td class="title1">产品编号</td>
		    <td class="title1">产品名称</td>
		    <td class="title1">产品数量单位</td>
		    <td class="title1">产品数量</td>
		    <td class="title1">销售单价</td>
		    <td class="title1">产品明细总价</td>
		  </tr>
		</table>
	</div>

</body>
</html>