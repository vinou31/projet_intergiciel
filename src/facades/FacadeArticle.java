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
	
	private  String CHAMP_NOM    = "nom";
	private  String CHAMP_DESCRIPTION = "description";
	private  String CHAMP_PRIX = "prix";
	
	
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
		return this.em.find(Article.class,id);
	}
	
	public void supprimerArticle(int id) {
		em.remove(em.find(Article.class, id));
	}
	
	public void modifierNom() {
		
	}
	
	@SuppressWarnings("unchecked")
	public Collection<String> getCategories(){
		return (Collection<String>)em.createNativeQuery("SELECT DISTINCT Categorie FROM Article;").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public Collection<String> getSousCategorieFacade(String categorie) {
		return (Collection<String>)em.createNativeQuery("SELECT DISTINCT sousCategorie FROM Article WHERE Categorie="+categorie+";").getResultList();
	}
	
	public Collection<Article> getArticles() {
		return em.createQuery("from Article", Article.class).getResultList();
	}
	
	public Collection<Article> getArticlesNom(String nom) {
		return em.createQuery("FROM Article WHERE nom LIKE '%"+ nom +"%'",Article.class).getResultList();
		
	}
	
	public Collection<Article> getArticlesFromCategories(int idC){
		Categorie cat = em.find(Categorie.class, idC);
		return (Collection<Article>) cat.getArticles();
	}
	
	public Collection<Categorie> getSousCategories(){
		return em.createQuery("FROM Categorie WHERE parent IS NOT NULL", Categorie.class).getResultList();
	}
	
	public void ajouterArticle(HttpServletRequest req, Membre m, String chemin){
		Article a = new Article();
		a.setNom(req.getParameter(CHAMP_NOM));
		a.setDescription(req.getParameter(CHAMP_DESCRIPTION));
		//int prix = 0;
		int prix  = Integer.parseInt(req.getParameter("prix"));
		a.setPrixPropose(prix);
		a.setImage(chemin);
		
		java.util.Date d1 = new java.util.Date();
		java.sql.Date d2 = new java.sql.Date(d1.getTime());
		a.setDateDepot(d2);
		em.persist(a);
		//a.setPossesseur(m);
		m.getPropose().add(a);
	}
	
	public void supprimerArticle(HttpServletRequest req){
		String nom = req.getParameter(CHAMP_NOM);
		Article a = em.createQuery("FROM Article WHERE nom='"+nom+"'", Article.class).getSingleResult();
		System.out.println("-------------------------------------------------------------------------------------------");
		System.out.println("nom = " + a.getNom());
		System.out.println("description = " + a.getDescription());
		System.out.println("lieu = " + a.getImage());
		System.out.println("-------------------------------------------------------------------------------------------");
		em.remove(a);
		
	}
}
