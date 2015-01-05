package projet_intergiciel;

import java.sql.Date;

import javax.persistence.ManyToOne;

public class AvisMembre extends Avis {

	@ManyToOne
	private Membre personne;
	
	public AvisMembre() {
		// TODO Auto-generated constructor stub
	}

	public AvisMembre(int note, String critique, Date datePublication) {
		super(note, critique, datePublication);
		// TODO Auto-generated constructor stub
	}

}
