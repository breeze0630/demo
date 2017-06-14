$(function(){
    /*新品上市*/
    var timer=null;
    $(".l_top li").mouseenter(function(){
        var index=$(this).index();
        var $this=$(this);
        timer=setTimeout(function () {
            $this.addClass("l_top_current").siblings(".fl").removeClass("l_top_current");
            $(".l_bottom div").eq(index).addClass("l_top_show").siblings("div").removeClass("l_top_show");
        },300);
    }).mouseleave(function () {
        clearTimeout(timer);
    })
    
    /*star*/
    var star_block="★";
    var star_none="☆";
    $(".star ul li").on("mouseenter",function(){
        $(this).text(star_block).prevAll().text(star_block).end().nextAll().text(star_none);
    })
    $(".star ul li").on("click",function(){
        $(this).addClass("clicked").siblings().removeClass("clicked");
    })
    $(".star ul").on("mouseleave",function(){
        $("ul li").text(star_none);
        $(".clicked").text(star_block).prevAll().text(star_block).end().nextAll().text(star_none);
    })
})

function test(){
	$(function(){
		this.class="fl  l_top_current";
		for(var i=1;i<5;i++){
			if(this.id!=("top_"+i)){
				$(".top_"+i).class="fl";
				
			}
			
		}
		
	})
	
	
}
