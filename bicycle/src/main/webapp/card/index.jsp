<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%session.setAttribute("userid", "1"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主界面</title>
</head>
<frameset rows="23,10,*" cols="*" frameborder="NO" border="0"
	framespacing="0" id="controlRv">
	<frame src="title.htm" name="topFrame" scrolling="NO" noresize>
	<frame src="dynamic_bar_h.htm" scrolling="no" name="sidebar_r" noresize>
	<frameset cols="120,10,*" frameborder="NO" border="0" framespacing="0"
		id="controlFv">
		<frame src="catalog.htm" name="leftFrame" scrolling="NO" noresize>
		<frame src="dynamic_bar_v.htm" scrolling="no" name="sidebar_v"
			noresize>
		<frame src="" name="mainFrame" scrolling="auto">
	</frameset>
</frameset>
<noframes></noframes>
</html>