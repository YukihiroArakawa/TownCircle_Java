<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<title>マッチング後のサークル一覧</title>
</head>
<body>
	<table class="table table-bordered">
		<tr>
			<th>サークル名</th>
			<th>活動場所</th>
			<th>カテゴリー</th>
			<th>男女比率</th>
			<th>活動頻度/週</th>
			<th>イベント頻度/月</th>
			<th>カップル率</th>
			<th>陰陽キャ指標</th>
			<th>年会費</th>
			<th>喫煙者率</th>
		</tr>
		<c:forEach items="${list}" var="circle">
			<tr>
				<td><c:out value="${circle.name}" /></td>
				<td><c:out value="${circle.place}" /></td>
				<td><c:out value="${circle.category}" /></td>
				<td><c:out value="${circle.menWomen}" /></td>
				<td><c:out value="${circle.frequency}" /></td>
				<td><c:out value="${circle.event}" /></td>
				<td><c:out value="${circle.love}" /></td>
				<td><c:out value="${circle.indoorOutdoor}" /></td>
				<td><c:out value="${circle.fee}" /></td>
				<td><c:out value="${circle.smoker}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>