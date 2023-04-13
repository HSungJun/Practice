<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<style>
	#seq{display:none};
</style>
</head>
<body>
<form action="modify.board" method="post">
	<table border="1" width="500" height="400">

		<tr>
			<th colspan="3" align="center">자유게시판</th>
		</tr>
		<tr>
			<input type="text" id="seq" name="seq" value="${dto.seq }">
			<td colspan="2">작성자 : <input type="text" name="writer"
				value="${dto.writer }" readonly></td>
			<td align="right">조회수 : ${dto.view_count }</td>
		</tr>
		<tr>
			<td colspan="2">제목 : <input type="text" size="40%" id="title"
				name="title" value="${dto.title }" readonly>
			</td>
			<td align="right">작성일 :<fmt:formatDate value="${dto.write_date}"
					pattern="yy-MM-dd HH:mm" /></td>
		</tr>
		<tr>
			<td colspan="3"><textarea cols="100%" rows="20%" id="contents"
					name="contents" readonly>${dto.contents }</textarea></td>
		</tr>

		<tr align="right">
			<td colspan="3">
			<c:choose>
					<c:when test="${dto.writer eq id}">
						<input type="button" value="삭제" id="delete">
						<input type="button" value="수정" id="modify">
						<input type="submit" value="수정완료" id="modComplete" style="display:none">
					</c:when>
				</c:choose> 
				<input type="button" value="목록으로" id="toList"></td>
		</tr>

	</table>
</form>
	<script>
		$("#toList").on("click", function() {
			location.href = "/list.board";
		})
		
		$("#delete").on("click",function(){
			if(confirm("게시글을 정말로 삭제하시겠습니까?")){
				location.href="/delete.board";				
			}else{return false;}
		})
		
		$("#modify").on("click",function(){
			$("#modify").css('display','none');
			$("#delete").css('display','none');
			$("#toList").css('display','none');
			$("#modComplete").css('display','block');
			$("#title,#contents").removeAttr("readonly");
		})

	</script>

</body>
</html>