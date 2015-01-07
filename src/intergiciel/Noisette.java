package intergiciel;

import javax.persistence.Entity;

@Entity
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
