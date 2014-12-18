package projet_intergiciel;

import java.sql.Date;
import java.util.Collection;
import java.util.Map;

public class Membre {
	

	private String nom;
	private int identifiant;
	private String mail;
	private String adresse;
	private int telephone;
	private String pseudonyme;
	private int porteMonnaie;
	private Date dateInscription;
	private Collection<Article> propose;
	private Map<Article, Troc> convoite;
	private Collection<Avis> estNote;
	
	//constructeur vide
	public Membre(){}
	
	
	//constructeur avec tous les attributs
	public Membre(String nom, int identifiant, String mail, String adresse, int telephone, String pseudonyme, int porteMonnaie, Date dateInscription) {
		super();
		this.nom = nom;
		this.identifiant = identifiant;
		this.mail = mail;
		this.adresse = adresse;
		this.telephone = telephone;
		this.pseudonyme = pseudonyme;
		this.porteMonnaie = porteMonnaie;
		this.dateInscription = dateInscription;
	}
	
	//a mettre dans la facade
	public void acheter(int montant, Membre vendeur){
		vendeur.porteMonnaie+=montant;
		this.porteMonnaie-=montant;
	}
	
	public void vendre(int montant, Membre acheteur){
		this.porteMonnaie+=montant;
		acheteur.porteMonnaie-=montant;
	}
	
	
	//tous les getteurs et setteurs
	
	public String getNom() {
		return nom;
	}
	public Collection<Article> getPropose() {
		return propose;
	}
	public void setPropose(Collection<Article> propose) {
		this.propose = propose;
	}
	public Map<Article, Troc> getConvoite() {
		return convoite;
	}
	public void setConvoite(Map<Article, Troc> convoite) {
		this.convoite = convoite;
	}
	public Collection<Avis> getEstNote() {
		return estNote;
	}
	public void setEstNote(Collection<Avis> estNote) {
		this.estNote = estNote;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getTelephone() {
		return telephone;
	}
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
	public String getPseudonyme() {
		return pseudonyme;
	}
	public void setPseudonyme(String pseudonyme) {
		this.pseudonyme = pseudonyme;
	}
	public int getPorteMonnaie() {
		return porteMonnaie;
	}
	public void setPorteMonnaie(int porteMonnaie) {
		this.porteMonnaie = porteMonnaie;
	}
	public Date getDateInscription() {
		return dateInscription;
	}
	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}

}
