<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SmokeConnect</title>
</head>
<body>
<h1>ユーザー登録</h1>
<form action="UserRegisterServlet" method="post">
ユーザー名：<input type="text" placeholder="ユーザー名を入力" name="name"><br>
パスワード：<input type="password" placeholder="パスワードを入力" name="pass"><br>

<input type="submit" value="登録">
</form>

<a href ="index.jsp">戻る</a>
</body>
</html>