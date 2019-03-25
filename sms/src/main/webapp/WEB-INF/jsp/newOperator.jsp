<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<HTML>
<HEAD>
<TITLE>中国移动业务管理系统</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<META content="MSHTML 6.00.2600.0" name=GENERATOR>
<link href="style.css" rel="stylesheet" type="text/css">
<style type="text/css">
body, td, th {
	font-family: Verdana;
}
</style>
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="js/operator.js"></script>
</HEAD>
<BODY bgColor=#ffffff leftMargin=0 topMargin=0 marginheight="0"
	marginwidth="0">
	${operatorinfo}
	<form method="POST" action="addoperator" id="addoperatorform">
		<table align="left" border="0" width="50%">
			<tr height="30">
				<td align="right" width="30%">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</td>
				<td width="70%"><input type="text" id="operatorname"
					name="operatorname" size="20" value="${operatorvalid.operatorname}">${operatorname}</td>
			</tr>
			<tr height="30">
				<td align="right">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
				<td><input type="radio" name="operatorsex" value="1" checked>男&nbsp;&nbsp;&nbsp;
					<input type="radio" name="operatorsex" value="0">女</td>
			</tr>
			<tr height="30">
				<td align="right">用&nbsp;&nbsp;&nbsp;户&nbsp;&nbsp;&nbsp;名：</td>
				<td><input type="text" id="username" name="username" size="20" value="${operatorvalid.username}">
					 ${username}</td>
			</tr>
			<tr height="30">
				<td align="right">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
				<td><input type="password" id="userpwd" name="userpwd"
					size="20" value="${operatorvalid.userpwd}">${userpwd}</td>
			</tr>
			<tr height="30">
				<td align="right">密&nbsp;码&nbsp;确&nbsp;认：</td>
				<td><input type="password" id="cpwd" name="cpwd" size="20"
					value=""></td>
			</tr>
			<tr height="30">
				<td align="right">是否管理员：</td>
				<td><input type="radio" value="Y" name="isadmin">是&nbsp;&nbsp;&nbsp;
					<input type="radio" name="isadmin" value="N" checked>否</td>
			</tr>
			<tr height="30">
				<td align="right">&nbsp;</td>
				<td><input type="submit" value="提交" name="submitbutton"
					id="submitbutton"></td>
			</tr>
		</table>
	</form>

</BODY>
</HTML>
