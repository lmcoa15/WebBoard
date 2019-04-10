<%@page import="github.lmcoa15.webboard.dto.Post"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<c:import url="/WEB-INF/views/common/common-rss.jsp"></c:import>
<title>Insert title here</title>
</head>
<body>
<c:import url="/WEB-INF/views/common/common-nav.jsp"></c:import>
<c:if test="${ not empty post }">
<h3>${ post.title}</h3>
<p>${ post.contents }</p>
</c:if>
<c:if test="${empty post }">
<h3> 글이 존재하지 않습니다.</h3>
</c:if>
<div class="container-fluid">
	<div class="row">
		<div class="col-xs-12 col-sm-4"><a class="btn btn-default form-control" href="/example/">목록으로</a></div>
		
		<c:if test="${isWriter}"> <!--  req.getAttribute("isWriter"); -->
		<div class="col-xs-12 col-sm-4"><a class="btn btn-default form-control" href="/example/edit?pid=${post.seq}">글수정</a></div>
		<div class="col-xs-12 col-sm-4"><a class="btn btn-default form-control" href="/example/delete?pid=${post.seq}">글삭제</a></div>
		</c:if> 
	</div>
</div>
</html>

