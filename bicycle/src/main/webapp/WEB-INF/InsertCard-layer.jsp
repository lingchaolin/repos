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
		
	</tr>
		<tr>
			<td align="center"><span id="cardId">${c.cardId }</span></td>
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
			<td align="center"><span id="status">${c.change }</span></td>
			<td align="center"><input type="hidden" id="type" value="${c.cardType }"></td>
		</tr>
	<tr>
		<td class="title2"></td>
	</tr>
</table>