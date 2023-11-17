<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/styles.css">
<meta charset="UTF-8">
<title>Créer un produit - Application Mercadona</title>
</head>
<body>
	<h1>Créer un nouveau produit</h1>
	<form action="ajouterProduit" method="post">
		<label for="libelle">Libellé :</label><br> <input type="text"
			id="libelle" name="libelle"><br>
		<br> <label for="description">Description :</label><br> <input
			type="text" id="description" name="description"><br>
		<br> <label for="prix">Prix :</label><br> <input
			type="number" id="prix" name="prix"><br>
		<br> <label for="image">Image :</label><br> <input
			type="text" id="image" name="image"><br>
		<br> <input type="submit" value="Créer">
	</form>
</body>
</html>
