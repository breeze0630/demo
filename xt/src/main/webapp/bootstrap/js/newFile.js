$(document).ready(function(){
	$("#btn").unbind;
	$("#btn").bind("click",function(){
		$.post("/xt/loginController/test.do",function(){});
	});
	
	
	
	
	var grid_data = 
	[ 
		{fromName:"Desktop",toName:"Computer",messageTime:"2007-12-03",messageStatus:"Yes",messageType:"系统消息", message:"Tomcat v9.0 Server at localhost [Apache Tomcat] C:"},
		{fromName:"Desktop",toName:"Computer",messageTime:"2007-12-03",messageStatus:"Yes",messageType:"系统消息", message:"Tomcat v9.0 Server at localhost [Apache Tomcat] C:"},
		{fromName:"Desktop",toName:"Computer",messageTime:"2007-12-03",messageStatus:"Yes",messageType:"系统消息", message:"Tomcat v9.0 Server at localhost [Apache Tomcat] C:"},
		{fromName:"Desktop",toName:"Computer",messageTime:"2007-12-03",messageStatus:"Yes",messageType:"系统消息", message:"Tomcat v9.0 Server at localhost [Apache Tomcat] C:"},
		{fromName:"Desktop",toName:"Computer",messageTime:"2007-12-03",messageStatus:"Yes",messageType:"系统消息", message:"Tomcat v9.0 Server at localhost [Apache Tomcat] C:"},
		{fromName:"Desktop",toName:"Computer",messageTime:"2007-12-03",messageStatus:"Yes",messageType:"系统消息", message:"Tomcat v9.0 Server at localhost [Apache Tomcat] C:"},
		{fromName:"Desktop",toName:"Computer",messageTime:"2007-12-03",messageStatus:"Yes",messageType:"系统消息", message:"Tomcat v9.0 Server at localhost [Apache Tomcat] C:"},
		{fromName:"Desktop",toName:"Computer",messageTime:"2007-12-03",messageStatus:"Yes",messageType:"系统消息", message:"Tomcat v9.0 Server at localhost [Apache Tomcat] C:"},
		{fromName:"Desktop",toName:"Computer",messageTime:"2007-12-03",messageStatus:"Yes",messageType:"系统消息", message:"Tomcat v9.0 Server at localhost [Apache Tomcat] C:"},
		{fromName:"Desktop",toName:"Computer",messageTime:"2007-12-03",messageStatus:"Yes",messageType:"系统消息", message:"Tomcat v9.0 Server at localhost [Apache Tomcat] C:"},
		{fromName:"Desktop",toName:"Computer",messageTime:"2007-12-03",messageStatus:"Yes",messageType:"系统消息", message:"Tomcat v9.0 Server at localhost [Apache Tomcat] C:"},
		{fromName:"Desktop",toName:"Computer",messageTime:"2007-12-03",messageStatus:"Yes",messageType:"系统消息", message:"Tomcat v9.0 Server at localhost [Apache Tomcat] C:"},
		{fromName:"Desktop",toName:"Computer",messageTime:"2007-12-03",messageStatus:"Yes",messageType:"系统消息", message:"Tomcat v9.0 Server at localhost [Apache Tomcat] C:"},
		{fromName:"Desktop",toName:"Computer",messageTime:"2007-12-03",messageStatus:"Yes",messageType:"系统消息", message:"Tomcat v9.0 Server at localhost [Apache Tomcat] C:"},
		{fromName:"Desktop",toName:"Computer",messageTime:"2007-12-03",messageStatus:"Yes",messageType:"系统消息", message:"Tomcat v9.0 Server at localhost [Apache Tomcat] C:"},
		{fromName:"Desktop",toName:"Computer",messageTime:"2007-12-03",messageStatus:"Yes",messageType:"系统消息", message:"Tomcat v9.0 Server at localhost [Apache Tomcat] C:"},
		{fromName:"Desktop",toName:"Computer",messageTime:"2007-12-03",messageStatus:"Yes",messageType:"系统消息", message:"Tomcat v9.0 Server at localhost [Apache Tomcat] C:"},
		{fromName:"Desktop",toName:"Computer",messageTime:"2007-12-03",messageStatus:"Yes",messageType:"系统消息", message:"Tomcat v9.0 Server at localhost [Apache Tomcat] C:"},
		{fromName:"Desktop",toName:"Computer",messageTime:"2007-12-03",messageStatus:"Yes",messageType:"系统消息", message:"Tomcat v9.0 Server at localhost [Apache Tomcat] C:"},
		{fromName:"Desktop",toName:"Computer",messageTime:"2007-12-03",messageStatus:"Yes",messageType:"系统消息", message:"Tomcat v9.0 Server at localhost [Apache Tomcat] C:"},
		{fromName:"Desktop",toName:"Computer",messageTime:"2007-12-03",messageStatus:"Yes",messageType:"系统消息", message:"Tomcat v9.0 Server at localhost [Apache Tomcat] C:"},
		{fromName:"Desktop",toName:"Computer",messageTime:"2007-12-03",messageStatus:"Yes",messageType:"系统消息", message:"Tomcat v9.0 Server at localhost [Apache Tomcat] C:"},
		{fromName:"Desktop",toName:"Computer",messageTime:"2007-12-03",messageStatus:"Yes",messageType:"系统消息", message:"Tomcat v9.0 Server at localhost [Apache Tomcat] C:"},
		{fromName:"Desktop",toName:"Computer",messageTime:"2007-12-03",messageStatus:"Yes",messageType:"系统消息", message:"Tomcat v9.0 Server at localhost [Apache Tomcat] C:"},
		{fromName:"Desktop",toName:"Computer",messageTime:"2007-12-03",messageStatus:"Yes",messageType:"系统消息", message:"Tomcat v9.0 Server at localhost [Apache Tomcat] C:"},
		{fromName:"Desktop",toName:"Computer",messageTime:"2007-12-03",messageStatus:"Yes",messageType:"系统消息", message:"Tomcat v9.0 Server at localhost [Apache Tomcat] C:"},
		{fromName:"Desktop",toName:"Computer",messageTime:"2007-12-03",messageStatus:"Yes",messageType:"系统消息", message:"Tomcat v9.0 Server at localhost [Apache Tomcat] C:"},
		{fromName:"Desktop",toName:"Computer",messageTime:"2007-12-03",messageStatus:"Yes",messageType:"系统消息", message:"Tomcat v9.0 Server at localhost [Apache Tomcat] C:"},
		{fromName:"Desktop",toName:"Computer",messageTime:"2007-12-03",messageStatus:"Yes",messageType:"系统消息", message:"Tomcat v9.0 Server at localhost [Apache Tomcat] C:"},
//		{id:"2",name:"Laptop",note:"Long text ",stock:"Yes",ship:"InTime",sdate:"2007-12-03"},
//		{id:"3",name:"LCD Monitor",note:"note3",stock:"Yes",ship:"TNT",sdate:"2007-12-03"},
//		{id:"4",name:"Speakers",note:"note",stock:"No",ship:"ARAMEX",sdate:"2007-12-03"},
//		{id:"5",name:"Laser Printer",note:"note2",stock:"Yes",ship:"FedEx",sdate:"2007-12-03"},
//		{id:"6",name:"Play Station",note:"note3",stock:"No", ship:"FedEx",sdate:"2007-12-03"},
//		{id:"7",name:"Mobile Telephone",note:"note",stock:"Yes",ship:"ARAMEX",sdate:"2007-12-03"},
//		{id:"8",name:"Server",note:"note2",stock:"Yes",ship:"TNT",sdate:"2007-12-03"},
//		{id:"9",name:"Matrix Printer",note:"note3",stock:"No", ship:"FedEx",sdate:"2007-12-03"},
//		{id:"10",name:"Desktop Computer",note:"note",stock:"Yes",ship:"FedEx", sdate:"2007-12-03"},
//		{id:"11",name:"Laptop",note:"Long text ",stock:"Yes",ship:"InTime",sdate:"2007-12-03"},
//		{id:"12",name:"LCD Monitor",note:"note3",stock:"Yes",ship:"TNT",sdate:"2007-12-03"},
//		{id:"13",name:"Speakers",note:"note",stock:"No",ship:"ARAMEX",sdate:"2007-12-03"},
//		{id:"14",name:"Laser Printer",note:"note2",stock:"Yes",ship:"FedEx",sdate:"2007-12-03"},
//		{id:"15",name:"Play Station",note:"note3",stock:"No", ship:"FedEx",sdate:"2007-12-03"},
//		{id:"16",name:"Mobile Telephone",note:"note",stock:"Yes",ship:"ARAMEX",sdate:"2007-12-03"},
//		{id:"17",name:"Server",note:"note2",stock:"Yes",ship:"TNT",sdate:"2007-12-03"},
//		{id:"18",name:"Matrix Printer",note:"note3",stock:"No", ship:"FedEx",sdate:"2007-12-03"},
//		{id:"19",name:"Matrix Printer",note:"note3",stock:"No", ship:"FedEx",sdate:"2007-12-03"},
//		{id:"20",name:"Desktop Computer",note:"note",stock:"Yes",ship:"FedEx", sdate:"2007-12-03"},
//		{id:"21",name:"Laptop",note:"Long text ",stock:"Yes",ship:"InTime",sdate:"2007-12-03"},
//		{id:"22",name:"LCD Monitor",note:"note3",stock:"Yes",ship:"TNT",sdate:"2007-12-03"},
//		{id:"23",name:"Speakers",note:"note",stock:"No",ship:"ARAMEX",sdate:"2007-12-03"}
	];	
	
	var grid_selector = "#grid-table";
	jQuery(function($) {
	$("#grid-table").jqGrid({
		//direction: "rtl",
		
		data: grid_data,
		datatype: "local",
		height: 400,
		colNames:['发信人','收信人', '发送时间','是否已读','消息类型','消息内容'],
		colModel:[
			
			{name:'fromName', width:90, sorttype:"int", editable: true},
			{name:'toName',width:90, editable:true, sorttype:"date"},
			{name:'messageTime', width:90,editable: true,editoptions:{size:"20",maxlength:"30"}},
			{name:'messageStatus', width:70, editable: true,edittype:"checkbox",editoptions: {value:"Yes:No"}},
			{name:'messageType', width:90, editable: true,edittype:"select",editoptions:{value:"FE:FedEx;IN:InTime;TN:TNT;AR:ARAMEX"}},
			{name:'message', width:150, sortable:false,editable: true,edittype:"textarea", editoptions:{rows:"2",cols:"10"}} 
		], 
		subGrid:true,
		subGridRowExpanded:function(subgrid_id,row_id){
			$("#" + subgrid_id).html("<table id='"+subgrid_id+"'class='scroll'></table><div id='"+subgrid_id+"_pgr' class='scroll'></div>");
			
		},
		viewrecords : true,
		rowNum:10,
		rowList:[10,20,30],
		
		altRows: true,
		//toppager: true,
		
		multiselect: true,
		//multikey: "ctrlKey",
        multiboxonly: true,

//		loadComplete : function() {
//			var table = this;
//			setTimeout(function(){
//				styleCheckbox(table);
//				
//				updateActionIcons(table);
//				updatePagerIcons(table);
//				enableTooltips(table);
//			}, 0);
//		},

		//editurl: $path_base+"/dummy.html",//nothing is saved
		caption: "我的消息",


		autowidth: true

	});
	
	});
});

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