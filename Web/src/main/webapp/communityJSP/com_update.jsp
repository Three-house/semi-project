<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<p align = "right">
	<button onclick = "location.href = 'ComC'">목록으로</button>
	</p>
	
	<form action = "ComUpdateC" method = "post">
	
	<h2 style = "font-family: 'Jua', sans-serif" align = "center">글 수정</h2>
	<hr>
	
	<table border = 1 id = "tbl_comUpdate">
		<tr>
			<td>${param.no}</td>
			<td><input name = "title" value = "${param.title}"></td>
		</tr>
		<tr>
			<td>${param.id}</td>
			<td>${param.date}</td>
		</tr>
		<tr>
			<td colspan = "2">
				<img src = "img/community/${param.imgFile}">
			</td>
		</tr>
		<tr>
			<td colspan = "2">
				<textarea name = "content">${param.contents}</textarea>
			</td>
		</tr>
	</table>
		<button name = "no" value = "${param.no }">수정 완료</button>
		</form>

	
</body>
</html>