package facades;

import java.util.Collection;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import metier.Membre;
import metier.Avis;

@Stateful
public class FacadeAvis {
	@PersistenceContext
	EntityManager em;
	
	public void creerAvis(Membre mConcerne, int note, String critique){
		Avis avis = new Avis();
		avis.setMembre(mConcerne);
		avis.setNote(note);
		avis.setCritique(critique);
		java.util.Date d1 = new java.util.Date();
		java.sql.Date d2 = new java.sql.Date(d1.getTime());
		avis.setDatePublication(d2);
		em.persist(avis);
		
	}
	
	public void modifierAvis(Avis avisModif, int note, String critique){
		em.find(Avis.class, avisModif.getID()).setCritique(critique);
		em.find(Avis.class, avisModif.getID()).setNote(note);
		java.util.Date d1 = new java.util.Date();
		java.sql.Date d2 = new java.sql.Date(d1.getTime());
		em.find(Avis.class, avisModif.getID()).setDatePublication(d2);
		
	}
	
	public Avis findAvis(int aid){
		return (Avis) em.createNativeQuery("select * from Avis where ID ="+aid+";");
	}
	
	public void supprimerAvis(Avis avis){
		em.createNativeQuery("delete * from avis where Avis="+avis+";");
		
	}
	
	@SuppressWarnings("unchecked")
	public Collection<Avis> getAvis(Membre m){
		return (Collection<Avis>) em.createNativeQuery("select * from Avis where membre ="+m+";").getResultList();
	}

	
}
