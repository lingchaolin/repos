jQuery(function($){
	$("#submitbutton").click(function() {
		if($("#username").val()==""){
			alert("用户名不能为空");
			return false;
		}else if($("#userpwd").val()==""){
			alert("密码不能为空");
			return false;
		}
	});
});
