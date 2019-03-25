<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'showBikeManger.jsp' starting page</title>
    <script>
function submitForm()
{
	parent.right.location.href = "adm_bikesList.html";
}
</script>
  </head>
  <body>
    <form name="form" method="post">
<TABLE align="center">
<TR>
	<TD>高级查询</TD>
	<TD></TD>
</TR>
<TR>
	<TD>车号：</TD>
	<TD>${bikesVo.bikenumber }</TD>
</TR>
<TR>
	<TD>型号：</TD>
	<TD>${bikesVo.biketype }</TD>
</TR>
<TR>
	<TD>颜色：</TD>
	<TD>${bikesVo.color }</TD>
</TR>
<TR>
	<TD>价值：</TD>
	<TD>${bikesVo.price }</TD>
</TR>
<TR>
	<TD>租金：</TD>
	<TD>${bikesVo.rentprice }</TD>
</TR>
<TR>
	<TD>押金：</TD>
	<TD>${bikesVo.deposit }</TD>
</TR>
<TR>
	<TD>租用情况：</TD>
	<TD>
		<c:if test="${bikesVo.isrenting == 1 }">已出租</c:if>
		<c:if test="${bikesVo.isrenting == 0 }">未出租</c:if>
	</TD>
</TR>
<TR>
	<TD><input type="button" value="返回" onClick="javascript:history.go(-1);" ></TD>
	<td>&nbsp;</td>
</TR>
</TABLE>
</form>
  </body>
</html>
