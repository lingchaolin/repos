<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<HTML><HEAD><TITLE>中国移动业务管理系统</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<META content="MSHTML 6.00.2600.0" name=GENERATOR>
<link href="style.css" rel="stylesheet" type="text/css">
<style type="text/css">
body,td,th {
	font-family: Verdana;
}
</style>
</HEAD>
<BODY bgColor=#ffffff leftMargin=0 topMargin=0 marginheight="0" marginwidth="0">
	 <TD height="600" bgColor=#f1f3f9>
 
	<br>
    <form name="form1" method="POST" action="">
    <p>&nbsp;&nbsp;&nbsp;号码类型：
    <input type="Radio" name="R1" value="SIM" checked>SIM &nbsp;&nbsp;
    <input type="Radio" name="R1" value="UIM">UIM
    </p>
    <p>&nbsp;&nbsp;&nbsp;指定号段：
    从<input type="text" name="T1" size="20" value="13910000001">到
    <input type="text" name="T2" size="20" value="13910000020">
    
    <input type="submit" value="提交" name="B1">
    <input type="reset" value="全部重写" name="B2"></p>
    </form>
    <br>
    <hr>
    
	<br>

    <form name="form2" method="POST" action="">
      <p>&nbsp;&nbsp;&nbsp;从指定文件导入：
      <input type="text" name="T1" size="40" value="C:\test\mobile_numbers.txt">
      <input type="submit" value="提交" name="B1">
      <input type="reset" value="全部重写" name="B2">
      </p>
    </form>
       
    </TD>
   
</BODY></HTML>
    