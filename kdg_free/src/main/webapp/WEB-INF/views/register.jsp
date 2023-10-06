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
	<header>Create Your Account</header>
	<hr>

	<div>
		<form
			action="http://localhost:8080/myweb/user/join"
			method="post">

			<fieldset>
				<legend>Personnel Information</legend>
				<ul class=update>
					<li>ID : <input type="text" name="userid" autofocus required
						placeholder="공백없이 입력하세요"></li><br>
					<li>PASSWORD : <input type="password" name="passwd" required
						placeholder="공백없이 입력하세요"></li><br>
					<li>USERNAME : <input type="text" name="username" required
						placeholder="공백없이 입력하세요"></li><br>
					<li>ACCOUNTNUMER : <input type="text" name="anum" required
						placeholder="공백없이 입력하세요"></li><br>
					<li>MOBILE : <input type="text" name="mobile" required
						placeholder="***.****.****"></li><br>
					<li>EMAIL : <input type="text" name="email" required
						placeholder="****@****.***"></li><br>
				</ul>
			</fieldset>
			<br>
			<fieldset>
				<input type="submit" name="submit" value="보내기"> <input
					type="reset" name="reset" value="다시 작성">
			</fieldset>
		</form>
		<br><br>
		<a class='manage' href="http://localhost:8080/myweb/"
			target="_self">메인 페이지 이동 </a>
	</div>
</body>
</html>