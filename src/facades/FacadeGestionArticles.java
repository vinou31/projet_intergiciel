package facades;

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
		em.persist(a);
	}

}
