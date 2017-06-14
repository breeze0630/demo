<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="xt.lb.dto.WebDto" %>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的消息</title>

<link rel="stylesheet" href="/xt/bootstrap/css/index.css">
<link rel="stylesheet" href="/xt/bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="/xt/bootstrap/css/base.css">
<script src="/xt/bootstrap/js/jquery.js"></script>
<script src="/xt/bootstrap/js/bootstrap.js"></script>
<script src="/xt/bootstrap/js/shopcar.js"></script>


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
            <li class="fl"><a href="/xt/page/shopcar.jsp">购物车</a></li>
        </ul>
    </div>
</div>
<!-- 表格显示 -->
<div >
<table class="table">
  <caption><h1>购物车</h1></caption>
  <thead>
   
  </thead>
  <tbody>
  
  
  <c:forEach var="i" begin="0" end="${webDto.carList.length() }">
  <!-- 每个商店的商品放在同一个tr中 ,每个td代表一种商品 -->
  <p style="display:none;" id="messageid_${i}">${webDto.news[i].messageId}</p>
  		<td>商店名： ${webDto.carList[i].carName} </td>
  		<!-- 店铺id -->
		<input style="visibility:hidden" id="shopid_${i }" value="${webDto.carList[i][j].shopId }"/>
  	
  	<input type="checkbox" id="check_${i }"/><tr >
 
  		<c:forEach var="j" begin="0" end="${webDto.carList[i].length() }">
  			<!-- 商品id -->
  			<input style="visibility:hidden" value="${webDto.carList[i][j].goodsId }"/>
	  		<input type="checkbox" id="check_in_${j }"/>
	  		<td class="col-md-8 col-offset-4">
	  			<img src="/xt/bootstrap/image/qiaqia.jpg" class="col-md-2"/><!-- 商品图片 谁知道是什么样的鬼东西-->
	  			<p class="col-md-4">${webDto.carList[i][j].name } 老子天下第一</p><!-- 商品名及介绍   其实就是自吹自擂 -->
	  			<h5 class="col-md-3" >商品数量：</h5>
				<input style="width:30px;height:30px;margin-left:00px" class="min" type="button" value="-" />
				<input style="width:50px;text-align:center" name="" type="text" value="${webDto.carList[i][j].amount }" />
				<input style="width:30px;height:30px"  class="add" type="button" value="+"/>
	  		</td>
  	
  		</c:forEach>
    </tr>
  </c:forEach>
    
  </tbody>
</table>

</div>

<input id="hidden_modal" style="display:none;" value=""/>
<input id="hidden_user" style="display:none;" value="${webDto.userName}"/>
</body>
</html>