<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isErrorPage="false"
    errorPage="/WEB-INF/errors/jsp-errors.jsp"
    %>
<%
/* 	int a = Integer.parseInt("azerty"); */
	// recup depuis la servlet
	String message = (String) request.getAttribute("message");
	int userChoice = (int) request.getAttribute("userChoice");
	int serverChoice = (int) request.getAttribute("serverChoice");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Résultat</title>
</head>
<body>
<h1>Résultat</h1>
<p> <%=message %> </p>
<p>Le choix de l'utilisateur: 
	<img src="<%= request.getContextPath() %>/assets/img/<%=userChoice %>.png">
</p>
<p>Le choix de l'ordi: 
	<img src="<%= request.getContextPath() %>/assets/img/<%=serverChoice %>.png">
</p>
<a href="<%= request.getContextPath() %>">Rejouer</a>
</body>
</html>