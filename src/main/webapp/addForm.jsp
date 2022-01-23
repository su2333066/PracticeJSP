<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>주소록 등록</h1>
    <form action="http://localhost:9010/addr/add">
        <div>
            이름 : <input type="text" name="name"><br />
            주소 : <input type="text" name="address"><br />
            번호 : <input type="text" name="phone"><br />
        </div>
        <br />
        <input type="submit" value="주소록 등록" />
    </form>
</body>
</html> 