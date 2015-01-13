package metier;

import java.sql.Date;
import java.util.Collection;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Article {
private String description;
private String image;//Url de l'emplacement de l'image
private Date dateDepot;
@ManyToOne
private Membre possesseur;
@OneToMany(mappedBy="article", fetch=FetchType.EAGER)
private Set<Avis> avis;
@ManyToMany(mappedBy="articles", fetch=FetchType.EAGER)
private Set<Categorie> estdeType;
@OneToMany(mappedBy="article", fetch=FetchType.EAGER)
private Set<Troc> offres;
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int ID;


 
//constructeur vide
public Article(){}

//constructeur classique
public Article(String nom, double tauxChange, String description, String image, Date dateDepot, Membre possesseur) {
	this.description = description;
	this.image = image;
	this.dateDepot = dateDepot;
	this.possesseur = possesseur;
	//this.estdeType = new HashSet<Categorie>();
	//this.offres = new HashMap<String, Troc>();
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

/*public Collection<Categorie> getEstdeType() {
	return estdeType;
}

public void setEstdeType(Collection<Categorie> estdeType) {
	this.estdeType = estdeType;
}

/*public Map<String, Troc> getOffres() {
	return offres;
}

public void setOffres(Map<String, Troc> offres) {
	this.offres = offres;
}*/

public void setDescription(String description) {
	this.description = description;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public Date getDateDepot() {
	return dateDepot;
}
public void setDateDepot(Date dateDepot) {
	this.dateDepot = dateDepot;
}

}