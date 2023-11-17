package Mercadona.app;

import java.time.LocalDate;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Promotion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPromotion;
	@ManyToOne
	@JoinColumn(name = "id_produit")
	private Produit produit;
	private LocalDate dateDebut;
	private LocalDate dateFin;
	private double pourcentageRemise;

	public Promotion() {
		// TODO Auto-generated constructor stub
	}

	public Long getIdPromotion() {
		return idPromotion;
	}

	public void setIdPromotion(Long idPromotion) {
		this.idPromotion = idPromotion;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public double getPourcentageRemise() {
		return pourcentageRemise;
	}

	public void setPourcentageRemise(double pourcentageRemise) {
		this.pourcentageRemise = pourcentageRemise;
	}

}
