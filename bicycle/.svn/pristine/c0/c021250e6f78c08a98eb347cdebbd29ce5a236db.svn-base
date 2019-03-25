<%--
  Created by IntelliJ IDEA.
  User: Lincar
  Date: 2018/6/7
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>供应商管理</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link href="<%=path %>/css/style.css" rel="stylesheet" type="text/css">
    <script language="javascript" src="<%=path %>/script/common.js"></script>
    <script type="text/javascript" src="<%=path %>/script/jquery-1.8.1.min.js"></script>
    <script language="javascript" type="text/javascript">

        function goPage(pageNumber) {
            var params = {
                "pageNum":pageNumber
            };

            $("#vender").load("<%=path%>/spring/showvender",params);
        }


    </script>
</head>

<body onload="goPage(1)">
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
    <tr>
        <td nowrap class="title1">您的位置：工作台面－－供应商管理</td>
    </tr>
</table>
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
    <tr>
        <td width="30px" nowrap class="toolbar">&nbsp;</td>
        <td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="location.href='<%=path%>/spring/venderaddpage'">
            <img src="<%=path %>/images/new.gif">新增</td>
        <td width="20px" nowrap class="toolbar">|</td>
        <td style="text-align: left" width="500px" nowrap class="toolbar">
            <img src="<%=path %>/images/search.gif"><a onclick="goPage(1)">查询</a>&nbsp;客户编号:<input type="text" id="customerCode">
            客户名称:<input type="text" id="name"></td>
        <td nowrap class="toolbar">&nbsp;</td>


    </tr>
</table>

<div id="vender">

</div>

</body>
</html>

