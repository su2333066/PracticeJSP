<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% for(int i = 0; i < 10 ;i++) { 
	out.println(i);
} %>
<hr>
<%
    ArrayList<String> list = new ArrayList<>();
    
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
    
    for(String str : list) {
        out.println(str);
    }
    
    request.setAttribute("aaa", list);
    
%>
<hr>
<c:forEach var="i" begin="0" end="9" step="1">
    ${i}
</c:forEach>
<hr>
<c:forEach items="${aaa}" var="str">
    ${str}
</c:forEach>



</body>
</html>