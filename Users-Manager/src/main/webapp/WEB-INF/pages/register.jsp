<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscription</title>
</head>
<body>
	<c:if test="${ erreurs != null }">
		<c:forEach var="erreur" items="${ erreurs }">
			<p style="color:red" >${ erreur }</p>
		</c:forEach>
	</c:if>
	<h1>Inscription</h1>
	<form method="post">
		<div>
			<label>Username</label>
			<input type="text" name="username">
		</div>
		<div>
			<label>Email</label>
			<input type="email" name="email">
		</div>
		<div>
			<label>Mot de passe</label>
			<input type="password" name="password">
		</div>
		<button type="submit">Inscription</button>
	</form>
</body>
</html>