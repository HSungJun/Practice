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
	<table border='1' align='1'>
		<tr>
			<th colspan='3'>Message List
		</tr>
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>Contact</th>
		</tr>
		<c:forEach items="${list }" var="i">
			<tr>
				<td>${i.id }</td>
				<td>${i.name }</td>
				<td>${i.contact }</td>
			</tr>
		</c:forEach>

		<form action='modify' method='get'>
			<tr>
				<td colspan='3'><input type='text'
					placeholder='Input id to modify' name='modID'> <input
					type='text' placeholder='Input writer to modify' name='modName'>
					<input type='text' placeholder='Input message to modify'
					name='modContact'>
					<button type='submit'>Modify</button></td>
		</form>


		<!-- form action='delete' method='get' -->
			<tr>
				<td colspan='3'><input type='text' name='delid' id='delid' placeholder='input delete id'>
					<button id="delete">delete</button></td>
			</tr>
		<!-- /form -->
		
		<!--  form태그를 주지 않고 삭제. -->
		<!-- del 버튼의 id값 설정. > jquery로 이벤트 할당. -->
		
		<script>
			$("#delete").on("click",function(){
				let delid = $("#delid").val();
				location.href="delete?delid="+delid; 
			});
		</script>
		<!-- location.href 의 경우 데이터를 옮길 수 없지만 form태그 servlet중 get 방식을 흉내내어 보낼 수 있음.  -->
		
		
		<tr>
			<td colspan='3' align=center><a href="index.html">back</a>
		</tr>
	</table>
</body>
</html>