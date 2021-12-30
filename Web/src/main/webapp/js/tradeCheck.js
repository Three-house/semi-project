function call(){
	let i1 = document.calc.i1;
	let i2 = document.calc.i2;
	let i3 = document.calc.i3;
	
	if(isEmpty(i1)){
		alert('매물 종류를 선택해주세요');
		return false;
	}
	if(isEmpty(i2)){
		alert('금액을 적어주세요');
		return false;
	}
	if(notNumber(i2)){
		alert('숫자만 입력해주세요');
		return false;
	}
	if(isEmpty(i3)){
		alert('협의 보수율을 적어주세요');
		return false;
	}
	if(notNumber(i3)){
		alert('숫자만 입력해주세요');
		return false;
	}
}

function call2(){
	let i1 = document.calc.i1;
	let i2 = document.calc.i2;
	let i3 = document.calc.i3;
	let i4 = document.calc.i4;
	
	if(isEmpty(i1)){
		alert('매물 종류를 선택해주세요');
		return false;
	}
	if(isEmpty(i2)||isEmpty(i3)){
		alert('금액을 적어주세요');
		return false;
	}
	if(notNumber(i2)||notNumber(i3)){
		alert('숫자만 입력해주세요');
		return false;
	}
	if(isEmpty(i4)){
		alert('협의 보수율을 적어주세요');
		return false;
	}
	if(notNumber(i4)){
		alert('숫자만 입력해주세요');
		return false;
	}
	
}