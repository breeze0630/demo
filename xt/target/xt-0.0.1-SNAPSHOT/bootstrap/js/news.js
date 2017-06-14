$(document).ready(function(){
	
	init();
	
});

function init(){
	
	
}

function answer(i){
	var username = $("#hidden_user").val;
	var to=null;
	var from=null;
	if(document.getElementById("to_name_"+i).val==username){
		to=document.getElementById("from_name_"+i).val;
		from=username;
	}else{
		to=document.getElementById("to_name_"+i).val;
		from=document.getElementById("from_name_"+i).val;
	}
	$("#modal-f").val(from);
	$("#modal-t").val(to);
	
}

function remove(i){
	var id = $("#messageid_"+i).val;
	$.ajax({url:"/xt/news/remove.do",data:'json'});
}

function inspect(){
	$("#modal-f").attr("value",$("#from_name_"+i).val());
	$("#modal-t").attr("value",$("#to_name_"+i).val());
	$("#modal-message-show").attr("value",$("#message_"+i).val());
	document.getElementById("answer_sub").style.visibility="hidden";
}