<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

	<link rel="stylesheet" href="/xt/bootstrap/css/index.css">
    <link rel="stylesheet" href="/xt/bootstrap/css/bootstrap.css">
	<link rel="stylesheet" href="/xt/bootstrap/css/base.css">
  <!--   <link rel="stylesheet" href="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css"> -->
	 <!--<script src="https://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>-->
	 <!--<script src="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>-->
	<script src="/xt/bootstrap/js/jquery.js"></script>
    <script src="/xt/bootstrap/js/bootstrap.js"></script>
	<script src="/xt/bootstrap/js/index.js"></script>
	<script type="text/javascript" src="/xt/bootstrap/js/myjs.js"></script>
</head>
<body>





<div class="top">
    <div class="w">
     
        <ul class="fr">
        	<li class="fl"><a href="/xt/page/login.jsp">请登录</a>|</li>
        	<li class="fl"><a href="/xt/page/findpass.jsp">忘记密码？</a>|</li>
        	<li class="fl"><a href="/xt/page/regist.jsp">还没有账号</a>|</li>
            <li class="fl"><a href="/xt/page/news.jsp">消息</a>|</li>
            <li class="fl"><a href="/xt/page/shopinfo.jsp">我的店铺</a>|</li>
            <li class="fl"><a href="/xt/page/shopcar.jsp">购物车</a>|</li>
            <li class="fl"><a href="/xt/page/conadmin.jsp">联系我们</a>|</li>
            <li class="fl"><a href="#">加入收藏</a></li>
        </ul>
    </div>
</div>

<!--搜索-->
<div class="w clearfix">
    <div class="fl web">Shopping</div>
			<div class="seach fr ">
						<form action="">
								<div class="input-group">
									  <input type="text" class="form-control" placeholder="店名或者商品名或者商品描述" aria-describedby="basic-addon2">
									  <span class="input-group-addon" id="basic-addon2">搜索</span>
								</div>
								<br/>
								<div>
									<input type="radio" name="text">店名
									<input type="radio" name="text">商品名
								</div>
						</form>
			</div>
</div>
<!--导航-->
<div class="nav">
    <div class="w">
        <div class="fl nav_left">
            <div class="dt">商品分类</div>
            <div class="dd">
                <ul>
                    <li><a href="xt/page/loginController/text.do" class="dd_first">饮料</a></li>
                    <li><a href="#">零食</a></li>
                    <li><a href="#">水果</a></li>
                    <li><a href="#" class="dd_last">超值大礼包</a></li>
                
                </ul>
            </div>
        </div>
        
    </div>
</div>
<!--banner-->

<a href="#" class="banner">
</a>



