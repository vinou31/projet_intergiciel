package intergiciel;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
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
