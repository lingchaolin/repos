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
        <td class="title1">自行车编号</td>
        <td class="title1">所在车桩ID</td>
        <td class="title1">销毁日期</td>
        <td class="title1">操作人</td>
        <td class="title1">操作时间</td>

        <td class="title1">租车卡ID</td>
        <td class="title1">备注</td>
        <td class="title1">操作</td>

    </tr>
    <c:forEach items="${page.list}" var="cl">
        <tr>
            <td align="center">${cl.bicycleCode}</td>
            <td align="center">${cl.pileID}</td>
            <td align="center">${cl.destroyDate}</td>
            <td align="center">${cl.userID}</td>
            <td align="center">${cl.operatorTime}</td>

            <td align="center">${cl.cardID}</td>
            <td align="center">${cl.remark}</td>
            <td align="center">
                <a href="<%=path%>/spring/showbicycleinfosta?bicycleId=${cl.bicycleId}" >查看</a>
            </td>

        </tr>
    </c:forEach>
    <tr>
        <td class="title2"></td>
    </tr>
</table>

<%@ include file="page.jsp" %>