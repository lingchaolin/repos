<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.8.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$(" :redio").click(function(){
			var id=$(":redio:checked").val();
		})
	})
</script>
<title>角色主页面</title>
</head>
<body>
	<form action="">
		角色查询：<input type="text" name="T1"/>&nbsp;&nbsp;
		<input type="submit" value="查询"/>&nbsp;&nbsp;
		<input type="button" value="新增角色" />
	</form><br/>
	
	<form action="">
		<input type="hidden" name="" />
	</form>
	<table cellspacing="0" border="1">
		<tr align="center">
			<td width="40px">&nbsp;&nbsp;</td>
			<td width="200px">角色名称</td>
			<td width="500px">角色描述</td>
			<td width="100px">操作</td>
		</tr>
		<tr align="center">
			<td><input type="radio" value="ID1" name="" id="role1"/></td>
			<td>普通租车者</td>
			<td>普通用户</td>
			<td>
				<input type="button" value="修改"/>&nbsp;&nbsp;
				<input type="button" value="删除"/>
			</td>
		</tr>
		<tr align="center">
			<td colspan="2">权限</td>
			<td colspan="2"> 
				<input type="checkbox" value="T1" name="T1" onclick="return false;"/>权限1&nbsp;&nbsp;
				<input type="checkbox" value="T2" name="T2" onclick="return false;"/>权限2&nbsp;&nbsp;
			</td>
		</tr>
	</table>
</body>
</html>