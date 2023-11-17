package com.mercadona.application.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Session;

import Mercadona.app.Produit;
import jakarta.transaction.Transaction;

/**
 * Servlet implementation class ProduitServlet
 */
public class ProduitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProduitServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Logique pour gérer les demandes GET si nécessaire
		// Par exemple, afficher la liste des produits existants
		// ou rediriger vers la page d'administration
		response.sendRedirect("/view/admin.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Logique pour gérer les demandes POST
		String action = request.getParameter("action");
		if (action != null) {
			if (action.equals("ajouterProduit")) {
				ajouterProduit(request, response);
			} else {
				// Gérer d'autres actions si nécessaire
			}
		}
	}

	private void ajouterProduit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// Logique pour ajouter un produit à la base de données avec Hibernate
		String libelle = request.getParameter("libelle");
		String description = request.getParameter("description");
		double prix = Double.parseDouble(request.getParameter("prix"));
		String image = request.getParameter("image");

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			// Démarrez une nouvelle transaction
			transaction = session.beginTransaction();

			// Créez un nouvel objet Produit
			Produit nouveauProduit = new Produit();
			nouveauProduit.setLibelle(libelle);
			nouveauProduit.setDescription(description);
			nouveauProduit.setPrix(prix);
			nouveauProduit.setImage(image);

			// Enregistrez le produit dans la base de données
			session.save(nouveauProduit);

			// Validez la transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}

		// Redirigez vers la page d'administration
		response.sendRedirect("admin.jsp");

	}
}
