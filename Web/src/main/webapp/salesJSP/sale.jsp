<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
						<td><h2  style = "font-family: 'Gowun Dodum', sans-serif;" align="center">매물</h2>
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
			<td>
			<form action="salesSearchC" onsubmit="return search();">
				<table border="1" id="tbl_salesSuch">
					<tr>
						<td colspan="5" style="background-color: #B1D0E0">매물 검색</td>
					</tr>
					<tr style="background-color: #B1D0E0">
						<td>지역</td>
						<td>가격</td>
						<td>거래 유형</td>
						<td>검색</td>
						<td rowspan="2" style="text-align: center;">
							<button name="searchEvery">검색하기</button>
						</td>
					</tr>
					<tr>
						<td><select name="region">
								<option value="seoul">서울</option>
								<option value="gyeonggido">경기도</option>
								<option value="chungcheongdo">충청도</option>
								<option value="gyeongsangdo">경상도</option>
								<option value="jeollado">전라도</option>
								<option value="jejudo">제주도</option>
						</select></td>
						<td><select name="priceHouse">
								<option value="zero">0만원 ~ 100만원</option>
								<option value="hundred">100만원 ~ 300만원</option>
								<option value="threehun">300만원 ~ 600만원</option>
								<option value="sixhun">600만원 ~ 1000만원</option>
								<option value="tenmillion">1000만원 ~ 1억원</option>
								<option value="hundredmillion">1억원 ~</option>
						</select></td>
						<td><select name="TypeofSale">
								<option value="lease">전세</option>
								<option value="monthlyRent">월세</option>
								<option value="sale">매매</option>
						</select></td>
						<td><input name="searchRoom" id="searchi1" placeholder="매물의 이름을 입력해주세요."></td>
					</tr>
				</table>
			</form>
			</td>
		</tr>
		<tr>
			<td><c:forEach var="s" items="${sales}">
					<table id="tbl_salesview">
						<tr>
							<td>
								<table border="1" id="tbl_salesview">
									<tr>
										<td width="200px;"><img src="sales_img/${s.img1}" width="200px">
										</td>
										<td>
											<!-- 건물 이름 --> <h2>${s.name}</h2>${s.location} 
											<hr> <!-- 가격, 평수 -->>&nbsp;<fmt:formatNumber value="${s.price}" pattern="#,###"/> 만원
											&nbsp;/&nbsp; ${s.size} &nbsp; m²&nbsp;/&nbsp;${s.condition}&nbsp; 
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
	<tr>
	<td align="center">
		<a href="SalesPageC?p=1" id="salesPaging">[맨앞으로]</a>
		<c:forEach var="p" begin="1" end="${pageCount}">
			<a href="SalesPageC?p=${p}" id="salesPaging">[${p}]</a>
		</c:forEach>
		<a href="SalesPageC?p=${pageCount}" id="salesPaging">[맨뒤로]</a>
	</td>
	</tr>
	</table>
	
</body>
</html>