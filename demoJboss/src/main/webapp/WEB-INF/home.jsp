<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QUiz</title>
</head>
<body>
<h1>Quiz</h1>
<form method="post" action="" >
	<div>
		<label> Nom </label>
		<input type="text" name="nom">
	</div>
	<div>
		<label> Question </label>
		<input type="text" name="question">
	</div>
	<div>
		<label> Option 1 </label>
		<input type="text" name="op1">
		<input type="checkbox" value="true" name="reponse1" >
	</div>	
	<div>
		<label> Option 2 </label>
		<input type="text" name="op2">
		<input type="checkbox" value="true" name="reponse2" >
	</div>	
	<div>
		<label> Option 3 </label>
		<input type="text" name="op3">
		<input type="checkbox" value="true" name="reponse3" >
	</div>
	<button type="submit"> Ajouter question </button>			
</form>
</body>
</html>