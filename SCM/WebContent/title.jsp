<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script language="javascript" src="script/common.js"></script>
<title>标题</title>
<SCRIPT language=JavaScript>
	function closeAlert() {
		question = confirm("您要退出系统，确定吗？");
		alert(question);
	  /* 	if (question != "0"){
	    	parent.close();
	  	} */
		if (question == true){
	    	parent.close();
	    	//退出servlet,定位到新界面
	  	} 
	}
</SCRIPT>
</head>
<body topmargin=0 leftmargin=0>
<table width="100%" border="0" align="right" cellpadding="0" cellspacing="0" height="25">
  <tr>
    <td class="toolbar">&nbsp;</td>
<%--     <c:if test="${empty sessionScope.userName }"> --%>
    <td class="toolbar" width="45px" onMouseOver="OMO()" onMouseOut="OMOU()" onClick="window.open('temp.jsp', 'mainFrame')">
      <img src="images/jrxt.jpg" border="0">登录</td>
    <td width="20px" nowrap class="toolbar">|</td>
    <td class="toolbar" width="45px" onMouseOver="OMO()" onMouseOut="OMOU()" onClick="closeAlert()">
      <img src="images/lkxt.jpg" border="0">离开</td>
    <td width="20px" nowrap class="toolbar">|</td>
<%--     </c:if> --%>
<%--      <c:if test="${not empty sessionScope.userName }">
   <td class="toolbar" width="85px" onMouseOver="OMO()" onMouseOut="OMOU()" onClick="window.open('temp.jsp', 'mainFrame')">
      欢迎你,${sessionScope.userName}</td>
    <td width="20px" nowrap class="toolbar">|</td>
    <td class="toolbar" width="45px" onMouseOver="OMO()" onMouseOut="OMOU()" onClick="closeAlert()">
      <img src="images/lkxt.jpg" border="0">离开</td>
    <td width="20px" nowrap class="toolbar">|</td>
     </c:if> --%>
  </tr>
</table>
</body>
</html>