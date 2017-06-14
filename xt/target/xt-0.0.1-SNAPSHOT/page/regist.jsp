<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
<link rel="stylesheet" href="/xt/bootstrap/css/base.css">
<link rel="stylesheet" href="/xt/bootstrap/css/index.css">
<link rel="stylesheet" href="/xt/bootstrap/css/bootstrap.css">

<link rel="stylesheet" href="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="/xt/bootstrap/js/jquery.js"></script>
<script src="/xt/bootstrap/js/bootstrap.js"></script>
<script src="/xt/bootstrap/js/regist.js"></script>
</head>
<body>

<div class="top">
    <div class="w"><p class="fl">Shopping</p></div>
        <ul class="fr">
        	<li class="fl"><a href="/xt/index.jsp">首页</a>|</li>
        	<li class="fl"><a href="/xt/page/login.jsp">已有账号?</a>|</li>
            <li class="fl"><a href="/xt/page/conadmin.jsp">联系我们</a>|</li>
            <li class="fl"><a href="#">加入收藏</a></li>
        </ul>
</div>



		<form id="regist_form" >
		<div class="row" style="margin-top:5%;">
		<!-- 用户名 -->
			<div class="from-group col-md-6 col-md-offset-3">
				<label  class="col-xs-3 col-sm-3 col-md-3  control-label text-right" for="username_input">用户名:</label>
				<div class="col-md-5 text-left">
					<input id="username_input" name="userName"  type="text" class="form-control" placeholder="用户名"></input>
				</div>
			</div>
			<div class="col-md-12" style="text-align:center"><p></p></div>
			<div class="col-md-12" style="text-align:center"><p></p></div>
		 	  
			<!-- 密码 -->	
			  <div class="from-group col-md-6 col-md-offset-3">
					<label  class="col-xs-3 col-sm-3 col-md-3  control-label text-right" for="password_input">密码:</label>
				<div class="col-md-5 text-left">
					<input id="password_input" name="password" type="password" class="form-control"  placeholder="密码" id="entryName"></input>
				</div>
			</div>
			<div class="col-md-12" style="text-align:center"><p></p></div>
				<div class="col-md-12" style="text-align:center"><p></p></div>
		    <!-- 确认密码 -->
		     <div class="from-group col-md-6 col-md-offset-3">
					<label  class="col-xs-3 col-sm-3 col-md-3  control-label text-right" for="password_2">确认密码:</label>
				<div class="col-md-5 text-left">
					<input id="password_2" type="password" class="form-control" name="entryName" placeholder="密码" ></input>
				</div>
			</div>
			<div class="col-md-12" style="text-align:center"><p></p></div>
				<div class="col-md-12" style="text-align:center"><p></p></div>
		  	<!-- 手机号 -->	
				 <div class="from-group col-md-6 col-md-offset-3">
					<label  class="col-xs-3 col-sm-3 col-md-3  control-label text-right" for="phoneno">手机号码:</label>
					<div class="col-md-5 text-left">
						<input id="phoneno" name="phoneNo" type="text" class="form-control"  placeholder="手机号码" ></input>
					</div>
				</div>
				<div class="col-md-12" style="text-align:center"><p></p></div>
				<div class="col-md-12" style="text-align:center"><p></p></div>
				<!-- 性别 -->
				<div class="from-group col-md-6 col-md-offset-3">
					<label  class="col-xs-3 col-sm-3 col-md-3  control-label text-right" for="sex">性别:</label>
					<div class="col-md-5 text-left">
						<select id="sex" name="sex" class="form-control">
							<option value="1">男</option>
							<option value="0">女</option>
						</select>
					</div>
				</div>
				<div class="col-md-12" style="text-align:center"><p></p></div>
				<div class="col-md-12" style="text-align:center"><p></p></div>
		 	    <!-- 地址 -->
		 	    <div class="from-group col-md-6 col-md-offset-3">
					<label  class="col-xs-3 col-sm-3 col-md-3  control-label text-right" for="address">地址:</label>
					<div class="col-md-5 text-left">
						<input id="address" name="address" type="text" class="form-control"  placeholder="地址" id="entryName"></input>
					</div>
				</div>
				<div class="col-md-12" style="text-align:center"><p></p></div>
				<div class="col-md-12" style="text-align:center"><p></p></div>
				<!-- 城市 -->
		 	    <div class="from-group col-md-6 col-md-offset-3">
					<label  class="col-xs-3 col-sm-3 col-md-3  control-label text-right" for="cityname">城市:</label>
					<div class="col-md-5 text-left">
						<input id="cityname" name="cityName" type="text" class="form-control"  placeholder="城市名" ></input>
					</div>
				</div>
				<div class="col-md-12" style="text-align:center"><p></p></div>
				<div class="col-md-12" style="text-align:center"><p></p></div>
		        <!-- 按钮 -->
		   		<div class="from-group col-md-6 col-md-offset-2 text-center">
				<button id="regist_sub" type="submit"  class="btn  btn-primary" >确定</button>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<button id="regist_can" type="reset" class="btn  btn-primary">取消</button>
				</div>
		    </div>
	   	</form>

</body>
</html>