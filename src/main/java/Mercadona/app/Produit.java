/**
 * 
 */
package Mercadona.app;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * 
 */
@Entity
@Table(name = "produit")
public class Produit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "identifiantproduit")
	private Long idProduit;

	@Column(name = "libelle")
	private String libelle;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "prix")
	private double prix;
	
	@Column(name = "image")
	private String image;

	/**
	 * @param description 
	 * @param idProduit 
	 * @param image 
	 * @param libelle 
	 * @param prix 
	 * 
	 */
	public Produit(String description, Long idProduit, String image, String libelle, double prix) {
		super();
		this.description = description;
		this.idProduit = idProduit;
		this.image = image;
		this.libelle = libelle;
		this.prix = prix;
	}

	public Long getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, idProduit, image, libelle, prix);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produit other = (Produit) obj;
		return Objects.equals(description, other.description) && Objects.equals(idProduit, other.idProduit)
				&& Objects.equals(image, other.image) && Objects.equals(libelle, other.libelle)
				&& Double.doubleToLongBits(prix) == Double.doubleToLongBits(other.prix);
	}

}
