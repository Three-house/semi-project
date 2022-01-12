<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table class="salesTbl">
		<tr>
			<td>
				<table id="tbl_sales_head">
					<tr>
						<td><h2 style="font-family: 'Jua', sans-serif" align="center">매물</h2>
							<div id="sales_head_div"></div></td>
					</tr>
					<tr>
						<td>
							<p align="right">
								<button onclick="location.href = 'SalesRegC'">매물 내놓기</button>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		
		<tr>
			<td><c:forEach var="s" items="${sales}">
					<table id="tbl_salesview">
						<tr>
							<td>
								<table border="1" id="tbl_salesview">
									<tr>
										<td width="200px;"><img src="salesimg/${s.img1}" width="200px">
										</td>
										<td>
											<!-- 건물 이름 --> <h2>${s.name}</h2>${s.location} 
											<hr> <!-- 가격, 평수 -->>&nbsp;${s.price} &nbsp;
											만원&nbsp;/&nbsp; ${s.size} &nbsp; m²&nbsp;/&nbsp;${s.condition}&nbsp; 
											<img src="img/icon/상세보기.png" onclick="location.href='SalesDetailC?num=${s.num}'"id="salesviewImg">											
											<hr> > 기타&옵션
											<p>${s.etc}
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</c:forEach></td>
		</tr>
	</table>
	<button onclick="location.href = 'salesC'">돌아가기</button>
</body>
</html>