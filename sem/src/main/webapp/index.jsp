<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>SCM</title>
</head>

<frameset rows="23,10,*" cols="*" frameborder="NO" border="0" framespacing="0" id="controlRv">
  <tiles:insertAttribute name="header"></tiles:insertAttribute>
  
  <tiles:insertAttribute name="header"></tiles:insertAttribute>
  <tiles:insertAttribute name="header"></tiles:insertAttribute>
  <tiles:insertAttribute name="header"></tiles:insertAttribute>
  <frame src="dynamic_bar_h.htm" scrolling="no" name="sidebar_r" noresize>
  <frameset cols="120,10,*" frameborder="NO" border="0" framespacing="0"  id="controlFv">
  	<tiles:insertAttribute name="menu"></tiles:insertAttribute>
	<frame src="dynamic_bar_v.htm" scrolling="no"  name="sidebar_v" noresize>
    <frame src="" name="mainFrame" scrolling="auto">
  </frameset>
</frameset>
<noframes></noframes>

<!-- <tiles:insertAttribute name="header"></tiles:insertAttribute> -->
</html>
