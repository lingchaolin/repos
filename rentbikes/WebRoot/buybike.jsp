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
			<td colspan="2">主单信息：</td>
		</tr>
		<TR>
			<TD>供应商id：</TD>
			<TD><input name="username" id="username" /><span id="username1"></span>
			</TD>
		</TR>
		<TR>
			<TD>购入日期：</TD>
			<TD><input name="identity" id="identity" /><span id="identity1"></span>
			</TD>
		</TR>
		<TR>
			<TD>购入数量：</TD>
			<TD><input name="fullname" />
			</TD>
		</TR>
		<tr>
		<td colspan="2"><a href="#">添加明细</a> </td>
		</tr>
		<tr>
			<td colspan="2">
				<table align="left">
					<tr>
						<td colspan="3">明细：</td>
					</tr>
					<tr>
						<td>出厂日期</td>
						<td>批次号</td>
						<td>注销标志</td>
					</tr>
					<tr>
						<td><input type="text" value="2013-07-30">
						</td>
						<td><input type="text" value="2"></td>
						<td><input type="text" value="1"></td>
					</tr>
					<tr>
						<td><input type="text" value="2013-07-30">
						</td>
						<td><input type="text" value="2"></td>
						<td><input type="text" value="1"></td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td colspan="2"><input type="button" value="保存">
			<a href="confirmBikeList.jsp">确认已保存单据</a>
			</td>
		</tr>
	</TABLE>


</body>
</html>
