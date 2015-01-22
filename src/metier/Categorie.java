package metier;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import exception.ArticlePresent;
import exception.SousCategoriePresent;

@Entity
public class Categorie {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ID;
	
	private String nomCategorie;
	
	@ManyToOne
	private Categorie parent;
	
	@OneToMany(mappedBy="parent", fetch=FetchType.EAGER)
	private Set<Categorie> sousCategorie;

	@OneToMany(mappedBy="estdeType", fetch=FetchType.EAGER)
	private Set<Article> articles;
	
	public Categorie(){
		
	}
	
	public Categorie(String nom){
		this.nomCategorie = nom;
	}

	public String getNomCategorie() {
		return nomCategorie;
	}

	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}

	public Set<Article> getArticles() {
		return articles;
	}


	public Categorie getParent() {
		return parent;
	}

	public Set<Categorie> getSousCategorie() {
		return sousCategorie;
	}
	
	public void setParent(Categorie c){
		this.parent=c;
	}

	public int getID() {
		return ID;
	}
}
