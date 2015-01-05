package projet_intergiciel;

import java.sql.Date;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class FacadeCompte {
	private Collection<Membre> compte;
	
	
	public FacadeCompte() {
		this.compte = new HashSet<Membre>();
	}

	public void creerCompte(String nom, int identifiant, String mail, String adresse, int telephone, String pseudonyme, int porteMonnaie, Date dateInscription, String mdp){
		Membre m = new Membre(nom, identifiant, mail, adresse, telephone, pseudonyme, porteMonnaie, dateInscription, mdp);
		if (this.compte.contains(m)){
			throw new membreExisteException();
		}
		this.compte.add(m);
	}

	public void modifierMotDePasse(Membre m, String newMDP){
		Iterator<Membre> it = compte.iterator();
		boolean trouve = false;
		while (it.hasNext() && !trouve){
			trouve = it.equals(m);
			it.next();
		}
		m.setMotDePasse(newMDP);;
		
	}
	
	public void resilierCompte(Membre m){
		compte.remove(m);
	}
	
	public void modifierCompte(){
		
	}

	public Collection<Membre> getCompte() {
		return compte;
	}

	public void setCompte(Collection<Membre> compte) {
		this.compte = compte;
	}



	
	
	
}
