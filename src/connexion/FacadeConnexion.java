package connexion;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;

import metier.Membre;

@Stateful
public class FacadeConnexion {
	@PersistenceContext
	EntityManager em;
	 //renvoie le resultat de l'inscription
    private String resultat;
    //tableau qui associe les erreurs de chaque champ
    private Map<String, String> erreurs = new HashMap<String, String>();

    
	public FacadeConnexion(){
		
	}
	
	public String getResultat() {
		return resultat;
	}

	public void setResultat(String resultat) {
		this.resultat = resultat;
	}

	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public void setErreurs(Map<String, String> erreurs) {
		this.erreurs = erreurs;
	}
	
	public void setErreurs(String champ, String message){
		this.erreurs.put(champ, message);
	}
	
//	public boolean connecter(String pseudo, String password){
//		//Membre m = em.createNativeQuery("SELECT * FROM Membre WHERE pseudonyme='"+pseudo+"';");
//		Membre m=em.createQuery("from Membre where pseudonyme='"+pseudo+"'", Membre.class).getResultList().get(0);
//		return (password.equals(m.getMotDePasse()));
//	}
//	
//	public Membre getMembre(String pseudo){
//		//return em.createNativeQuery("SELECT * FROM Membre WHERE pseudonyme='"+pseudo+"';").getResultList().get(0);
//		return  em.createQuery("from Membre where pseudonyme='"+pseudo+"'", Membre.class).getResultList().get(0);
//	}
	
	public boolean connecter (HttpServletRequest request){
		String pseudonyme = (String) request.getParameter("pseudonyme");
		String motDePasse = (String) request.getParameter("motDePasse");
		Membre m = null;
		boolean resultat = false;
		// Membre m =
		// em.createNativeQuery("SELECT * FROM Membre WHERE pseudonyme='"+pseudonyme+"';").getResultList().get(0);
		try {
			m = em.createQuery(
					"from Membre where pseudonyme='" + pseudonyme + "'",
					Membre.class).getResultList().get(0);
			if (motDePasse.equals(m.getMotDePasse())) {
				resultat = true;
			} else {
				setErreurs("exception", "Le mot de passe est mauvais");
			}
		} catch (Exception e) {
			setErreurs("exception",
					"Le pseudo n'est pas présent dans la base de données");
		}
		return resultat;
		
	}
	
	public Membre getMembre(HttpServletRequest request){
		String pseudonyme = (String)request.getParameter("pseudonyme");
		Membre m = null;
		//return em.createNativeQuery("SELECT * FROM Membre WHERE pseudonyme='"+pseudonyme+"';").getResultList().get(0);
		try{
		m =  em.createQuery("from Membre where pseudonyme='"+pseudonyme+"'", Membre.class).getResultList().get(0);
		}catch(Exception e){
			setErreurs("exception",
					"Le membre n'est pas présent dans la base de données");
		}
		return m;
	}
}
