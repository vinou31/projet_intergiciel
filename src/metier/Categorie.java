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

	@ManyToMany
	private Set<Article> articles;
	
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

	public void ajoutArticle(Article article) throws ArticlePresent{
		boolean isAbsent = this.articles.add(article);
		if (!isAbsent){
			throw new ArticlePresent();
		}		
	}
	
	public void ajoutArticles(Set<Article> articles) throws ArticlePresent{
		boolean isAbsent = this.articles.addAll(articles);
		if (!isAbsent){
			throw new ArticlePresent();
		}	
	}

	public Categorie getParent() {
		return parent;
	}

	public Set<Categorie> getSousCategorie() {
		return sousCategorie;
	}
	
	public void ajoutSousCategorie(Categorie categorie) throws SousCategoriePresent{
		boolean isAbsent = this.sousCategorie.add(categorie);
		if (!isAbsent){
			throw new SousCategoriePresent();
		}	
		}
	
}
