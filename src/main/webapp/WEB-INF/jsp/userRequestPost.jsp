<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SmokeConnect</title>
</head>
<body>
<h1>SmokeConnect</h1>
<form action = "UserRequestServlet" method="post">
	<div>
		喫煙所：
		<select name="place" size=1>
			<option value="バツハン梅田店B2F">バツハン梅田店B2F</option>
 			<option value="バツハン梅田店B1F">バツハン梅田店B1F</option>
			<option value="バツハン梅田店1F">バツハン梅田店1F</option>
			<option value="321梅田店1F">321梅田店1F</option>
			<option value="321梅田店2F">321梅田店2F</option>
		</select>
	</div>
	<div>
		滞在時間：
		<input type="radio" name="time"value="5分" checked>5分
 		<input type="radio" name="time"value="10分">10分
		<input type="radio" name="time"value="15分">15分
	</div>
	<input type="submit" value="投稿">
</form>
<p><a href="Main">戻る</a></p>
</body>
</html>