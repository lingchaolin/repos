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
		if (question == true){
	    	parent.close();
	    	//退出servlet,定位到新界面
	  	} 
	}
	function login(){
		document.getElementById("logform").submit();
	}
</SCRIPT>
</head>
<body bgcolor="#ffffff" >

<form action="login" id="logform">
<table width="100%"  border="0"  >
	<tr>
		<td class="title1">&nbsp;</td>
	</tr>
  <tr>
    <td width="50%" align="right" >用户名&nbsp;&nbsp;</td>
    <td width="50%"><input type="text" id="account" name="account"/></td>
  </tr>
  <tr>
    <td align="right">密码&nbsp;&nbsp;&nbsp;</td>
    <td><input type="password"/></td>
  </tr>
  <tr>
  	<td class="title1"><div align="right"><input type="button" value="登录" onclick="login()"/></div></td>
	<td class="title1"><div align="left"><input type="reset" value="重置"/></div></td>
  </tr>
</table>
</form>
</body>
</html>