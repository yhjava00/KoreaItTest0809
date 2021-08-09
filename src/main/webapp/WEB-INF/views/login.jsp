<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			#loginBox {
				width: 300px;
				margin: 0 auto;
			}
		</style>
		<script type="text/javascript">
			<c:choose>
				<c:when test="${state == 'signUp'}">
						alert('가입되었습니다. 로그인 해주세요.')
				</c:when>
				<c:when test="${state == 'fail'}">
						alert('아이디/비밀번호를 다시 확인하세요.')
				</c:when>
				<c:when test="${state == 'logout'}">
						alert('로그아웃 되었습니다.')
				</c:when>
			</c:choose>
		</script>
	</head>
	<body>
		<div id="loginBox">
			<h1>로그인</h1>
			<form action="loginAction" method="post">
				ID : <input name="id"> <br>
				PW : <input type="password" name="pw"> <br>
				<input type="submit" value="로그인" style="width: 100%;"> <br>
			</form>
			<button onclick="location.href='signUp'" style="width: 100%;">회원가입</button>
		</div>
	</body>
</html>