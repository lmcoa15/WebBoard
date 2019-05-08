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
<h3>내 정보 보기</h3>
<div class="container-fluid">
	<div class="row">
		<div class="col-xs-6">${user.email }</div>
		<div class="col-xs-6">ADSFASDDD</div>
	</div>
</div>
</body>
</html>
