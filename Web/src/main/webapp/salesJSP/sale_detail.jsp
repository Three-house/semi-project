<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table class="detailsalesTbl">
		<tr>
			<td>
				<table id="tbl_detailsales_head" >
					<tr>
						<td>
							<h2 style="font-family: 'Jua', sans-serif" align="center">매물
								상세보기</h2>
							<div id="detailsales_head_div"></div>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<h2 align="center"><${sales.name}></h2> 
				<table style="border-collapse: collapse" id="tbl_detailsalesview" border="1">
					<tr>
						<td>
						<img src="img/icon/facebook_icon.png" width="25px" id="detailsales_img" onclick="location.href='https://www.facebook.com/'">
						<img src="img/icon/call.png" width="25px"> <hr>
						>&nbsp;${sales.price} &nbsp;만원&nbsp;/&nbsp; ${sales.size} &nbsp; m²&nbsp;/&nbsp;${sales.condition}&nbsp; <hr>
						${sales.etc}
						</td>
					</tr>
				</table>
				<table id="tbl_detailsaleimg" border="1">
				<tr>
				<td> <img src="img/sales/${sales.img1}">  </td>
				</tr>
				<tr>
				<td> <img src="img/sales/${sales.img2}">  </td>
				</tr>
				<tr>
				<td> <img src="img/sales/${sales.img3}">  </td>
				</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<p align="right">
					<button onclick="history.back()">목록보기</button>
			</td>
		</tr>
	</table>





	<!--  매물용 댓글 DAO, DB 만들기 -->
	<!-- 댓글 보기 -->
	<!-- 댓글보이는 부분 -->



</body>
</html>