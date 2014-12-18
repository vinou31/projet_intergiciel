package projet_intergiciel;

import java.awt.Image;
import java.sql.Date;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


public class Article extends Troc{
private String description;
private Image image;
private Date dateDepot;
private Membre possesseur;
private Collection<Categorie> estdeType;
private Map<String, Troc> offres;


 
//constructeur vide
public Article(){}

//constructeur classique
public Article(String nom, double prixreel, double tauxChange, String description, Image image, Date dateDepot, Membre possesseur) {
	super(nom, prixreel, tauxChange);
	this.description = description;
	this.image = image;
	this.dateDepot = dateDepot;
	this.possesseur = possesseur;
	this.estdeType = new HashSet<Categorie>();
	this.offres = new HashMap<String, Troc>();
}


//tous les getters et setters

public String getDescription() {
	return description;
}
public Membre getPossesseur() {
	return possesseur;
}

public void setPossesseur(Membre possesseur) {
	this.possesseur = possesseur;
}

public Collection<Categorie> getEstdeType() {
	return estdeType;
}

public void setEstdeType(Collection<Categorie> estdeType) {
	this.estdeType = estdeType;
}

public Map<String, Troc> getOffres() {
	return offres;
}

public void setOffres(Map<String, Troc> offres) {
	this.offres = offres;
}

public void setDescription(String description) {
	this.description = description;
}
public Image getImage() {
	return image;
}
public void setImage(Image image) {
	this.image = image;
}
public Date getDateDepot() {
	return dateDepot;
}
public void setDateDepot(Date dateDepot) {
	this.dateDepot = dateDepot;
}

}
