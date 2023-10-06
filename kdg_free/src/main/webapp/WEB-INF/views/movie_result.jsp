<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="org.tukorea.myweb.domain.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TUK CINEMA</title>
<link rel="stylesheet" href="http://localhost:8080/myweb/resources/cinema.css" type="text/css"></link>
</head>
<body>
	<header> TUK CINEMA </header>
	<hr>
	<%
	String loginId = null;
	if (session.getAttribute("loginId") != null) {
		loginId = (String) session.getAttribute("loginId");
	}
	%>
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
	</div>
	<br>
	<br>
	<br>
	<div>
		<%
		MovieVO movie = (MovieVO) request.getAttribute("movie");
		%>
		<table>
			<tr>
				<td>영화 이름</td>
				<td>영화 장르</td>
				<td>상영관</td>
				<td>상영 시간</td>
			</tr>
			<tr>
				<td><%=movie.getMoviename()%></td>
				<td><%=movie.getMoviegenre()%></td>
				<td><%=movie.getRoom()%></td>
				<td><%=movie.getMovietime()%></td>
			</tr>
		</table>
	</div>
</body>
</html>