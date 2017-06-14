<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>

    <link rel="stylesheet" href="/xt/bootstrap/css/base.css">
    <link rel="stylesheet" href="/xt/bootstrap/css/index.css">
    <link rel="stylesheet" href="/xt/bootstrap/css/bootstrap.css">

 <link rel="stylesheet" href="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="/xt/bootstrap/js/jquery.js"></script>
    <script src="/xt/bootstrap/js/bootstrap.js"></script>
    <script src="/xt/bootstrap/js/login.js"></script>

</head>
<body style="align:center;background:url(/xt/bootstrap/image/banner-login.jpg) no-repeat;">

 	
<div class="top">
    <div >
        <ul class="fr">
        	<li class="fl"><a href="/xt/index.jsp">首页</a>|</li>
        	<li class="fl"><a href="/xt/page/regist.jsp">还没有账号?</a>|</li>
            <li class="fl"><a href="/xt/page/conadmin.jsp">联系我们</a>|</li>
            <li class="fl"><a href="#">加入收藏</a></li>
        </ul>
    </div>
</div>

	<div style="margin-top:220px;margin-left:900px;width:350px;height:250px;border:solid black 2px;">
		<form id="login_form" class="form-inline">
		     <div style="margin-top:5px;margin-left:50px;">
				<p id="tips">您输入的用户名或者密码不正确</p></div>
		 	 <div class="form-group" style="margin-top:10px;margin-left:30px">
		  		  <label for="exampleInputName2" style="margin-left:20px;">用户名</label>
		  		  <input name="userName" type="text" class="form-control" style="margin-left:30px" id="exampleInputName2" placeholder="请输入用户名或者手机号">
		 	 </div>
		 	 

			  <div class="form-group" style="margin-top:20px;margin-left:30px">
		  	  	 <label for="exampleInputEmail2" style="margin-left:20px;">密&nbsp;&nbsp;&nbsp;码</label>
		 	     <input name="password" type="password" class="form-control" style="margin-left:30px" id="exampleInputEmail2" placeholder="请输入密码">
		    </div>
			  <button id="login_sub" type="submit" class="btn btn-default" style="margin-top:20px;margin-left:60px;width:240px">登录</button>
			  <a href="findpass.jsp" style="margin-top:60px;margin-left:60px">忘记密码</a>
			  <a href="regist.jsp" style="margin-top:40px;margin-left:20px">免费注册</a>
	   	</form>

	 </div>
	
	
	
<div style="margin-top:20%;margin-left:30%">
    <jsp:include page="buttom.jsp"></jsp:include>
</div>
	
 
</body>
</html>