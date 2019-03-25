<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script language="javascript" src="script/common.js" ></script>
<script type="text/javascript" src="script/productDiv.js" ></script>
<script language="javascript" type="text/javascript">
	function query() {
		location="gztm/th_qurey.jsp";
	}
	function addAccount(){//新增用户
		var p=document.getElementById("addForm");
		p.submit();
	}
	function modify(obj){
		var p=document.getElementById("addForm");
		var square=obj.parentNode.parentNode.cells[0].innerHTML;
		var formId=document.getElementById("addInputId");
		formId.value=square;
		p.submit();
		}
	var httpRequest;
	function deleteThis(obj){
		if(window.confirm("确定要删除该用户的数据吗？")){
			var tar=obj.parentNode.parentNode.cells[0].innerHTML;//判断是否可以删除？？是否在工作过程中
			document.getElementById("accountNo").value=tar;
			document.getElementById("delat").submit();
		}
	}
	
</script>
<%	String path=request.getContextPath();
String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath %>">

</head>
<body>
	<form action="MaDeleteAccount" id="delat"><input type="hidden" id="accountNo" name="accountNo"/></form>
<div id="m">
<form action="MaAddOrModifyAccount" id="addForm"><input type="hidden" name="addAccount" id="addInputId"></form>
<table width="100%"  border="0" cellpadding="0" cellspacing="0" id="m">
  <tr>
    <td nowrap class="title1">您的位置：工作台面－－用户管理</td>
  </tr>
</table>
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="30px" nowrap class="toolbar">&nbsp;</td>
    <td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="addAccount()"><img src="images/new.gif">新增</td>
    <td width="20px" nowrap class="toolbar">|</td>
    <td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="query()"><img src="images/search.gif">查询</td>
    <td width="1000px" nowrap class="toolbar" >&nbsp;</td>
  </tr>
</table>
<table width="100%"  border="0" align="center" cellspacing="1" class="c">
  <tr>
    <td class="title1">用户账号</td>
    <td class="title1">用户姓名</td>
	<td class="title1">添加日期</td>
    <td class="title1">锁定状态</td>
    <td class="title1">用户权限列表</td>
    <td class="title1">操作</td>
  </tr>
  <c:forEach items="${requestScope.amList }" var="per" varStatus="status">
  	<tr>
	    <td align="center">${per.account }</td> 
	    <td align="center">${per.name }</td>
		<td align="center">${per.createDate }</td>
	    <td align="center">${per.status }</td>
	    <td align="center">${per.modelName }</td>
	    <td align="center"><span onClick="modify(this)">修改</span> <span onclick="deleteThis(this)">删除</span></td>
    </tr>
  </c:forEach>
</table>
</div>
</body>
</html>