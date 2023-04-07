<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script  src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>
<style>
	.container{margin:auto}
</style>
<body>
	
	<div class="container">
	<c:choose>
		<c:when test="${result==true}"> 입력한 아이디는 중복입니다. </c:when>
		<c:otherwise> 입력한 아이디 사용 가능. </c:otherwise>
	</c:choose>
	</div>
	
</body>
</html>