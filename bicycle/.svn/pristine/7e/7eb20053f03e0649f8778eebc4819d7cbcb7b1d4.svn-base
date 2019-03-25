<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%String path = request.getContextPath();%>

<html>
<head>
    <title>销售单</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css">
    <script language="javascript" src="<%=path%>/script/common.js"></script>
    <script type="text/javascript" src="<%=path%>/script/SOproductDiv.js"></script>
    <script type="text/javascript" src="<%=path%>/script/jquery-1.8.1.min.js"></script>
    <script type="text/javascript" src="<%=path%>/script/My97DatePicker/WdatePicker.js"></script>

    <style type="text/css">


        div.product {
            position: absolute;
            top: 2px;
            left: 2px;
            width: 100%;
            height: 98%;
            background-color: #fffffe;
        }

    </style>
    <script language="javascript">

        // 我的js

        function add() {

            var bicycleStation = {};
            bicycleStation.stationName = $("#stationName").val();
            bicycleStation.longitude = $("#longitude").val();
            bicycleStation.latitude = $("#latitude").val();
            bicycleStation.bicyclePileNum = $("#bicyclePileNum").val();
            bicycleStation.address = $("#address").val();
            bicycleStation.personInCharge = $("#personInCharge").val();
            bicycleStation.userId = $("#userId").val();
            bicycleStation.remark = $("#remark").val();


            var venderId = document.getElementsByName("venderId");
            var status = document.getElementsByName("status");
            var userId = document.getElementsByName("userId");
            var installTime = document.getElementsByName("installTime");
            var bicycleId = document.getElementsByName("bicycleId");
            var remark = document.getElementsByName("remark");
            var bicyclePiles = new Array();
            for (var i = 0; i < venderId.length; i++) {
                var bicyclePile = {};
                bicyclePile.venderId = venderId[i].value;
                bicyclePile.status = status[i].value;
                bicyclePile.userId = userId[i].value;
                bicyclePile.installTime = installTime[i].value;
                bicyclePile.bicycleId = bicycleId[i].value;
                bicyclePile.remark = remark[i].value;
                bicyclePiles.push(bicyclePile);
            }

            var params = {
                "bicycleStation":bicycleStation,
                "bicyclePiles":bicyclePiles
            }

            var map = JSON.stringify(params);
            var test = JSON.stringify({"name":"a","pass":"b"});

            $.ajax({
                type: "POST",
                url: "<%=path%>/spring/addbicyclestation",
                data: {bicycleStation:JSON.stringify(bicycleStation),bicyclePiles:JSON.stringify(bicyclePiles)},//将对象序列化成JSON字符串
                // dataType:"json",
                // contentType:"application/json;charset=utf-8",
                success: function (data) {
                    window.alert(data);
                }

            });

            <%--$.post("<%=path%>/sc/xs/addsomain",params,function(data){--%>
                <%--var e = document.getElementById("error");--%>

                <%--if (data == "k"){--%>
                    <%--e.innerText = "有项目为空！";--%>
                <%--}else if (data == "cf") {--%>
                    <%--e.innerText = "客户编号重复或数据有误！";--%>
                <%--}else{--%>
                    <%--location.href = "<%=path%>/sc/xs/somain";--%>
                <%--}--%>
            <%--});--%>
        }



    </script>
</head>
<div >
</div>
<body onLoad="init()">
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
    <tr>
        <td nowrap class="title1">您的位置：工作台面－－销售管理－－销售单管理</td>
    </tr>
