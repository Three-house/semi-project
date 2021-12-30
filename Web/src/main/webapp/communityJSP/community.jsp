<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>	
		
		<h2 style = "font-family: 'Jua', sans-serif" align = "center">커뮤니티</h2>
		<h4 style = "font-family: 'Jua', sans-serif" align = "center">${r }</h4>
		<p align = "right">
		<button onclick = "location.href = 'ComRegC'">글쓰기</button>
		</p>

	
		<table border = 1 id = "tbl_community">
			<thead>
				<tr>
					<th style = "font-family: 'Jua', sans-serif" align = "center">번호</th>
					<th style = "font-family: 'Jua', sans-serif" align = "center">작성자</th>
					<th style = "font-family: 'Jua', sans-serif" align = "center">제목</th>
					<th style = "font-family: 'Jua', sans-serif" align = "center">등록일</th>
				</tr>
			</thead>
			<c:forEach var = "c" items = "${communities }">
			<tr class = "com_tr1">
				<td class = "com_td1" onclick = "location.href = 'ComDetailC?num=${c.no}'">
					${c.no }
				<td class = "com_td1" onclick = "location.href = 'ComDetailC?num=${c.no}'">
					${c.userId }
				</td>
				<td class = "com_td1" onclick = "location.href = 'ComDetailC?num=${c.no}'">
					${c.title }
				</td>
				<td class = "com_td1" onclick = "location.href = 'ComDetailC?num=${c.no}'">
				<fmt:formatDate value="${c.date }"
					type = "date" dateStyle="long" />
				</td>
			</tr>
			</c:forEach>
		</table>
	
	<table>
		<tr>
			<td>
				<input id = "search" name = "search" placeholder="제목을 입력해주세요">
			</td>
			<td>
				<button onclick = "comSearch()">검색하기</button>
				<button onclick="location.href='ComC'">목록가기</button>
			</td>
		</tr>
	</table>
</body>
</html>