<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table class="community_writeTbl">
<tr>
<td>
	<table id="tbl_community_write_head">
	<tr>
	<td><h2 style="font-family: 'Jua', sans-serif" align="center">글쓰기</h2>
	<div id="com_write_head_div"></div>
	</td>
	</tr>
	<tr>
	<td>
	<p align = "right">
	<button onclick = "history.back()">목록</button>
	<button onclick = "comDelete(${community.no});">삭제</button>
	<button onclick = "location.href = 'ComUpdateC?no=${community.no}&title=${community.title }&id=${community.userId }&imgFile=${community.img }&contents=${community.content }&date=${community.date }'">수정</button>
	</p>
	</td>
	</tr>		
	</table>
</td>
</tr>
<tr>
<td>
	<table border = 1 id = "tbl_comDetail">
		<tr>
			<td width="100px">${community.no }</td>
			<td> ${community.title }</td>
		</tr>
		<tr>
			<td>${community.userId }</td>
			<td>${community.date }</td>
		</tr>
		<tr>
			<td colspan = "2" height="400px;">
				<img src = "img/community/${community.img }">
			</td>
		</tr>
		<tr>
			<td colspan = "2" height="100px;">${community.content }</td>
		</tr>
	</table>
</td>
</tr>
<tr>
<td>
	<table id="tbl_com_comment">
	<tr>
	<td>
	<h3  style = "font-family: 'Jua', sans-serif" onclick = "location.href = 'cmt.jsp'">댓글보기</h3>
	<hr>
	<p align = "right">
	<button onclick = "history.back()">목록</button>
	</p>
	</td>
	</tr>
	</table>
</td>
</tr>
</table>
</body>
</html>