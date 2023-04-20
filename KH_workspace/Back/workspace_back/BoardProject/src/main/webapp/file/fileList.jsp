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
			<th colspan="4">파일 목록</th>
			
		</tr>
		
		<tr>
			<td align=center width="200">seq</td>
			<td align=center width="200">oriName</td>
			<td align=center width="200">sysName</td>
			<td align=center width="200">parent_seq</td>
		</tr>
		
		<c:choose>
			<c:when test="${list!=null}">
				<c:forEach var="i" items="${list}">
					<tr>
						<td align="center">${i.seq}</td>
						<td align="center">${i.oriName}</td>
						<td align="center">${i.sysName}</td>
						<td align="center">${i.parent_seq}</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="4" align="center" height="300">
						표시할 내용이 없습니다.</td>
				</tr>
			</c:otherwise>
		</c:choose>
	
	</table>
</body>
</html>