package metier;

import javax.persistence.Entity;


public class Noisette extends Troc {
	private int quantite;

	public Noisette() {
		super();
	}

	public Noisette(String nom, double prixreel, double tauxChange) {
		super(nom, prixreel, tauxChange);
		this.quantite = 0;
	}


}
