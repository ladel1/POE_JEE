<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
String erreur = (String) request.getAttribute("erreur");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<h1>Login</h1>
<%
if(erreur!=null){
	out.write("<h1>"+erreur+"</h1>");
}
%>

<form method="post">
	<div>
		<label>Username</label>
		<input type="text" name="username"  >
	</div>
	<div>
		<label>Mot de passe</label>
		<input type="password" name="password"  >
	</div>	
	<button type="submit">Connexion</button>
</form>
</body>
</html>