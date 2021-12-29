<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/idcheckForm.css">
</head>
<body>
<div id="wrap">
	<br>
	<b> <font size="4" color="gray">아이디 중복체크</font> </b>
	<div style="border: 1px solid black; margin-top: 6px;"></div>
	<br>
	<div id="chk">
		<form action="CheckId" id="checkFrom">
			<input type="text" name="idinput" id="userid" value="${param.id}">
			<button>중복확인</button> <p>
			${r}
		</form>
		<div id="msg" style="margin-left: 20px">
		<br>
		<button id="cancelBtn" type="button" onclick="window.close()">취소</button> 
		<button id="useBtn" type="button" onclick="sendCheckvalue();">사용하기</button>
		</div>
	</div>
</div>
</body>
</html>