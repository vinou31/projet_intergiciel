package facades;

import java.util.Collection;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import exception.ArticlePresent;
import metier.Article;
import metier.Avis;
import metier.Categorie;
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
	
	public Collection<Categorie> getCategories() {
		return em.createQuery("from Categorie where parent=null", Categorie.class).getResultList();
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
		
		

		
		
		Categorie c = new Categorie("ordinateur");
		Categorie c2 = new Categorie("Acer");
		Categorie c3 = new Categorie("AlienWare");
		c2.setParent(c);
		c3.setParent(c);
		Categorie c4 = new Categorie("Electroménager");
		Categorie c5 = new Categorie("Machine à laver");
		c5.setParent(c4);
		em.persist(c);
		em.persist(c2);
		em.persist(c3);
		em.persist(c4);
		em.persist(c5);

		Article a = new Article();
		a.setDescription("testArtcle");
		a.setDateDepot(d2);
		a.setNom("testArticle");
		a.setPrixPropose(0);
		a.setEstdeType(c2);
		a.setImage("V2/synchronous/images/JPEG.jpg");
		em.persist(a);
		a.setPossesseur(m3);	

		
		
	}
	
}
