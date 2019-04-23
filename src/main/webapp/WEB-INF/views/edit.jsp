<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>글수정</h3>
<!-- form은 앵커하고 하는 일이 똑같습니다. 
<a href="xxxxxxxx">DDDDD</a>
 -->
<form action="/example/doEdit" method="post">
	<input type="hidden" value="${post.seq}" name="seq">
	<input type="text" value="${post.title}" name="title">
	<br>
	<textarea rows="5" cols="40" name="content">${post.content }</textarea>
	<input type="submit" value="수정">
</form>
</body>
</html>    