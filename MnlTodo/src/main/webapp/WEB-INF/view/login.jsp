<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>MnlTodo </title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h2>
			Login
			<c:if test="${param.error != null}">
				<script>
					alert("다시 로그인해 주세요");   
				</script>
				 
				<br />Invalid username and password. (${param.error})
		 	</c:if>

			<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
				<font color="red"> Your login attempt was not successful due
					to <br />
				<br /> <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />.
				</font>
			</c:if>
			<c:if test="${param.logout != null}">
				<br />You have been logged out.
      		</c:if>
		</h2>
		<a href="/registform">신규 가입</a>

		<form role="form" action="/login" method="post">
			<div class="form-group">
				<label for="username">loginid:</label> <input type="text"
					class="form-control" id="loginid" name="loginid"
					placeholder="Enter loginid">
			</div>
			<div class="form-group">
				<label for="password">Password:</label> <input type="password"
					class="form-control" id="password" name="password"
					placeholder="Enter password">
			</div>
			<div class="checkbox">
				<label><input type="checkbox"
					name="_spring_security_remember_me" value="true"> Remember
					me</label>
			</div>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			<button type="submit" class="btn btn-default">Log in</button>
		</form>
	</div>

</body>
</html>
