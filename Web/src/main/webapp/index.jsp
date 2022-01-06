<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Every House</title>
<link href="img/icon/home.png" rel="shortcut icon" type="image/x-icon">
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/home.css">
<link rel="stylesheet" href="css/signup.css">
<link rel="stylesheet" href="css/mypage.css">
<link rel="stylesheet" href="css/community.css">
<link rel="stylesheet" href="css/calculator.css">
<link rel="stylesheet" href="css/sales.css">
<script type="text/javascript" src="js/validCheck.js"></script>
<script type="text/javascript" src="js/go.js"></script>
<script type="text/javascript" src="js/check.js"></script>
<script type="text/javascript" src="js/tradeCheck.js"></script>
<script type="text/javascript" src="js/comments.js"></script>
<script type="text/javascript" src="js/community.js"></script>
</head>
<body>
	<div id="indexHeadDiv"></div>
	<table class="indexTbl">
	<tr id="indexTr1"> 
		<td width="700px">
			<img src="img/icon/everyhouse2.png" width="260px" height="75px" onclick="location.href='HC'" style="cursor: pointer;">
		</td>
		<td>
			<jsp:include page="${loginPage}"></jsp:include>
		</td> 
	</tr>
	<tr id="indexTr2"> 
		<td colspan="2">
			<div id="menu1"> <a onclick="location.href='MapC'"style="cursor: pointer">지도</a> </div>
			<div id="menu2"> <a onclick="location.href='ComC'"style="cursor: pointer">커뮤니티</a> </div>
			<div id="menu3"> <a onclick="location.href='salesC'" style="cursor: pointer">매물</a> </div>
			<div id="menu4"> <a onclick="location.href='CalmainC'"style="cursor: pointer">중개보수 계산</a> </div>
			<div id="menu5">나의 관심매물</div>
			<div id="menuLine"></div>
		</td> 
	</tr>
	<tr id="indexTr3"> 
		<td colspan="2">
			<jsp:include page="${contentPage}"></jsp:include>
		</td> 
	</tr>
	</table>
<div id="indexfootDiv">
 <div id="indexfoot_info_div">
 	♣ made by 노솔리, 이태림, 장하늬 <p>
 	 &nbsp;&nbsp; 기간 : 2021.12.14 - 2022.01.13
 </div>
</div>
</body>
</html>