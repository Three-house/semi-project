<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="UpdateAccountC" method="post">
	<table class="signupTbl" style="margin-bottom: 500px">	
	<tr>
	 <td colspan="2" id="mypageTd"> <h1>&nbsp;&nbsp;내 정보</h1> 
	 	  <div id="signupHead"></div>
	 </td>
	</tr>
	<tr>
		<td colspan="2" style="color: white;">-----------</td>
	</tr>
	<tr>
		<td id="mypageTd">&nbsp;&nbsp;이 름</td>
		<td>${sessionScope.accountInfo.name}</td>
	</tr>
		<tr>
		<td colspan="2" style="color: white;">-----------</td>
	</tr>
	<tr>
		<td id="mypageTd"> &nbsp;&nbsp;ID</td>
		<td>${sessionScope.accountInfo.id}</td>
	</tr>
		<tr>
		<td colspan="2" style="color: white;">-----------</td>
	</tr>
	<tr>
	  <td id="mypageTd">&nbsp;&nbsp;성별</td>
	  <td> ${sessionScope.accountInfo.sex}</td>
	</tr>
	<tr>
		<td colspan="2" style="color: white;">-----------</td>
	</tr>
	<tr>
	 <td id="mypageTd">&nbsp;&nbsp;전화번호</td>
	 <td> ${sessionScope.accountInfo.contact} </td>
	</tr>
	<tr>
		<td colspan="2" style="color: white;">-----------</td>
	</tr>
	<tr>
	 <td id="mypageTd"> &nbsp;&nbsp;주소 </td>
	 <td> ${sessionScope.accountInfo.addr} </td>
	</tr>
	<tr>
		<td colspan="2" style="color: white;">-----------</td>
	</tr>
	<tr id="signupTr12">
	<td></td>
	 <td> 
		<button>수정하기</button>
		<button type="button" onclick="deleteAccount('${sessionScope.accountInfo.id}')">탈퇴하기</button>
	 </td>
	</tr>	
	</table>
</form>
</body>
</html>