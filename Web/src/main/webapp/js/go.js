function deleteAccount(i) {
	
	let ok = confirm('정말 탈퇴 하시겠습니까?')
	
	if(ok) {
		location.href = 'DeleteAccountC?id='+ i;		
	}
}