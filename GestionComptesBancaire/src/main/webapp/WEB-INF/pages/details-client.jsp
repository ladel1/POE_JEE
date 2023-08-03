<%@page import="fr.eni.comptesbancaire.bo.Client"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Client client = (Client) request.getAttribute("client");
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>détails client</title>
</head>
<body>
<h1>détails</h1>
<table>
<thead>
	<th>#Id</th>
	<th>Nom</th>
	<th>Prénom</th>
	<th>Date de naissance</th>
	<th>Adresse</th>
</thead>
<tbody>
		<tr>
			<td><%=client.getId() %></td>
			<td><%=client.getNom() %></td>
			<td><%=client.getPrenom() %></td>
			<td>
				<%=client.getDateNaissance()  %>			
			</td>
			<td>
				<%=client.getAdresse()  %>			
			</td>
		</tr>

</tbody>
</table>
</body>
</html>