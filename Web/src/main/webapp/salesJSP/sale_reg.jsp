<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table class="regsalesTbl">
<tr>
<td>
<table id="tbl_regsales_head">
<tr>
<td>
<h2 style = "font-family: 'Jua', sans-serif" align = "center">매물 내놓기</h2>
<div id="regsales_head_div"></div>
</td>
</tr>
</table>
</td>
</tr>
<tr>
<td>
	<form action = "SalesRegC" method = "post" enctype = "multipart/form-data">
		<table border = 1 id = "tbl_salesReg">
			<tr>
			<tr>
				<td id="regsalesTbl_td">건물명</td>
				<td><input name = "buildingName"></td>
			</tr>
				<td id="regsalesTbl_td">거래 종류</td>
				<td>
					월세<input type = "checkbox" name = "condition" value = "월세">
					전세<input type = "checkbox" name = "condition" value = "전세">
					매매<input type = "checkbox" name = "condition" value = "매매">
				</td>
			</tr>
			<tr>
				<td id="regsalesTbl_td">건물종류</td>
				<td> <input name="salesort"> </td>
			</tr>
			<tr>
				<td id="regsalesTbl_td">지역</td>
				<td><select name="location">
						<option value="서울">서울</option>
						<option value="경기도">경기도</option>
						<option value="충청도">충청도</option>
						<option value="경상도">경상도</option>
						<option value="전라도">전라도</option>
						<option value="제주도">제주도</option>
					</select></td>
			</tr>
			<tr>
				<td id="regsalesTbl_td">가격</td>
				<td><input name = 'price'></td>
			</tr>
			<tr>
				<td id="regsalesTbl_td">평수</td>
				<td><input name = 'size'></td>
			</tr>
			<tr>
				<td id="regsalesTbl_td">옵션</td>
				<td><input name = 'etc'></td>
			</tr>
			<tr> 
				<td id="regsalesTbl_td">사진1</td>
				<td><input type = "file" name = "img1"></td>
			</tr>
			<tr> 
				<td id="regsalesTbl_td">사진2</td>
				<td><input type = "file" name = "img2"></td>
			</tr>
			<tr> 
				<td id="regsalesTbl_td">사진3</td>
				<td><input type = "file" name = "img3"></td>
			</tr>
			<tr>
				<td id="regsalesTbl_td">연락처</td>
				<td><input name = "contact"></td>
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
<button onclick = "history.back()">목록보기</button>
</td>
</tr>
</table>
</body>
</html>