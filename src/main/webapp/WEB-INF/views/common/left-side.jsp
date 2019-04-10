<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

      <!-- Sidebar - Brand -->
      <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
        <div class="sidebar-brand-icon rotate-n-15">
          <i class="fas fa-laugh-wink"></i>
        </div>
        <div class="sidebar-brand-text mx-3">SB Admin <sup>2</sup></div>
      </a>

      <!-- Divider -->
      <hr class="sidebar-divider">

      <!-- Heading -->
      <div class="sidebar-heading">
        카테고리
      </div>

	 <li class="nav-item">
        <a class="nav-link collapsed" href="#" aria-expanded="true">
          <i class="fas fa-fw fa-cog"></i>
          <span>전체글</span>
        </a>
      </li>
      <!-- Nav Item - Pages Collapse Menu -->
      <c:forEach var="cate" items="${category}">
      <li class="nav-item">
        <a class="nav-link collapsed" href="${pageContext.request.contextPath}/${cate.alias}" aria-expanded="true">
          <i class="fas fa-fw fa-cog"></i>
          <span>${cate.cateName}</span>
        </a>
      </li>
      </c:forEach>

      <!-- Divider -->
      <hr class="sidebar-divider">
 
      <!-- Sidebar Toggler (Sidebar) -->
      <div class="text-center d-none d-md-inline">
        <button class="rounded-circle border-0" id="sidebarToggle"></button>
      </div>

    </ul>