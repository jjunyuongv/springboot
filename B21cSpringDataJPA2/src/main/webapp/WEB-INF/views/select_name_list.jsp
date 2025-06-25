<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>데이터 조회</title>
		</head>
		<body>
			<%
				out.println("Spring JPA #2 - Select Name Like");
			%>
			<ul>
				<li><a href="/">루트</a></li>
			</ul>
			<c:forEach items="${ members }" var="member">
			아이디 : ${ member.id }<br>
			이름 : ${ member.name } <br>
			이메일 : ${ member.email }
			<hr />
			</c:forEach>
	</body>
</html>