<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>출판사 선택 하기</h2>
	<form >
		<select name ="publisher">
			<c:forEach var="book" items="${booklist}">
				<option value="${book.publisher}">${book.publisher}</option>
			</c:forEach>
		</select>
		
		<input type = "submit"/>
	</form>

</body>
</html>