<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>error/title></title>
	</head>
	<body>
		<h2>로그인 실패</h2>
		${errorMsg }
		<a href="login.do">로그인</a>
	</body>
</html>