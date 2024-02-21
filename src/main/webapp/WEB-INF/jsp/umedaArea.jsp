<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%@ page import="model.PostData" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="dao.PostsDAO" %>

<%
    User loginUser = (User) session.getAttribute("loginUser");
    List<PostData> postingList = null;

    try {
        PostsDAO dao = new PostsDAO();
        postingList = dao.displayPostData();
    } catch (Exception e) {
        e.printStackTrace();
    }

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
        <p><%= loginUser.getName() %>さん、ログイン中 <a href="Logout">ログアウト</a></p>
        <form action="UserRequestServlet">
            <input type="submit" value="投稿する">
        </form>
        <p><a href="Main">更新</a></p>

        <% if (postingList != null) { %>
            <% for (Iterator<PostData> iterator = postingList.iterator(); iterator.hasNext();) { %>
                <p>-----------------------------------</p>
                <%
                    PostData posting = iterator.next();
                %>
                <p>ID：<%= posting.getId() %><br>ユーザーネーム：<%= posting.getUserName() %><br>
                喫煙所名：<%= posting.getPlace() %><br>
                滞在時間：<%= posting.getTime() %></p><br>
                <form action="UserResponseServlet" method="post">
                	<input type="hidden" name="ID" value="<%=posting.getId() %>">
                    <input type="submit" value="ライターを貸す">
                </form>
                <p>-----------------------------------</p>
            <% } %>
        <% } else { %>
            <p>投稿がありません。</p>
        <% } %>
    </div>
</body>
</html>
