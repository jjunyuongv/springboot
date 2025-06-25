<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>데이터 입력</title>
	</head>
	<body>
		<%
			out.println("Spring JPA #2");
		%>
		<h2>Spring boot 프로젝트</h2>
		<ul>
			<li><a href="/">루트</a></li>
		</ul>
			아이디 : ${member.id } <br/>
			이름 : $member.name } <br/>
			날짜 : ${member.email } <br/>
			<hr />
	</body>
</html>