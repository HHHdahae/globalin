<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Insert title here</title>
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
		<div class="jumbotron text-center" style="margin-bottom:0">
		<h3>메 모</h3>
		<ul>
			<li> <a href="memo_list" class="btn btn-outline-dark" >메모 관리 </a>	</li>
			<li> <a href="memo_req_list?reqPage=1" class="btn btn-outline-dark" >메모 요청 리스트 </a> </li>	
			<li> <a href="memo_input" class="btn btn-outline-dark" >메모 저장 </a>	</li>					
			<li> <a href="input_form" class="btn btn-outline-dark" >input 화면으로 가기</a> </li>
			<li> <a href="input_publisher" class="btn btn-outline-dark" >출판사 목록</a> </li>				
		</ul>
		</div>
	</body>
</html>