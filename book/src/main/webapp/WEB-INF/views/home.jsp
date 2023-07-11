<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<a href="/home">welcome -- 클릭해 주세요</a><br>
<a href="/books">도서 목록 보기 1</a><br>
<a href="/books/all">도서 목록 보기 2</a><br>
<a href="/test/t1/ISBN-200">도서 정보 보기 1</a><br>
<a href="/test/t2/에세이/publisher/대학문화사">도서 정보 보기 2</a><br>
<a href="/books/IT서적">도서 정보 보기 3 - IT서적</a><br>
<a href="/books/인문교양">도서 정보 보기 4 - 인문교양</a><br>
</body>
</html>
