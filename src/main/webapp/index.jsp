<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SmokeConnect</title>
<link rel="stylesheet" href="css/style.css"> 
</head>
<body>
<div class="wrapper">
<h1>SmokeConnect</h1>
<form action="Login" method="post">
ユーザー名：<input type="text" name="name"><br>
パスワード：<input type="password" name="pass"><br>
<input type="submit" value="ログイン">
</form>
</div>
<a href="userRegister.jsp">ユーザー登録</a>
</body>
</html>