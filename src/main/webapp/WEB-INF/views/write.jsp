<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>글작성!</h3>

<form action="/example/doWrite" method="post">
	<input type="text" name="title">
	<br>
	<textarea rows="5" cols="40" name="content"></textarea>
	<input type="submit" value="글쓰기">
</form>

</body>
</html>