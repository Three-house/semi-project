<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table class="homeTbl">
		<tr width="800px;" align="center">
			<td colspan="4" height="250px;"><img src="img/bener/배너.png" height="300px"
				width="700px;"></td>
		</tr>
		<tr>
			<c:forEach var="i" items="${salesfour }">
				<td id="homeTbl_td" >
					<table id="home_sales_tbl" border="1" onclick="location.href='SalesDetailC?num=${i.num}'">
						<tr height="200px">
							<td><img src="salesimg/${i.img1 }"  width=""></td>
						</tr>
						<tr style="font-size: 12px;">
							<td>${i.name } / 
							<fmt:formatNumber value="${i.price}" pattern="#,###"/> 만원
							</td>
						</tr>
					</table>
				</td>
			</c:forEach>
		</tr>
		<tr>
			<td colspan="4" height="25px;" align="center">
				<button style="font-size: 8px;" onclick="location.href='salesC'">매물보러가기</button>
			</td>
		</tr>
		<tr><td colspan="4" style="color: white;">------</td></tr>
	</table>
</body>
</html>