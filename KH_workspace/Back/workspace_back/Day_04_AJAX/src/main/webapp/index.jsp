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

	<!-- 비동기 자바스크립트 -->
	<!-- 데이터 전송기능 (페이지의 전환 없이)  -->

	<fieldset>
		<legend> 기본 AJAX (Asynchronous Javascript and XML) </legend>
		<button id="ajax1">테스트</button>
	</fieldset>

	<fieldset>
		<legend> Ajax 2 </legend>
		<button id="ajax2">테스트</button>
	</fieldset>

	<fieldset>
		<legend> Return 값을 돌려받는 Ajax 통신 </legend>
		<button id="ajax3">테스트</button>
	</fieldset>

	<fieldset>
		<legend> 배열을 돌려받는 Ajax 통신 </legend>
		<button id="ajax4">테스트</button>
	</fieldset>

	<fieldset>
		<legend> 객체를 돌려받는 Ajax 통신 </legend>
		<button id="ajax5">테스트</button>
	</fieldset>

	<fieldset>
		<legend> 객체 배열을 돌려받는 Ajax 통신 </legend>
		<button id="ajax6">테스트</button>
	</fieldset>
	
	<fieldset>
		<legend> 여러 데이터를 돌려받는 Ajax 통신 </legend>
		<button id="ajax7">테스트</button>
	</fieldset>
	
	
	
	<script>
		$("#ajax1").on("click", function() {

			$.ajax({
				url : "/exam01.ajax" //컨트롤러와 마찬가지의 호출이나 페이지의 전환이 없음.
			});

		})

		$("#ajax2").on("click", function() {

			$.ajax({
				url : "/exam02.ajax", //컨트롤러와 마찬가지의 호출이나 페이지의 전환이 없음.
				type : "post",
				data : {
					fruit : "apple", // fruit 키 값에 Apple 삽입
					music : "piano"
				}
			})

		})

		$("#ajax3").on("click", function() {

			$.ajax({
				url : "/exam03.ajax" //컨트롤러와 마찬가지의 호출이나 페이지의 전환이 없음.

			//리퀘스트 보낸 후 response에 정보를 담아 받을 때에 done 부분에서 받아줄 수 있음.
			//done 부분에 콜백을 첨가하여 기능 실행 > 파라미터로 들어온다.
			}).done(function(resp) { //response로 들어오기 때문에 resp 라는 이름정함. 아무거나로 해도 됨.
				console.log(resp);
			})
		})

		$("#ajax4").on("click", function() {
			$.ajax({
				url : "/exam04.ajax",
				dataType : "json"
			}).done(function(resp) {
				//resp = JSON.parse(resp);
				console.log(resp[0]);
			});

		})

		//직렬화 - serialization 다른 언어별 데이터를 보내는 방식.
		//역 직렬화 - deserializaion 다른언어에선 보낸 데이터를 해석하여 받는 방식

		$("#ajax5").on("click", function() {
			$.ajax({
				url : "/exam05.ajax",
				dataType : "json"
			}).done(function(resp) {
				//resp = JSON.parse(resp);
				console.log(resp);
				console.log(resp.name); // 문자열이기 때문에 name에 들어간 값은 안나옴 > datatype:json / resp = JSON.parse(resp)을 해줄 경우 가능.
				
			})
		})
		
		$("#ajax6").on("click", function() {
			$.ajax({
				url : "/exam06.ajax",
				dataType : "json"
			}).done(function(resp) {
				console.log(resp);
				
			})
		})
		
		$("#ajax7").on("click", function() {
			$.ajax({
				url : "/exam07.ajax",
				dataType : "json"
			}).done(function(resp) {
				console.log(resp);
				let arr = JSON.parse(resp.arr);
				console.log(arr);
				
			})
		})
	</script>



</body>
</html>