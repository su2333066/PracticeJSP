<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GUGUDAN</title>
</head>
<body>
    <h1>JSTL 구구단</h1>

	<c:forEach var="dan" begin="${fdan}" end="${ldan}">
		<c:forEach var="gop" begin="1" end="9">
			${dan} X ${gop} = ${dan*gop} <br />
		</c:forEach>
	</c:forEach>
</body>
</html>