</table>
<div class="formVisiblitly" id="formDiv"></div>
<form action="" name="mainFrm">
    <table width="100%"  border="0" cellpadding="0" cellspacing="0">
        <tr>
            <td width="30px" nowrap class="toolbar">&nbsp;</td>
            <td width="70px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="document.mainFrm.mx.click()"><img src="<%=path%>/images/add.gif">增加明细</td>
            <td width="20px" nowrap class="toolbar">|</td>
            <td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="sub()"><img src="<%=path%>/images/save.gif">保存</td>
            <td width="20px" nowrap class="toolbar">|</td>
            <td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="document.mainFrm.ts.click()"><img src="<%=path%>/images/send.gif">提审</td>
            <td width="20px" nowrap class="toolbar">|</td>
            <td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="document.mainFrm.dy.click()"><img src="<%=path%>/images/search.gif">打印</td>
            <td width="20px" nowrap class="toolbar">|</td>
            <td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="document.mainFrm.cz.click()"><img src="<%=path%>/images/reset.gif">重置</td>
            <td width="20px" nowrap class="toolbar">|</td>
            <td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="document.mainFrm.gb.click()"><img src="<%=path%>/images/cancel.gif">关闭</td>
            <td nowrap class="toolbar">&nbsp;</td>
        </tr>
    </table>

    <table id="headTable" width="100%"  border="0" align="center" class="a1">
        <tr align="justify">
            <td>车点名称</td>
            <td><input id="stationName" type="text" size="15"/>
                <span class="requred_symbol">*</span></td>
            <td>经度</td>
            <td><input id="longitude" type="text" size="15"/>
                <span class="requred_symbol">*</span></td>
            <td>纬度</td>
            <td><input id="latitude" type="text" size="15"/>
                <span class="requred_symbol">*</span></td>

            <td>车桩数量</td>
            <td><input name="bicyclePileNum" id="bicyclePileNum" type="text" size="15"/>
                <span class="requred_symbol">*</span></td>
        </tr>
        <tr align="justify">
            <td>地址</td>
            <td><input id="address" type="text" size="15" value="0" />
                <span class="requred_symbol">*</span></td>
            <td> 负责人</td>
            <td><input id="personInCharge" type="text" size="15" /></td>

            <td>操作人</td>
            <td><input id="userId" name="text" type="text" size="15" value="0"/></td>
        </tr>


        <tr align="justify">
            <td>备注</td>
            <td colspan="7"><input id="remark" name="text" size="100" ></td>
        </tr>

        <tr>
            <td class="title2"></td>
        </tr>
    </table>
    <table width="100%"  border="0" align="center" cellspacing="1" id="detailTable">
        <tr>
            <%--<td class="toolbar"> 序号 </td>--%>
            <td class="toolbar"> 供应商ID </td>
            <td class="toolbar"> 车桩状态 </td>
            <td class="toolbar"> 操作人 </td>
            <td class="toolbar"> 安装日期 </td>
            <td class="toolbar">车辆ID</td>
            <td class="toolbar">备注</td>
            <td class="toolbar">&nbsp;</td>
        </tr>

        <tr style="text-align: center">
            <td><input type='text' name='venderId' id="venderId" class="venderId" size='15' ></td>

            <td>
                <input type='text'  name='status' id="status" size='10'  >
                <span class='LL'>

                    </span>
            </td>

            <td><input type='text' name='userId'  size='15' ></td>
            <td><input type='text' name='installTime' id="installTime" size='10' ></td>
            <td><input type='text' name='bicycleId' id="bicycleId" size='10' ></td>
            <td><input type='text' name='remark' class="mxzj" size='10' ></td>
            <td><image src="<%=path%>/images/delete.gif" class="LL" onclick="del(this)"/></td>

        </tr>
    </table>


    <table width="100%"  border="0" align="center" cellspacing="1">
        <tr>
            <td class="title2"></td>
        </tr>

    </table>
    <br>
    <div align="center">
        <input type="button" id="mx" value="增加明细" onClick="addItem()"/>
        <input type="button" id="bc" value="保存" onclick="add()"/>
        <input type="submit" id="ts" value="提审"/>
        <input type="button" id="dy" value="打印" onClick="window.print()"/>
        <input name="reset"  id="cz" value="重置" type="reset"/>
        <input type="button" id="gb" value="关闭" onClick="window.close()"/>
        <br>
        <span id="error"></span>
    </div>

    <!-- div -->

    <div id="productDiv" style="visibility: hidden;" class="product">
        <table width="100%"  border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td width="30px" nowrap="nowrap" class="toolbar" >&nbsp;</td>
                <td width="40px" nowrap="nowrap" class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="choiceAnonymous('productDiv')"><img src="<%=path%>/images/confirm.gif">确定</td>
                <td width="20px" nowrap="nowrap" class="toolbar">|</td>
                <td width="40px" nowrap="nowrap" class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="hiddenDiv()"><img src="<%=path%>/images/cancel.gif">取消</td>
                <td align="center" valign="middle" nowrap="nowrap" class="toolbar">&nbsp;</td>
            </tr>
        </table>
        <table width="100%"  border="0" align="center" cellspacing="1" class="a1" id="spxxTable">
            <tr>
                <td class="title1">选择</td>
                <td class="title1">产品编码</td>
                <td class="title1">产品名称</td>
                <td class="title1">数量单位</td>
            </tr>
            <%--<c:forEach items="${products}" var="p" varStatus="i">--%>
                <%--<tr onClick="selectItem(this)" onMouseOver="OMO1(event)" onDblClick="choice(${i.index+1})" align="center">--%>
                    <%--<td>&nbsp;</td>--%>
                    <%--<td>${p.productCode}</td>--%>
                    <%--<td>${p.name}</td>--%>
                    <%--<td>${p.unitName}</td>--%>
                <%--</tr>--%>
            <%--</c:forEach>--%>

            <tr>
                <td class="title2"></td>
            </tr>
        </table>
    </div>


</form>
</body>
</html>
