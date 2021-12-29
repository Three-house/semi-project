function check() {

	let id = document.getElementById('id');
	let pw = document.getElementById('pw');
	let pww = document.getElementById('pww');
	let num2 = document.getElementById('num2');
	let num3 = document.getElementById('num3');
	let postAddr1 = document.getElementById('postAddr1');
	let postAddr2 = document.getElementById('postAddr2');
	let postAddr3 = document.getElementById('postAddr3');
	let idDuplication = document.getElementById('idDuplication');

	
// 아이디 (한글외 5자리이상)
if(isEmpty(id)) {
	alert('아이디 : 비어있습니다 확인해주세요!')
	id.focus();
	id.value = "";
	return false;
}
if(idDuplication != "idCheck") {
	alert('아이디 중복체크를 해주세요!');
	return false;
}
// 비밀번호 (대,소,수 포함 3자리 이상)
if(isEmpty(pw) || lessThan(pw,3) || notContains(pw, "1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM!@#$%^&*()_+~")) {
	alert('비밀번호 : 대문자, 소문자, 숫자 포함 3자리 이상 입력해주세요!');	
	pw.focus();
	pw.value = "";
	return false;
}
// 비밀번호(pw랑pww 비교)
if(notEquals(pw,pww)) {
	alert('비밀번호가 일치하지 않습니다!')
	
	pww.focus();
	pww.value = "";
	return false;
}
// 전화번호 2번째 자리(숫자 3자리이상)	
if(isNotNumber(num2) || lessThan(num2,3)) {
	alert('전화번호(중간) : 숫자만 3자리 이상 입력해주세요')
	
	num2.focus();
	num2.value = "";
	
	return false;
}
// 전화번호 3번째 자리(숫자 자리이상)	
if(isNotNumber(num3) || lessThan(num3,4)) {
	alert('전화번호(마지막) : 숫자만 4자리 이상 입력해주세요')
	
	num2.focus();
	num2.value = "";
	
	return false;
}
return true;
}

//--------------------------------------------------------------------------------
// 아이디 중복체크 화면 open
function openIdchk() {

	window.name = "parentForm";
	openWin = window.open("idcheckFrom.jsp?id="+document.getElementById('id').value,"chkForm","width=500, height=300, resizable=no, scrollbars=no");
	openWin.document.getElementById("userid").value = document.getElementById('id').value;
}

function inputIdchk() {
	document.myForm.idDuplication.value = "idUncheck";
}
//idcheckFrom.jsp에서 아이디 중복체크
function idCheck() {
	
	let id = document.getElementById('userid');
	document.write(id);
	
	if(isEmpty(id)) {
		alert('아이디를 입력하지 않았습니다.');
		return false;
	}else if(lessThan(id,5) || containKR(id)) {
		alert('한글 외 5자리이상 입력해주세요')
		return false;
	}
	return true;
}
// idcheckFrom.jsp 사용하기 클릭시 부모창으로 값 전달
function sendCheckvalue() {
	// 중복체크 결과인 idcheck 값을 전달한다.
	opener.document.myForm.idDuplication.value = "idCheck";
	// 회원가입 화면의 ID입력란에 값을 전달
	opener.document.myForm.id.value = document.myForm.idinput.value;
	
	if(opener != null) {
		opener.chkForm = null;
		self.close();
	}
}
