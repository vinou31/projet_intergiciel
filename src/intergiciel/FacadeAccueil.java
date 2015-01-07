package intergiciel;

import java.util.Collection;
import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
public class FacadeAccueil {

	@PersistenceContext
	EntityManager em;
	
	public Collection<Article> getArticles(){
		return em.createQuery("from Article", Article.class).getResultList();		
	}
	
	public Collection<Avis> getAvisArticle(Article article){
		return em.createQuery("from Avis", Avis.class).getResultList();
	}
}
