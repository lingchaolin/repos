<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'addUser.jsp' starting page</title>
     <script type="text/javascript">
  	function check(){
  		if(document.getElementById("username").value.length ==0 ){
			document.getElementById("username1").innerHTML="���֤����Ϊ�գ�";
			return false;
		}else if(document.getElementById("identity").value.length ==0 ){
			document.getElementById("identity1").innerHTML="��������Ϊ�գ�";
			return false;
		}else if(document.getElementById("userlevel").value.length ==0 ){
			document.getElementById("userlevel1").innerHTML="�û����Ͳ���Ϊ�գ�";
			return false;
		}else if(document.getElementById("password").value.length ==0 ){
			document.getElementById("password1").innerHTML="���벻��Ϊ�գ�";
			return false;
		}
		else{
			return true;
		}
  	}
  </script>
  </head>
  <body>
    <form name="form" action="AddUserServlet" method="post" onsubmit="return check();">
<TABLE align="center">
<TR>
	<TD>��¼����</TD>
	<TD><input name="username" id="username"/><span id="username1"></span></TD>
</TR>
<TR>
	<TD>���֤��</TD>
	<TD><input name="identity" id="identity"/><span id="identity1"></span></TD>
</TR>
<TR>
	<TD>������</TD>
	<TD><input name="fullname"/></TD>
</TR>
<TR>
	<TD>�Ա�</TD>
	<TD>
		<SELECT NAME="sex" id="sex">
			<option value="1">��</option>
			<option value="0">Ů</option>
		</SELECT>
	</TD>
</TR>
<TR>
	<TD>��ַ��</TD>
	<td><input name="address"/></td>
</TR>
<TR>
	<TD>��ϵ�绰��</TD>
	<TD><input name="phone"/></TD>
</TR>
<TR>
	<TD>ְλ��</TD>
	<TD><input name="position"/></TD>
</TR>
<TR>
	<TD>�������ţ�</TD>
	<TD>
		<SELECT id="role" name="userlevel">
			<option>��ѡ��</option>
			<option value="admin">����</option>
			<option value="service">��ѧ��</option>
			<option value="user">�г���</option>
		</SELECT><span id="userlevel1"></span>
	</TD>
</TR>
<TR>
	<TD>��ɫ��</TD>
	<TD>
		<SELECT id="role" name="userlevel">
			<option>��ѡ��</option>
			<option value="admin">����Ա</option>
			<option value="service">������Ա</option>
			<option value="user">��ͨ�ͻ�</option>
		</SELECT><span id="userlevel1"></span>
	</TD>
</TR>
<TR>
	<TD>�û����룺</TD>
	<td><input type="password" name="password"/><span id="password1"></span></td>
</TR>
<TR>
	<TD><input type="submit" value="�ύ"/></TD>
	<td><td>
</TR>
</TABLE>
</form>
  </body>
</html>
