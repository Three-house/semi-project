function check() {

	let id = document.myForm.id.value;	

	
// 아이디 (한글외 5자리이상)
if(id == "") {
	alert('아이디 : 한글 이외 5자리 이상 입력해주세요!')
	id.focus();
	return false;
}else if(pw == "") {
	alert('비밀번호 :')
	pw.focus();
	return false;
}

}