<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TUK CINEMA</title>
<link rel="stylesheet" href="http://localhost:8080/myweb/resources/cinema.css" type="text/css"></link>
</head>
<body>
	<header>Login Your Account</header>
	<hr>

	<div>
		<form action="http://localhost:8080/myweb/user/login" method="post">

			<fieldset>
				<ul class=update>
					<li>ID : <input type="text" name="userid" autofocus required
						placeholder="공백없이 입력하세요"></li>
					<br>
					<li>PASSWORD : <input type="password" name="passwd" required
						placeholder="공백없이 입력하세요"></li>
				</ul>
			</fieldset>
			<br>
			<fieldset>
				<input type="submit" name="submit" value="확인"> <input
					type="reset" name="reset" value="다시 작성">
			</fieldset>
		</form>
		<br>
		<br> <a class='manage' href="http://localhost:8080/myweb"
			target="_self">메인 페이지 이동 </a>
	</div>
</body>
</html>