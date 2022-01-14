<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="font-family: 'Gowun Dodum', sans-serif;">


	<table class="detailsalesTbl">
		<tr>
			<td>
				<table id="tbl_detailsales_head" >
					<tr>
						<td>
							<h2 align="center">매물
								상세보기</h2>
							<div id="detailsales_head_div"></div>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<p align="right">
					<button onclick="history.back()">목록보기</button>
					<button onclick = "salesDelete(${sales.num});">삭제</button>
					<button onclick="location.href='SalesUpdateC?num=${sales.num}'">수정</button>
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
						>&nbsp;<fmt:formatNumber value="${sales.price}" pattern="#,###"/> 만원&nbsp;/&nbsp; ${sales.size} m²&nbsp;/&nbsp;${sales.condition}&nbsp;/&nbsp;${sales.location} <hr>
						${sales.etc}<hr>
						연락처 : ${sales.contact}
						</td>
					</tr>
				</table>
				<table id="tbl_detailsaleimg" style="text-align: center;">
				<tr>
				<td> <img src="sales_img/${sales.img1}">  </td>
				</tr>
				<tr>
				<td> <img src="salesimg/${sales.img2}">  </td>
				</tr>
				<tr>
				<td> <img src="salesimg/${sales.img3}">  </td>
				</tr>
				</table>
			</td>
		</tr>
		<tr>
		<td>
	<form action="SaleReplyRegC" method = "post">
	<table id = "tbl_reply">
		<tr>
			<td colspan = "2" style ="font-weight: bold;" align="left"> &nbsp;&nbsp; 댓글 <hr> </td> 
		</tr>
		<tr>
			<td width = "90px;" style = "background-color : #e8e8e8; font-weight:bold;">작성자</td>
			<td><input id = "replyWriter" type = "text" name = "name" placeholder = "작성자" size="100"></td>
		</tr>
		<tr>
			<td style = "background-color : #e8e8e8; font-weight:bold;">내용</td>
			<td><textarea id = "replyContent" name = "content" placeholder = "댓글을 입력해주세요."></textarea></td>
		</tr>
		<tr>
			<td colspan = "2">
				<button>댓글 등록</button>
				<!-- <input id = "replyReset" type = "reset" value = "다시쓰기"> -->
				<button id = "replyReset" type="reset" value="다시쓰기">다시쓰기</button>
			</td>
		</tr>
	</table>
	</form>
		</td>
		</tr>
		
		<tr>
		<td>
	<!-- 댓글 리스트 -->
	<table id = "replyList" >
		<c:forEach var = "s" items = "${saleReplies}">
			<tr align="center">
				<td class = "relist" style = "font-size : small; color : grey;" width = "30px">${s.s_no }</td>
				<td class = "relist" style = "font-weight : bold;" width = 250px">${s.s_name }</td>
				<td class = "relist" style = "font-size : small; color : grey;"><fmt:formatDate value="${s.s_date }" type="both" dateStyle="long" /></td>
				<td class = "relist">
					<span  style = "font-size : small; color : grey;  cursor: pointer;" onclick = "saleReplyUpdate('${s.s_name }', '${s.s_content }','${s.s_no }')">수정</span> 
					<span  style = "font-size : small; color : grey;  cursor: pointer;" onclick = "saleReplyDelete(${s.s_no })">삭제</span>
				</td>
			</tr>
			<tr>
				
				<td  id = "reCon" colspan = "4" style = "padding: 20px 0 20px 0;">${s.s_content }</td>
			</tr>
			<tr>
				<td colspan = "4" style = "background-color : white; "><br></td>
			</tr>
		</c:forEach>
	</table>
		</td>
		</tr>
	</table>




	<!--  매물용 댓글 DAO, DB 만들기 -->
	<!-- 댓글 보기 -->
	<!-- 댓글보이는 부분 -->



</body>
</html>