<!--select-->
<div class="select">
    <div class="w">
        <div class="select_left fl">
			<a class="btn btn-primary" role="button" data-toggle="collapse" href="#collapseExample1" aria-expanded="true" aria-controls="collapseExample">
			  新品上市
			</a>
			<button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#collapseExample2" aria-expanded="true" aria-controls="collapseExample">
			  促销商品
			</button>
			<button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#collapseExample3" aria-expanded="true" aria-controls="collapseExample">
			热销商品
			</button>
			<button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#collapseExample4" aria-expanded="true" aria-controls="collapseExample">
			猜你喜欢
			</button>
				<!-- 新品上市 -->
				<div class="collapse" id="collapseExample1">
				  <div class="well">
				    <div class="l_top_show">
				                    <ul>
				                        <li class="fl" id="li_01">
				                            <img src="/xt/bootstrap/image/shangping.jpg" alt="">
				                            <p><a href="page/gouwu.jsp">年年有东江香辣鱼148g</a></p>
				                            <p><span class="col-red strike">￥8.00</span><span>￥5.60</span></p>
				                        </li>
				                        <li class="fl" id="li_02">
				                            <img src="/xt/bootstrap/image/shangping.jpg" alt="">
				                            <p><a href="page/gouwu.jsp">年年有东江香辣鱼148g</a></p>
				                            <p><span class="col-red strike">￥8.00</span><span>￥5.60</span></p>
				                        </li>
				                        <li class="fl" id="li_03">
				                            <img src="/xt/bootstrap/image/shangping.jpg" alt="">
				                            <p><a href="page/gouwu.jsp">年年有东江香辣鱼148g</a></p>
				                            <p><span class="col-red strike">￥8.00</span><span>￥5.60</span></p>
				                        </li>
				                        <li class="fl" id="li_04">
				                            <img src="/xt/bootstrap/image/shangping.jpg" alt="">
				                            <p><a href="page/gouwu.jsp">年年有东江香辣鱼148g</a></p>
				                            <p><span class="col-red strike">￥8.00</span><span>￥5.60</span></p>
				                        </li>
				                    </ul>
				                   
				  </div>
				</div>
				</div>
				         <!-- 促销商品 -->  
				  <div class="collapse" id="collapseExample2">
				  <div class="well">
				    <div class="l_top_show">
				                    <ul>
				                        <li class="fl" id="li_05">
				                            <img src="/xt/bootstrap/image/shangping.jpg" alt="">
				                            <p><a href="page/gouwu.jsp">2年年有东江香辣鱼148g</a></p>
				                            <p><span class="col-red strike">￥8.00</span><span>￥5.60</span></p>
				                        </li>
				                        <li class="fl" id="li_06">
				                            <img src="/xt/bootstrap/image/shangping.jpg" alt="">
				                            <p><a href="page/gouwu.jsp">年年有东江香辣鱼148g</a></p>
				                            <p><span class="col-red strike">￥8.00</span><span>￥5.60</span></p>
				                        </li>
				                        <li class="fl" id="li_07">
				                            <img src="/xt/bootstrap/image/shangping.jpg" alt="">
				                            <p><a href="page/gouwu.jsp">年年有东江香辣鱼148g</a></p>
				                            <p><span class="col-red strike">￥8.00</span><span>￥5.60</span></p>
				                        </li>
				                        <li class="fl" id="li_08">
				                            <img src="/xt/bootstrap/image/shangping.jpg" alt="">
				                            <p><a href="page/gouwu.jsp">年年有东江香辣鱼148g</a></p>
				                            <p><span class="col-red strike">￥8.00</span><span>￥5.60</span></p>
				                        </li>
				                    </ul>
				                   
				  </div>
				</div>
				</div>
				<!-- 热销商品 -->
				<div class="collapse" id="collapseExample3">
				  <div class="well">
				    <div class="l_top_show">
				                    <ul>
				                        <li class="fl" id="li_09">
				                            <img src="/xt/bootstrap/image/shangping.jpg" alt="">
				                            <p><a href="page/gouwu.jsp">3年年有东江香辣鱼148g</a></p>
				                            <p><span class="col-red strike">￥8.00</span><span>￥5.60</span></p>
				                        </li>
				                        <li class="fl" id="li_10">
				                            <img src="/xt/bootstrap/image/shangping.jpg" alt="">
				                            <p><a href="page/gouwu.jsp">年年有东江香辣鱼148g</a></p>
				                            <p><span class="col-red strike">￥8.00</span><span>￥5.60</span></p>
				                        </li>
				                        <li class="fl" id="li_11">
				                            <img src="/xt/bootstrap/image/shangping.jpg" alt="">
				                            <p><a href="page/gouwu.jsp">年年有东江香辣鱼148g</a></p>
				                            <p><span class="col-red strike">￥8.00</span><span>￥5.60</span></p>
				                        </li>
				                        <li class="fl" id="li_12">
				                            <img src="/xt/bootstrap/image/shangping.jpg" alt="">
				                            <p><a href="page/gouwu.jsp">年年有东江香辣鱼148g</a></p>
				                            <p><span class="col-red strike">￥8.00</span><span>￥5.60</span></p>
				                        </li>
				                    </ul>
				                   
				  </div>
				</div>
				</div>
				<!-- 猜你喜欢 -->
				<div class="collapse" id="collapseExample4">
				  <div class="well">
				    <div class="l_top_show">
				                    <ul>
				                        <li class="fl" id="li_13" onclick="#">
				                            <img src="/xt/bootstrap/image/shangping.jpg" alt="">
				                            <p><a href="page/gouwu.jsp">4年年有东江香辣鱼148g</a></p>
				                            <p><span class="col-red strike">￥8.00</span><span>￥5.60</span></p>
				                        </li>
				                        <li class="fl" id="li_14">
				                            <img src="/xt/bootstrap/image/shangping.jpg" alt="">
				                            <p><a href="page/gouwu.jsp">年年有东江香辣鱼148g</a></p>
				                            <p><span class="col-red strike">￥8.00</span><span>￥5.60</span></p>
				                        </li>
				                        <li class="fl" id="li_15">
				                            <img src="/xt/bootstrap/image/shangping.jpg" alt="">
				                            <p><a href="page/gouwu.jsp">年年有东江香辣鱼148g</a></p>
				                            <p><span class="col-red strike">￥8.00</span><span>￥5.60</span></p>
				                        </li>
				                        <li class="fl" id="li_16">
				                            <img src="/xt/bootstrap/image/shangping.jpg" alt="">
				                            <p><a href="page/gouwu.jsp">年年有东江香辣鱼148g</a></p>
				                            <p><span class="col-red strike">￥8.00</span><span>￥5.60</span></p>
				                        </li>
				                    </ul>
				                   
				  </div>
				</div>
				</div>         
				           
        </div>
        
        
        <div class="select_right fr">
            <div class="r_top">
                <h2 class="fl"><b class="col-red">最新</b>公告</h2>
                <span class="fr"><a href="#">More>></a></span>
            </div>
            <div class="r_bottom">
                <p><a href="#" class="col-red">【公告】宅土豆囤货季上线 全场满就送</a></p>
                <p><a href="#" class="col-red">【公告】宅土豆囤货季上线 全场满就送</a></p>
                <p><a href="#" class="col-red">【公告】宅土豆囤货季上线 全场满就送</a></p>
                <p><a href="#">【公告】宅土豆囤货季上线 全场满就送</a></p>
                <p><a href="#">【公告】宅土豆囤货季上线 全场满就送</a></p>
                <p><a href="#">【公告】宅土豆囤货季上线 全场满就送</a></p>
            </div>
        </div>
    </div>
