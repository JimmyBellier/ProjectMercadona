<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/styles.css">
<meta charset="UTF-8">
<title>Catalogue - Application Mercadona</title>
</head>
<body>
	<div class="menu">
		<div>
			<img alt="logo" src="../img/logo.png">
		</div>
		<ul>
			<li><a href="accueil.jsp">Accueil</a></li>
			<li><a href="catalogue.jsp">Catalogue</a></li>
			<li><a href="produit.jsp">Produit</a></li>
			<li><a href="connexion.jsp">Connexion</a></li>
			<li><a href="connexion.jsp">Connexion</a></li>

		</ul>
	</div>
	<header class="header">
		<div>
		    <h1>Catalogue des produits</h1>
		</div>
	</header>

    <!-- Ajouter un filtre pour les catégories -->
    <form action="filtrerCatalogue" method="post">
        <label for="categorie">Filtrer par catégorie :</label>
        <select id="categorie" name="categorie">
            <option value="tous">Tous les produits</option>
            <option value="promotion">Promotion</option>
            <option value="alimentaire">Alimentaire</option>
            <option value="hygiene">Hygiène</option>
        </select>
        <input type="submit" value="Filtrer">
    </form>

    <ul>
        <!-- Parcourir et afficher la liste des produits -->
        <!-- Exemple de structure pour un produit : -->
        <%-- Remplacer "listeProduits" par votre liste réelle de produits --%>
        <c:forEach var="produit" items="${listeProduits}">
            <li>
                <h3>${produit.libelle}</h3>
                <p>${produit.description}</p>
                <%-- Vérifier si le produit est en promotion et l'afficher en conséquence --%>
                <c:choose>
                    <c:when test="${produit.enPromotion eq true}">
                        <p style="font-weight: bold; color: red;">Prix en promotion : ${produit.prixPromotion} €</p>
                    </c:when>
                    <c:otherwise>
                        <p>Prix : ${produit.prix} €</p>
                    </c:otherwise>
                </c:choose>
            </li>
        </c:forEach>
    </ul>

</body>
</html>
