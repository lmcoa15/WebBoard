<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
<!-- 
Object o = session.getAttribute("LOGIN_USER")
if ( o != null ) {
 -->

<c:if test="${not empty LOGIN_USER }">
<!-- 
User user = session.getAttribute("LOGIN_USER");
String email = user.getEmail():
 -->
 	<b>${LOGIN_USER.email}</b> 님 반갑습니다! |  
 	<a href="<c:url value="/logout"></c:url>">로그아웃</a>
</c:if>
<c:if test="${empty LOGIN_USER }">
<a href="<c:url value="/login"></c:url>">로그인</a>
</c:if>
</div>

