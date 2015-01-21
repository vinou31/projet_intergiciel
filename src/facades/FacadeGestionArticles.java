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
	
	public void ajouterArticle(HttpServletRequest req, Membre m, String chemin){
		Article a = new Article();
		a.setNom(CHAMP_NOM);
		a.setDescription(CHAMP_DESCRIPTION);
		a.setImage(chemin);
		a.setPossesseur(m);
		java.util.Date d1 = new java.util.Date();
		java.sql.Date d2 = new java.sql.Date(d1.getTime());
		a.setDateDepot(d2);
		em.persist(a);
	}

}
