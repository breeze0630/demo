$().ready(function(){
	$("#regist_sub").unbind;
	$("#regist_sub").bind("click",function(){
		$.ajax({url:"/xt/regist.do",method:'post',data:$("#regist_form").serialize(),function(result){
			
			
		}});
		
		
	});
	
	
});