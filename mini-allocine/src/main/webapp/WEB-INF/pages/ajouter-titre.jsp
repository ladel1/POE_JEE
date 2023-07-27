<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="" method="post" >
		<div>
			<label>Nom(Série/Film)</label>
			<input type="text" name="nom" placeholder="" >
		</div>
		<div>
			<label>Synopsis</label>
			<textarea name="synopsis" ></textarea>
		</div>
		<div>
			<label>Réalisateur</label>
			<input type="text" name="realisateur" placeholder="" >
		</div>
		<div>
			<label>Genre</label>
			<input type="text" name="genre" placeholder="" >
		</div>
		<div>
			<label>Date de sorite</label>
			<input type="date" name="date_sortie" placeholder="" >
		</div>
		<div>
			<label>Duree</label>
			<input type="number" name="duree" placeholder="" >
		</div>
		
		<div>
			<label>Type</label>
			<select name="type">
				<option value="true">Série</option>
				<option value="false">Film</option>
			</select>
		</div>
		<button type="submit">Ajouter un titre</button>											
	</form>
</body>
</html>