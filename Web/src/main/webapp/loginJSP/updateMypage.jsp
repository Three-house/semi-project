<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode;
                document.getElementById("sample4_roadAddress").value = roadAddr;
                document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
         
                document.getElementById("sample4_engAddress").value = data.addressEnglish;
                       
                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                if(roadAddr !== ''){
                    document.getElementById("sample4_extraAddress").value = extraRoadAddr;
                } else {
                    document.getElementById("sample4_extraAddress").value = '';
                }

                var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            }
        }).open();
    }
</script>
</head>
<body>
<form action="UpdateAccountC" onsubmit="return check()" name="myForm">
	<table class="signupTbl">	
	<tr>
	 <td colspan="2"> <h1>&nbsp;&nbsp;내 정보 수정</h1> 
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
		<td> <input name="pw2" type="password"> <input name="pw" value="${sessionScope.accountInfo.pw}" type="hidden"> </td>
	</tr>
	<tr>
		<td>&nbsp;&nbsp;PW 확인</td>
		<td> <input name="pw2" type="password"> <input name="pw" value="${sessionScope.accountInfo.pw}" type="hidden"> </td>
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
		 <input name="num11" size="3" value="${sessionScope.accountInfo.num1}">-
		 <input name="num22" size="5" value="${sessionScope.accountInfo.num2}">-
		 <input name="num33" size="5" value="${sessionScope.accountInfo.num3}"> 
		 <input name="num1" size="3" value="${sessionScope.accountInfo.num1}" type="hidden">
		 <input name="num2" size="5" value="${sessionScope.accountInfo.num2}" type="hidden">
		 <input name="num3" size="5" value="${sessionScope.accountInfo.num3}" type="hidden"> 
	  </td>
	</tr>
	<tr>
		<td colspan="2" style="color: white;">-----------</td>
	</tr>
	<tr>
	 <td colspan="2"> &nbsp;&nbsp;주소 <p>
	 	<input type="text" id="sample4_postcode" placeholder="우편번호" name="postAddr11">
		<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기" style="cursor: pointer;"><br>
		<input type="text" id="sample4_roadAddress"  size="60" placeholder="도로명주소" name="postAddr22"><br>
		<input type="hidden" id="sample4_jibunAddress" placeholder="지번주소"  size="60">
		<span id="guide" style="color:#999;display:none"></span>
		<input type="text" id="sample4_detailAddress" placeholder="상세주소"  size="60" name="postAddr33"><br>
		<input type="hidden" id="sample4_extraAddress" placeholder="참고항목"  size="60">
		<input type="hidden" id="sample4_engAddress" placeholder="영문주소"  size="60" ><br>		
	 	<input name="postAddr1" type="hidden" value="${sessionScope.accountInfo.postAddr1}">
	 	<input name="postAddr2" type="hidden" value="${sessionScope.accountInfo.postAddr2}">
	 	<input name="postAddr3" type="hidden" value="${sessionScope.accountInfo.postAddr3}">
	 </td>
	</tr>
	<tr id="signupTr12">
	 <td colspan="2"> 
		<button value="${sessionScope.accountInfo.id}" name="id">확인</button>
	 </td>
	</tr>	
	</table>
</form>
</body>
</html>