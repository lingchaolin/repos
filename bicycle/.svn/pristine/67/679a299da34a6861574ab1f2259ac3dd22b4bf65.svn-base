<%--
  Created by IntelliJ IDEA.
  User: Lincar
  Date: 2018/6/8
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>添加新供应商</title>
    <link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="<%=path %>/script/jquery-1.8.1.min.js"></script>
    <script>
        <%--function goPage(pageNumber) {--%>
            <%--var params = {--%>
                <%--"currentPage":pageNumber,--%>
                <%--"customerCode":$("#customerCode").val(),--%>
                <%--"name":$("#name").val()--%>
            <%--};--%>

            <%--$("#customer").load("<%=path%>/xs/showcustomer",params);--%>
        <%--}--%>

        function add() {
            var params = {
                "customerCode":$("#customerCode").val(),
                "name":$("#name").val(),
                "password":$("#password").val(),
                "contactor":$("#contactor").val(),
                "address":$("#address").val(),
                "postCode":$("#postCode").val(),
                "tel":$("#tel").val(),
                "fax":$("#fax").val()
            };

            $.post("<%=path%>/sc/xs/addcustomer",params,function (data) {
                var e = document.getElementById("error");

                if (data == "k"){
                    e.innerText = "有项目为空！";
                }else if (data == "cf") {
                    e.innerText = "供应商编号重复或数据有误！";
                }else{
                    location.href = "<%=path%>/sc/xs/customer";
                }
            })


            // http.setRequestHeader("Content-type","application/x-www-form-urlcoded");
            <%--$.post("<%=path%>/xs/addcustomer",params);--%>
        }

    </script>
</head>

<body>
<div id="m">
    <table width="100%"  border="0" cellpadding="0" cellspacing="0" id="m">
        <tr>
            <td nowrap class="title1">您的位置：工作台面－－供应商管理--供应商添加</td>
        </tr>
    </table>
    <table width="100%"  border="0" cellpadding="0" cellspacing="0">
        <tr>
            <td width="20px" nowrap class="toolbar">&nbsp;</td>
        </tr>
    </table>
    <table width="100%"  border="0" align="center" cellspacing="1" class="c">
        <tr>
            <td class="title1">&nbsp;</td>
        </tr>
    </table>
</div>

<div id="add" >

    <form>
        <table width="100%"  border="0" align="center" cellspacing="1" class="c">
            <tr>
                <td class="title1">&nbsp;</td>
                <td class="title1" style="text-align: center" id="error"></td>
            </tr>
            <tr>
                <td align="center">供应商编号</td>
                <td align="center"><input type="text" id="customerCode" value="${customerCode}"/></td>
            </tr>
            <tr>
                <td align="center">供应商名称</td>
                <td align="center"><input type="text" id="name" value="${name}"/></td>
            </tr>
            <tr>
                <td align="center">供应商密码</td>
                <td align="center"><input type="text" id="password" value="${password}"/></td>
            </tr>
            <tr>
                <td align="center">联系人</td>
                <td align="center"><input type="text" id="contactor" value="${contactor}"/></td>
            </tr>
            <tr>
                <td align="center">地址</td>
                <td align="center"><input type="text" id="address" value="${address}"/></td>
            </tr>
            <tr>
                <td align="center">邮编</td>
                <td align="center"><input type="text" id="postCode" value="${postCode}"/></td>
            </tr>
            <tr>
                <td align="center">电话</td>
                <td align="center"><input type="text" id="tel" value="${tel}"/></td>
            </tr>
            <tr>
                <td align="center">传真</td>
                <td align="center"><input type="text" id="fax" value="${fax}"/></td>
            </tr>
            <tr>

                <td height="18" colspan="2" align="center"><input type="reset"/> <input type="button" value="保存" onclick="add()"/>
                <input type="button" onclick="history.back(-1)" value="返回"></td>
            </tr>
        </table>
    </form>

</div>

<iframe width=174 height=189 name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="../common/calendar/ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; left:-500px; top:0px;"></iframe>
</body>
</html>
