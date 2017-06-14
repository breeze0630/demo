$(document).ready(function(){
	$(".add").click(function() {
		         // $(this).prev() 就是当前元素的前一个元素，即 text_box
		         $(this).prev().val(parseInt($(this).prev().val()) + 1);
		         setTotal();
		 });
		   
		 $(".min").click(function() {
		         // $(this).next() 就是当前元素的下一个元素，即 text_box
		 		if($(this).next().val()<=0){
		 			$(this).next().val(0);
		 		}else{
		 			$(this).next().val(parseInt($(this).next().val()) - 1);
		 			
		 		}
		         setTotal();
		 });
		 jQuery(function($) {
				$("#grid-table").jqGrid({
					//direction: "rtl",
					
					data: grid_data,
					datatype: "local",
					subGrid:true,
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

					viewrecords : true,
					rowNum:10,
					rowList:[10,20,30],
					
					altRows: true,
					//toppager: true,
					
					multiselect: true,
					//multikey: "ctrlKey",
			        multiboxonly: true,

//					loadComplete : function() {
//						var table = this;
//						setTimeout(function(){
//							styleCheckbox(table);
//							
//							updateActionIcons(table);
//							updatePagerIcons(table);
//							enableTooltips(table);
//						}, 0);
//					},

					//editurl: $path_base+"/dummy.html",//nothing is saved
					caption: "我的购物车",


					autowidth: true

				});
		 });		
});