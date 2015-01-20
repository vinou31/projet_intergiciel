package metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public abstract class Troc {
	private String nom;
	private double prixreel;
	private double tauxChange;
	private double prixNoisettes;
	@ManyToOne
	private Article article;
	@ManyToOne
	private Membre membre;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ID;
	
	public Troc(){}
	
	public Troc (String nom, double prixreel, double tauxChange) {
		this.nom = nom;
		this.prixreel = prixreel;
		this.tauxChange = tauxChange;
		this.prixNoisettes = prixreel*tauxChange;
	}

	

	
	public void conversionEuros2Troc(double euros){
		this.prixNoisettes = 1.1*euros;
	}
	
	public void conversionTroc2Euros(double noisettes){
		this.prixreel = noisettes/1.1;
	}

	
	
	//tous les getters et setters
	public double getTauxChange() {
		return tauxChange;
	}

	public void setTauxChange(double tauxChange) {
		this.tauxChange = tauxChange;
	}
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrixreel() {
		return prixreel;
	}

	public void setPrixreel(double prixreel) {
		this.prixreel = prixreel;
	}

	public double getPrixNoisettes() {
		return prixNoisettes;
	}

	public void setPrixNoisettes(double prixNoisettes) {
		this.prixNoisettes = prixNoisettes;
	}
	
	
}
