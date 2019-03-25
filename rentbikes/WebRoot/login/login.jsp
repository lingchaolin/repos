<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'login.jsp' starting page</title>
     <script type="text/javascript">
  	function check(){
  		if(document.getElementById("username").value.length ==0 ){
			document.getElementById("username1").innerHTML="身份证不能为空！";
			return false;
		}else if(document.getElementById("password").value.length ==0 ){
			document.getElementById("password1").innerHTML="密码不能为空！";
			return false;
		}
		else{
			return true;
		}
  	}
  
  </script>
  </head>
  <body>
    <form action="/auto_lease/LoginServlet" method="post"  onsubmit="return check();">
    <table border="0">
    <tr><td>用户名：</td>
		<td>	<input type="text" name="username" id="username"><span id="username1"></span><br></td></tr>
   <tr> <td>密码：</td><td><input type="password" name="password" id="password"><span id="password1"><br></span></td></tr>
    <tr><td>管理员：<input type="radio" value="admin" name="userlevel">
    服务员：<input type="radio" value="service" name="userlevel"><br></td></tr>
    <tr><td><input type="submit" value="登陆"></td>
    <td><input type="reset" value="重置"></td></tr>
    </table>
    </form>
  </body>
</html>
