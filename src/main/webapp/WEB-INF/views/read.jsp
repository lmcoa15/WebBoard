<%@page import="github.lmcoa15.webboard.dto.Post"%>
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

<%--Post post= (Post) request.getAttribute("post") ;
<% if(post!=null) { %>
<h3><%=post.getTitle()%></h3>
<p><%=post.getContent() %></p>
<% } else{%>
<h3> 글이 존재하지 않습니다.</h3>
<% } %> --%>
<c:if test="${ not empty post }">
<h3>${ post.title}</h3>
<p>${ post.content }</p>
</c:if>
<c:if test="${empty post }">
<h3> 글이 존재하지 않습니다.</h3>
</c:if>
<div><a href="/example/">목록으로</a></div>
<div><a href="/example/edit?pid=${post.seq}">글수정</a></div>
</body>
</html>

