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
<body>
	<table border=1 align=center>
		<tr>
			<th colspan=4>마이 페이지</th>
		</tr>
		<tr>
			<td>ID</td>
			<td>NAME</td>
			<td>PHONE</td>
			<td>EMAIL</td>
		</tr>
		<tr>
			<td>${id }</td>
			<td>${name }</td>
			<td>${phone }</td>
			<td>${email }</td>
		</tr>
	</table>
</body>
</html>