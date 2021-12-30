<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1" style="margin-bottom: 500px">
		<tr>
			<td>복비 계산 결과</td>
		</tr>
		<tr>
			<td>
			거래 종류 : ${result.deal_sort} 매물 종류 : ${result.sort}
			</td>
		</tr>
		<tr>
		<td>
		최대 중개 보수 :<fmt:formatNumber type="currency">${result.result}</fmt:formatNumber><br>
		계산식 :<fmt:formatNumber type="currency"> ${result.price}</fmt:formatNumber> x ${result.confer} / 100	
		</td>
		</tr>
		<tr>
		<td>
		협의/상한 효율 : ${result.confer}
		</td>
		</tr>
		<tr>
		<td>
		거래 금액 :<fmt:formatNumber type="currency"> ${result.price}</fmt:formatNumber>
		</td>
		</tr>
		<tr>
		<td>
		<button onclick="location.href='CalmainC'">돌아가기</button>
		</td>
		</tr>
		</table>
</body>
</html>