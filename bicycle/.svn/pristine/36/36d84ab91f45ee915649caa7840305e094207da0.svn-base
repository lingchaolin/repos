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
    <title>车辆年度/月度信息统计</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link href="<%=path %>/css/style.css" rel="stylesheet" type="text/css">
    <script language="javascript" src="<%=path %>/script/common.js"></script>
    <script type="text/javascript" src="<%=path %>/script/jquery-1.8.1.min.js"></script>
    <script type="text/javascript" src="<%=path %>/script/My97DatePicker/WdatePicker.js"></script>

    <script language="javascript" type="text/javascript">

        function goPage() {
            var params = {
                "startDay":$("#startDay").val(),
                "endDay":$("#endDay").val()
            };

            $("#bicyclesta").load("<%=path%>/spring/showbicyclesta",params);
        }


    </script>
</head>

<body onload="goPage()">
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
    <tr>
        <td nowrap class="title1">您的位置：工作台面－－车辆年度/月度信息统计</td>
    </tr>
</table>
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
    <tr>
        <td width="30px" nowrap class="toolbar">&nbsp;</td>

        <td style="text-align: left" width="500px" nowrap class="toolbar">
            <img src="<%=path %>/images/search.gif"><a onclick="goPage()">查询</a>&nbsp;

            日期:
            <input id="startDay" class="Wdate" type="text"  onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:true,readOnly:true})"/>

            -
            <input id="endDay" class="Wdate" type="text"  onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:true,readOnly:true})"/>
        <td nowrap class="toolbar">&nbsp;</td>


    </tr>
</table>

<div id="bicyclesta">

</div>

</body>
</html>

