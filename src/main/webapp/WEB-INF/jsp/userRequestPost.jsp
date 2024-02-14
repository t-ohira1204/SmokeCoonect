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
<form action = "Main" method="post">
	<div>
		喫煙所：
		<select name="place" size=1>
			<option value="マルハン梅田店B2F">マルハン梅田店B2F</option>
 			<option value="マルハン梅田店B1F">マルハン梅田店B1F</option>
			<option value="マルハン梅田店1F">マルハン梅田店1F</option>
			<option value="123梅田店1F">123梅田店1F</option>
			<option value="123梅田店2F">123梅田店2F</option>
		</select>
	</div>
	<div>
		滞在時間：
		<input type="radio" name="time"value="5分">5分
 		<input type="radio" name="time"value="10分">10分
		<input type="radio" name="time"value="15分">15分
	</div>
	<input type="submit" value="投稿">
</form>
</body>
</html>