$(document).ready(function(){
	
	init();
	
	$("#answer_sub").unbind();
	$("#answer_sub").bind("click",function(){
		
		$.post(getRootPath()+"/news/query.do",$("model_form").serialize(),function(){
			
		});
		
	});
	
});

function init(){
	$.post("/xt/news/query.do",{userName:'tom',opea:'41'},function(){
		
	});
	
	
}

function answer(i){
	var username = $("#hidden_user").val;
	var to=null;
	var from=null;
	if(document.getElementById("to_name_"+i).val() == username){
		to=document.getElementById("from_name_"+i).val();
		from=username;
	}else{
		to=document.getElementById("to_name_"+i).val();
		from=document.getElementById("from_name_"+i).val();
	}
	$("#modal-f").val(from);
	$("#modal-t").val(to);
	
}

function remove(i){
	var id = $("#messageid_"+i).val();
	$.ajax({url:"/xt/news/remove.do",data:'json'});
}

function inspect(){
	$("#modal-f").attr("value",$("#from_name_"+i).val());
	$("#modal-t").attr("value",$("#to_name_"+i).val());
	$("#modal-message-show").attr("value",$("#message_"+i).val());
	document.getElementById("answer_sub").style.visibility="hidden";
}

/**
 * 获取绝对路径
 */
function getRootPath(){
    // 获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
    var curWwwPath=window.document.location.href;
    // 获取主机地址之后的目录，如： uimcardprj/meun.jsp
    var pathName=window.document.location.pathname;
    var pos=curWwwPath.indexOf(pathName);
    // 获取主机地址，如： http://localhost:8083
    var localhostPaht=curWwwPath.substring(0,pos);
    // 获取带"/"的项目名，如：/uimcardprj
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
    return(localhostPaht+projectName);
}