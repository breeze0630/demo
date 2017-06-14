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
	
});