<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Tentative</title>
	</head>
	<body>
		<header>
			<h1>Tentative</h1>
		</header>
		<main>
			<form action="<%= request.getContextPath() %>/traitement" method="POST">
				<button type="submit" name="userChoice" value="0" >
					<img src="<%= request.getContextPath() %>/assets/img/0.png" alt="CHI" >
				</button>
				<button type="submit" name="userChoice" value="1" >
					<img src="<%= request.getContextPath() %>/assets/img/1.png" alt="FOU" >
				</button>
				<button type="submit" name="userChoice" value="2" >
					<img src="<%= request.getContextPath() %>/assets/img/2.png" alt="MI" >
				</button>
			</form>
		</main>
	</body>
</html>