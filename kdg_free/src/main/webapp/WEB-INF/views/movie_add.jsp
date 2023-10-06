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
	<header>상영 영화 추가</header>

	<div>
		<form
			action="http://localhost:8080/myweb/movie/join"
			method="post">

			<fieldset>
				<legend>Movie Information</legend>
				<ul class=update>
					<li>Movie ID : <input type="text" name="movieid" autofocus required
						placeholder="공백없이 입력하세요"></li><br>
					<li>Movie Name : <input type="text" name="moviename" required></li><br>
					<li>Movie Genre : <input type="text" name="moviegenre" required></li><br>
					<li>Room : <input type="text" name="room" required
						placeholder="0관"></li><br>
					<li>Movie Time : <input type="text" name="movietime" required
						placeholder="00:00 ~ 00:00"></li><br>
				</ul>
			</fieldset>
			<br>
			<fieldset>
				<input type="submit" name="submit" value="보내기"> <input
					type="reset" name="reset" value="다시 작성">
			</fieldset>
		</form>
	</div>
</body>
</html>