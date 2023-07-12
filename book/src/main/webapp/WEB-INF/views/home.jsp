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
	
	<P>  The time on the server is ${requestScope.serverTime}. </P>
	<a href="/home">welcome -- 클릭해 주세요</a><br>
	<a href="/books">도서 목록 보기 1</a><br>
	<a href="/books/all">도서 목록 보기 2</a><br>
	<a href="/test/t1/ISBN-200">도서 정보 보기 1</a><br>
	<a href="/test/t2/에세이/publisher/대학문화사">도서 정보 보기 2</a><br>
	<a href="/books/IT서적">도서 정보 보기 3 - IT서적</a><br>
	<a href="/books/인문교양">도서 정보 보기 4 - 인문교양</a><br>
	<a href="/test/t3/ISBN-300;category=인문교양">도서 정보 보기 5 - 인문교양</a><br>
	<a href="/test/t5/ISBN-500;publisher=더조은/category/인문교양;publisher=아이티">도서 정보 보기 7 - 인문교양</a><br>
	<a href="/test/t6/ISBN-600">도서 정보 보기 8</a><br>
	<a href="/test/t7/ISBN-700;publisher=더조은;name=스프링/category/IT서적;publisher=아이티;author=아카데미">도서 정보 보기 9</a><br>
	<a href="/books/filter/bookFilter;publisher=한길사;category=인문교양" >출판사 및 도서분야로 검색하기 1</a><br>
	<a href="/books/filter/bookFilter;publisher=한빛아카데미;category=IT서적" >출판사 및 도서분야로 검색하기 2</a><br>
	<a href="/books/filter/bookFilter;publisher=이지스퍼블리싱;category=IT서적" >출판사 및 도서분야로 검색하기 3</a><br>
	
	<!-- 이지스퍼블리싱 출판사에 도서분야가 IT서적, 인문교양 두 개가 있다면 아래와 같이 작서하면 됨 --> 
	<a href="/books/filter/bookFilter;publisher=이지스퍼블리싱;category=IT서적,인문교양" >출판사 및 도서분야로 검색하기 4</a><br>
	<a href="/test/t8?id=ISBN-1234">도서 정보 보기 9</a><br><br>
	
	<a href="/test/regForm">회원가입하기</a><br>
	<a href="/books/regBook">도서등록하기</a><br><br>
	
	<a href="/test/t9">@ModelAttribute 메소드 수준에서 적용하기</a>
	</body>
</html>




