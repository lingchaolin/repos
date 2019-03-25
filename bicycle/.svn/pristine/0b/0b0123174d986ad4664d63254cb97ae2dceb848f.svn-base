<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<script type="text/javascript" src="<%=path%>/script/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0& ak=Oe2HatGh3npsCvd7WYZ610G1jTXWkvTV"></script>
<style type="text/css">
body, html, #allmap {
	width: 100%;
	height: 100%;
	overflow: hidden;
	margin: 0;
	font-family: "微软雅黑";
}
</style>
<title>车点展示</title>
</head>
<body onload="init()">
	<div id="allmap"></div>
</body>
</html>
<script type="text/javascript">
	function init(){
		var params = {
				"username":"zhangsan",
				"password":"1234"
			}; 
		$.post("<%=path%>/spring/stationmap",params,function(data){
			
		var points=data;
		addMarker(points);
		
		},"json");
		
	}
	function addMarker(points) {
		//循环建立标注点
		for (var i = 0; i < points.length; i++) {
			var point = new BMap.Point(points[i].longitude, points[i].latitude); //将标注点转化成地图上的点
			var marker = new BMap.Marker(point); //将点转化成标注点
			map.addOverlay(marker); //将标注点添加到地图上
			//添加监听事件
			(function() {
				var thePoint = points[i];
				marker.addEventListener("click", function() {
					showInfo(this, thePoint);
				});
			})();
		}
	}
	function showInfo(thisMarker, point) {
		//获取点的信息
		var sContent = '<ul style="margin:0 0 5px 0;padding:0.2em 0">'
				+ '<li style="line-height: 26px;font-size: 15px;">'
				+ '<span style="width: 50px;display: inline-block;">id：</span>'
				+ point.stationId
				+ '</li>'
				+ '<li style="line-height: 26px;font-size: 15px;">'
				+ '<span style="width: 50px;display: inline-block;">名称：</span>'
				+ point.stationName
				+ '</li>'
				+ '<li style="line-height: 26px;font-size: 15px;"><span style="width: 50px;display: inline-block;">查看：</span><a href="'+point.address+'">详情</a></li>'
				+ '</ul>';
		var infoWindow = new BMap.InfoWindow(sContent); //创建信息窗口对象
		thisMarker.openInfoWindow(infoWindow); //图片加载完后重绘infoWindow
	}
	//创建地图
	var map = new BMap.Map("allmap");
	map.centerAndZoom(new BMap.Point(120.187914, 30.265809), 14); // 设置中心点
	map.centerAndZoom("杭州");
	map.setCurrentCity("杭州"); 
	map.addControl(new BMap.MapTypeControl());
	map.enableScrollWheelZoom(true);
</script>