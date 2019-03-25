jQuery(function($){
	$("#submitbutton").click(function() {
		if($("#operatorname").val()==""){
			alert("操作员姓名不能为空");
			return false;
		}else if($("#username").val()==""){
			alert("用户名不能为空");
			return false;
		}else if($("#userpwd").val()==""){
			alert("密码不能为空");
			return false;
		}else if($("#userpwd").val() != $("#cpwd").val()){
			alert($("#userpwd").val());
			alert($("#cpwd").val());
			alert("两次密码不一致!");
			return false;
		}
	});
});

/*
$(document).ready(function(){
	  // 在这里写你的代码...
	});
	
可以简写成
jQuery(function(){ });

（function($){….}）（jQuery）
第一个括号表示定义了一个匿名函数，然后第二个函数表示为该函数传递的参数，整个结合起来意思就是，
定义了一个匿名函数，然后又调用该函数，该函数的实参为jQuery。


*/