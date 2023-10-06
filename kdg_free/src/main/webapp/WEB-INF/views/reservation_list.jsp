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
	<header> TUK CINEMA </header>
	<h3>예매 목록</h3>
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
		<table>
			<tr class="trName">
				<td class="trName">예매 번호</td>
				<td class="trName">UserId</td>
				<td class="trName">MovieId</td>
				<td class="trName">MovieName</td>
				<td class="trName">SeatNumber</td>
				<td class="trName">관리</td>
			</tr>

			<%
			pageContext.setAttribute("loginId", session.getAttribute("loginId"));
			pageContext.setAttribute("admin", session.getAttribute("admin"));
			List<ReservationVO> reservationList = (List<ReservationVO>) request.getAttribute("reservationList");
			for (ReservationVO vo : reservationList) {
				pageContext.setAttribute("userid", vo.getUserid());
			%>
			<tr>
				<c:if test="${loginId == userid && !admin}">
					<td><%=vo.getReserveid()%></td>
					<td><%=vo.getUserid()%></td>
					<td><%=vo.getMovieid()%></td>
					<td><%=vo.getMoviename()%></td>
					<td><%=vo.getSeatnumber()%></td>
					<td><a class='manage'
						href="http://localhost:8080/myweb/reservation/delete?reserveid=<%=vo.getReserveid()%>"
						target="_self"> 예매 취소</a>
				</c:if>
				<c:if test="${admin}">
					<td><%=vo.getReserveid()%></td>
					<td><%=vo.getUserid()%></td>
					<td><%=vo.getMovieid()%></td>
					<td><%=vo.getMoviename()%></td>
					<td><%=vo.getSeatnumber()%></td>
					<td><a class='manage'
						href="http://localhost:8080/myweb/reservation/delete?reserveid=<%=vo.getReserveid()%>"
						target="_self"> 예매 취소</a></td>
				</c:if>
			</tr>
			<%
			}
			%>
		</table>
	</div>
</body>
</html>