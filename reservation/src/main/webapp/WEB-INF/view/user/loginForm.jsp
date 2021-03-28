<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
  <html>
    <head>
      <title>로그인 </title>
    </head>
  <body>
    <div>
      <div>
        <form method="post" action="/reservation/auth">
          <div>
            <label>ID</label>
            <input type="text" name="userEmail">
          </div>
          <div>
            <label>암호</label>
            <input type="password" name="password">
          </div>
          <div>
            <label></label>
            <input type="submit" value="로그인">
          </div>
        </form>
      </div>
    </div>
  </body>
</html>