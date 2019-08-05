<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>메모 리스트</title>
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
		  h2 {background-color : yellow}
		}
		
		#select { font-size: 50px;}
	
	</style>
</head>
<body>
<div class="container">
	<h2>Memo List</h2>	
	<a href="memo_input" class="btn btn-dark">메모 저장</a>
	<form action="memo_search" method="post">
	<input type = "text" placeholder="이름을 입력하세요" name ="name"/>
	<input type = "submit" class="btn btn-outline-dark" value="검색"/>
	</form>
	<c:if test="${empty memos}">
		<hr />
		검색된 결과가 존재하지 않습니다.
		<hr />
	</c:if>
	<c:if test="${!empty memos}">
		<table class="table table-dark table-hover">
			<tr>
				<th>메모번호 </th>
				<th>이름</th>
				<th>나이</th>
				<!-- <td>상세보기</td> -->
			</tr>
			<c:forEach var="memo" items="${memos}">
				<tr>
					<td>${memo.memoid}</td>
					<td><a href="memo_detail?memoid=${memo.memoid}">${memo.name}</a></td>
					<td>${memo.age}</td>										
				</tr>							
			</c:forEach>  
		</table>
	</c:if>
	<br />
	<br />	
	<!--페이지 처리 부분-->
	<c:if test="${pageGroupResult.beforPage}">
	<a href="memo_req_list?reqPage=${pageGroupResult.groupStartNumber-1}">《 </a>
	</c:if>
		
	<c:forEach var="index" begin="${pageGroupResult.groupStartNumber}" end="${pageGroupResult.groupEndNumber}">
		<c:choose>
			<c:when test="${pageGroupResult.selectPageNumber==index}">
				<span id="select"><a href="memo_req_list?reqPage=${index}" >${index}</a></span>
			</c:when>
			<c:otherwise>
				<a href="memo_req_list?reqPage=${index}">${index}</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	
	<c:if test="${pageGroupResult.afterPage}"> 
	<a href="memo_req_list?reqPage=${pageGroupResult.groupEndNumber+1}"> 》</a>
	</c:if>	 	 
</div>
</body>
</html>