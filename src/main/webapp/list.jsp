<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.cha.demo.AddrDB" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.cha.demo.Addr" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>주소 목록</h1>
<c:forEach items="${addrList}" var="addr">
    <div>
        번호 : ${ addr.idx } <br/>
        이름 : ${ addr.name }<br/> 
        주소 : ${ addr.address }<br/>
        전화번호 : ${ addr.phone }<br/>
    </div>
    <hr>
</c:forEach>
</body>
</html>