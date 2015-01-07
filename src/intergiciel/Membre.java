package intergiciel;

import java.sql.Date;
import java.util.Collection;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Membre {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ID;
	
	private String nom;
	private String mail;
	private String adresse;
	private int telephone;
	private String pseudonyme;
	private int porteMonnaie;
	private Date dateInscription;
	@OneToMany(mappedBy="possesseur", fetch=FetchType.EAGER)
	private Set<Article> propose;
	@OneToMany(mappedBy="membre", fetch=FetchType.EAGER)
	private Set<Troc> mesTrocs;
	@OneToMany(mappedBy="membre", fetch=FetchType.EAGER)
	private Set<Avis> estNote;
	private String motDePasse;
	
	//constructeur vide
	public Membre(){}
	
	
	//constructeur avec tous les attributs
	public Membre(String nom, String mail, String adresse, int telephone, String pseudonyme, int porteMonnaie, Date dateInscription, String mdp) {
		super();
		this.nom = nom;
		this.mail = mail;
		this.adresse = adresse;
		this.telephone = telephone;
		this.pseudonyme = pseudonyme;
		this.porteMonnaie = porteMonnaie;
		this.dateInscription = dateInscription;
		this.motDePasse = mdp;
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
	public Set<Article> getPropose() {
		return propose;
	}
	public void setPropose(Set<Article> propose) {
		this.propose = propose;
	}

	public Collection<Avis> getEstNote() {
		return estNote;
	}
	public void setEstNote(Set<Avis> estNote) {
		this.estNote = estNote;
	}
	public void setNom(String nom) {
		this.nom = nom;
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


	public String getMotDePasse() {
		return motDePasse;
	}


	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}


	public Collection<Troc> getMesTrocs() {
		return mesTrocs;
	}


	public void setMesTrocs(Set<Troc> mesTrocs) {
		this.mesTrocs = mesTrocs;
	}


	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}
	
	

}
