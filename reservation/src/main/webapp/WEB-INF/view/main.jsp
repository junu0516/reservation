<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	로그인된 사용자 세션정보가 존재하는가? : ${sessionScope.User != null}
	<c:if test="${userId != null}">
		현재  ${userId} 님이 로그인한 상태입니다.<br>
		<a href="logout">로그아웃</a>
	</c:if>
	<c:if test="${userId == null}">
		<h1>로그인 페이지</h1>
		<form method="post" action="/reservation/authenticate">
			<div>
				<label>Email : </label>
				<input type="text" name="userEmail">
			</div>
			
			<div>
				<label>Password : </label>
				<input type="password" name="password">
			</div>
			<br>
			<input type="submit" value="로그인">
		</form>
	</c:if>
	
</body>
</html>