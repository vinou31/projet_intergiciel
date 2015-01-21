package facades;

import java.util.Collection;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateful;
import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;

import metier.Article;
import metier.Categorie;
import metier.Membre;

@Stateful
public class FacadeArticle {
	@PersistenceContext
	EntityManager em;
	
	
	public void creerArticle(Membre possesseur, String description){
		Article m = new Article();
		m.setPossesseur(possesseur);
		m.setDescription(description);
		java.util.Date d1 = new java.util.Date();
		java.sql.Date d2 = new java.sql.Date(d1.getTime());
		m.setDateDepot(d2);
		em.persist(m);	
	}
	
	public Article findArticle(Integer id) {
		/*Article res = new Article();
		Query reponse =  em.createNativeQuery("SELECT * FROM Article WHERE ID="id+";");
		res.setDescription(reponse.);
		res.setDateDepot(dateDepot);
		res.setPossesseur(possesseur);*/
		return this.em.find(Article.class,id);
	}
	
	@SuppressWarnings("unchecked")
	public Collection<String> getCategories(){
		return (Collection<String>)em.createNativeQuery("SELECT DISTINCT Categorie FROM Article;").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public Collection<String> getSousCategorieFacade(String categorie) {
		return (Collection<String>)em.createNativeQuery("SELECT DISTINCT sousCategorie FROM Article WHERE Categorie="+categorie+";").getResultList();
	}
	
	public Collection<Article> getArticles(Integer idPossesseur) {
		return (Collection<Article>)em.createNativeQuery("SELECT * FROM Article WHERE possesseur="+ idPossesseur +";", Article.class);
	}
	
	public Collection<Article> getCategories(int idC){
		return em.find(Categorie.class, idC).getArticles();
	}

}
