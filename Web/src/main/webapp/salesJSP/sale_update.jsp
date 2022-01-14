<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
function salesCheck() {
	let salesImg1 = document.getElementById('salesImg1');
	let salesImg2 = document.getElementById('salesImg2');
	let salesImg3 = document.getElementById('salesImg3');
	
	if(isEmpty(salesImg1)) {
		alert('사진1 : 파일선택을 해주세요!')
		return false;
	}
	if(isEmpty(salesImg2)) {
		alert('사진2 : 파일선택을 해주세요!')
		return false;
	}
	if(isEmpty(salesImg3)) {
		alert('사진3 : 파일선택을 해주세요!')
		return false;
	}
	return true;
}
</script>
<body style="font-family: 'Gowun Dodum', sans-serif;">
	<table class="regsalesTbl">
		<tr>
			<td>
				<table id="tbl_regsales_head">
					<tr>
						<td>
							<h2 align="center">매물
								정보 수정</h2>
							<div id="regsales_head_div"></div>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<form action="SalesUpdateC?num=${sales.num}" method="post"
					enctype="multipart/form-data" onsubmit="return salesCheck()">
					<table border=1 id="tbl_salesReg">
						<tr>
						<tr>
							<td id="regsalesTbl_td">건물명</td>
							<td><input name="buildingName" id="salesName"
								value="${sales.name}"></td>
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
							<td><input name="salesort" id="salesSort"
								value="${sales.salesort}"></td>
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
							<td><input name="address" id="salesAddress" size=40
								value="${sales.address}"></td>
						</tr>
						<tr>
							<td id="regsalesTbl_td">가격</td>
							<td><input name="price" placeholder="원/보증금은 옵션에 적어주세요."
								size=25 id="salesPrice" value="${sales.price}"></td>
						</tr>
						<tr>
							<td id="regsalesTbl_td">크기</td>
							<td><input name="size" placeholder="㎡" id="salesSize"
								value="${sales.size}"></td>
						</tr>
						<tr>
							<td id="regsalesTbl_td">옵션</td>
							<td><input name="etc" placeholder="500자 이내로 작성해주세요."
								id="salesEtc" value="${sales.etc}"></td>
						</tr>
						<tr>
							<td id="regsalesTbl_td">사진1</td>
							<td><img src="sales_img/${sales.img1}" width="200px"><br>
								<input type="file" name="img1" id="salesImg1" value="${img1}"></td>
						</tr>
						<tr>
							<td id="regsalesTbl_td">사진2</td>

							<td><img src="sales_img/${sales.img2}" width="200px"><br>
								<input type="file" name="img2" id="salesImg2" value="${img2}"></td>
						</tr>
						<tr>
							<td id="regsalesTbl_td">사진3</td>

							<td><img src="sales_img/${sales.img3}" width="200px"><br>
								<input type="file" name="img3" id="salesImg3" value="${img3}"></td>
						</tr>
						<tr>
							<td id="regsalesTbl_td">연락처</td>
							<td><input name="contact" id="salesContact"
								value="${sales.contact}"></td>
						</tr>
					</table>
					<table id="tbl_regsales_button">
						<tr>
							<td>
								<button onclick="history.back()">목록보기</button>
								<button>수정</button>
							</td>
						</tr>
					</table>
				</form>
</body>
</html>