<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>form tag</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	/*radio*/
	var gender = "${gender}";
	
	$('input[type=radio]').each(function(){		
		if(gender==$(this).val()){
			$(this).attr('checked','checked');
		}				
	});
	
	/*checkbox*/
	<c:forEach var="vehicle" items="${vehicles}">
		var value='<c:out value="${vehicle}"/>';
		
		$('input[type=checkbox]').each(function(){		
			if(value==$(this).val()){
				$(this).attr('checked','checked');
			}					
		});		
	</c:forEach>
	
	/*select*/
	var cars = "${cars}";
	$('option').each(function(){		
		if(cars==$(this).val()){
			$(this).attr('selected','selected');
		}		
		
	});
	
});
</script>
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
	<h2>Result Element</h2>
	<form method="post" action="input_01">
		<input type ="text" name ="username" value="${name}"/>
		<input type ="password" name ="password" value="${password}"/>
		<input type ="reset"  /> <input type ="submit" />						
	</form>
			
	<form method = "post" action = "input_02">
		<input type = "radio" name= "gender" value = "male">남자
		<input type = "radio" name= "gender" value = "female" >여자
		<input type = "radio" name= "gender" value = "other">또다른사람
		<input type = "submit"/>
	</form>
				
	<form method = "post" action = "input_03">
		<input type = "checkbox" name= "vehicle" value = "Birke">자전거
		<input type = "checkbox" name= "vehicle" value = "Car">자동차	
		<input type = "checkbox" name= "vehicle" value = "Subway">지하철
		<input type = "checkbox" name= "vehicle" value = "Bus">버스		
		<input type = "submit"/>
	</form>
		
	<form method = "post" action = "select">
	<select name = cars>
		<option value = "volvo">Volvo</option>
		<option value= "audi">Audi</option>
		<option value= "bmw" >Bmw</option>	
	</select>		
		<input type = "submit"/>
	</form>
		
	<form method ="post" action ="textarea">
		<textarea name = "message" rows="10" cols="30"></textarea>
		<input type = "submit"/>
	</form>		
	</body>
</html>