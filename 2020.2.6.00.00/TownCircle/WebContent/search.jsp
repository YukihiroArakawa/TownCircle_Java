<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
	<head>
        <!--スタート　登録　サークル一覧(3個程度表示できるように)-->
        <title>タウンサークル/結果</title>
        <style type="text/css">
                @import url("../towncircle.css");
        </style>
                <meta name="viewport" content="width=device-width,initial-scale=1">
        <meta name="format-detection" content="telephone=no">
        <link href="https://fonts.googleapis.com/css?family=Kosugi+Maru|M+PLUS+Rounded+1c&display=swap&subset=japanese" rel="stylesheet">
    </head>
    <header class="header">
        <a href="/TownCircle/town/index">
        <img src="../whitelogo.png" height="90">
        </a>
    </header>
    <body class="body" bgcolor="#243552">
		<c:forEach items="${resultList}" var="dto">
		<div class="box">
			<p class="img1"><img src="../image/<c:out value="${dto.name}"></c:out>.png" height="150"></p>
			<p class="mozi1"><c:out value="${dto.name}" /></p>
		<table class="table1">
		  <tbody>
		<!--	<tr>
			<td>マッチ度</td>
			<td>❤️❤️❤️</td>
		    </tr>	-->
		    <tr>
			<td>紹介文</td>
			<td><c:out value="${dto.intro}" /></td>
		    </tr>
		    <tr>
			<td>男女比</td>
			<td><c:out value="${dto.menWomenText}" /></td>
		    </tr>
		    <tr>
			<td>活動比率</td>
			<td><c:out value="${dto.frequencyText}" /></td>
		    </tr>
		    <tr>
			<td>カップル率</td>
			<td><c:out value="${dto.loveText}" /></td>
		    </tr>
		    <tr>
			<td>喫煙率</td>
			<td><c:out value="${dto.smokerText}" /></td>
		    </tr>
		    <tr>
			<td>入会費</td>
			<td><c:out value="${dto.feeText}" /></td>
		    </tr>
			<tr>
			<td>SNS</td>
			<td><a href='<c:out value="${dto.link}"></c:out>'><c:out value="${dto.link}"></c:out></a>
			</td>
		    </tr>
	    </tbody>
	  </table>
		</div>
		</c:forEach>
		<div><a href="/TownCircle/town/index" class="btn2">スタートに戻る</a></div>
    </body>
</html>