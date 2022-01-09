<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="CalculatorC" name="calc" onsubmit="return call();">
<table>
	<tr>
			<td>매물 종류</td>
			<td><input type="radio" name="sort" value="주택" id ="i1">주택 <input
				type="radio" name="sort" value="오피스텔" id ="i1">오피스텔 <input
				type="radio" name="sort" value="주택외부동산" id ="i1">주택 외 부동산</td>
	</tr>
		
	<tr>
			<td>보증금</td>
			<td>
			<input name="jeonse_deposit" placeholder="원" id="i2">
			<input type="hidden" name="deal_sort" value="${deal_sort}">
			</td>
	</tr>
	<tr>
			<td>협의 보수율</td>
			<td><input name="confer" placeholder="%" id="i3"></td>
	</tr>
	<tr>
			<td colspan="2">상한요율보다 높은 값을 적으면 상한요율이 적용됩니다.</td>
	</tr>
	<tr>
			<td colspan="2">
				<button>계산</button>
			</td>
	</tr>
	</table>
</form>
</body>
</html>