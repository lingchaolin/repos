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
	function update() {
		
			var params = {
				"cardId" : $("#cardId").val(),
				"cardCode" : $("#cardCode").val(),
				"cardType" : $("#cardType").val(),
				"name" : $("#name").val(),
				"idcard" : $("#idcard").val(),
				"sex" : $("input[name='sex']:checked").val(),
				"telphone" : $("#telphone").val(),
				"mobile" : $("#mobile").val(),
				"email" : $("#email").val(),
				"address" : $("#address").val(),
				"work" : $("#work").val(),
				"monthlyMoney" : $("#monthlyMoney").val(),
				"walletMoney" : $("#walletMoney").val(),
				"status":$("input[name='status']:checked").val()
			}
			$.get("<%=path%>/spring/card/update", params, function(data) {

				if (data == "ok") {
					alert("修改成功");
					window.location.href="<%=path%>/card/turnCard.jsp";
				} else {
					alert("修改失败")
				}

			});
		}
	function type(){
		$("#cardType").val($("#hide").val());
		$("input[type='radio'][value='"+$("#hideSex").val()+"']").attr("checked",true);
		$("input[type='radio'][value='"+$("#hideStatus").val()+"']").attr("checked",true);
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

<body onload="type(),cop()">
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
					<td align="center"><input type="text" id="cardId" value="${card.cardId }" readonly="readonly"
						 /></td>
				</tr>
				<tr>
					<td align="center">卡号</td>
					<td align="center"><input type="text" id="cardCode" value="${card.cardCode }" readonly="readonly"/></td>
				</tr>
				<tr>
					<td align="center">卡类型</td>
					<td align="center"><select id="cardType" onchange="cop()" >
							<option value="1">A卡</option>
							<option value="2">D卡</option>
							<option value="3">市民卡/社保卡</option>
							<option value="4">员工卡</option>
							<option value="5">维修调度卡</option>
					</select></td>
				</tr>
				<tr>
					<td align="center">姓名</td>
					<td align="center"><input type="text" id="name" value="${card.name }" /></td>
				</tr>
				<tr>
					<td align="center">身份证</td>
					<td align="center"><input type="text" id="idcard" value="${card.idcard }"/></td>
				</tr>
				<tr>
					<td align="center">性别</td>
					<td align="center"><input type="radio" name="sex" value="0" >女
					<input type="radio" name="sex"  value="1" >男
					</td>
				</tr>
				<tr>
					<td align="center">联系电话</td>
					<td align="center"><input type="text" id="telphone" value="${card.telphone }" /></td>
				</tr>
				<tr>
					<td align="center">手机</td>
					<td align="center"><input type="text" id="mobile" value="${card.mobile }" /></td>
				</tr>
				<tr>
					<td align="center">邮箱</td>
					<td align="center"><input type="text" id="email" value="${card.email }"/></td>
				</tr>
				<tr>
					<td align="center">地址</td>
					<td align="center"><input type="text" id="address" value="${card.address }"/></td>
				</tr>
				<tr>
					<td align="center">工作单位</td>
					<td align="center"><input type="text" id="work" value="${card.work }"/></td>
				</tr>
				<tr id="month" style="display: none">
					<td align="center">月票金额</td>
					<td align="center"><input type="text" id="monthlyMoney"  value="${card.monthlyMoney }"/></td>
				</tr>
				<tr id="wallet" style="display: none">
					<td align="center">钱包余额</td>
					<td align="center"><input type="text" id="walletMoney"  value="${card.walletMoney}"/></td>
				</tr>
				<tr >
					<td align="center">状态</td>
					<td align="center"><input type="radio" name="status" value="1" >正常
					<input type="radio" name="status"  value="2" >锁定</td>
				</tr>
				<tr>

					<td height="18" colspan="2" align="center"><input type="hidden" id="hide" value="${card.cardType }">
					<input type="hidden" id="hideSex" value="${card.sex }">
					<input type="hidden" id="hideStatus" value="${card.status }">
						<input type="button" value="修改" onClick="update()" /></td>
				</tr>
			</table>
		</form>

	</div>
</body>
</html>