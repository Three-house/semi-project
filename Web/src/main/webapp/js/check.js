function check() {

	let id = document.getElementById('id');
	let pw = document.getElementById('pw');
	let pww = document.getElementById('pww');
	let num2 = document.getElementById('num2');
	let num3 = document.getElementById('num3');
	let postAddr1 = document.getElementById('postAddr1');
	let postAddr2 = document.getElementById('postAddr2');
	let postAddr3 = document.getElementById('postAddr3');

	
// 아이디 (한글외 5자리이상)
if(isEmpty(id)) {
	alert('아이디 : 한글 이외 5자리 이상 입력해주세요!')
	id.focus();
	id.value = "";
	return false;
}
if(isEmpty(pw)) {
	alert('비밀번호:')
	pw.focus();
	pw.value = "";
	return false;
}
return true;
}