$(document).ready(function(){
	
	document.getElementById("tips").style.visibility="hidden";
	
	
	
	$("#login_sub").unbind();
	$("#login_sub").bind("click",function(){
		
		//$("#login_form").sumbit();
		
		$.ajax({url:"/xt/account/login.do",
			type:"POST",
			data:$("#login_form").serialize(),
			dataType:'json',
			success:function(result,textStatus){
				
				if(1==result.webDto.status){
					$("#tips").style.visibility="visible";
				}else{
					document.location("/xt/index.jsp");
				}
		}});
		
			
		
	});
	
	
});

function init(){
	
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