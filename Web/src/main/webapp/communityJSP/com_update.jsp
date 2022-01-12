<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table class="community_updateTbl">
<tr>
<td  align = "right">
	<button onclick = "location.href = 'ComC'">목록으로</button>
</td>
<tr>
<td>
<h2  style = "	font-family: 'Gowun Dodum', sans-serif; font-weight : bold;" align = center>글 수정</h2>
<div id="com_write_head_div"></div>
<br>
</td>
</tr>
<tr>
<td>
	<form action = "ComUpdateC" method = "post">	
	<table border = 1 id = "tbl_comUpdate">
		<tr style="background-color: #B1D0E0; font-weight: bold;">
			<td width="50px">${param.no}</td>
			<td width="100px"><input  id = "regInput" name = "title" value = "${param.title}"></td>
			<td width="100px">${param.id}</td>
			<td width="100px">${param.date}</td>
		</tr>
		<tr>
			<td colspan = "4"  height="400px;" style="text-align: center;">
				<img src = "com_img/${param.imgFile}">
			</td>
		</tr>
		<tr>
			<td colspan = "4">
				<textarea  id = "comText" name = "content">${param.contents}</textarea>
			</td>
		</tr>
	</table>
	<p align="right">
		<button name = "no" value = "${param.no }">수정 완료</button>
		</form>
</td>
</tr>
</table>	
</body>
</html>