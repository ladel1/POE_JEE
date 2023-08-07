<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connexion</title>
</head>
<body>
	<h1>Connexion</h1>
	<c:if test="${ ! empty erreurs }">
		<c:forEach var="erreur" items="${ erreurs }" >
			<p style="color:red" >${ erreur }</p>
		</c:forEach>
	</c:if>
	<form method="POST" >
		<div>
			<label>Email</label>
			<input type="email" name="email">
		</div>
		<div>
			<label>Mot de passe</label>
			<input type="password" name="password">
		</div>
		<button type="submit" >Connexion</button>
	</form>
</body>
</html>