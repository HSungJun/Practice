<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>
<body>
	<form action="/write.board" method="post" id="form" name="form">
		<table border="1" width="500" height="400">

			<tr>
				<th align="center">자유게시판 글 작성하기</th>
			</tr>
			<tr> <td> 작성자 : <input type="text" name="writer" value="${sessionScope.loginId}"></td> </tr>
			<tr>
				<td><input type="text" size="100%" placeholder="글 제목을 입력하세요"
					id="title" name="title"></td>
			</tr>
			<tr>
				<td><textarea cols="100%" rows="20%" placeholder="글 내용을 입력해주세요"
						id="contents" name="contents"></textarea></td>
			</tr>

			<tr align="right">
				<td><input type="button" value="목록으로" id="toList"> <input
					type="submit" value="작성완료" id="complete"></td>
			</tr>

		</table>
	</form>
	<script>
		$("#toList").on("click", function() {
			location.href = "/list.board";
		});
	</script>

</body>
</html>