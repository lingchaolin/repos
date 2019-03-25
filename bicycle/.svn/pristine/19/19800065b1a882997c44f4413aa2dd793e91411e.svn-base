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
    <title>车辆信息统计</title>
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
        <td nowrap class="title1">您的位置：工作台面－－车辆信息统计</td>
    </tr>
</table>
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
    <tr>
        <td width="30px" nowrap class="toolbar">&nbsp;</td>

        <%--<td style="text-align: left" width="500px" nowrap class="toolbar">--%>
            <%--<img src="<%=path %>/images/search.gif"><a onclick="goPage()">查询</a>&nbsp;--%>

            <%--日期:--%>
            <%--<input id="startDay" class="Wdate" type="text"  onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:true,readOnly:true})"/>--%>

            <%-----%>
            <%--<input id="endDay" class="Wdate" type="text"  onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:true,readOnly:true})"/>--%>
        <%--<td nowrap class="toolbar">&nbsp;</td>--%>

    <td>车辆ID：${bicycleInfoSta.BICYCLEID}</td>
    <td><input type="button" value="返回" onclick="history.back()"></td>
    </tr>
</table>

<table width="100%"  border="0" align="center" cellspacing="1">
    <tr>
        <td>借还次数</td>
        <td>修理次数</td>
        <td>调度次数</td>
        <td>总借还时间</td>
        <td>平均借还时间</td>
        <td>总借车收入</td>
        <td>平均借车收入</td>
        <td>总修理费用</td>
        <td>平均修理费用</td>
    </tr>

    <tr>
        <td>${bicycleInfoSta.BICYCLERECORDCOUNT}</td>
        <td>${bicycleInfoSta.REPAIRRECORDCOUNT}</td>
        <td>${bicycleInfoSta.BICYCLEDEPLOYCOUNT}</td>
        <td>${bicycleInfoSta.TOTALRENTRETURNTIME}</td>
        <td>${bicycleInfoSta.AVGRENTRETURNTIME}</td>
        <td>${bicycleInfoSta.TOTALRENTFEE}</td>
        <td>${bicycleInfoSta.AVGRENTFEE}</td>
        <td>${bicycleInfoSta.TOTALREPAIRFEE}</td>
        <td>${bicycleInfoSta.AVGREPAIRFEE}</td>
    </tr>

</table>

</body>
</html>

