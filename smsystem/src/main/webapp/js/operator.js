jQuery(function($){
	$("#submitbutton").click(function() {
		
		/*alert("123");

		var s=$("#addoperatorform").serialize();
		alert(s);*/
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
		}/*else{
			alert("??");
			var s="username="+$("#username").val();
			$.ajax({
				url:"ceckUsername",
				data:s,
				dataType="text",
				success:function(data){
					alert(data);
				}
			});
			return false;
		}*/
	});
});
