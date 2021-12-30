<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2 style = "font-family: 'Jua', sans-serif" align = "center">글 등록하기</h2>
	<hr>
	
	<form action = "ComRegC" method = "post" enctype = "multipart/form-data">
		<table border = 1 id = "tbl_comReg">
			<tr>
				<td>제목</td>
				<td><input name = "title" required="required"></td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input name = "userId"></td>
			</tr>
			<tr>
				<td colspan = "2" align = "left">내용</td>
			</tr>
			<tr>
				<td colspan = "2">
					<textarea name = "content" required="required"></textarea>
				</td>
			</tr>
			<tr> 
				<td>파일</td>
				<td><input type = "file" name = "file"></td>
			</tr>
		</table>
					<p>
					<button>등록하기</button>
	</form>
	
	 <p align = "right">
	 <button onclick = "history.back()">목록보기</button>
	 </p>
	
</body>
</html>