<%@page import="fr.eni.ecole.bo.Voiture"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String title = "Démo";
	String [] nav = {
		"Accueil",
		"Blog",
		"A propos",
		"Contact",
		"Presentation",
		"Connexion",
		"Inscription"
	};
%>
<%
	// récupération de l'objet transmis par la servlet 
			 //  Cast
 	Voiture v = (Voiture) request.getAttribute("voiture");
%>    
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><%=title %></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
  </head>
  <body>
	
	<nav class="navbar navbar-expand-lg bg-body-tertiary">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="#"><%=title %></a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarNav">
	      <ul class="navbar-nav">
	      	<!-- Début nav -->
	      	<%
	      		for(String item:nav){
	      	%>
		        <li class="nav-item">
		          <a class="nav-link active" aria-current="page" href="#"> 
		          	<%=item %> 
		          </a>
		        </li>
	        <% } %>
	        <!-- Fin nav -->
	      </ul>
	    </div>
	  </div>
	</nav>    

	<main>
		
		<p> Marque: <%= v.getMarque() %> </p>
		<p> Modele: <%= v.getModel() %> </p>
		
	</main>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
  </body>
</html>