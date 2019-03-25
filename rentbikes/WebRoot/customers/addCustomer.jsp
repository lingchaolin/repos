<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'addCustomer.jsp' starting page</title>
    <script type="text/javascript">
  	function check(){
  		if(document.getElementById("identity").value.length ==0 ){
			document.getElementById("identity1").innerHTML="身份证不能为空！";
			return false;
		}else if(document.getElementById("custname").value.length ==0 ){
			document.getElementById("custname1").innerHTML="姓名不能为空！";
			return false;
		}else if(document.getElementById("address").value.length ==0 ){
			document.getElementById("address1").innerHTML="地址不能为空！";
			return false;
		}
		else{
			return true;
		}
  	
  	}
  
  </script>
  </head>
  <body>
   <form name="form" method="post" action="/auto_lease/AddCustomersServlet" onsubmit="return check();"/>
<TABLE align="center">
<TR>
	<TD>身份证：</TD>
	<TD><input name="identity" id="identity"/><span id="identity1"></span></TD>
</TR>
<TR>
	<TD>姓名：</TD>
	<TD><input name="custname" id="custname"/><span id="custname1"></span></TD>
</TR>
<TR>
	<TD>性别：</TD>
	<TD>
		<SELECT NAME="sex" id="sex">
			<option value="1">男</option>
			<option value="0">女</option>
		</SELECT>
	</TD>
</TR>
<TR>
	<TD>地址：</TD>
	<TD><input name="address" id="address"/><span id="address1"></span></TD>
</TR>
<TR>
	<TD>电话：</TD>
	<TD><input name="phone"/></TD>
</TR>
<TR>
	<TD>职业：</TD>
	<TD><input name="career"/></TD>
</TR>
<TR>
	<TD>密码：</TD>
	<TD><input type="password" name="password"/></TD>
</TR>
<TR>
	<TD></TD>
	<TD><input type="submit" value="提交"></TD>
</TR>
</TABLE>
</form>
  </body>
</html>
