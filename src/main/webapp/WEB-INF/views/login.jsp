<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>로그인</h3>
<form action="/example/doLogin" method="post">
	<input type="text" value="" name="ID" placeholder="아이디">	
	<br>
	<input type="password" value="" name="Password" placeholder="패스워드">
	<input type="submit" value="로그인">
</form>
</body>
</html>