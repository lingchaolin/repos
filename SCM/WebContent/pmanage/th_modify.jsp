<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script language="javascript" src="script/common.js" ></script>
<script type="text/javascript" src="script/productDiv.js" ></script>
<script language="javascript" type="text/javascript">
	function getDate(){
		var dateVal=document.getElementsByName("jzrq")[0];//dateVal.value===""说明日期中没有值，即新增，获取当前日期；
		if(dateVal.value===""){
			var date=new Date();
			document.getElementsByName("jzrq")[0].value=date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate();
		}
		//锁定设置
    	var y=document.getElementById("y2").value;
		var ys=document.getElementsByName("y");
		if(y=="是"){
			ys[0].ckecked="true";
		}else if(y=="否"){
			ys[1].checked="true";
		}  
		//权限设置
	    var auth=document.getElementById("auth2").value;
		var auths=document.getElementsByName("auth");
		if(auth.indexOf("管理员")>-1){
			auths[0].checked="true";
		}
		 if(auth.indexOf("采购")>-1){
			auths[1].checked="true";
		}
		 if(auth.indexOf("仓管")>-1){
			auths[2].checked="true";
		}
		 if(auth.indexOf("财务")>-1){
			auths[3].checked="true";
		}
		 if(auth.indexOf("销售")>-1){
			auths[4].checked="true";
		} 
	}
	function reseting(){
		window.location.reload();
	}
	//ajax校验用户名
	var httpRequest;
	function checkRepeat(){
		var accountVal=document.getElementById("userAccount").value;
		httpRequest=new XMLHttpRequest();
		httpRequest.open("GET","MaCheckAccountRepeat?userAccount="+accountVal,true);
		httpRequest.onreadystatechange=callback;
		httpRequest.send(null);
	}
	function callback(){
		if(httpRequest.readyState==4){
			if(httpRequest.status==200){
				var text=httpRequest.responseText;
				var flag=document.getElementById("userSpan");
				if(text=="yes"){
					flag.innerHTML="账号可用";
					flag.style.color="green";
				}else if(text=="no"){
					flag.innerHTML="账号不可用";
					flag.style.color="red";
				}else{
					flag.innerHTML="";
				}
			}
		}
	}
	function submitValue(){
		var valu1=document.getElementsByName("userAccount")[0].value;
		var fom=document.getElementById("userSpan");
		if(document.getElementById("userSpan")!=null){//说明存在这个span,是新增
			if(fom.innerHTML=="账号不可用"){
				alert("账号不可用");
				return;
			}else if(fom.innerHTML==""){
				alert("请填入账号信息");
				return;
			}
		}
		var valu2=document.getElementById("accountName").value;//用户名
		if(valu2==""){
			alert("请填入用户名");
			return;
		} 
		var flag=false;
		for(var j=0;j<document.getElementsByName("auth").length;j++){
		 	if(document.getElementsByName("auth")[j].checked==true){
		 		flag=true;
		 		break;
			} 
		} 
		if(!flag){
			alert("请选择权限");
			return;
		}
		document.getElementById("getValue").submit();
	}
</script>
<%	String path=request.getContextPath();
String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath %>">
</head>
<body onload="getDate()">
<div id="add">
<form action="MaAddOrModifyAccountToSql" id="getValue" name="getValue">
	<table width="100%"  border="0" align="center" cellspacing="1" class="c">
  <tr>
    <td align="center">用户账号</td>
    <td align="center">
    	<c:choose>
    		<c:when test="${ empty requestScope.amList[0]}">
    			<input type="text" id="userAccount" name="userAccount" onkeyup="checkRepeat()" />
    			<span id="userSpan"></span>
    		</c:when>
    		<c:otherwise>
    		<input type="text" readonly="readonly" id="userAccount" name="userAccount" value="${requestScope.amList[0].account }" />
    		<!-- <span id="userSpan"></span> -->
    		</c:otherwise>
    	</c:choose>
    </td>
	</tr>
  	<tr>
	    <td align="center">用户名</td>
	    <td align="center">
	    	<input type="text"  id="accountName" name="accountName" value="${requestScope.amList[0].name }" />
	    </td>
	</tr>
  <tr>
    <td align="center">添加日期</td>
    <td align="center">
    	<input name="jzrq" id="jzrq" type="text" size="15" value="${requestScope.amList[0].createDate }"  readonly="readonly"  />
      <span class="requred_symbol">*</span>
      <a href="javascript:void(0)" onClick="gfPop.fPopCalendar(document.all.jzrq);return false;">
      <img name="popcal"  src="images/selectDate.gif" width="15" height="12" border="0" alt=""></a>
    </td>
	</tr>
  <tr>
    <td align="center">锁定状态</td>
    <td align="center">
    	<input type="radio" name="y"/ value="是">是 <input type="radio" checked="checked" name="y" value="否"/>否
    	<input type="hidden" id="y2" name="y2" value="${requestScope.amList[0].status }"/>
    	<%-- <input type="hidden" name="yName" value="${requestScope.amList[0].status }"/> --%>
    </td>
	</tr>
  <tr>
    <td align="center">用户权限</td>
   <!--  <td align="center"><input type="checkbox"/>管理员<input type="checkbox"/>采购<input type="checkbox"/>仓管<input type="checkbox"/>财务</td> -->
    <td align="center">
    	<input name="auth" type="checkbox" value="管理员"/>管理员
    	<input name="auth" type="checkbox" value="采购"/>采购
    	<input name="auth" type="checkbox" value="仓管"/>仓管
    	<input name="auth" type="checkbox" value="财务"/>财务
    	<input name="auth" type="checkbox" value="销售"/>销售
    	<input type="hidden" id="auth2" name="auth2" value="${requestScope.amList[0].modelName }"/>
    </td>
	</tr>
  <tr>
    <td height="18" colspan="2" align="center"><input onclick="reseting()" type="reset"/> <input type="button" value="保存" onClick="submitValue()"/></td>
    </tr>
</table>
</form>
</div>
<!-- <iframe width=174 height=189 name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="common/calendar/ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; left:-500px; top:0px;"></iframe>
 -->
</body>
</html>