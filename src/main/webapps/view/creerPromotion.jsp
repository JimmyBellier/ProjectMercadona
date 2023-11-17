<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/styles.css">
<meta charset="UTF-8">
<title>Créer une promotion - Application Mercadona</title>
</head>
<body>
	<h1>Créer une nouvelle promotion</h1>
	<form action="ajouterPromotion" method="post">
		<label for="produit">Produit :</label><br> <select id="produit"
			name="produit">
			<!-- Liste des produits à afficher -->
		</select><br>
		<br> <label for="dateDebut">Date de début :</label><br> <input
			type="date" id="dateDebut" name="dateDebut"><br>
		<br> <label for="dateFin">Date de fin :</label><br> <input
			type="date" id="dateFin" name="dateFin"><br>
		<br> <label for="pourcentageRemise">Pourcentage de remise
			:</label><br> <input type="number" id="pourcentageRemise"
			name="pourcentageRemise"><br>
		<br> <input type="submit" value="Créer">
	</form>
</body>
</html>
