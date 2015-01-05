package projet_intergiciel;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Avis {
	private int note;
	private String critique;
	private Date datePublication;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ID;
	//constructeur vide
	public Avis(){}
	
	//constructeur classique
	public Avis(int note, String critique, Date datePublication) {
		super();
		this.note = note;
		this.critique = critique;
		this.datePublication = datePublication;
	}
	
	//tous les getters et setters
	public int getNote() {
		return note;
	}
	public void setNote(int note) {
		this.note = note;
	}
	public String getCritique() {
		return critique;
	}
	public void setCritique(String critique) {
		this.critique = critique;
	}
	public Date getDatePublication() {
		return datePublication;
	}
	public void setDatePublication(Date datePublication) {
		this.datePublication = datePublication;
	}

}
