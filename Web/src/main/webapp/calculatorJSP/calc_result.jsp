<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table class="calculatorTbl">
		<tr>
			<td>
				<table>
					<tr>
						<td>
							<h2 style="font-family: 'Jua', sans-serif" align="center">중개보수
								계산</h2>
							<div id="com_write_head_div"></div>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<table border="1" id="tbl_calculator_result">
					<tr>
						<td style="background-color: #B1D0E0">복비 계산 결과</td>
					</tr>
					<tr>
						<td>거래 종류 : ${result.deal_sort} 매물 종류 : ${result.sort}</td>
					</tr>
					<tr>
						<td>최대 중개 보수 :<fmt:formatNumber type="currency">${result.result}</fmt:formatNumber><br>
							계산식 :<fmt:formatNumber type="currency"> ${result.price}</fmt:formatNumber>
							x ${result.confer} / 100
						</td>
					</tr>
					<tr>
						<td>협의/상한 효율 : ${result.confer}</td>
					</tr>
					<tr>
						<td>거래 금액 :<fmt:formatNumber type="currency"> ${result.price}</fmt:formatNumber>
						</td>
					</tr>
					<tr>
						<td>
							<button onclick="location.href='CalmainC'">돌아가기</button>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>