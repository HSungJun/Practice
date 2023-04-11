<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- selectMSG 서블릿에서 넘어온 키,밸류값인 "list", result가 넘어옴. EL을 통한 사용 -->
	<!-- EL : Expression Language - controller가 request에 담아 보낸 데이터를 표현하기 위한 언어  
	키값으로 한글을 넣을 수 없음 주석 안에서도 \${}또한 인식되기에 \ 를 통해 특수문자기능을 해재하여 \${}의 경우 인식되지 않음. 
	{}내에서 연산 및 비교식 사용 가능 -->
	ex) EL 문 연습
	<br> Controller로부터 넘어온 숫자 값 : ${number +50} : ${number == 100}
	<br> 리스트 데이터 : ${arr[0] } : ${arr[1] } : ${arr[2] }
	<!-- list 의 경우 배열 내 (주소값 비슷한)해쉬코드가 나타남. -->
	<br> dto 값 : ${dto.id } : ${dto.writer } : ${dto.message }
	<br> list 사이즈 : ${list.size()}
	<br> list값 : ${list[0].id } : ${list[0].writer } :
	${list[0].message }
	<br> list값 : ${list[1].id } : ${list[1].writer } :
	${list[1].message }
	<br>
	<br>
	<br>

	<br>
	<hr>
	JSTL 예시
	<br>
	<!-- JSTL = JSP Standard Tag Library -->
	<!-- JSTL 에서는 "" 가 의무사항 -->
	<!-- if 문 형태 이며 else if 등의 기능은 없음 -->
	<c:if test="${number == 100}">
		number 안에 있는 값은 100
	</c:if>

	<br>
	<br>
	<!-- choose > 경우에 따라 if ,else if, else 까지 사용 가능-->
	<!-- c:choose == if / c:when else == if / c:otherwise == else 
	문자열 비교는 .equals 사용 / == 사용 가능하나 문자열의 경우 equals 사용-->
	<c:choose>
		<c:when test="${string.equals('Hello JSP') }"> 문자열 값 Hello JSP </c:when>

		<c:when test="${string.equals('Hello JSTL') }"> 문자열 값 Hello JSTL </c:when>

		<c:otherwise> 문자열은 JSP JSTL 둘 다 아님 </c:otherwise>
	</c:choose>

	<br>
	<br>

	<!-- for each문 사용을 통한 반복문 -->
	<!-- for (i : list) 와 비슷함 i에는 자료형이 MessagesDTO로 저장됨-->
	<c:forEach items="${list }" var="i">
		${i.id } : ${i.writer } : ${i.message }<br>
	</c:forEach>

	<br>
	<br>

	<hr>

	<table border='1' align='center'>
		<tr>
			<th colspan='3'>Message List
		</tr>
		<tr>
			<th>ID</th>
			<th>WRITER</th>
			<th>MESAGE</th>
		</tr>

		<c:forEach items="${list }" var="i">
			<tr>
				<td>${i.id }</td>
				<td>${i.writer }</td>
				<td>${i.message }</td>
			</tr>
		</c:forEach>

		<form action='modify.message' method='get'>
			<tr>
				<td colspan='3'><input type='text' placeholder='Input id to modify' name='modID'>
					<input type='text' placeholder='Input writer to modify' name='modWriter'>
					<input type='text' placeholder='Input message to modify' name='modMessage'>
					<button type='submit'>Modify</button></td>
			</tr>
		</form>
		<form action='delete.message' method='get'>
			<tr>
				<td colspan='3'><input type='text' name='delid' id='text'
					placeholder='input delete id'>
					<button>delete</button></td>
			</tr>
		</form>
		<tr>
			<td colspan='3' align=center><a href="index.html">back</a>
		</tr>
	</table>

	<hr>

</body>
</html>