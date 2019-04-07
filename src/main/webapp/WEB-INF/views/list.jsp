<%@page import="github.lmcoa15.webboard.dto.Post"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<c:import url="/WEB-INF/views/common/common-rss.jsp"></c:import>
<title>Insert title here</title>
<style type="text/css">
.btn.btn-primary {
	padding : 3px;
}
</style>
</head>
<body>
<c:import url="/WEB-INF/views/common/common-nav.jsp"></c:import>
<h3>글목록</h3>
<hr>
<table class="table">
<tr>
	<td>글번호</td>
	<td>제목</td>
	<td>조회수</td>
	<td>작성자</td>
	<td>작성일</td>
</tr>

<c:forEach var="p" items="${posts}">
<tr>
	<td>${p.seq}</td>
	<td><a href="/example/read?pid=${p.seq }">${p.title}</a></td>
	<td>${p.viewCount}</td>
	<td>${p.writer}</td> <!-- p.writer : getter 메소드 -->
	<td>${p.date}</td>
</tr>
</c:forEach>
</table>

<a href="/example/write"> <button class="btn btn-primary"> 글쓰기</button> </a>
</body>
</html>
