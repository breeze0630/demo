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
<script src="/xt/bootstrap/js/news.js"></script>

</head>
<body>

<div class="top">
    <div class="w">
     
        <ul class="fr">
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
  <caption><h1>我的消息</h1></caption>
  <thead>
    <tr >
      <th class="col-md-2">发信人</th>
      <th class="col-md-2">收信人</th>
      <th class="col-md-7">消息</th>
      <th class="col-md-1"></th>
      <th class="col-md-1"></th>
      <th class="col-md-1"></th>
    </tr>
  </thead>
  <tbody>
  
  
  <c:forEach var="i" begin="0" end="${webDto.news.lenght() }">
  
  <p style="display:none" id="messageid_${i}">${webDto.news[i].messageId}</p>
  <tr>
      <td id="from_name_${i}" class="col-md-2">${webDto.news[i].fromName}</td>
      <td id="to_name_${i}" class="col-md-2">${webDto.news[i].toName}</td>
      <td id="message_${i}" class="col-md-7">${webDto.news[i].message}</td>
      <td  class="col-md-1">
      <!-- 1.回复 2.删除 3.查看详细 -->
      	<button id="answer_btn_${i}" class="btn" data-toggle="modal"  data-target="#myModal" onclick="answer(${i})">回复</button>
      	</td>
      	<td  class="col-md-1">
      	<button id="remove_btn_${i}" class="btn" onclick="remove(${i})">删除</button>
      	</td>
      	<td class="col-md-1">
      	<button id="inspect_btn_${i}" class="btn" data-toggle="modal"  data-target="#myModal" onclick="inspect()">查看详细</button>
      	</td>
    </tr>
    
  </c:forEach>
    
  </tbody>
</table>

</div>
<!-- 按钮触发模态框<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
	开始演示模态框
</button>
 -->

<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			
			<form action="" id="model_form">
			<div class="modal-header">
			我的消息	
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="col-md-12">
					<div class="col-md-3"><label class="">发信人：</label></div>
					<div class="col-md-3"><label id="modal-f" name="from_name" ></label></div>
					<div class="col-md-3"><label class="">收信人：</label></div>
					<div class="col-md-3"><label id="modal-t" name="to_name" ></label></div>
					</div>
					<div class="col-md-12">
						<div class="col-md-8 col-offset-1"><p id="modal-message_show"></p><textarea id="modal-message" name="message"></textarea></div>
					</div>
				</div>
			</div>
			
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭取消
				</button>
				<button id="answer_sub" type="submit" class="btn btn-primary">
					提交回复
				</button>
			</div>
			</form>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>

<input id="hidden_modal" style="display:none;" value=""/>
<input id="hidden_user" style="display:none;" value="${webDto.userName}"/>
</body>
</html>