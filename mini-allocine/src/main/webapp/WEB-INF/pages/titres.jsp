<%@page import="fr.eni.miniallocine.bo.Titre"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Titre> titres = (List<Titre>) request.getAttribute("titres");
%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Liste films & séries</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
  </head>
  <body>    
    <div class="container-fluid">
    	<header class="row">
			<nav class="navbar navbar-expand-lg bg-primary" data-bs-theme="dark">
			  <div class="container-fluid">
			    <a class="navbar-brand" href="#">Mini AlloCiné</a>
			    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
			      <span class="navbar-toggler-icon"></span>
			    </button>
			    <div class="collapse navbar-collapse" id="navbarNav">
			      <ul class="navbar-nav">
			        <li class="nav-item">
			          <a class="nav-link active" aria-current="page" href="#">Titres</a>
			        </li>
			      </ul>
			    </div>
			  </div>
			</nav>    		
    	</header>
    	<main class="row">
    		<div class="row text-center mt-5">
    			<h1>Films & séries</h1>
    		</div>
    		<div class="row mt-3">
    			<div class="col-8 offset-2">
	    			<table class="table table-primary" style="width:100%">
	    				<thead>
	    					<th>ID</th>
	    					<th>Titre</th>
	    					<th>Résumé</th>
	    					<th>Genre</th>
	    					<th>Date de sortie</th>
	    					<th>Type</th>
	    					<th>Actions</th>
	    				</thead>
	    				<tbody>
	    					<% for( Titre titre:titres ){ %>
	    						<tr id="<%= titre.getId() %>" >
	    							<td> <%= titre.getId() %> </td>
	    							<td> <%= titre.getNom() %> </td>
	    							<td> <%= titre.getSynopsis().substring(0, titre.getSynopsis().length()<30? titre.getSynopsis().length() : 30) %> </td>
	    							<td> <%= titre.getGenre() %> </td>
	    							<td> <%= titre.getDateSortie() %> </td>
	    							<td> <%= titre.isType()?"Série":"Film" %> </td>    							
	    							<td>
										<!-- Button trigger modal -->
										<button type="button" class="btn btn-info" 										
										data-nom="<%= titre.getNom() %>"
										data-synopsis="<%= titre.getSynopsis()%>"
										data-genre="<%= titre.getGenre() %>"
										data-date="<%= titre.getDateSortie() %>"
										data-type="<%= titre.isType()?"Série":"Film" %>"
										data-realisateur="<%= titre.getRealisateur()%>"
										data-bs-toggle="modal" data-bs-target="#exampleModal" >
										
										  <i class="fa-solid fa-eye"></i>
										</button>	 
										<form action="" style="display:inline" method="post" onSubmit="return confirm('Voulez-vous vraiment supprimer ce titre?');">										
	    									<input type="hidden" name="id" value="<%= titre.getId() %>" >
	    									<button  type="submit" class="btn btn-danger"> 
	    										<i class="fa-solid fa-trash"></i> 
	    									</button>
										</form>   								    								
	    							</td>
	    						</tr>
	    					<% } %>
	    				</tbody>
	    			</table>    			
    			</div>
    		</div>
			<!-- Modal -->
			<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h1 class="modal-title fs-5" id="titre">Modal title</h1>
			        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			      </div>
			      <div class="modal-body">
			        <div class="row text-center">
			        	<p id="synopsis">
			        		blabalbalbal
			        	</p>
			        	<hr>
			        	<p> 
			        	Réalisateur: <span id="real" ></span>
			        	Date de sortie: <span id="sortie"></span>
			        	</p>			        	
			        </div> 			        
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
			      </div>
			    </div>
			  </div>
			</div>    		
    	</main>
    	<footer></footer>
    </div>       
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
    <script src="<%=request.getContextPath() %>/assets/js/main.js"></script>
  </body>
</html>