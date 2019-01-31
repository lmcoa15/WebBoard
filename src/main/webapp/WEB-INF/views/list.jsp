<%@page import="github.lmcoa15.webboard.dto.Post"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>글목록</h3>

<hr>
<table>
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
	<td>0</td>
	<td>0</td>
	<td>${p.creationTime}</td>
</tr>
</c:forEach>
</table>
</body>
</html>
