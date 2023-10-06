<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="org.tukorea.myweb.domain.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TUK CINEMA</title>
<link rel="stylesheet" href="http://localhost:8080/myweb/resources/cinema.css" type="text/css"></link>
</head>
<body>
	<header>Member Update</header>
	<HR>
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
	<div align="center">

		<form
			action="http://localhost:8080/myweb/user/update"
			method="post">
			<%
			UserVO user = (UserVO) request.getAttribute("user");
			%>
			<fieldset>
				<legend>Information Update</legend>
				<ul class=update>
					<li>ID : <input type="text" name="userid"
						value=<%=user.getUserid()%> readonly></li>
					<br>
					<li>PASSWORD : <input type="password" name="passwd"
						value=<%=user.getPasswd()%> autofocus></li>
					<br>
					<li>USERNAME : <input type="text" name="username"
						value=<%=user.getUsername()%>></li>
					<br>
					<li>ACCOUNTNUMBER : <input type="text" name="anum"
						value=<%=user.getAnum()%>></li>
					<br>
					<li>MOBILE : <input type="text" name="mobile"
						value=<%=user.getMobile()%>></li>
					<br>
					<li>EMAIL : <input type="text" name="email"
						value=<%=user.getEmail()%>></li>
					<br>
					<%
					pageContext.setAttribute("admin", session.getAttribute("admin"));
					%>
					<c:if test="${admin}">
						<li>USERTYPE : <input type="text" name="usertype"
							value=<%=user.getUsertype()%>></li>
					</c:if>
				</ul>
			</fieldset>
			<br>
			<fieldset>
				<input type="submit" name="submit" value="최종 수정"> <input
					type="reset" name="reset" value="다시 작성">
			</fieldset>
		</form>
	</div>
</body>
</html>