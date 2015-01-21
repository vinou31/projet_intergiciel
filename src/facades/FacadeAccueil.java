package facades;

import java.util.Collection;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import metier.Article;
import metier.Avis;
import metier.Membre;

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
	
	public void  initialiserBD(){
		Membre m = new Membre();
		m.setNom("test1");
		m.setMail("a.b@c.d");
		m.setAdresse("gitanBat");
		m.setTelephone("5648545816");
		m.setPseudonyme("gitan");
		m.setPorteMonnaie(0);
		java.util.Date d1 = new java.util.Date();
		java.sql.Date d2 = new java.sql.Date(d1.getTime());
		m.setDateInscription(d2);
		m.setMotDePasse("gitan");
		m.setPrenom("supergitan");
		m.setVille("gitanVille");
		em.persist(m);
		
		Membre m2 = new Membre();
		m2.setNom("Yolo");
		m2.setMail("q.s@d.f");
		m2.setAdresse("yoloBat");
		m2.setTelephone("9846549561");
		m2.setPseudonyme("yolo");
		m2.setPorteMonnaie(0);
		m2.setDateInscription(d2);
		m2.setMotDePasse("yolo");
		m2.setPrenom("suryolo");
		m2.setVille("yoloVille");
		em.persist(m2);
		
		Membre m3 = new Membre();
		m3.setNom("Aleatoire");
		m3.setMail("w.x@c.v");
		m3.setAdresse("randomBat");
		m3.setTelephone("8489479485");
		m3.setPseudonyme("random");
		m3.setPorteMonnaie(0);
		m3.setDateInscription(d2);
		m3.setMotDePasse("random");
		m3.setPrenom("Srandom");
		m3.setVille("randomCity");
		em.persist(m3);
		
		
		Article a = new Article();
		a.setDescription("testArtcle");
		a.setDateDepot(d2);
		a.setNom("testArticle");
		a.setPossesseur(m3);
		em.persist(a);
	}
	
}
