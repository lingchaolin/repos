<%--
  Created by IntelliJ IDEA.
  User: Lincar
  Date: 2018/6/7
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%String path = request.getContextPath();%>
<table width="100%"  border="0" align="center" cellspacing="1" >
    <tr>
        <td class="title1">供应商编号</td>
        <td class="title1">供应商类别</td>
        <td class="title1">供应商名称</td>
        <td class="title1">地址</td>
        <td class="title1">电话</td>

        <td class="title1">联系人</td>
        <td class="title1">生产许可</td>
        <td class="title1">工商注册号</td>
        <td class="title1">注册资金</td>
        <td class="title1">操作人</td>
        <td class="title1">操作日期</td>
        <td class="title1">注销标志</td>
        <td class="title1">备注</td>
    </tr>
    <c:forEach items="${page.list}" var="cl">
    <tr>
        <td align="center">${cl.venderCode}</td>
        <td align="center">${cl.venderType}</td>
        <td align="center">${cl.venderName}</td>
        <td align="center">${cl.address}</td>
        <td align="center">${cl.telephone}</td>

        <td align="center">${cl.contacts}</td>
        <td align="center">${cl.productLicense}</td>
        <td align="center">${cl.bussinessRegistrationNo}</td>
        <td align="center">${cl.registeredCapital}</td>
        <td align="center">${cl.userID}</td>
        <td align="center">${cl.createTime}</td>
        <td align="center">${cl.zxbj}</td>
        <td align="center">${cl.remark}</td>
        <td align="center">
            <a href="<%=path%>/sc/xs/customershowmodify?customercode=${cl.venderID}" >修改</a>
            <a onclick="location.href='deletecustomer?customercode=${cl.venderID}'">删除</a>
        </td>
    </tr>
    </c:forEach>
    <tr>
        <td class="title2"></td>
    </tr>
</table>

<%@ include file="page.jsp" %>