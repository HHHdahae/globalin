<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>사원 디테일</title>
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
	<h3>상세보기</h3>
	<hr />
	<a href="memo_list">목록으로 돌아가기</a>		
	<form action="memo_update" method="post">
		<input type="hidden" name="memoid" value="${memo.memoid}" /><br />
		이름:<input type="text"  name="name" value="${memo.name}"/><br />
		나이:<input type="text"  name="age" value="${memo.age}"/><br />
		<input type="submit" class="btn btn-primary" value="수정"><br />	
	</form>	
	<hr />
	<a href="memo_delete?memoid=${memo.memoid}">삭제</a>	
	</div>
</body>
</html>