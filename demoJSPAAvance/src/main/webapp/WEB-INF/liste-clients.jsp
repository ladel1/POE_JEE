<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste Clients</title>
</head>
<body>
	<ul>
		<c:forEach var="item" items="${ menu }" >
			<c:choose>
				<c:when test="${ item == 'Home' }">
					<li style="color:red"> ${ fn:toUpperCase(item) } </li>
				</c:when>
				<c:otherwise>
					<li> ${ fn:toUpperCase(item) } </li>
				</c:otherwise>
			</c:choose>
					
		</c:forEach>
	</ul>
	<table>
		<thead>
			<th>Nom</th>
			<th>Prénom</th>
			<th>Age</th>
		</thead>
		<tbody>
			<c:forEach var="client" items="${ clients }" >
				<tr>
					<td>${ client.prenom }</td>
					<td>${ client.nom }</td>
					<td>${ client.age }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>