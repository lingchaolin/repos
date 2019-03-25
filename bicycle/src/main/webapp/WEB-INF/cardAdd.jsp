<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=path%>/card/css/style.css" rel="stylesheet"
	type="text/css">
<script language="javascript" src="<%=path%>/card/script/common.js"></script>
<script type="text/javascript" src="<%=path%>/card/script/productDiv.js"></script>
<script type="text/javascript"
	src="<%=path%>/card/script/jquery-1.8.1.min.js"></script>
<script type="text/javascript"
	src="<%=path%>/card/script/My97DatePicker/WdatePicker.js"></script>
<title>增加供应商</title>
<script type="text/javascript">
	function add() {
		
			var params = {
				"cardId" : $("#cardId").val(),
				"cardCode" : $("#cardCode").val(),
				"cardType" : $("#cardType").val(),
				"name" : $("#name").val(),
				"idcard" : $("#idcard").val(),
				"sex" : $('input:radio:checked').val(),
				"telphone" : $("#telphone").val(),
				"mobile" : $("#mobile").val(),
				"email" : $("#email").val(),
				"address" : $("#address").val(),
				"work" : $("#work").val(),
				"monthlyMoney" : $("#monthlyMoney").val(),
				"walletMoney" : $("#walletMoney").val()
			}
			$.get("<%=path%>/spring/card/add", params, function(data) {

				if (data == "ok") {
					alert("添加成功");
					window.location.href="<%=path%>/card/turnCard.jsp";
				} else if(data=="id") {
					alert("主id重复");
				}else{
					alert("添加失败");
				}

			});
		}
	function cop(){
		var type=$("#cardType").val();
		if(type==1){
			$("#month").show();
			$("#wallet").show();
		}
		if(type==2){
			$("#month").show();
			$("#wallet").hide();
		}
		if(type==3){
			$("#month").show();
			$("#wallet").show();
		}
		if(type==4){
			$("#month").hide();
			$("#wallet").hide();
		}
		if(type==5){
			$("#month").hide();
			$("#wallet").hide();
		}
	}
</script>
</head>

<body onload="cop()">
	<div id="m">
		<table width="100%" border="0" cellpadding="0" cellspacing="0" id="m">
			<tr>
				<td nowrap class="title1">您的位置：工作台面－－新办卡</td>
			</tr>
		</table>
		<table width="100%" border="0" align="center" cellspacing="1"
			class="c">
			<tr>
				<td class="title1">&nbsp;</td>
			</tr>
		</table>
	</div>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="30px" nowrap class="toolbar"><a href="<%=path%>/card/turnCard.jsp">返回办卡主界面</a></td>

		</tr>
	</table>
	<div id="add">
		<form id="form" >
			<table width="100%" border="0" align="center" cellspacing="1"
				class="c">
				<tr>
					<td class="title1">&nbsp;</td>
					<td class="title1">&nbsp;</td>
				</tr>
				<tr>
					<td align="center">主ID</td>
					<td align="center"><input type="text" id="cardId"
						 /></td>
				</tr>
				<tr>
					<td align="center">卡号</td>
					<td align="center"><input type="text" id="cardCode" /></td>
				</tr>
				<tr>
					<td align="center">卡类型</td>
					<td align="center"><select id="cardType" onchange="cop()">
							<option value="1">A卡</option>
							<option value="2">D卡</option>
							<option value="3">市民卡/社保卡</option>
							<option value="4">员工卡</option>
							<option value="5">维修调度卡</option>
					</select></td>
				</tr>
				<tr>
					<td align="center">姓名</td>
					<td align="center"><input type="text" id="name" /></td>
				</tr>
				<tr>
					<td align="center">身份证</td>
					<td align="center"><input type="text" id="idcard" /></td>
				</tr>
				<tr>
					<td align="center">性别</td>
					<td align="center"><input type="radio" name="sex" checked value="0" >女
					<input type="radio" name="sex" checked value="1" >男
					</td>
				</tr>
				<tr>
					<td align="center">联系电话</td>
					<td align="center"><input type="text" id="telphone" /></td>
				</tr>
				<tr>
					<td align="center">手机</td>
					<td align="center"><input type="text" id="mobile" /></td>
				</tr>
				<tr>
					<td align="center">邮箱</td>
					<td align="center"><input type="text" id="email" /></td>
				</tr>
				<tr>
					<td align="center">地址</td>
					<td align="center"><input type="text" id="address" /></td>
				</tr>
				<tr>
					<td align="center">工作单位</td>
					<td align="center"><input type="text" id="work" /></td>
				</tr>
				<tr id="month" style="display: none">
					<td align="center">月票金额</td>
					<td align="center"><input type="text" id="monthlyMoney" /></td>
				</tr>
				<tr id="wallet" style="display: none">
					<td align="center">钱包余额</td>
					<td align="center"><input type="text" id="walletMoney" /></td>
				</tr>
				<tr>

					<td height="18" colspan="2" align="center"><input type="reset" />
						<input type="button" value="保存" onClick="add()" /></td>
				</tr>
			</table>
		</form>

	</div>
</body>
</html>