function replyUpdate(w, c, n){
	
	let w1 = prompt("이름을 수정해주세요", w);
	
	//n1이 null, 공백 X
	if(w1 != null && w1 != ''){
		
		let c1 = prompt('댓글을 수정해주세요', c);
		
		location.href = 'ReplyUpdateC?name='+ w1 + '&content=' + c1 + '&no=' + n;
	}
}

function replyDelete(n){
	
	let ok = confirm('삭제 하시겠습니까?');
	
	if(ok){
		location.href = 'ReplyDeleteC?no=' + n
	}
}

function saleReplyUpdate(w, c, n){
	
	let w1 = prompt("이름을 수정해주세요", w);
	
	//n1이 null, 공백 X
	if(w1 != null && n1 != ''){
		
		let c1 = prompt('댓글을 수정해주세요', c);
		
		location.href = 'SaleReplyUpdateC?name='+ w1 + '&content=' + c1 + '&no=' + n;
	}
}

function saleReplyDelete(n){
	let ok = confirm('삭제 하시겠습니까?');
	
	if(ok){
		location.href = 'SaleReplyDeleteC?no=' + n
	}
}