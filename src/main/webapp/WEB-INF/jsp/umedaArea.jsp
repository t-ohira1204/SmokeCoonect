<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8" %>
<%@ page import="model.User,model.Posting,java.util.List,java.util.Date,java.text.SimpleDateFormat" %>
<%
// セッションスコープに保存されたユーザー情報を取得
User loginUser = (User) session.getAttribute("loginUser");
// アプリケーションスコープに保存されたつぶやきリストを取得
List<Posting> postingList = (List<Posting>) application.getAttribute("postingList");
// リクエストスコープに保存されたエラーメッセージを取得
String errorMsg = (String) request.getAttribute("errorMsg");
%>
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
<p>
<%= loginUser.getName() %>さん、ログイン中
<a href="Logout">ログアウト</a>
</p>
<form action="UserRequestServlet">
<input type="submit" value="投稿する">
</form>
<p><a href="Main">更新</a></p>
<% if(errorMsg != null){ %>
<p><%= errorMsg %></p>
<% } %>
<% for(Posting posting : postingList){%>
  <p>-----------------------------------</p>
  <p>ユーザーネーム：<%=posting.getUserName()%><br>
  喫煙所名：<%=posting.getPlace()%><br>
  滞在時間：<%=posting.getTime()%></p><br>
  <form action="UserResponseServlet" method="post">
  <input type="submit" value="ライターを貸す">
  </form>
  <p>-----------------------------------</p>
<% } %>
</div>
</body>
</html>