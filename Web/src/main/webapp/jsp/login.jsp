<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="LoginC" method="post">
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
		<td><input name="id"></td>
	</tr>
	<tr>
		<td>&nbsp;&nbsp;PW</td>
		<td><input name="pw"></td>
	</tr>
	<tr>
		<td colspan="2" style="color: white; height: 60px;">-----------</td>
	</tr>
	<tr id="signupTr12">
	 <td colspan="2"> 
		<button>로그인</button>
		<button type="button" onclick="location.href='SignUpC'">회원가입</button>
	 </td>
	</tr>	
	</table>
</form>
</body>
</html>