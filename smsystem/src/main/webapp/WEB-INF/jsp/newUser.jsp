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
<form method="POST" action="newAccount.htm">
     <table align="left" border="0">
    	<tr height="30">
        	<td align="right" width="20%">手机号码：</td>
            <td width="80%"><input type="text" name="T1" size="20"></td>
        </tr>
        <tr height="30">
            <td align="right">漫游状态：</td>
            <td>
            <input type="radio" name="R1" value="V4" checked>省内漫游
            <input type="radio" name="R1" value="V5">国内漫游
            <input type="radio" name="R1" value="V6">国际漫游
            </td>
        </tr>
        <tr height="30">
            <td align="right">通话级别：</td>
            <td>
            <input type="radio" name="R2" value="V1" checked>本地通话
            <input type="radio" name="R2" value="V2">国内长途
            <input type="radio" name="R2" value="V3">国际长途
            </td>
        </tr>
        <tr height="30">
            <td align="right">客户编号：</td>
            <td><input type="text" name="T2" size="20" value="11100011" readonly></td>
        </tr>
        <tr height="30">
            <td align="right">账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</td>
            <td><input type="text" name="T3" size="20"></td>
        </tr>
        <tr height="30">
            <td colspan="2" align="center">
            <input type="submit" value="下一步>>" name="B1">
            <input type="reset" value="全部重写" name="B2"></td>
        </tr>
    </table>
    </form> 
     
</BODY></HTML>
    