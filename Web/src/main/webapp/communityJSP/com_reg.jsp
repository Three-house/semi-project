<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.tr.log.Account"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
HttpSession hs = request.getSession();
Account a = (Account) hs.getAttribute("accountInfo");
String id = a.getId();
%>

<table class="community_writeTbl">
<tr>
<td>
<h2 style = "font-family: 'Gowun Dodum', sans-serif;" align = "center">글 등록하기</h2>
<div id="com_write_head_div"></div>
</td>
</tr>
<tr>
<td>
	<form action = "ComRegC" method = "post" enctype = "multipart/form-data">
		<table border = 1 id = "tbl_comReg">
			<tr>
				<td style="background-color: #F5F5F5">제목</td>
				<td><input id = "regInput" name = "title" required="required" placeholder = "제목"></td>
			</tr>
			<tr>
				<td style="background-color: #F5F5F5">작성자</td>
				<td><input id = "regInput" name = "userId" placeholder = "작성자" value="<%=id%>"></td>
			</tr>
			<tr>
				<td colspan = "2" style="background-color: #F5F5F5">내용</td>
			</tr>
			<tr>
				<td colspan = "2" height="100px;">
					<textarea id = "comText" name = "content" required="required" placeholder = "내용을 입력해주세요."></textarea>
				</td>
			</tr>
			<tr height="40px;"> 
				<td style="background-color: #F5F5F5">파일</td>
				<td><input type = "file" name = "file"></td>
			</tr>
		</table>
					<p align="right">
					<button>등록하기</button>
					<button type="button" onclick = "history.back()">목록보기</button>
					</p>
	</form>
</td>
</tr>
</table>
</body>
</html>
