<%@page import="fr.eni.avis.bo.Avis"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	Avis avis = (Avis) request.getAttribute("avis");
	String erreurs = (String) request.getAttribute("erreurs");
%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Modifier un avis</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
  </head>
  <body>
    
    <div class="container-fluid">
    	<%@ include file="/WEB-INF/parts/header.jsp" %>
    	<main class="row">
   			<div class="row text-center mt-4">
	    		<h1>Modifier un avis</h1>
   			</div>   			
   			<div class="row">
   				<div class="col-6 offset-3">
   					<% if(erreurs!=null){ %>
	   					<div class="alert alert-danger">
	   						<%= erreurs %>
	   					</div>
   					<% } %>
   					<form action="" method="post">
						<div class="mb-3">
						  <label for="username" class="form-label">Nom de l'utilisateur</label>
						  <input type="text" name="username" class="form-control" id="username" value="<%= avis.getUsername() %>" placeholder="" >
						</div>
						<div class="mb-3">
						  <label for="product_name" class="form-label">Nom du produit</label>
						  <input type="text" name="product_name" class="form-control" id="product_name" value="<%= avis.getProductName() %>" placeholder="" >
						</div>
						<div class="mb-3">
						 <label for="rating" class="form-label">Note</label>
						  <input type="number" name="rating" class="form-control"  id="rating" value="<%= avis.getRating() %>" placeholder="" >
						</div>
						<div class="mb-3">
						  <label for="comment" class="form-label">Commentaire</label>
						  <textarea class="form-control" name="comment" id="comment" rows="3"><%= avis.getComment() %></textarea>
						</div>   
						<button class="btn btn-primary" type="submit">Modifier</button>					
   					</form>   					
   				</div>
   			</div>
    	</main>
    	<%@ include file="/WEB-INF/parts/footer.jsp" %>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
  </body>
</html>