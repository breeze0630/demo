<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/19
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>/WEB-INF/jsp/index.jsp 页面 h1</h1>
<form action="/file/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="file"/>
    <input type="submit" value="提交上传"/>
</form>
</body>
</html>
