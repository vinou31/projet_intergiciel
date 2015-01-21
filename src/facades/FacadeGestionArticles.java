package facades;

import java.sql.Date;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;

import metier.Article;
import metier.Membre;

@Stateful
public class FacadeGestionArticles {
	@PersistenceContext
	EntityManager em;
	
	private  String CHAMP_NOM    = "nom";
	private  String CHAMP_DESCRIPTION = "description";
	private  String CHAMP_PRIX = "prix";
	
	
	public void ajouterArticle(HttpServletRequest req, Membre m, String chemin){
		Article a = new Article();
		a.setNom(req.getParameter(CHAMP_NOM));
		a.setDescription(req.getParameter(CHAMP_DESCRIPTION));
		int prix = Integer.parseInt(req.getParameter(CHAMP_PRIX));
		a.setPrixPropose(prix);
		a.setImage(chemin);
		a.setPossesseur(m);
		java.util.Date d1 = new java.util.Date();
		java.sql.Date d2 = new java.sql.Date(d1.getTime());
		a.setDateDepot(d2);
		em.persist(a);
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