</div>

<!--吃货点评-->
<div class="w">
    <div class="food">
        <div class="food_top">
            <img src="/xt/bootstrap/image/1.jpg" alt="">
            <span>吃货点评</span>
        </div>
        <div class="foot_boottom">
            <div class="snacks fl">
                <a href="#"><div class="djy fl"></div></a>
                <div class="evaluate fr">
                    <p id="evalute_name_01">鱼豆腐烧烤味170g</p>
                    <div class="star">
                        <span class="fl">评价：</span>
                        <ul class="fl">
                            <li class="fl">☆</li>
                            <li class="fl">☆</li>
                            <li class="fl">☆</li>
                            <li class="fl">☆</li>
                            <li class="fl">☆</li>
                        </ul>
                    </div>
                    <div class="s_e">
                        <p class="fl s_evaluate">零食点评：</p>
                        <p class="fl e_text" id="evalute_value_01">好好吃哦，没少了，下次多买点！</p>
                    </div>

                </div>

            </div>
            <div class="snacks fl">
                <a href="#"><div class="djy fl"></div></a>
                <div class="evaluate fr">
                    <p id="evalute_name_02">鱼豆腐烧烤味170g</p>
                    <div class="star">
                        <span class="fl">评价：</span>
                        <ul class="fl">
                            <li class="fl">☆</li>
                            <li class="fl">☆</li>
                            <li class="fl">☆</li>
                            <li class="fl">☆</li>
                            <li class="fl">☆</li>
                        </ul>
                    </div>
                    <div class="s_e">
                        <p class="fl s_evaluate">零食点评：</p>
                        <p class="fl e_text" id="evalute_value_02">好好吃哦，没少了，下次多买点！</p>
                    </div>

                </div>

            </div>
            <div class="snacks fl" onclick="#">
                <a href="#"><div class="djy fl"></div></a>
                <div class="evaluate fr">
                    <p id="evalute_name_03">鱼豆腐烧烤味170g</p>
                    <div class="star">
                        <span class="fl">评价：</span>
                        <ul class="fl">
                            <li class="fl">☆</li>
                            <li class="fl">☆</li>
                            <li class="fl">☆</li>
                            <li class="fl">☆</li>
                            <li class="fl">☆</li>
                        </ul>
                    </div>
                    <div class="s_e">
                        <p class="fl s_evaluate">零食点评：</p>
                        <p class="fl e_text" id="evalute_value_03">好好吃哦，没少了，下次多买点！</p>
                    </div>

                </div>

            </div>
            <div class="snacks fl">
                <a href="#"><div class="djy fl"></div></a>
                <div class="evaluate fr">
                    <p id="evalute_name_04">鱼豆腐烧烤味170g</a></p>
                    <div class="star">
                        <span class="fl">评价：</span>
                        <ul class="fl">
                            <li class="fl">☆</li>
                            <li class="fl">☆</li>
                            <li class="fl">☆</li>
                            <li class="fl">☆</li>
                            <li class="fl">☆</li>
                        </ul>
                    </div>
                    <div class="s_e">
                        <p class="fl s_evaluate">零食点评：</p>
                        <p class="fl e_text" id="evalute_value_04">好好吃哦，没少了，下次多买点！</p>
                    </div>

                </div>

            </div>
            <div class="snacks fl">
                <a href="#"><div class="djy fl"></div></a>
                <div class="evaluate fr">
                    <p id="evalute_name_05">鱼豆腐烧烤味170g</a></p>
                    <div class="star">
                        <span class="fl">评价：</span>
                        <ul class="fl">
                            <li class="fl">☆</li>
                            <li class="fl">☆</li>
                            <li class="fl">☆</li>
                            <li class="fl">☆</li>
                            <li class="fl">☆</li>
                        </ul>
                    </div>
                    <div class="s_e">
                        <p class="fl s_evaluate">零食点评：</p>
                        <p class="fl e_text" id="evalute_value_05">好好吃哦，没少了，下次多买点！</p>
                    </div>

                </div>

            </div>
            <div class="snacks fl" >
                <a href="#"><div class="djy fl"></div></a>
                <div class="evaluate fr">
                    <p id="evalute_name_06">鱼豆腐烧烤味170g</a></p>
                    <div class="star">
                        <span class="fl">评价：</span>
                        <ul class="fl">
                            <li class="fl">☆</li>
                            <li class="fl">☆</li>
                            <li class="fl">☆</li>
                            <li class="fl">☆</li>
                            <li class="fl">☆</li>
                        </ul>
                    </div>
                    <div class="s_e">
                        <p class="fl s_evaluate">零食点评：</p>
                        <p class="fl e_text" id="evalute_value_06">好好吃哦，没少了，下次多买点！</p>
                    </div>

                </div>

            </div>
        </div>
    </div>
