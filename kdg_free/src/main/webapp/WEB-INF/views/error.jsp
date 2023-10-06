<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="org.tukorea.myweb.domain.*, java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TUK CINEMA</title>
<link rel="stylesheet" href="http://localhost:8080/myweb/resources/cinema.css" type="text/css"></link>
</head>
<body>
	<%
	String loginId = null;
	if (session.getAttribute("loginId") != null) {
		loginId = (String) session.getAttribute("loginId");
	}
	%>
	<header> TUK CINEMA </header>
	<hr>
	<div class=menu>
		<nav class="clearfix">
			<ul class="clearfix">
				<li><a href="http://localhost:8080/myweb/"
					target="_self">메인 페이지</a></li>
				<li><a
					href="http://localhost:8080/myweb/user/list"
					target="_self">전체 회원 목록 보기 </a></li>

				<li><a
					href="http://localhost:8080/myweb/movie/list"
					target="_self">상영 영화 목록 보기 </a></li>
				<%
				if (loginId == null) {
				%>
				<li><a
					href="http://localhost:8080/myweb/user/login"
					target="_self"> 로그인</a></li>
				<%
				} else {
				%>
				<li><strong>${loginId} 님 반갑습니다.</strong></li>
				<li><a
					href="http://localhost:8080/myweb/reservation/list"
					target="_self"> 예매 내역 확인</a></li>
				<li><a
					href="http://localhost:8080/myweb/user/logout"
					target="_self"> 로그아웃</a></li>
				<%
				}
				%>
				<li><a
					href="http://localhost:8080/myweb/user/join"
					target="_self"> 회원가입</a></li>
			</ul>
		</nav>
		<header style="font-size: 100px">ERROR!</header>
	</div>
	
</body>
</html>