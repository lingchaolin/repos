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

<title>My JSP 'bikefee.jsp' starting page</title>

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
	<table border="1" cellspacing="0">
		<tr>
			<td colspan="8">月度/年度车辆费用统计</td>
		</tr>
		<tr>
			<td colspan="8">年份：<select>
					<option id="">请选择</option>
					<option id="">2013</option>
					<option id="">2012</option>
					<option id="">2011</option>
					<option id="">2010</option>
					<option id="">2009</option>
			</select> 月份：<select>
					<option id="">请选择</option>
					<option id="">一月</option>
					<option id="">二月</option>
					<option id="">三月</option>
					<option id="">四月</option>
					<option id="">五月</option>
			</select> <input type="button" value="查询"></td>
		</tr>
		<tr>
			<td>车辆数量</td>
			<td>借还次数</td>
			<td>修理次数</td>
			<td>平均借还时 间</td>
			<td>总借还时间平均借车收入费用</td>
			<td>总借车收入费用</td>
			<td>平均修理费用</td>
			<td>总修理费</td>
		</tr>
		<tr>
			<td>300辆</td>
			<td>3000次</td>
			<td>23430次</td>
			<td>34分钟</td>
			<td>34元</td>
			<td>34000元</td>
			<td>234324元</td>
			<td>21323元</td>
		</tr>
	</table>
</body>
</html>
