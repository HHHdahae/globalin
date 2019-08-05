<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>메모 등록 폼</title>
		<!-- bootstrap 준비완료 -->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
		<style>
		div {
		  padding: 20px;
		  border: 1px solid #4CAF50;
		  text-align:center;
		}
	</style>
	</head>
	<body>
	<div class="container">
		<h3>메모 저장 </h3>
		<form method="post" action="memo_save">
			<input type="text"  class="form-control active" placeholder="이름을 입력하세요" name="name"/><br />
			<input type="text"  class="form-control active" placeholder="나이를 입력하세요" name="age"/><br />
			<input type="submit" class="btn btn-primary" value="메모 등록"><br />	<br />	
			<a href="memo_list" class="btn btn-primary" >목록으로 돌아가기</a>		
		</form>
	</div>
	
	</body>
</html>
