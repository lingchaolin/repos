jQuery(function($){
	$("[name=tomodify]").click(function() {
		$("#operatorid").val($(this).parent().parent().find("td:eq(1)").html());
		$("#tomodify").submit();
	});
	$("#fordelete").click(function() {
		var selt=$("[name=operatorselectid]:checked").length;
		if(selt==0){
			alert("请选中要删除的账号");
			return false;
		}
		if(window.confirm("确定删除选定操作员账号？")){
			if(selt==1){
				$("#tomodify").attr("action","deleteOperator");
				$("#tomodify").submit();
			}else if(selt>1){
				$("#tomodify").attr("action","deleteOperators");
				$("#tomodify").submit();
			}
		}
	});
	
	
});
