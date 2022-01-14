function salesReg(){
	
	let salesName = document.getElementById('salesName');
	let salesSort = document.getElementById('salesSort');
	let salesAddress = document.getElementById('salesAddress');
	let salesPrice = document.getElementById('salesPrice');
	let salesSize = document.getElementById('salesSize');
	let salesEtc = document.getElementById('salesEtc');
	let salesImg1 = document.getElementById('salesImg1');
	let salesImg2 = document.getElementById('salesImg2');
	let salesImg3 = document.getElementById('salesImg3');
	let salesContact = document.getElementById('salesContact');
	
	if(isEmpty(salesName)) {
	alert('건물명을 입력해주세요!');
	salesName.focus();
	salesName.value = "";
	return false;
}
	if(isEmpty(salesSort)) {
	alert('건물 종류를 입력해주세요!');
	salesSort.focus();
	salesSort.value = "";
	return false;
}
	if(isEmpty(salesAddress)) {
	alert('상세 주소를 입력해주세요!');
	salesSort.focus();
	salesSort.value = "";
	return false;
}
	if(isEmpty(salesPrice)) {
	alert('가격을 입력해주세요!');
	salesPrice.focus();
	salesPrice.value = "";
	return false;
}
if(isNotNumber(salesPrice)){
	alert('숫자만 입력해주세요!');
	salesSize.focus();
	salesSize.value = "";
	return false;
}

	if(isEmpty(salesSize)) {
	alert('크기를 입력해주세요!');
	salesSize.focus();
	salesSize.value = "";
	return false;
}
if(isNotNumber(salesSize)){
	alert('숫자만 입력해주세요!');
	salesSize.focus();
	salesSize.value = "";
	return false;
}
	if(isEmpty(salesEtc)) {
	alert('옵션을 입력해주세요!');
	salesEtc.focus();
	salesEtc.value = "";
	return false;
}
if(!lessThan(salesEtc,500)){
	alert('500자이내로 작성해주세요!');
	salesEtc.focus();
	salesEtc.value = "";
	return false;
}
	if(isEmpty(salesImg1)) {
	alert('사진1을 선택해주세요!');
	return false;
}
	if(isEmpty(salesImg2)) {
	alert('사진2를 선택해주세요!');
	return false;
}
	if(isEmpty(salesImg3)) {
	alert('사진3을 선택해주세요!');
	return false;
}
	if(isEmpty(salesContact)) {
	alert('연락처를 입력해주세요!');
	salesContact.focus();
	salesContact.value = "";
	return false;
}
	return true;
	
	
	
}

//세일즈 디테일 삭제
function salesDelete(n){
	let ok  = confirm('삭제하시겠습니까?');
	
	if(ok){
		location.href = 'SalesDeleteC?no=' + n;
	}
}