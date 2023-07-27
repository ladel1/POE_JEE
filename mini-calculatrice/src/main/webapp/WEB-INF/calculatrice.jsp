<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
/* 	float result = 0;
	if(request.getAttribute("result")!=null)
		result = (float) request.getAttribute("result"); */
		
	float result = 	(request.getAttribute("result")==null)?0:(float) request.getAttribute("result");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calculatrice</title>
</head>
<body>
	<h1>Calculatrice</h1>
	<main>
		<form action="" method="post">
			<div>
				<input type="number" name="op1" step="0.1" value="<%= request.getParameter("op1") %>" placeholder="ex. 5" >
			</div>
			<div>
				<% char [] operateurs = {'+','*','%','/','+'}; %>
				<select name="op">
					<% for(char operateur : operateurs){ %>
						<% if(request.getParameter("op")!=null && operateur==request.getParameter("op").charAt(0) ){ %>
							<option  selected ><%=operateur %></option>
						<% }else{ %>
							<option><%=operateur %></option>
						<%} %>
					<%} %>
				</select>
			</div>
			<div>
				<input type="number" name="op2" value="<%= request.getParameter("op2") %>" step="0.1" placeholder="ex. 9" >
			</div>	
			<button type="submit">
				Calculer
			</button>		
		</form>
		<div>
		 <p>Résultat: <%=result %></p>
		</div>
	</main>
</body>
</html>