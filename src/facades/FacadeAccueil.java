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
		m.setNom("Boucheraa");
		m.setMail("alvin.boucheraa@etu.enseeiht.fr");
		m.setAdresse("4 rue Pierre Laplace");
		m.setTelephone("0649607777");
		m.setPseudonyme("vinou");
		m.setPorteMonnaie(0);
		java.util.Date d1 = new java.util.Date();
		java.sql.Date d2 = new java.sql.Date(d1.getTime());
		m.setDateInscription(d2);
		m.setMotDePasse("200793");
		m.setPrenom("Alvin");
		m.setVille("Toulouse");
		em.persist(m);
		
		Membre m2 = new Membre();
		m2.setNom("Bioy");
		m2.setMail("marianne.bioy@etu.enseeiht.fr");
		m2.setAdresse("rue de la gare");
		m2.setTelephone("0605253142");
		m2.setPseudonyme("pixie");
		m2.setPorteMonnaie(0);
		m2.setDateInscription(d2);
		m2.setMotDePasse("pixie");
		m2.setPrenom("Marianne");
		m2.setVille("Paris");
		em.persist(m2);
		
		Membre m3 = new Membre();
		m3.setNom("Theodose");
		m3.setMail("ruddy.theodose@etu.enseeiht.fr");
		m3.setAdresse("rue de compans");
		m3.setTelephone("0658963425");
		m3.setPseudonyme("speedr972");
		m3.setPorteMonnaie(0);
		m3.setDateInscription(d2);
		m3.setMotDePasse("972");
		m3.setPrenom("Ruddy");
		m3.setVille("Bordeaux");
		em.persist(m3);
		
		Membre m4 = new Membre();
		m4.setNom("Eccli");
		m4.setMail("kevin.eccli@etu.enseeiht.fr");
		m4.setAdresse("rue de jeanne d'arc");
		m4.setTelephone("0658963563");
		m4.setPseudonyme("gitan");
		m4.setPorteMonnaie(0);
		m4.setDateInscription(d2);
		m4.setMotDePasse("gitan");
		m4.setPrenom("Kevin");
		m4.setVille("Marspich");
		em.persist(m4);
		
		

		
		
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
		a.setDescription("ordi acer peu utilisé");
		a.setDateDepot(d2);
		a.setNom("ordiAcer");
		a.setPrixPropose("500 € ou un ordinateur Alienware");
		a.setEstdeType(c2);
		a.setImage("/intergiciel/V2/synchronous/images/acer.jpg");
		em.persist(a);
		a.setPossesseur(m);	
		
		Article a1 = new Article();
		a1.setDescription("ordi Alienware, peu utilisé, je n'en ai plus besoin (femme anti-gamer)");
		a1.setDateDepot(d2);
		a1.setNom("ordiA");
		a1.setPrixPropose("600 € ou ordi standard");
		a1.setEstdeType(c3);
		a1.setImage("/intergiciel/V2/synchronous/images/alienware.jpg");
		em.persist(a1);
		a1.setPossesseur(m4);
		
		Article a2 = new Article();
		a2.setDescription("Machine à laver à donner car je ne veux pas la jeter elle foncitonne encore. Moi je déménage donc bon, j'espère qu'elle trouvera preneur.");
		a2.setDateDepot(d2);
		a2.setNom("machine");
		a2.setPrixPropose("nada");
		a2.setEstdeType(c5);
		a2.setImage("/intergiciel/V2/synchronous/images/machine.jpg");
		em.persist(a2);
		a2.setPossesseur(m2);

		
		
	}
	
}
