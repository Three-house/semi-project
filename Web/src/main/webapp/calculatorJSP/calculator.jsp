<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" style="margin-bottom: 500px">
		<tr>
			<td colspan="2">복비 계산</td>
		</tr>
		<tr>
			<td>거래 종류</td>
			<td>
			<form action="Deal_sortC">
			<button name="deal_sort" value="매매">매매</button>
			<button name="deal_sort" value="전세">전세 임대차</button>
			<button name="deal_sort" value="월세">월세 임대차</button>
			</form>
			</td>
		</tr>
		<tr>
		<td colspan="2">
		<jsp:include page="${dealSortPage}"></jsp:include>
		</td>
		</tr>
		</table>
</body>
</html>