<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'chezhuang.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   车桩列表：
	<table>
		<tr>
			<td>车桩编号</td>
			<td>所属车点</td>
			<td>状态</td>
			<td>安装日期</td>
			<td>操作人</td>
			<td>注销标志</td>
			<td>操作</td>
		</tr>
		<tr>
			<td>一号</td>
			<td>1</td>
			<td>100</td>
			<td>60</td>
			<td>10</td>
			<td>1</td>
			<td><input type="button" value="入桩">
			</td>
		</tr>
		<tr>
			<td>二号</td>
			<td>1</td>
			<td>100</td>
			<td>60</td>
			<td>10</td>
			<td>1</td>
			<td><input type="button" value="入桩">
			</td>
		</tr>
		<tr>
			<td>三号</td>
			<td>1</td>
			<td>100</td>
			<td>60</td>
			<td>10</td>
			<td>1</td>
			<td><input type="button" value="入桩">
			</td>
		</tr>
	</table>
  </body>
</html>
