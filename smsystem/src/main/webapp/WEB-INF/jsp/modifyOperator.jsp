<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<HTML><HEAD><TITLE>中国移动业务管理系统</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<META content="MSHTML 6.00.2600.0" name=GENERATOR>
<link href="style.css" rel="stylesheet" type="text/css">
<style type="text/css">
body,td,th {
	font-family: Verdana;
}
</style>
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="js/modifyOperator.js"></script>
</HEAD>
<BODY bgColor=#ffffff leftMargin=0 topMargin=0 marginheight="0" marginwidth="0">
${operatorinfo}
	<form method="POST" action="modifyoperatorlink" id="tomodify">
		<input type="hidden" id="operatorid" name="operatorid"/>
 	
	<table border="0" width="100%">
 			<tr vAlign=top  height="360">
 				<td>
 					<table border="1" width="100%">
	      	<tr>
		        <td width="5%" align="center" height="16">&nbsp;</td>
		        <td width="0%" align="center" height="17" style="display:none"></td>
                <td width="20%" align="center" height="16">用户名</td>
		        <td width="20%" align="center" height="16">姓名</td>
                <td width="20%" align="center" height="16">性别</td>         
		        <td width="20%" align="center" height="16">是否管理员</td>
		        <td width="15%" align="center" height="16">修改</td>
		      </tr>
		      <c:forEach items="${list}" var="per">
	      	  <tr>
		      	<td width="5%" align="center" height="16"><input type="checkbox" name="operatorselectid" value="${per.operatorid}" /></td>
		      	<td width="0%" align="center" height="17" style="display:none">${per.operatorid}</td>
		        <td width="20%" align="center" height="17" value="123">${per.username}</td>
		        <td width="20%" align="center" height="17">${per.operatorname}</td>
                <td width="20%" align="center" height="17">
                <c:choose>
	                <c:when test="${per.operatorsex=='1'}">男</c:when>
	                <c:otherwise>女</c:otherwise>
                </c:choose>
                </td>
		        <td width="20%" align="center" height="17">
		        	<c:choose>
		                <c:when test="${per.isadmin=='Y'}">是</c:when>
		                <c:otherwise>否</c:otherwise>
               	 	</c:choose>
		        </td>
		        <td width="15%" align="center" height="17">
		        	<div name="tomodify">&gt;&gt;</div>
		        </td>
		      </tr>
		      </c:forEach>
		      <tr>
		      	<td width="5%" align="center" height="16">&nbsp;</td>
		      	<td width="0%" align="center" height="17" style="display:none"></td>
		        <td width="20%" align="center" height="16">&nbsp;</td>
		        <td width="20%" align="center" height="16">&nbsp;</td>
		        <td width="20%" align="center" height="16">&nbsp;</td>
		        <td width="20%" align="center" height="16">&nbsp;</td>
                <td width="15%" align="center" height="16">&nbsp;</td>
		      </tr>
		      <tr>
		      	<td colSpan=6>&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" id="fordelete" value="删除" /></td>	
		      </tr>
    		</table>
 				</td>
 			</tr>
 			<tr>
 				<td align="center">首页&nbsp;上一页&nbsp;下一页&nbsp;尾页</td>
 			</tr>
 		</table>   
</form>
    </BODY></HTML>
    