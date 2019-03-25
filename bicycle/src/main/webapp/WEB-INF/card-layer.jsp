<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
%> 
<table width="100%" border="0" align="center" cellspacing="1">
	<tr>
		<td class="title1">主id</td>
		<td class="title1">卡号</td>
		<td class="title1">卡类型</td>
		<td class="title1">姓名</td>
		<td class="title1">身份证</td>

		<td class="title1">性别</td>
		<td class="title1">联系电话</td>
		<td class="title1">手机</td>
		<td class="title1">邮箱</td>
		<td class="title1">住址</td>
		<td class="title1">工作单位</td>
		<td class="title1">注销标志</td>
		<td class="title1">月票金额</td>
		<td class="title1">冻结金额</td>
		<td class="title1">钱包余额</td>
		<td class="title1">卡状态</td>
		<td class="title1">操作</td>
		
	</tr>
	<c:forEach items="${page.list}" var="c">
		<tr>
			<td align="center">${c.cardId }</td>
			<td align="center">${c.cardCode }</td>
			<td align="center">${c.turn }</td>
			<td align="center">${c.name }</td>
			<td align="center">${c.idcard }</td>

			<td align="center">${c.sex }</td>
			<td align="center">${c.telphone }</td>
			<td align="center">${c.mobile }</td>
			<td align="center">${c.email }</td>
			<td align="center">${c.address }</td>
			<td align="center">${c.work }</td>
			<td align="center">${c.zxbj }</td>

			<td align="center">${c.monthlyMoney }</td>
			<td align="center">${c.frozenMoney }</td>
			<td align="center">${c.walletMoney }</td>
			<td align="center">${c.change }</td>

			<td align="center">
			<c:if test="${c.zxbj!=1}">
			<input type="button" value="注销" onclick="deleteCard(${c.cardId})" />
			</c:if>
			<c:if test="${c.status!=2 }">
			<input type="button" value="挂失" onclick="loss('${c.cardId}')" />
			</c:if>
			<c:if test="${c.zxbj!=1 }">
			<a href="<%=path%>/spring/card/change?cardId=${c.cardId}" >修改</a>
			</c:if>
			</td>
		</tr>
	</c:forEach>
	<tr>
		<td class="title2"></td>
	</tr>
</table>

<%@ include file="page.jsp"%>