package intergiciel;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class AvisArticle extends Avis {

	@ManyToOne
	private Article article;
	public AvisArticle() {
		// TODO Auto-generated constructor stub
	}

	public AvisArticle(int note, String critique, Date datePublication) {
		super(note, critique, datePublication);
		// TODO Auto-generated constructor stub
	}

}
