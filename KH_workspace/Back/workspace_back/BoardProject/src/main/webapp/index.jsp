<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>
<body>
	<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
</head>
<body>
	<form action="LoginServLet" method="post">
		<table border="1" align="center">
			<tr>
				<th colspan="2">Login Box</th>
			</tr>
			<tr>
				<td>아이디 :</td>
				<td><input type="text" placeholder="Input your id"></td>
			</tr>
			<tr>
				<td>패스워드 :</td>
				<td><input type="text" placeholder="Input your pw"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="button" value="로그인">
					<input type="button" id="toJoin" value="회원가입"><br> <input
					type="checkbox">ID 기억하기</td>
			</tr>
		</table>
	</form>
	<script>
		$("#toJoin").on("click",function(){
			location.href="/member/joinform.jsp";
		})
	</script>

</body>
</html>
</body>
</html>