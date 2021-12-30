<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="LoginC" method="post"  name="loginForm">
	<table class="signupTbl" style="margin-bottom: 500px">	
	<tr>
	 <td colspan="2"> <h1>&nbsp;&nbsp;로그인</h1> 
	 	  <div id="signupHead"></div>
	 </td>
	</tr>
	<tr>
		<td colspan="2" style="color: white;">-----------</td>
	</tr>
	<tr>
		<td> &nbsp;&nbsp;ID</td>
		<td><input name="id" required="required"></td>
	</tr>
	<tr>
		<td>&nbsp;&nbsp;PW</td>
		<td><input name="pw" required="required"></td>
	</tr>
	<tr>
		<td colspan="2" style="color: white; height: 60px;">-----------</td>
	</tr>
	<tr id="signupTr12">
	 <td></td>
	 <td> 
		<button style="margin-left:190px">로그인</button>
		<button type="button" onclick="location.href='SignUpC'" >회원가입</button>
	 </td>
	</tr>	
	</table>
</form>
</body>
</html>