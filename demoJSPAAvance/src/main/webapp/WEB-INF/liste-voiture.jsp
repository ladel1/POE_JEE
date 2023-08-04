<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="v1" 
				 scope="request" 
				 class="demoJSPAAvance.bo.Voiture" 
	></jsp:useBean>
	<jsp:useBean id="v2" 
				 scope="request" 
				 class="demoJSPAAvance.bo.Voiture" 
	></jsp:useBean>
	<h6>Voiture 1</h6>
		<p>Marque: <jsp:getProperty property="marque" name="v1"/> </p>
		<p>Modele: <jsp:getProperty property="modele" name="v1"/> </p>
		<p>Vitesse Max: <jsp:getProperty property="vitesseMax" name="v1"/> </p>
	<h6>Voiture 2</h6>
		<p>Marque: <jsp:getProperty property="marque" name="v2"/> </p>
		<p>Modele: <jsp:getProperty property="modele" name="v2"/> </p>
		<p>Vitesse Max: <jsp:getProperty property="vitesseMax" name="v2"/> </p>
	<hr>
		<h6>Voiture 1</h6>
		<p>Marque: ${ v1.marque }</p>
		<p>Modele: ${ v1.modele } </p>
		<p>Vitesse Max: ${ v1.vitesseMax }  </p>
		<h6>Voiture 2</h6>
		<p>Marque: ${ v2.marque }</p>
		<p>Modele: ${ v2.modele } </p>
		<p>Vitesse Max: ${ v2.vitesseMax }  </p>	
	<hr>
	<h1>${ pageContext.request.contextPath }</h1>
	<h2>${ param.voiture }</h2>
</body>
</html>