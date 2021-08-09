<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			#container{
				width: 70%;
			}
			#header {
				width: 100%;
				overflow: hidden;
			}
			#logoBox {
				width: 20%;
				float: left;
			}
			#memberInfoBox {
				float: right;
			}
			#btnBox {
				float: right;
			}
			.size350 {
				width: 350;
				height: 408;
			}
			table {
				text-align: center;
			}
			#addArea {
				width: 100%;
				overflow: hidden;
			}
			#addArea > img {
				float: right;
			}
		</style>
		<script type="text/javascript">
			function plusPoint() {
				location.href='plusPoint'
			}
			function purchase(goods, point) {
				var memberPoint = ${member.point}
				
				if(point > memberPoint) {
					alert('포인트가 부족합니다. 광고를 클릭하세요.')
					return
				}
				
				location.href='purchase?goods=' + goods + '&point=' + point
			}
			<c:choose>
				<c:when test="${not empty goods}">
						alert('컨텐츠(' + '${goods}' + ')를 구입하였습니다.')
				</c:when>
				<c:when test="${not empty plus}">
						alert('1000점이 적립되었습니다.')
						location.href='http://www.koreaisacademy.com/'
				</c:when>
			</c:choose>
		</script>
	</head>
	<body>
		<div id="container">
			<div id="header">
				<div id="logoBox">
					<h1>메인페이지</h1>
				</div>
				<div id="btnBox">
					<button onclick="location.href='logout'">로그아웃</button>
				</div>
				<div id="memberInfoBox">
					${member.name}(${member.id})님 안녕하세요 <br>
					포인트 : ${member.point}점
				</div>
			</div>
			<h3>구입할 컨텐츠를 선택하세요</h3>
			<table>
				<tr>
					<td> <img onclick="purchase('intro', 100000)" class="size350" src="resources/Intro_350_408.png"> </td>
					<td> <img onclick="purchase('java', 500000)" class="size350" src="resources/Java_350_408.png"> </td>
					<td> <img onclick="purchase('cpp', 300000)" class="size350" src="resources/Cpp_350_408.png"> </td>
				</tr>
				<tr>
					<td>100,000포인트</td>
					<td>500,000포인트</td>
					<td>300,000포인트</td>
					
				</tr>
			</table>
			<div id="addArea">
				<img onclick="plusPoint()" class="size350" src="resources/korea_it.png">
			</div>
		</div>
	</body>
</html>