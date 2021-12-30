function comDelete(n){
	let ok  = confirm('삭제하시겠습니까?');
	
	if(ok){
		location.href = 'ComDeleteC?no=' + n;
	}
}

function comSearch(){
	
	let searchInput = document.getElementById('search');
	let searchVal = searchInput.value;
	
	location.href = 'ComSearchC?search='+ searchVal;
}