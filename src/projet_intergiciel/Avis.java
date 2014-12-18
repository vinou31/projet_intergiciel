package projet_intergiciel;

import java.sql.Date;

public class Avis {
	private int note;
	private String critique;
	private Date datePublication;
	
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
