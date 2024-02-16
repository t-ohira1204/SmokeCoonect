<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%
// アプリケーションスコープからリクエストユーザーネームを取得
String resUser = (String)application.getAttribute("resUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SmokeConnect</title>
</head>
<body>
<h1>SmokeConnect</h1>
<p><%= resUser %> があなたにお貸しします。</p>
<p>レンタルが完了しましたら以下のボタンを押してください</p>
<strong>※必ず完了後押してください。</strong>
<form action="UserResponseServlet">
<input type="submit" value="貸与完了">
</form>
</body>
</html>