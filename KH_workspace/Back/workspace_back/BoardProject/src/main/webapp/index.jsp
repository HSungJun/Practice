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

	<c:if test="${param.state=='a_j'}">
		<script>
			alert("회원가입 완료");
		</script>
	</c:if>
	<c:if test="${param.state=='l_s'}">
		<script>
			alert("로그인 완료");
		</script>
	</c:if>
	<c:if test="${param.state=='l_sf'}">
		<script>
			alert("로그인 실패");
		</script>
	</c:if>
	
	

	<c:choose>
		<c:when test="${loginId==null}">
			<form action="/Login.members" method="post">
				<table border="1" align="center">
					<tr>
						<th colspan="2">Login Box</th>
					</tr>
					<tr>
						<td>아이디 :</td>
						<td><input type="text" placeholder="Input your id" name="id"></td>
					</tr>
					<tr>
						<td>패스워드 :</td>
						<td><input type="text" placeholder="Input your pw" name="pw"></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit"
							value="로그인" id="login"> <input type="button" id="toJoin"
							value="회원가입"><br> <input type="checkbox">ID
							기억하기</td>
					</tr>
				</table>
			</form>
		</c:when>
		<c:otherwise>
			<table border=1 align=center>
				<tr>
					
					<th colspan=4>${sessionScope.loginId} 님 환영합니다.</th>
					
				</tr>
				<tr>
					<td align=center><a href="/ToBoard.members"><button id="toBoard">게시판</button></a></td>
					<td align=center><a href="/MyPage.members"><button id="myPage">마이페이지</button></a></td>
					<td align=center><a href="/Logout.members"><button id="Logout">로그아웃</button></a></td>
					<td align=center><a href="/Out.members"><button id="memberOut">회원탈퇴</button></a></td>
				</tr>
			</table>

			<!-- $ 안에는 세션의 키값도 사용 가능 -->
		</c:otherwise>

	</c:choose>


	<script>
		$("#toJoin").on("click", function() {
			location.href = "/member/joinform.jsp";
		})
		
		$("#memberOut").on("click",function(){
			if(confirm("계정을 정말로 삭제하시겠습니까?")){
				return true;
			}else{return false;}
		})
		
			
	</script>


</body>
</html>