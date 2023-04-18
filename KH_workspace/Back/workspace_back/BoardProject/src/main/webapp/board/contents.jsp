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
.seq{display: none};

</style>
</head>
<body>
	<!-- 게시글 내용 -->
	<form action="modify.board" method="post">
		<table border="1" width="500" height="400">

			<tr>
				<th colspan="3" align="center">자유게시판</th>
			</tr>
			<tr>

				<td colspan="2">작성자 : <input type="text" name="writer"
					value="${dto.writer }" readonly> <input type="text"
					class="seq" name="seq" value="${dto.seq }">
				</td>
				<td align="right">조회수 : ${dto.view_count }</td>
			</tr>
			<tr>
				<td colspan="2">제목 : <input type="text" size="40%" id="title"
					name="title" value="${dto.title }" readonly>
				</td>
				<td align="right">작성일 :<fmt:formatDate
						value="${dto.write_date}" pattern="yy-MM-dd HH:mm" /></td>
			</tr>
			<tr>
				<td colspan="3"><textarea cols="100%" rows="20%" id="contents"
						name="contents" readonly>${dto.contents }</textarea></td>
			</tr>

			<tr align="right">
				<td colspan="3"><c:choose>
						<c:when test="${dto.writer eq id}">
							<input type="button" value="삭제" id="delete">
							<input type="button" value="수정" id="modify">
							<input type="submit" value="수정완료" id="modComplete"	style="display: none">
						</c:when>
					</c:choose> <input type="button" value="목록으로" id="toList"></td>
			</tr>

		</table>
	</form>


	<hr>
	<!-- 댓글 작성란 -->
	<form action="write.reply" method="post">
		<table border="1" width="500">
			<tr>
				<td colspan="2">작성자 ID : <input type="text" id="re_writer"
					name="re_writer" value="${sessionScope.loginId}" readonly>
					<input type="text" class="seq" name="seq" value="${dto.seq }">
				</td>
			</tr>
			<tr>
				<td><input type="text" id="re_contents" name="re_contents"
					placeholder="작성할 댓글 입력" size="87%"></td>
				<td><input type="submit" value="작성완료" id="re_write_btn"
					name="re_write_btn"></td>
			</tr>
		</table>
	</form>


	<!-- 댓글 목록 -->
	<c:if test="${replyList!=null}">
		<form action="update.reply" method="post">
			<table border="1" width="500">
				<c:forEach var="i" items="${replyList}">
					<tr>
						<td colspan="2">작성자 ID : <input type="text"
							value="${i.writer }" readonly></td>
					</tr>
					<tr>
						<td><input type="text" value="${i.contents }" size="87%"></td>
						
						<td>
						<c:choose>
							<c:when test="${sessionScope.loginId eq i.writer}">
								<button id="re_update">수정</button>
								<button id="re_delete">삭제</button>

								<input type="button" value="수정완료" id="re_updateComp"
									style="display: none">

								<input type="text" class="seq" id="re_seq" name="re_seq" value="${i.seq }">

							</c:when>
						</c:choose>
						</td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</c:if>


	<script>
		$("#toList").on("click", function() {
			location.href = "/list.board?cpage=${sessionScope.currentPage}";
		})

		$("#delete").on("click", function() {
			if (confirm("게시글을 정말로 삭제하시겠습니까?")) {
				location.href = "/delete.board";
			} else {
				return false;
			}
		})

		$("#modify").on("click", function() {
			$("#modify").css('display', 'none');
			$("#delete").css('display', 'none');
			$("#toList").css('display', 'none');
			$("#modComplete").css('display', 'block');
			$("#title,#contents").removeAttr("readonly");
		})

		$("#re_update").on("click", function() {
			$("#re_updateComp").css('display', 'block');
			$("#re_contents").removeAttr("readonly");
		})

		$("#re_delete").on("click", function() {
			if (confirm("댓글을 정말로 삭제하시겠습니까?")) {
				location.href = "/delete.reply";
			} else {
				return false;
			}
		})

		$("#re_update").on("click", function() {
			$("#re_delete").css("display", "none");
			$("#re_update").css("display", "none");
			$("#re_updateComp").css("display", "block");
		})
	</script>
</body>
</html>