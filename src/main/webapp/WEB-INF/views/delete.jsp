<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

function goList(){
	// alert('dkdkdkd');
	// 페이지를 강제로 이동시킬 수 있습니다.
	document.location.href = '/example/';
}
</script>
</head>
<body>
<h3>지우시겠습니까?</h3>
<form action="/example/doDelete" method="post">
	<input type="hidden" value="${post.seq}" name="seq">
	<input type="submit" value="지우겠습니다"> | <input type="reset" value="취소" onclick="goList()">  
</form>
</body>
</html>