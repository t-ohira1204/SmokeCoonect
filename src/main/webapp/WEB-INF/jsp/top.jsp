<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8" %>
<%@ page import="model.User" %>
<%
// セッションスコープからユーザー情報を取得
User loginUser = (User) session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css"> 
<title>SmokeConnect</title>
</head>
<body>
<div class="wrapper">
<h1>SmokeConnect</h1>
<% if(loginUser != null) { %>
  <p>ログインに成功しました</p>
  <p>ユーザー情報</p>
  <p>ようこそ、<%= loginUser.getName() %>さん</p>
  <a href="AreaSelectServlet">エリア選択画面へ</a><br>
  <a href="LogoutServlet">ログアウトする</a>
<% } else { %>
  <p>ログインに失敗しました</p>
  <a href="index.jsp">TOPへ</a>
<% } %>
</div>
</body>
</html>