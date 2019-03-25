<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>查询</title>
<% 	String path=request.getContextPath();
		String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath %>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<link type="text/css" href="css/jquery-ui-1.8.17.custom.css" rel="stylesheet" />
     <link type="text/css" href="css/jquery-ui-timepicker-addon.css" rel="stylesheet" />
    <script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
	<script type="text/javascript" src="js/jquery-ui-1.8.17.custom.min.js"></script>
	<script type="text/javascript" src="js/jquery-ui-timepicker-addon.js"></script>
    <script type="text/javascript" src="js/jquery-ui-timepicker-zh-CN.js"></script>


<script language="javascript" src="script/common.js" ></script>
<script type="text/javascript" src="script/productDiv.js" ></script>
<script language="javascript" type="text/javascript">
$(function () {
    $(".ui_timepicker").datetimepicker({
        showSecond: true,
        timeFormat: 'hh:mm:ss',
        stepHour: 1,
        stepMinute: 1,
        stepSecond: 1
    })
})

		function query(){
			document.getElementById("queryCond").submit();
	} 
</script>
</head>
<body>
<div id="add">
	<form action="MaQueryAccount" id="queryCond" name="queryCond">
	<table width="100%"  border="0" align="center" cellspacing="1" class="c">
		  <tr>
			    <td align="center">用户账号</td>
			    <td align="center">
		    			<input type="text" id="userAccount" name="userAccount"  />
		    			<span id="userAccount"></span>
			    </td>
			</tr>
		  <tr>
		    <td align="center">用户名</td>
		    <td align="center"><input type="text"  id="accountName" name="accountName" /></td>
			</tr>
		<!--   <tr>
		    <td align="center">日期段：</td>
		     <td align="center">
		        <input type="text" id="stdatetime" size="10px"name="stdatetime" class="ui_timepicker" value="">~ 
		        <input type="text" id="eddatetime" size="10px" name="eddatetime" class="ui_timepicker" value="">
		     </td>
			</tr> -->
		  <tr>
		    <td align="center">锁定状态</td>
		    <td align="center">请勾选要查询的条件
		    	<input type="checkbox"  name="y" value="1"/>是 
		    	<input type="checkbox"  name="y" value="0"/>否
		    	<input type="hidden" name="yName" "/>
		    </td>
			</tr>
		  <tr>
		    <td align="center">用户权限</td>
		    <td align="center">请勾选要查询的条件
<!-- 		    	<input name="auth"  type="checkbox" value="管理员"/>管理员
		    	<input name="auth"  type="checkbox" value="采购"/>采购
		    	<input name="auth"  type="checkbox" value="仓管"/>仓管
		    	<input name="auth"  type="checkbox" value="财务"/>财务
		    	<input name="auth"  type="checkbox" value="销售"/>销售 -->
		        <input name="auth"  type="checkbox" value="01"/>管理员
		    	<input name="auth"  type="checkbox" value="02"/>采购
		    	<input name="auth"  type="checkbox" value="03"/>仓管
		    	<input name="auth"  type="checkbox" value="04"/>财务
		    	<input name="auth"  type="checkbox" value="05"/>销售
		    </td>
		</tr>
	  <tr>
	    <td height="18" colspan="2" align="center">
	    <input type="button" value="查询" onClick="query()"/> 
	    <!-- <input type="button" value="取消" onClick="submitValue()"/> -->
	    </td>
	    </tr>
	</table>
</form>
</div>
</body>
</html>