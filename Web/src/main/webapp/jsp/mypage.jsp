<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table class="signupTbl">	
	<tr>
	 <td colspan="2"> <h1>&nbsp;&nbsp;내 정보</h1> 
	 	  <div id="signupHead"></div>
	 </td>
	</tr>
	<tr>
		<td colspan="2" style="color: white;">-----------</td>
	</tr>
	<tr>
		<td>&nbsp;&nbsp;이 름</td>
		<td>${sessionScope.accountInfo.name}</td>
	</tr>
	<tr>
		<td> &nbsp;&nbsp;ID</td>
		<td>${sessionScope.accountInfo.id}</td>
	</tr>
	<tr>
		<td>&nbsp;&nbsp;PW</td>
		<td><input name="pw" type="password" value="${sessionScope.accountInfo.pw}"></td>
	</tr>
	<tr>
		<td>&nbsp;&nbsp;PW 확인</td>
		<td><input name="pw" type="password" value="${sessionScope.accountInfo.pw}"></td>
	</tr>
	<tr>
	<td>&nbsp;&nbsp;성별</td>
	 <td> ${sessionScope.accountInfo.sex}</td>
	</tr>
	<tr>
		<td colspan="2" style="color: white;">-----------</td>
	</tr>
	<tr>
	 <td>&nbsp;&nbsp;전화번호</td>
	 <td>
	 <input name="num1" size="3" value="${sessionScope.accountInfo.num1}">-
	 <input name="num2" size="5" value="${sessionScope.accountInfo.num2}">-
	 <input name="num3" size="5" value="${sessionScope.accountInfo.num3}"> </td>
	</tr>
	<tr>
		<td colspan="2" style="color: white;">-----------</td>
	</tr>
	<tr>
	 <td colspan="2"> &nbsp;&nbsp;주소 <p>
	 	<input type="text" id="sample4_postcode" value="${sessionScope.accountInfo.postAddr1}">
		<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
		<input type="text" id="sample4_roadAddress" placeholder="도로명주소" size="60" value="${sessionScope.accountInfo.postAddr2}"><br>
		<input type="hidden" id="sample4_jibunAddress" placeholder="지번주소"  size="60">
		<span id="guide" style="color:#999;display:none"></span>
		<input type="text" id="sample4_detailAddress" placeholder="상세주소"  size="60" value="${sessionScope.accountInfo.postAddr3}"><br>
		<input type="hidden" id="sample4_extraAddress" placeholder="참고항목"  size="60">
		<input type="hidden" id="sample4_engAddress" placeholder="영문주소"  size="60" ><br>		
	 </td>
	</tr>
	<tr id="signupTr12">
	 <td colspan="2"> 
		<button>수정하기</button>
	 </td>
	</tr>	
	</table>
</body>
</html>