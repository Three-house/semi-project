<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				<table id="tbl_calculator_head">
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
				<table border="1" id="tbl_calculator_cal">
					<tr>
						<td colspan="2" style="background-color: #B1D0E0" height="40px;">복비 계산</td>
					</tr>
					<tr>
						<td style="background-color: #B1D0E0">거래 종류</td>
						<td>
							<form action="Deal_sortC">
								<button name="deal_sort" value="매매">매매</button>
								<button name="deal_sort" value="전세">전세 임대차</button>
								<button name="deal_sort" value="월세">월세 임대차</button>
							</form>
						</td>
					</tr>
					<tr>
						<td colspan="2"><jsp:include page="${dealSortPage}"></jsp:include>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>