<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
	<script type="text/javascript" src="js/jquery-1.8.1.min.js"></script>
	<script tepe="text/javascript">
	     /* var httpRequest;
	 	  function checkAccount(){
	 		alert($("#name").val());
	 		var name=$("#name").val();
	 		httpRequest=new XMLHttpRequest();
	 		httpRequest.open("get","serone?name="+name,true);
	 		httpRequest.onreadystatechange=callback;
	 		httpRequest.send(null);
	 	}   
	 	function callback(){
 			if(httpRequest.readyState==4&&httpRequest.status==200){
 				var result=httpRequest.responseText;
 				alert(result);
 			}
 		}  */
 	 	 /* function checkAccount(){
	 		var ds=$("#useform").serialize();
	 		alert(ds);
			$.ajax({
				url:"serone",
				data:ds,
				dataType:"text",
					alert("ok");
				success:function(data){
					//alert(data);
				}
			});   */
/* function checkAccount(){
		 $.get(
				"serone",
				{"name":"zhangsan"},
				function(obj){
					//eval
					alert(obj);
				} ,
				"text"
			); 
		//注意区分ajax方法
			//get方法的参数：路径,提交的参数,回调函数,返回数据的类型
			//如果返回类型设置为json，jquery自动将json数据转为js对象（回调函数的data不再是json字符串，而是js对象）
 }   */
function checkAccount(){
	 	var obj = '{"name":"zhangsan","password":20}';
	 	alert(obj);
		$.post(
				"serone",
				{"userjson":obj},
				function(data){
					alert(data);
				}
		);		 
 }  
	</script>
</head>
<body>
	<form action="" id="useform">
		name<input type="text" id="name" name="name"  onchange="checkAccount()"/>
		<span id="result"></span>
	</form>
</body>
</html>