<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>注册</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>

    <title>Title</title>
</head>
<body>
<h1>新用户注册</h1>
<form action="${pageContext.request.contextPath}/signinServlet" method="post">
    姓  名：<input type="text" name="name"><br>
    年  龄：<input type="text" name="age"><br>
    地  址：<input type="text" name="address"><br>
    q   q：<input type="text" name="qq"><br>
    email：<input type="text" name="email"><br>
    性  别：<input type="text" name="gender"><br>
    用户名：<input type="text" name="username"><br>
    密  码：<input type="text" name="password"><br>
    <input type="submit" value="注册"><br>
    <a href="login.html">已注册？点击登陆</a>
</form>
</body>
</html>