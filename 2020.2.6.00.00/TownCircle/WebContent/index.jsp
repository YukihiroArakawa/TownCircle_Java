<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>



<head>
        <!--スタート　登録　サークル一覧(3個程度表示できるように)-->
        <title>タウンサークル</title>
        <style type="text/css">
                @import url("../towncircle.css");
        </style>
        <meta name="viewport" content="width=device-width,initial-scale=1">
        <meta name="format-detection" content="telephone=no">
        <link href="https://fonts.googleapis.com/css?family=Kosugi+Maru|M+PLUS+Rounded+1c&display=swap&subset=japanese" rel="stylesheet">
    </head>
    <header class="header">
        <a href="start.html">
        </a>
    </header>
    <body class="body" bgcolor="#c35b14">
	<div class="wrapper">
		<div class="container">
      <br>
	  <br>
	  <br>
	  <br>
	  <br>
		<img src="../whitelogo.png" height="280" >
	   <br>
        <div class="start">
            <a href="/TownCircle/town/input" class="btn">サークル検索</a>
            <a href="../circleRegister.jsp" class="btn">サークル登録</a>
            <!--余裕があれば下に変える
            <a href="regist.html" class="btn">新規登録</a>
            <a href="login.html" class="btn">ログイン</a>→search.htmlに移動
            -->
        </div>
		</div>
		</div>
		<footer class="footer">
	<br>
	<p>©︎Yukki Gundan</p>
		</footer>
		</div>
    </body>



</html>