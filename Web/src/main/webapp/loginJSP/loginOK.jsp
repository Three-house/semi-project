<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<form action="LoginC">
${sessionScope.accountInfo.name}님 반갑습니다! <p>
<button type="button" onclick="location.href='InfoAccountC'">내정보</button>
<button onclick="location.href='LoginC'">로그아웃</button>
</form>
</body>
</html>