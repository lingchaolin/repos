<%@ page language="java"  pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'updateBike.jsp' starting page</title>

  </head>
  
  <body>

    <form name="form" method="post" action="UpdateBikeServlet">
    <input type="hidden" name="id" value="${carsVo.id }">
<TABLE align="center">
<TR>
	<TD>车号：</TD>
	<TD><input name="bikenumber" value="${bikesVo.bikenumber }" readonly/></TD>
</TR>
<TR>
	<TD>型号：</TD>
	<TD><input name="biketype" value="${bikesVo.biketype }" readonly/></TD>
</TR>
<TR>
	<TD>颜色：</TD>
	<TD><input name="color" value="${bikesVo.color }"/></TD>
</TR>
<TR>
	<TD>价值：</TD>
	<TD><input name="price" value="${bikesVo.price }"/></TD>
</TR>
<TR>
	<TD>租金：</TD>
	<TD><input name="rentprice" value="${bikesVo.rentprice }"/></TD>
</TR>
<TR>
	<TD>押金：</TD>
	<TD><input name="deposit" value="${bikesVo.deposit }"/></TD>
</TR>
<TR>
	<TD>租用情况：</TD>
	<TD>
		<SELECT NAME="isrenting" id="isRent">
			<option value="${bikesVo.isrenting }"><c:if test="${bikesVo.isrenting == 1 }">已出租</c:if>
			<c:if test="${bikesVo.isrenting == 0 }">未出租</c:if>
			</option>
			<option value="1">已出租</option>
			<option value="0">未出租</option>
		</SELECT>
	</TD>
</TR>
<TR>
	<TD>简介：</TD>
	<TD><textarea col="5" row="5" name="description">${carsVo.description }</textarea></TD>
</TR>
<TR>
	<TD></TD>
	<TD>
		<input type="submit" value="提交">
	</TD>
</TR>
</TABLE>
</form>
  </body>
</html>