</div>
<!--品牌推荐-->
<div class="w">
    <div class="brand">
        <div class="food_top">
            <img src="/xt/bootstrap/image/1.jpg" alt="">
            <span>品牌推荐</span>
        </div>
        <div class="p_bottom">
            <div class="fruit fl">
                <p>干果炒货</p>
                <img src="/xt/bootstrap/image/hetao.jpg" alt="">
                <div class="qiaqia">
                    <ul>
                        <li class="fl"><a href="#"><img src="/xt/bootstrap/image/qiaqia.jpg" alt=""></a></li>
                        <li class="fl"><a href="#"><img src="/xt/bootstrap/image/qiaqia.jpg" alt=""></a></li>
                        <li class="fl"><a href="#"><img src="/xt/bootstrap/image/qiaqia.jpg" alt=""></a></li>
                        <li class="fl"><a href="#"><img src="/xt/bootstrap/image/qiaqia.jpg" alt=""></a></li>
                        <li class="fl"><a href="#"><img src="/xt/bootstrap/image/qiaqia.jpg" alt=""></a></li>
                        <li class="fl"><a href="#"><img src="/xt/bootstrap/image/qiaqia.jpg" alt=""></a></li>
                    </ul>
                </div>
            </div>
            <div class="fruit fl">
                <p>干果炒货</p>
                <img src="/xt/bootstrap/image/hetao.jpg" alt="">
                <div class="qiaqia">
                    <ul>
                        <li class="fl"><a href="#"><img src="/xt/bootstrap/image/qiaqia.jpg" alt=""></a></li>
                        <li class="fl"><a href="#"><img src="/xt/bootstrap/image/qiaqia.jpg" alt=""></a></li>
                        <li class="fl"><a href="#"><img src="/xt/bootstrap/image/qiaqia.jpg" alt=""></a></li>
                        <li class="fl"><a href="#"><img src="/xt/bootstrap/image/qiaqia.jpg" alt=""></a></li>
                        <li class="fl"><a href="#"><img src="/xt/bootstrap/image/qiaqia.jpg" alt=""></a></li>
                        <li class="fl"><a href="#"><img src="/xt/bootstrap/image/qiaqia.jpg" alt=""></a></li>
                    </ul>
                </div>
            </div>
            <div class="fruit fl">
                <p>干果炒货</p>
                <img src="/xt/bootstrap/image/hetao.jpg" alt="">
                <div class="qiaqia">
                    <ul>
                        <li class="fl"><a href="#"><img src="/xt/bootstrap/image/qiaqia.jpg" alt=""></a></li>
                        <li class="fl"><a href="#"><img src="/xt/bootstrap/image/qiaqia.jpg" alt=""></a></li>
                        <li class="fl"><a href="#"><img src="/xt/bootstrap/image/qiaqia.jpg" alt=""></a></li>
                        <li class="fl"><a href="#"><img src="/xt/bootstrap/image/qiaqia.jpg" alt=""></a></li>
                        <li class="fl"><a href="#"><img src="/xt/bootstrap/image/qiaqia.jpg" alt=""></a></li>
                        <li class="fl"><a href="#"><img src="/xt/bootstrap/image/qiaqia.jpg" alt=""></a></li>
                    </ul>
                </div>
            </div>
            <div class="fruit fl">
                <p>干果炒货</p>
                <img src="/xt/bootstrap/image/hetao.jpg" alt="">
                <div class="qiaqia">
                    <ul>
                        <li class="fl"><a href="#"><img src="/xt/bootstrap/image/qiaqia.jpg" alt=""></a></li>
                        <li class="fl"><a href="#"><img src="/xt/bootstrap/image/qiaqia.jpg" alt=""></a></li>
                        <li class="fl"><a href="#"><img src="/xt/bootstrap/image/qiaqia.jpg" alt=""></a></li>
                        <li class="fl"><a href="#"><img src="/xt/bootstrap/image/qiaqia.jpg" alt=""></a></li>
                        <li class="fl"><a href="#"><img src="/xt/bootstrap/image/qiaqia.jpg" alt=""></a></li>
                        <li class="fl"><a href="#"><img src="/xt/bootstrap/image/qiaqia.jpg" alt=""></a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<!--友情链接-->
