<%@page import="java.util.List"%>
<%@page import="fr.eni.avis.bo.Avis"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	List<Avis> listAvis = (List<Avis>) request.getAttribute("listAvis");
%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Avis</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
  </head>
  <body>
    
    <div class="container-fluid">
    	<%@ include file="/WEB-INF/parts/header.jsp" %>
    	<main class="row">
   			<div class="row text-center mt-4">
	    		<h1>Liste avis</h1>
   			</div>   			
   			<div class="row">
   				<div class="col-6 offset-3">
   					<table class="table table-primary">
   						<thead>
   							<th>ID</th>
   							<th>Auteur</th>
   							<th>Produit</th>
   							<th>Note</th>
   							<th>Actions</th>
   						</thead>
   						<tbody>
   							<% for(Avis avis:listAvis){ %>
	   							<tr>
	   								<td><%=avis.getId() %></td>
	   								<td><%=avis.getUsername() %></td>
	   								<td><%=avis.getProductName() %></td>
	   								<td><%=avis.getRating() %></td>
	   								<td>
	   									<a href="<%=request.getContextPath() %>/avis/modifier/<%=avis.getId() %>" class="btn btn-primary"><i class="fa-solid fa-pen-to-square"></i></a> 
	   									<a href="<%=request.getContextPath() %>/avis/detail/<%=avis.getId() %>" class="btn btn-info"><i class="fa-solid fa-eye"></i></a> 
	   								</td>
	   							</tr>
   							<% } %>
   						</tbody>
   					</table>   					
   				</div>
   			</div>
    	</main>
    	<%@ include file="/WEB-INF/parts/footer.jsp" %>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
  </body>
</html>