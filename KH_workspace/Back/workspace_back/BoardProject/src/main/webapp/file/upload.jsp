<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File upload</title>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>
<body>
	<form action="/upload.file" method="post" enctype="multipart/form-data">
		<table border=1 align=center>
			<tr>
				<th>File Upload</th>
			</tr>
			<tr>
				<td align=center><input type=text name=message placeholder="메세지 입력"></td>
			</tr>
			<tr>
				<td><input type=file name=file></td>
			</tr>
			<tr>
				<td align=center><button>Upload</button>
				<a href="/"><button type=button>Back</button></a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>