<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Main Page</h1>
	<c:if test="${userEmail != null}">
		현재 ${userEmail}님이 로그인하신 상태입니다.<br>
		<a href="logout">로그아웃</a>
	</c:if>
	<c:if test="${userEmail == null}">
		<a href="loginForm">로그인하러 가기</a>
	</c:if>
	
</body>
</html>