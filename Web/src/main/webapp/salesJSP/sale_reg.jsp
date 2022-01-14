<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="font-family: 'Gowun Dodum', sans-serif;">
	<table class="regsalesTbl">
		<tr>
			<td>
				<table id="tbl_regsales_head">
					<tr>
						<td>
							<h2 align="center">매물
								내놓기</h2>
							<div id="regsales_head_div"></div>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<form action="SalesRegC" method="post" enctype="multipart/form-data"
					onsubmit="return salesReg();">
					<table border=1 id="tbl_salesReg">
						<tr>
						<tr>
							<td id="regsalesTbl_td">건물명</td>
							<td><input name="buildingName" id="salesName"></td>
						</tr>
						<td id="regsalesTbl_td">거래 종류</td>
						<td><select name="condition" id="salesCondition">
								<option value="월세">월세</option>
								<option value="전세">전세</option>
								<option value="매매">매매</option>
						</select></td>
						</tr>
						<tr>
							<td id="regsalesTbl_td">건물종류</td>
							<td><input name="salesort" id="salesSort"></td>
						</tr>
						<tr>
							<td id="regsalesTbl_td">지역</td>
							<td><select name="location" id="salesLocation">
									<option value="서울">서울</option>
									<option value="경기도">경기도</option>
									<option value="충청도">충청도</option>
									<option value="경상도">경상도</option>
									<option value="전라도">전라도</option>
									<option value="제주도">제주도</option>
							</select></td>
						</tr>
						<tr>
							<td id="regsalesTbl_td">상세 주소</td>
							<td><input name="address" id="salesAddress" size=40></td>
						</tr>
						<tr>
							<td id="regsalesTbl_td">가격</td>
							<td><input name="price" placeholder="원/보증금은 옵션에 적어주세요."
								size=25 id="salesPrice"></td>
						</tr>
						<tr>
							<td id="regsalesTbl_td">크기</td>
							<td><input name="size" placeholder="㎡" id="salesSize"></td>
						</tr>
						<tr>
							<td id="regsalesTbl_td">옵션</td>
							<td><input name="etc" placeholder="500자 이내로 작성해주세요."
								id="salesEtc"></td>
						</tr>
						<tr>
							<td id="regsalesTbl_td">사진1</td>
							<td><input type="file" name="img1" id="salesImg1"></td>
						</tr>
						<tr>
							<td id="regsalesTbl_td">사진2</td>
							<td><input type="file" name="img2" id="salesImg2"></td>
						</tr>
						<tr>
							<td id="regsalesTbl_td">사진3</td>
							<td><input type="file" name="img3" id="salesImg3"></td>
						</tr>
						<tr>
							<td id="regsalesTbl_td">연락처</td>
							<td><input name="contact" id="salesContact"></td>
						</tr>
					</table>
					<table id="tbl_regsales_button">
						<tr>
							<td>
								<button>매물 등록</button>
							</td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
		<tr>
			<td>
				<p align="right">
					<button onclick="history.back()">목록보기</button>
			</td>
		</tr>
	</table>
</body>
</html>