<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/styles.css">
<title>Zone d'administration - Application Mercadona</title>
</head>
<body>
    <h1>Zone d'administration</h1>

    <!-- Formulaire de création de produit -->
    <h2>Créer un nouveau produit</h2>
    <form action="ajouterProduit" method="post">
        <label for="libelle">Libellé :</label><br>
        <input type="text" id="libelle" name="libelle"><br><br>
        <label for="description">Description :</label><br>
        <input type="text" id="description" name="description"><br><br>
        <label for="prix">Prix :</label><br>
        <input type="number" id="prix" name="prix"><br><br>
        <label for="image">Image :</label><br>
        <input type="text" id="image" name="image"><br><br>
        <input type="submit" value="Créer">
    </form>

    <!-- Formulaire de création de promotion -->
    <h2>Créer une nouvelle promotion</h2>
    <form action="ajouterPromotion" method="post">
        <label for="produit">Produit :</label><br>
        <select id="produit" name="produit">
            <!-- Liste des produits à afficher -->
        </select><br><br>
        <label for="dateDebut">Date de début :</label><br>
        <input type="date" id="dateDebut" name="dateDebut"><br><br>
        <label for="dateFin">Date de fin :</label><br>
        <input type="date" id="dateFin" name="dateFin"><br><br>
        <label for="pourcentageRemise">Pourcentage de remise :</label><br>
        <input type="number" id="pourcentageRemise" name="pourcentageRemise"><br><br>
        <input type="submit" value="Créer">
    </form>

    <!-- Liste des produits existants avec la possibilité de les mettre en promotion -->
    <h2>Gérer les promotions</h2>
    <ul>
        <!-- Liste des produits avec la possibilité de les mettre en promotion -->
    </ul>

</body>
</html>
