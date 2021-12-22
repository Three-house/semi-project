// JS 라이브러리 완성!

// 일반적으로 유효성 검사하는 것들

// 함수형태로 정리해서
// 나중에 필요할때 쓸라고(쓰기 편하게)
// .jar 라이브러리 쓰는 것 처럼

// <input>을 넣으면...
// 거기에 글자가 없으면 true 있으면 false

function isEmpty(input) {
	return !input.value; //값이 없다 (자바스크립트에서 empty == false (같다 but ===로 타입비교했을시 안됨))
}//값이 공백이면 투루 -> 투루면 콜함수로 넘어가서 아래 문 실행


// <input>랑 글자 수를 넣으면
// 그 글자 수 보다 적으면 true, 아니면 false

function lessThan(input, length) {
	return input.value.length < length ;
}

// <input>을 넣으면
// 한글/특수문자 들어있으면 true, 아니면 false

function containKR(input) {
	// 엠지
	//input.value = '엠지';

	let ok = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890@._"

	for (let i = 0; i < input.value.length; i++) {
		if (ok.indexOf(input.value[i]) == -1) {
			return true;
		}
	}
}
//  Test

// <input> x 2 넣으면
// 내용이 다르면 true, 아니면 false

function notEquals(input1, input2) {
	return input1.value != input2.value;

}

// <input>, 문자열세트
// 그 문자열 세트가 포함 안되있으면  true
// 들어있으면 false
// 비밀번호 조합

function notContains(input, set) {
	// input : 1qwerASD

	// set : 1234567890 숫자를 반드시 포함시키고 싶다
	// set : QWERTYUIOPASDFGHJKLZXCVBNM 대문자를 반드시 포함시키고 싶다

	for (let i = 0; i < set.length; i++) {
	
		if(input.value.indexOf(set[i]) != -1)
			return false;
	}
	return true;
}

// <input>을 넣어서
// 숫자가 아니면 true, 아니면 false

function isNotNumber(input) {
	return isNaN(input.value);
}





