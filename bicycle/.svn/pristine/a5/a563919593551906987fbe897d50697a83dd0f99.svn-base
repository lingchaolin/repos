<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	pageContext.setAttribute("path", path);
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${path}/spring/addRepairRecord" method="post">
		车辆id:<input type="text" readonly="readonly" name="bicycleId" value="${bikeID}"/><br/> 
		
		修理类型 :<select name ="repairType" id="mz" disable=true> 
			<option value="1">普修</option>
			<option value="2">更换零件</option>
			<option value="3">维修+更换零件</option>
		</select> <br />
		修理部位:<input type="text" name="repairPart"/><br/> 
		修理结果 :<select name ="repairResult" id="mz" disable=true> 
			<option value="1">修理成功</option>
			<option value="2">修理失败</option>
		</select> <br />
		维修费用:<input type="text" name="fee"/><br/> 
		修理人:<input type="text" name="repairer"/><br/> 
		备注:<input type="text" name="remark"/><br/> 
		<input type="submit" value="提交" />
	</form>
</body>
</html>