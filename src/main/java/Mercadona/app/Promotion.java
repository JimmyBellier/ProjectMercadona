package Mercadona.app;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "promotion")
public class Promotion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "identifiantpromotion")
	private Long idPromotion;
	@ManyToOne
	@JoinColumn(name = "id_produit")
	private Produit produit;

	@Column(name = "datedebut")
	private LocalDate dateDebut;

	@Column(name = "datefin")
	private LocalDate dateFin;

	@Column(name = "pourcentageremise")
	private double pourcentageRemise;

	public Promotion(Long idPromotion, Produit produit, LocalDate dateDebut, LocalDate dateFin,
			double pourcentageRemise) {
		super();
		this.idPromotion = idPromotion;
		this.produit = produit;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.pourcentageRemise = pourcentageRemise;
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

	@Override
	public int hashCode() {
		return Objects.hash(dateDebut, dateFin, idPromotion, pourcentageRemise, produit);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Promotion other = (Promotion) obj;
		return Objects.equals(dateDebut, other.dateDebut) && Objects.equals(dateFin, other.dateFin)
				&& Objects.equals(idPromotion, other.idPromotion)
				&& Double.doubleToLongBits(pourcentageRemise) == Double.doubleToLongBits(other.pourcentageRemise)
				&& Objects.equals(produit, other.produit);
	}

}
