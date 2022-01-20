<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>JSTL 조건문</h1>
<%  
    int age = 77;    
%>
<% if(age < 20 || age > 59) { %>
    <div>
        할인 대상입니다.
    </div>
<% } 
   if(age >= 20 && age <= 59) { %>
    <div>
        할인 대상이 아닙니다.
    </div>
<% } %>    
<hr>
<% if(age < 20) { %>
    <div>
        할인 대상입니다.
    </div>
<% } else if(age >= 60) { %>
    <div>
        할인 대상입니다.
    </div>
<% } else { %>

    <div>
        할인 대상이 아닙니다.
    </div>
<% } %>
<hr>
<c:set var="age" value="77" />

<c:if test="${ age < 20 || age > 59 }">
    <div>
        할인 대상입니다.
    </div>
</c:if>
<c:if test="${ age >= 20 && age <= 59 }">
    <div>
        할인 대상이 아닙니다.
    </div>
</c:if>

<hr>
<c:choose>
    <c:when test="${ age < 20 }">
        <div>
            할인 대상입니다.
        </div>
    </c:when>
    <c:when test="${ age > 59 }">
        <div>
            할인 대상입니다.
        </div>
    </c:when>
    <c:otherwise>
        <div>
            할인 대상이 아닙니다.
        </div>
    </c:otherwise>
</c:choose>


</body>
</html>