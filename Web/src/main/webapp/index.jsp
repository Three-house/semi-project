<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Every House</title>
<link href="img/icon/home.png" rel="shortcut icon" type="image/x-icon">
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/signup.css">
<link rel="stylesheet" href="css/mypage.css">
<script type="text/javascript" src="js/go.js"></script>
<script type="text/javascript" src="js/check.js"></script>
<script type="text/javascript" src="js/validCheck.js"></script>
</head>
<body>
	<div id="indexHeadDiv"></div>
	<table class="indexTbl" >
	<tr id="indexTr1"> 
		<td width="700px">
			<img src="img/icon/everyhouse2.png" width="260px" height="60px" onclick="location.href='HC'" style="cursor: pointer;">
		</td>
		<td>
			<jsp:include page="${loginPage}"></jsp:include>
		</td> 
	</tr>
	<tr id="indexTr2"> 
		<td colspan="2">
			<div id="menu1">지도</div>
			<div id="menu2">커뮤니티</div>
			<div id="menu3">매물</div>
			<div id="menu4">중개보수 계산</div>
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
</body>
</html>