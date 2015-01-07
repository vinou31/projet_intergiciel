package intergiciel;

import java.sql.Date;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
public class FacadeCompte {
	
	@PersistenceContext
	EntityManager em;
	
	public FacadeCompte(){
		
	}
	
	public void creerMembre(String nom, String mail, String adresse, int telephone, String pseudonyme, int porteMonnaie, Date dateInscription, String mdp){
		Membre m = new Membre(nom, mail, adresse, telephone, pseudonyme, porteMonnaie, dateInscription, mdp);
		em.persist(m);
		
	}

	public void modifierMotDePasse(Membre m, String newMDP){
		em.find(Membre.class, m.getID()).setMotDePasse(newMDP);
		
	}
	
	public void resilierMembre(Membre m){
		em.remove(m);
	}
	
	public void modifierMembre(){
		
	}

	public List<Membre> getMembre() {
		return em.createQuery("from Membre", Membre.class).getResultList();
	}





	
	
	
}
