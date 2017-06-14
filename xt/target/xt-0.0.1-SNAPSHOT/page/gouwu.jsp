<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/xt/bootstrap/css/ace.min.css">
<link rel="stylesheet" href="/xt/bootstrap/css/index.css">
<link rel="stylesheet" href="/xt/bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="/xt/bootstrap/css/base.css">
<script src="/xt/bootstrap/js/jquery.js"></script>
<script src="/xt/bootstrap/js/bootstrap.js"></script>
<script src="/xt/bootstrap/js/ace.min.js"></script>
<script src="/xt/bootstrap/js/gouwu.js"></script>
 

</head>
<body>

<div class="top">
    <div class="w">
        <ul class="fr">
        	<li class="fl"><a href="/xt/index.jsp">首页</a>|</li>
        	<li class="fl"><a href="/xt/page/login.jsp">用户</a>|</li>
        	<li class="fl"><a href="#zhuxiao action">注销</a>|</li>
            <li class="fl"><a href="/xt/page/news.jsp">消息</a>|</li>
            <li class="fl"><a href="/xt/page/shopinfo.jsp">我的店铺</a>|</li>
            <li class="fl"><a href="/xt/page/shopcar.jsp">购物车</a>|</li>
            <li class="fl"><a href="/xt/page/conadmin.jsp">联系我们</a>|</li>
            <li class="fl"><a href="#">加入收藏</a></li>
        </ul>
    </div>
</div>
<div style="margin-top:20px;align:center;padding-left:150px;padding-right:150px">
	<!-- 左半边显示图片 -->
	<div class="fl" style="width:300px;height:300px">
		<img alt="正在加载……" src="/xt/bootstrap/image/banner.jpg" style="width:500px;height:300px">
	</div>
	<!-- 右半边显示信息 -->
	<div class="fr" style="width:400px;height:300px">
		<div style="width:400px;height:100px"><h2>商品简介</h2></div>
		<div style="width:400px;height:150px;margin-top:100px;">
			<h5 style="width:80px;height:30px">商品数量：</h5>
			<input style="width:30px;height:30px;margin-left:00px" class="min" type="button" value="-" />
			<input style="width:50px;text-align:center" name="" type="text" value="1" />
			<input style="width:30px;height:30px"  class="add" type="button" value="+"/>
			 <button type="button" class="btn btn-default" style="margin-left:50px">加入购物车</button>
			 <button type="button" class="btn btn-default" style="margin-left:30px">立即购买</button>
		</div>
	</div>
</div>
<!-- 下方买家评论 -->
<div style="margin-top:20px;align:center;padding-left:150px;padding-right:150px">
	<div class="col-xs-12">
		<div class="table-responsive">
			<table id="sample-table-1" class="table table-striped table-bordered table-hover">...</table>
		</div>
	</div>
</div>
</body>
</html>