<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>할인대상 판별</h1>



<%
    // JSP를 작성하는 법.
    // <% 를 이용해서 HTML 코드와 JAVA 코드를 구분.
    // <% 표현을 스크립틀릿이라고 부름.
    // 추후 스크립틀릿으로 감싸여진 부분은 서블릿으로 변환할 때 일반 자바코드로 들어가고
    // HTML 코드는 out.write()로 변환되는 방식
    int age = 77;
%>
<% if(age < 20 || age > 59) { %>
    <div>
        할인 대상입니다.
    </div>
<% } else { %>
    <div>
        할인 대상이 아닙니다.
    </div>
<% } %>

</body>
</html>