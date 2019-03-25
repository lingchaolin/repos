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
<form method="POST" action="newCustomer1.htm">
    <table align="left" border="0">
    	<tr height="30">
        	<td align="right" width="30%">证件类型：</td>
            <td width="70%">
            <select size="1" name="D1">
                <option>居民身份证</option>
                <option>护照</option>
                <option>军官证</option>
          	</select>
            </td>
        </tr>
        <tr height="30">
            <td align="right">证件号码：</td>
            <td><input type="text" name="T2" size="20" value="3323224123341"></td>
        </tr>
        <tr height="30">
            <td colspan="2" align="center"><input type="submit" value="下一步>>" name="B1"><input type="reset" value="全部重写" name="B2"></td>
        </tr>
    </table>
    </form>
    
</BODY></HTML>
    