<div class="w">
    <div class="you clearfix">
        <div class="yq">
            <p>友情链接</p>
            <div>
                <ul>
                    <li><a href="#">零食网</a></li>
                    <li><a href="#">零食网</a></li>
                    <li><a href="#">零食网</a></li>
                    <li><a href="#">零食网</a></li>
                    <li><a href="#">零食网</a></li>
                    <li><a href="#">零食网</a></li>
                    <li><a href="#">零食网</a></li>
                    <li><a href="#">零食网</a></li>
                    <li><a href="#">零食网</a></li>
                    <li><a href="#">零食网</a></li>
                    <li><a href="#">零食网</a></li>
                    <li><a href="#">零食网</a></li>
                    <li><a href="#">零食网</a></li>
                    <li><a href="#">零食网</a></li>
                    <li><a href="#">零食网</a></li>
                    <li><a href="#">零食网</a></li>
                    <li><a href="#">零食网</a></li>
                    <li><a href="#">零食网</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>
<!--foot-->
<div class="foot">
    <div class="foot_nav">
        <div class="w">
            <ul>
                <li class="fl"><a href="#">首页</a>|</li>
                <li class="fl"><a href="#">新品</a>|</li>
                <li class="fl"><a href="#">促销</a>|</li>
                <li class="fl"><a href="#">团购</a>|</li>
                <li class="fl"><a href="#">秋冬养生</a>|</li>
                <li class="fl"><a href="#">招商加盟</a>|</li>
                <li class="fl"><a href="#">联系我们</a></li>
            </ul>
        </div>
    </div>
    <div class="w">
        <div class="add">
            <p>Copyright © 2003 - 2014 郑XXXX . All Rights Reserved　郑XXXXX 版权所有 豫ICP备045678881号</p>
            <p>地址：河南省郑州市中原区xxxxxxx 电话：0371-78878888 邮箱：123@163.com</p>
        </div>
    </div>
</div>




<!-- 填写隐藏信息 -->
<div style="display:none">
<form>
<p name="login_is" value="false"></p>
<p name="shop_have" value="false"></p>
</form>
</div>
</body>
</html>