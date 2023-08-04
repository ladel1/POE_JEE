<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String _page = "Home"; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Démo</title>
</head>
	<body>
		
		<jsp:include page="/WEB-INF/header.jsp">
			<jsp:param value="Adel" name="prenom"/>
		</jsp:include>
		<jsp:include page="/WEB-INF/front.jsp" />		
		<%@ include file="/WEB-INF/footer.jspf" %>
		 
	</body>
</html>