<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'buybike.jsp' starting page</title>

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

	<TABLE align="left">
		<tr>
			<td colspan="4">单据确认列表</td>
		</tr>
		<tr>
			<td>单据id：</td>
			<TD>供应商id：</TD>
			<TD>购入日期：</TD>
			<td>操作</td>
		</tr>
		<tr>
			<td>1</td>
			<TD>2</TD>
			<TD>2013</TD>
			<td><input type="button" value="确认该单据" onclick="javascript:document.location.href='confirmBike.jsp'" >
			</td>
		</tr>
		<tr>
			<td>1</td>
			<TD>3</TD>
			<TD>2011</TD>
			<td><input type="button" value="确认该单据" onclick="javascript:document.location.href='confirmBike.jsp'" >
			</td>
		</tr>
	</TABLE>


</body>
</html>
