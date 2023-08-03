<%@page import="fr.eni.comptesbancaire.bo.Client"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Client> clients = (List<Client>) request.getAttribute("clients");
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste clients</title>
</head>
<body>
<h1>Liste clients</h1>
<table>
<thead>
	<th>#Id</th>
	<th>Nom</th>
	<th>Prénom</th>
	<th>Actions</th>
</thead>
<tbody>
	<% for( Client client: clients ){ %>
		<tr>
			<td><%=client.getId() %></td>
			<td><%=client.getNom() %></td>
			<td><%=client.getPrenom() %></td>
			<td>
				<a href="<%= request.getContextPath()%>/clients/details/<%=client.getId() %>"> Détails client </a>
				<a href="#"> Détails compte </a>
				<a href="#"> modifier client </a>
				<a href="#"> supprimer client </a>				
			</td>
		</tr>
	<%} %>
</tbody>
</table>
</body>
</html>