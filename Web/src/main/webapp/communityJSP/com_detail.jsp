<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
	<td>
	<h2 style = "font-family: 'Gowun Dodum', sans-serif;" align="center">게시글</h2>
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
		<tr style="background-color: #B1D0E0; font-weight:bold;">
			<td width="50px">${community.no }</td>
			<td width = "100px"> ${community.title }</td>
			<td width = "100px">${community.userId }</td>
			<td width = "100px">${community.date }</td>
		</tr>
		<tr>
			<td colspan = "4" height="400px;">
				<img src = "com_img/${community.img }">
			</td>
		</tr>
		<tr>
			<td colspan = "4" height="100px;">${community.content }</td>
		</tr>
	</table>
</td>
</tr>
<tr>
<td>
	<br>
	<form action="ReplyRegC" method = "post">
	<table id = "tbl_reply">
		<tr>
			<td colspan = "2" style ="font-weight: bold;" align="left"> &nbsp;&nbsp; 댓글 <hr> </td> 
		</tr>
		<tr>
			<td width = "90px;" style = "background-color : #e8e8e8; font-weight:bold;">작성자</td>
			<td><input  style = "font-family: 'Gowun Dodum', sans-serif;" id = "replyWriter" type = "text" name = "name" placeholder = "작성자" size="115"></td>
		</tr>
		<tr>
			<td style = "background-color : #e8e8e8; font-weight:bold;">내용</td>
			<td><textarea  style = "font-family: 'Gowun Dodum', sans-serif;" id = "replyContent" name = "content" placeholder = "댓글을 입력해주세요."></textarea></td>
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
		<c:forEach var = "r" items = "${repls }">
			<tr>
				<td class = "relist" style = "font-size : small; color : grey;" width = "10px">${r.re_no }</td>
				<td class = "relist" style = "font-weight : bold;" width = 250px">${r.re_name }</td>
				<td class = "relist" style = "font-size : small; color : grey;"><fmt:formatDate value="${r.re_date }" type="both" dateStyle="long" /></td>
				<td class = "relist" >
					<span  style = "font-size : small; color : grey;" onclick= "replyUpdate('${r.re_name }', '${r.re_content }','${r.re_no }')">수정</span> &nbsp; 
					<span  style = "font-size : small; color : grey;" onclick = "replyDelete(${r.re_no })">삭제</span>
				</td>
			</tr>
			<tr>
				
				<td id = "reCon" colspan = "4" style = "padding: 20px 0 20px 0;">${r.re_content }</td>
			</tr>
			<tr>
				<td colspan = "4" style = "background-color : white; "><br></td>
			</tr>
		</c:forEach>
	</table>
</td>
</tr>
</table>

</body>
</html>