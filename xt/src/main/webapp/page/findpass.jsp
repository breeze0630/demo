<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/xt/bootstrap/css/base.css">
 <link rel="stylesheet" href="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	 <script src="https://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<title>找回密码</title>


</head>
<body>

<div class="top">
    <div class="w">
        <p class="fl">X T Shopping</p>
        <ul class="fr">
        	<li class="fl"><a href="/xt/page/login.jsp">请登录</a>|</li>
        	<li class="fl"><a href="/xt/page/regist.jsp">还没有账号?</a>|</li>
            <li class="fl"><a href="/xt/page/conadmin.jsp">联系我们</a>|</li>
            <li class="fl"><a href="#">加入收藏</a></li>
        </ul>
    </div>
</div>
<div style="margin-top:200px;width:800px;align:center">
	
	


 	<div class="row">
  		<div class="col-md-7"></div>
  		<div class="col-md-2"> <p style="font-size:18px;text:center">手机号</p> </div>
		<div class="col-md-3">
    		<div class="input-group">
 		 		<input type="text" class="form-control" placeholder="请输入手机号" />
 	  		</div>
		</div>
	</div>
	<div class="row">
  		<div class="col-md-8"></div>
  		<div class="col-md-2"> <button class="btn btn-default" type="submit" style="margin-top:50px;text:center">找回密码</button> </div>
		<div class="col-md-2"></div>
	</div>
	
 </div>
<div style="margin-top:20%;margin-left:30%">
    <jsp:include page="buttom.jsp"></jsp:include>
</div>
</body>
</html>