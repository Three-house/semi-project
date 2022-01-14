<%@page import="com.tr.log.Account"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function login_check() {
	alert('로그인 후 이용해주세요');
	return false;

}
</script>
</head>
<body style="font-family: 'Gowun Dodum', sans-serif;">
	<table class="communityTbl">
		<tr>
			<td>
				<table id="tbl_community_head">
					<tr>
						<td><h2 style = "font-family: 'Gowun Dodum', sans-serif;" align="center">커뮤니티</h2>
						<div id="com_head_div"></div>
						</td>
					</tr>
					<tr>
						<td>
							<p align="right">
<%
HttpSession hs = request.getSession();
if(hs.getAttribute("accountInfo") == null) {%>							
								<button onclick="return login_check()">글쓰기</button>
<%}else{ %>								
								<button onclick="location.href = 'ComRegC'">글쓰기</button>
<%} %>								
						</td>					
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<table border=1 id="tbl_community">
					<thead>
						<tr style="background-color: #B1D0E0">
							<th align="center" width="50px;">번호</th>
							<th align="center" width="70px;">작성자</th>
							<th align="center">제목</th>
							<th align="center" width="190px;">등록일</th>
						</tr>
					</thead>
					<c:forEach var="c" items="${communities }">
						<tr class="com_tr1" style="cursor: pointer;">
							<td class="com_td1"
								onclick="location.href = 'ComDetailC?num=${c.no}'">${c.no }
							
							<td class="com_td1"
								onclick="location.href = 'ComDetailC?num=${c.no}'">
								${c.userId }</td>
							<td class="com_td1"
								onclick="location.href = 'ComDetailC?num=${c.no}'">
								${c.title }</td>
							<td class="com_td1">
								<fmt:formatDate
										value="${c.date }" type="date" dateStyle="long" />
							</td>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
		<tr>
			<td>
													<c:choose>
								<c:when test="${curPageNo == 1 }">◀</c:when>
								<c:otherwise>
								<a href="CommunityPageC?p=${curPageNo - 1 }">◀</a>
								</c:otherwise>
								</c:choose>
							
								<c:forEach var = "p" begin = "1" end = "${pageCount }">
									<a href = "CommunityPageC?p=${p }"> ${p } </a>
								</c:forEach>
						
								<c:choose>
								<c:when test="${curPageNo == pageCount }">▶</c:when>
								<c:otherwise>
								<a href="CommunityPageC?p=${curPageNo + 1 }">▶</a>
								</c:otherwise>
								</c:choose>
			</td>
		</tr>
		<tr>
			<td>
				<table id="tbl_community_such">
					<tr>
						<td><input style = "font-family: 'Gowun Dodum', sans-serif;" id="search" name="search" placeholder="제목을 입력해주세요">
						</td>
						<td>
							<button onclick="comSearch()">검색하기</button>
							<button onclick="location.href='ComC'">목록가기</button>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>