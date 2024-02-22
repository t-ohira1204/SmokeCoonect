<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%@ page import="model.UserResponseLogic" %>
<%@ page import="dao.PostsDAO" %>

<%
	// セッションスコープからリクエストユーザーのユーザーネームを取得
	User loginUser = (User) session.getAttribute("loginUser");
	String reqName = loginUser.getName();

	// UserResponseLogicインスタンスを生成しレスポンスユーザーネームを取得
	UserResponseLogic userResponseLogic = new UserResponseLogic();
	String resUser = userResponseLogic.getResUserName(reqName);
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
    <form action="UserResponseServlet?action=Completed" method="post">
        <input type="submit" value="貸与完了">
    </form>
</body>
</html>
