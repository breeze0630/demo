<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="/xt/bootstrap/css/base.css">
    <link rel="stylesheet" href="/xt/bootstrap/css/index.css">
    <script src="/xt/bootstrap/js/jquery-1.11.1.min.js"></script>
    <script src="/xt/bootstrap/js/index.js"></script>
    
   
</head>
<body>
<div class="top">
    <div class="w">
        <p class="fl">欢迎光临 XX有限公司</p>
        <ul class="fr">
            <li class="fl"><a href="#">设为首页</a>|</li>
            <li class="fl"><a href="#">联系我们</a>|</li>
            <li class="fl"><a href="#">加入收藏</a></li>
        </ul>
    </div>
</div>
<!--搜索-->
<div class="w clearfix">
    <div class="fl web">SNACKS WEB</div>
<div class="seach fr ">
         <form action="">
             <div class="inp">
                 <input type="text">
                 <button></button>
             </div>
         </form>
        <form action="">
            <div class="radio">
                <input type="radio" class="text" value="" name="text" checked="checked">名称
                <input type="radio" class="text" value="" name="text">描述
                <input type="radio" class="text" value="" name="text">内容
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
                    <li><a href="#" class="dd_first">坚果炒货</a></li>
                    <li><a href="#">坚果炒货</a></li>
                    <li><a href="#">坚果炒货</a></li>
                    <li><a href="#">坚果炒货</a></li>
                    <li><a href="#">坚果炒货</a></li>
                    <li><a href="#" class="dd_last">坚果炒货</a></li>
                </ul>
            </div>
        </div>
        <div class="nav_right fr">
            <ul>
                <li class="fl shouye"><a href="#">首页</a></li>
                <li class="fl"><a href="#">新品</a></li>
                <li class="fl"><a href="#">促销</a></li>
                <li class="fl"><a href="#">团购</a></li>
                <li class="fl"><a href="#">秋冬养生</a></li>
                <li class="fl"><a href="#">招商加盟</a></li>
                <li class="fl"><a href="#">联系我们</a></li>
            </ul>
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
            <div class="l_top">
                <ul>
                    <li class="fl" id="top_1" onclick="test()">新品上市</li>
                    <li class="fl l_top_current" onclick="test()" id="top_2">促销商品</li>
                    <li class="fl" id="top_3" onclick="test()">热销商品</li>
                    <li class="fl" id="top_4" onclick="test()">猜你喜欢</li>
                </ul>
            </div>
            <div class="l_bottom">
                <div class="l_top_show">
                    <ul>
                        <li class="fl">
                            <a href="#"><img src="image/shangping.jpg" alt=""></a>
                            <p><a href="#">年年有东江香辣鱼148g</a></p>
                            <p><span class="col-red strike">￥8.00</span><span>￥5.60</span></p>
                        </li>
                        <li class="fl">
                            <a href="#"><img src="image/shangping.jpg" alt=""></a>
                            <p><a href="#">年年有东江香辣鱼148g</a></p>
                            <p><span class="col-red strike">￥8.00</span><span>￥5.60</span></p>
                        </li>
                        <li class="fl">
                            <a href="#"><img src="image/shangping.jpg" alt=""></a>
                            <p><a href="#">年年有东江香辣鱼148g</a></p>
                            <p><span class="col-red strike">￥8.00</span><span>￥5.60</span></p>
                        </li>
                        <li class="fl">
                            <a href="#"><img src="image/shangping.jpg" alt=""></a>
                            <p><a href="#">年年有东江香辣鱼148g</a></p>
                            <p><span class="col-red strike">￥8.00</span><span>￥5.60</span></p>
                        </li>
                    </ul>
                </div>
                <div class="l_top_show">
                    <ul>
                        <li class="fl">
                            <a href="#"><img src="image/shangping.jpg" alt=""></a>
                            <p><a href="#">年年有东江香辣鱼148g</a></p>
                            <p><span class="col-red strike">￥18.00</span><span>￥5.60</span></p>
                        </li>
                        <li class="fl">
                            <a href="#"><img src="image/shangping.jpg" alt=""></a>
                            <p><a href="#">年年有东江香辣鱼148g</a></p>
                            <p><span class="col-red strike">￥18.00</span><span>￥5.60</span></p>
                        </li>
                        <li class="fl">
                            <a href="#"><img src="image/shangping.jpg" alt=""></a>
                            <p><a href="#">年年有东江香辣鱼148g</a></p>
                            <p><span class="col-red strike">￥18.00</span><span>￥5.60</span></p>
                        </li>
                        <li class="fl">
                            <a href="#"><img src="image/shangping.jpg" alt=""></a>
                            <p><a href="#">年年有东江香辣鱼148g</a></p>
                            <p><span class="col-red strike">￥18.00</span><span>￥5.60</span></p>
                        </li>
                    </ul>
                </div>
                <div>
                    <ul>
                        <li class="fl">
                            <a href="#"><img src="image/shangping.jpg" alt=""></a>
                            <p><a href="#">年年有东江香辣鱼148g</a></p>
                            <p><span class="col-red strike">￥28.00</span><span>￥5.60</span></p>
                        </li>
                        <li class="fl">
                            <a href="#"><img src="image/shangping.jpg" alt=""></a>
                            <p><a href="#">年年有东江香辣鱼148g</a></p>
                            <p><span class="col-red strike">￥28.00</span><span>￥5.60</span></p>
                        </li>
                        <li class="fl">
                            <a href="#"><img src="image/shangping.jpg" alt=""></a>
                            <p><a href="#">年年有东江香辣鱼148g</a></p>
                            <p><span class="col-red strike">￥28.00</span><span>￥5.60</span></p>
                        </li>
                        <li class="fl">
                            <a href="#"><img src="image/shangping.jpg" alt=""></a>
                            <p><a href="#">年年有东江香辣鱼148g</a></p>
                            <p><span class="col-red strike">￥28.00</span><span>￥5.60</span></p>
                        </li>
                    </ul>
                </div>
                <div>
                    <ul>
                        <li class="fl">
                            <a href="#"><img src="image/shangping.jpg" alt=""></a>
                            <p><a href="#">年年有东江香辣鱼148g</a></p>
                            <p><span class="col-red strike">￥38.00</span><span>￥5.60</span></p>
                        </li>
                        <li class="fl">
                            <a href="#"><img src="image/shangping.jpg" alt=""></a>
                            <p><a href="#">年年有东江香辣鱼148g</a></p>
                            <p><span class="col-red strike">￥38.00</span><span>￥5.60</span></p>
                        </li>
                        <li class="fl">
                            <a href="#"><img src="image/shangping.jpg" alt=""></a>
                            <p><a href="#">年年有东江香辣鱼148g</a></p>
                            <p><span class="col-red strike">￥38.00</span><span>￥5.60</span></p>
                        </li>
                        <li class="fl">
                            <a href="#"><img src="image/shangping.jpg" alt=""></a>
                            <p><a href="#">年年有东江香辣鱼148g</a></p>
                            <p><span class="col-red strike">￥38.00</span><span>￥5.60</span></p>
                        </li>
                    </ul>
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
            <img src="image/1.jpg" alt="">
            <span>吃货点评</span>
        </div>
        <div class="foot_boottom">
            <div class="snacks fl">
                <a href="#"><div class="djy fl"></div></a>
                <div class="evaluate fr">
                    <p><a href="#">鱼豆腐烧烤味170g</a></p>
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
                        <p class="fl e_text">好好吃哦，没少了，下次多买点！</p>
                    </div>

                </div>

            </div>
            <div class="snacks fl">
                <a href="#"><div class="djy fl"></div></a>
                <div class="evaluate fr">
                    <p><a href="#">鱼豆腐烧烤味170g</a></p>
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
                        <p class="fl e_text">好好吃哦，没少了，下次多买点！</p>
                    </div>

                </div>

            </div>
            <div class="snacks fl">
                <a href="#"><div class="djy fl"></div></a>
                <div class="evaluate fr">
                    <p><a href="#">鱼豆腐烧烤味170g</a></p>
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
                        <p class="fl e_text">好好吃哦，没少了，下次多买点！</p>
                    </div>

                </div>

            </div>
            <div class="snacks fl">
                <a href="#"><div class="djy fl"></div></a>
                <div class="evaluate fr">
                    <p><a href="#">鱼豆腐烧烤味170g</a></p>
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
                        <p class="fl e_text">好好吃哦，没少了，下次多买点！</p>
                    </div>

                </div>

            </div>
            <div class="snacks fl">
                <a href="#"><div class="djy fl"></div></a>
                <div class="evaluate fr">
                    <p><a href="#">鱼豆腐烧烤味170g</a></p>
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
                        <p class="fl e_text">好好吃哦，没少了，下次多买点！</p>
                    </div>

                </div>

            </div>
            <div class="snacks fl">
                <a href="#"><div class="djy fl"></div></a>
                <div class="evaluate fr">
                    <p><a href="#">鱼豆腐烧烤味170g</a></p>
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
                        <p class="fl e_text">好好吃哦，没少了，下次多买点！</p>
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
            <img src="image/1.jpg" alt="">
            <span>品牌推荐</span>
        </div>
        <div class="p_bottom">
            <div class="fruit fl">
                <p>干果炒货</p>
                <img src="image/hetao.jpg" alt="">
                <div class="qiaqia">
                    <ul>
                        <li class="fl"><a href="#"><img src="image/qiaqia.jpg" alt=""></a></li>
                        <li class="fl"><a href="#"><img src="image/qiaqia.jpg" alt=""></a></li>
                        <li class="fl"><a href="#"><img src="image/qiaqia.jpg" alt=""></a></li>
                        <li class="fl"><a href="#"><img src="image/qiaqia.jpg" alt=""></a></li>
                        <li class="fl"><a href="#"><img src="image/qiaqia.jpg" alt=""></a></li>
                        <li class="fl"><a href="#"><img src="image/qiaqia.jpg" alt=""></a></li>
                    </ul>
                </div>
            </div>
            <div class="fruit fl">
                <p>干果炒货</p>
                <img src="image/hetao.jpg" alt="">
                <div class="qiaqia">
                    <ul>
                        <li class="fl"><a href="#"><img src="image/qiaqia.jpg" alt=""></a></li>
                        <li class="fl"><a href="#"><img src="image/qiaqia.jpg" alt=""></a></li>
                        <li class="fl"><a href="#"><img src="image/qiaqia.jpg" alt=""></a></li>
                        <li class="fl"><a href="#"><img src="image/qiaqia.jpg" alt=""></a></li>
                        <li class="fl"><a href="#"><img src="image/qiaqia.jpg" alt=""></a></li>
                        <li class="fl"><a href="#"><img src="image/qiaqia.jpg" alt=""></a></li>
                    </ul>
                </div>
            </div>
            <div class="fruit fl">
                <p>干果炒货</p>
                <img src="image/hetao.jpg" alt="">
                <div class="qiaqia">
                    <ul>
                        <li class="fl"><a href="#"><img src="image/qiaqia.jpg" alt=""></a></li>
                        <li class="fl"><a href="#"><img src="image/qiaqia.jpg" alt=""></a></li>
                        <li class="fl"><a href="#"><img src="image/qiaqia.jpg" alt=""></a></li>
                        <li class="fl"><a href="#"><img src="image/qiaqia.jpg" alt=""></a></li>
                        <li class="fl"><a href="#"><img src="image/qiaqia.jpg" alt=""></a></li>
                        <li class="fl"><a href="#"><img src="image/qiaqia.jpg" alt=""></a></li>
                    </ul>
                </div>
            </div>
            <div class="fruit fl">
                <p>干果炒货</p>
                <img src="image/hetao.jpg" alt="">
                <div class="qiaqia">
                    <ul>
                        <li class="fl"><a href="#"><img src="image/qiaqia.jpg" alt=""></a></li>
                        <li class="fl"><a href="#"><img src="image/qiaqia.jpg" alt=""></a></li>
                        <li class="fl"><a href="#"><img src="image/qiaqia.jpg" alt=""></a></li>
                        <li class="fl"><a href="#"><img src="image/qiaqia.jpg" alt=""></a></li>
                        <li class="fl"><a href="#"><img src="image/qiaqia.jpg" alt=""></a></li>
                        <li class="fl"><a href="#"><img src="image/qiaqia.jpg" alt=""></a></li>
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
</body>
</html>