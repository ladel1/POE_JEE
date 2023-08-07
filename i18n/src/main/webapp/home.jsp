<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<fmt:setLocale value="${ param['lang'] }"/>
<fmt:setBundle basename="messages"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>
<fmt:message>home</fmt:message>
</title>
</head>
<body>
	<form>
		<select name="lang" onChange="document.forms[0].submit();" >
			<option value="fr" ${ param['lang']=='fr'? 'selected':'' } >Fr</option>
			<option value="en" ${ param['lang']=='en'? 'selected':'' } >En</option>
		</select>
	</form>
<h1>
<fmt:message>home</fmt:message>
</h1>
</body>
</html>