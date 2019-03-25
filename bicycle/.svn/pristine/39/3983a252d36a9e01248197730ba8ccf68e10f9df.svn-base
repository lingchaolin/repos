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
        <td class="title1">车点编号</td>
        <td class="title1">车点名称</td>
        <td class="title1">车点经度</td>
        <td class="title1">车点纬度</td>
        <td class="title1">车桩数量</td>

        <td class="title1">地址</td>
        <td class="title1">负责人</td>
        <td class="title1">新建日期</td>
        <td class="title1">运行日期</td>
        <td class="title1">操作人</td>
        <td class="title1">创建日期</td>
        <td class="title1">备注</td>
    </tr>
    <c:forEach items="${page.list}" var="cl">
    <tr>
        <td align="center">${cl.stationCode}</td>
        <td align="center">${cl.stationName}</td>
        <td align="center">${cl.longitude}</td>
        <td align="center">${cl.latitude}</td>
        <td align="center">${cl.bicyclePileNum}</td>

        <td align="center">${cl.address}</td>
        <td align="center">${cl.personInCharge}</td>
        <td align="center">${cl.buildTime}</td>
        <td align="center">${cl.runTime}</td>
        <td align="center">${cl.userId}</td>
        <td align="center">${cl.createTime}</td>
        <td align="center">${cl.remark}</td>
        <td align="center">
            <a href="<%=path%>/sc/xs/customershowmodify?customercode=${cl.stationId}" >修改</a>
            <a onclick="location.href='deletecustomer?customercode=${cl.stationId}'">删除</a>
        </td>
    </tr>
    </c:forEach>
    <tr>
        <td class="title2"></td>
    </tr>
</table>

<%@ include file="page.jsp" %>