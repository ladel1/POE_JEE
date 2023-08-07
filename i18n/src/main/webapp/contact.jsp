<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>    
<fmt:setLocale value="${ lang }"/>
<fmt:setBundle basename="messages"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><fmt:message>contact</fmt:message></title>
</head>
<body>
	<h1>${ lang }</h1>
	<a href="${ pageContext.request.contextPath }/fr/contact.jsp">Fr</a>
	<a href="${ pageContext.request.contextPath }/en/contact.jsp">En</a>
	<h1><fmt:message>contact</fmt:message></h1>
	<h2><fmt:message>hello</fmt:message></h2>
</body>
</html>