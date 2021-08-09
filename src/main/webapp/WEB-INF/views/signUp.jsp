<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			#signUpBox {
				width: 300px;
				margin: 0 auto;
			}
		</style>
	</head>
	<body>
		<div id="signUpBox">
			<h1>회원가입</h1>
			<form action="signUpAction" method="post">
				ID : <input name="id"> <br>
				PW : <input type="password" name="pw"> <br>
				NAME : <input name="name"> <br>
				<input type="submit" value="작성완료" style="width: 100%;">
			</form>
		</div>
	</body>
</html>