package facades;

//import java.sql.Date;
import java.util.Collection;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;

import metier.Membre;

@Stateful
public class FacadeCompte {
	
	@PersistenceContext
	EntityManager em;
	
	public FacadeCompte(){
		
	}
	
	public void creerMembre(String nom, String mail, String adresse, String telephone, String pseudonyme, Date dateInscription, String mdp){
		//Membre m = new Membre(nom, mail, adresse, telephone, pseudonyme, 0, dateInscription, mdp);
		Membre m = new Membre();
		m.setNom(nom);
		m.setMail(mail);
		m.setAdresse(adresse);
		m.setTelephone(telephone);
		m.setPseudonyme(pseudonyme);
		m.setPorteMonnaie(0);
		java.util.Date d1 = new java.util.Date();
		java.sql.Date d2 = new java.sql.Date(d1.getTime());
		m.setDateInscription(d2);
		m.setMotDePasse(mdp);
		em.persist(m);
		
	}
	
	public void creerMembre(Membre m){
		em.persist(m);
		
	}

	public void modifierMotDePasse(Membre m, String newMDP){
		em.find(Membre.class, m.getID()).setMotDePasse(newMDP);
		
	}
	
	public void modifierNom(Membre m, String newNom){
		em.find(Membre.class, m.getID()).setNom(newNom);
	}
	
	public void modifierMail(Membre m, String newMail) {
		em.find(Membre.class, m.getID()).setMail(newMail);
	}
	
	public void modifierAdresse(Membre m, String newAdresse) {
		em.find(Membre.class, m.getID()).setAdresse(newAdresse);
	}
	
	public void modifierTel(Membre m, String newTel) {
		em.find(Membre.class, m.getID()).setTelephone(newTel);
	}
	
	public void modifierPseudo(Membre m, String newPseudo) {
		em.find(Membre.class, m.getID()).setPseudonyme(newPseudo);
	}
	
	public void resilierMembre(Membre m){
		em.remove(m);
	}
	
	public Membre getMembre(Membre m){
		return em.find(Membre.class, m.getID());
	}

	public Collection<Membre> getMembres() {
		//return (List<Membre>)em.createQuery("from Membre", Membre.class).getResultList();
		return em.createNativeQuery("SELECT * FROM Membre;").getResultList();
	}
	
	public boolean estDejaPresent(String pseudo){
		Collection<String> ls = (Collection<String>) em.createNativeQuery("SELECT pseudonyme FROM Membre WHERE pseudonyme='"+pseudo+"';").getResultList();
		return(ls.size()!=0);
	}
	
	public void acheter(int montant, Membre vendeur){
		vendeur.setPorteMonnaie(vendeur.getPorteMonnaie()+montant);
		
	}
	
	public void vendre(int montant, Membre acheteur){
		acheteur.setPorteMonnaie(acheteur.getPorteMonnaie()+montant);
	}

	/////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////Verification données entrees///////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////
	private static final String CHAMP_NOM    = "nom";
	private static final String CHAMP_MAIL  = "mail";
    private static final String CHAMP_PASS   = "motdepasse";
    private static final String CHAMP_CONF   = "confirmation";
    private static final String CHAMP_PRENOM   = "prenom";
    private static final String CHAMP_VILLE   = "ville";
	private static final String CHAMP_ADRESSE    = "adresse";
	private static final String CHAMP_TELEPHONE    = "telephone";
	private static final String CHAMP_PSEUDONYME    = "pseudonyme";
	private static final String CHAMP_PORTEMONNAIE    = "portemonnaie";
	
    
    //renvoie le resultat de l'inscription
    private String resultat;
    //tableau qui associe les erreurs de chaque champ
    private Map<String, String> erreurs = new HashMap<String, String>();

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }
    
    public int nbMemePseudo(String pseudo){
    	return em.createNativeQuery("SELECT pseudonyme FROM Membre WHERE pseudonyme='"+pseudo+"';").getResultList().size();
    }
    

    public Membre inscrireUtilisateur( HttpServletRequest request ) {
    //public void inscrireUtilisateur( HttpServletRequest request ) {
    	
    	
    	String nom = getValeurChamp( request, CHAMP_NOM );
    	String mail = getValeurChamp( request, CHAMP_MAIL );
        String motDePasse = getValeurChamp( request, CHAMP_PASS );
        String confirmation = getValeurChamp( request, CHAMP_CONF );
        String prenom = getValeurChamp( request, CHAMP_PRENOM );
        String ville = getValeurChamp( request, CHAMP_VILLE );
        String adresse = getValeurChamp( request, CHAMP_ADRESSE );
    	String telephone = getValeurChamp( request, CHAMP_TELEPHONE );
    	String pseudonyme = getValeurChamp( request, CHAMP_PSEUDONYME );
        String  portemonnaie= getValeurChamp( request, CHAMP_PORTEMONNAIE );
        

        Membre utilisateur = new Membre();
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FacadeCompte");
//        EntityManager em = emf.createEntityManager();

        try {
            validationEmail( mail );
            
        } catch ( Exception e ) {
            setErreur( CHAMP_MAIL, e.getMessage() );
        }
        utilisateur.setMail( mail );

        try {
            validationMotsDePasse( motDePasse, confirmation );
        } catch ( Exception e ) {
            setErreur( CHAMP_PASS, e.getMessage() );
            setErreur( CHAMP_CONF, null );
        }
        utilisateur.setMotDePasse( motDePasse );

        try {
            validationAdresse( adresse );
        } catch ( Exception e ) {
            setErreur( CHAMP_ADRESSE, e.getMessage() );
        }
        utilisateur.setAdresse( adresse );
        
        try {
            validationTelephone( telephone );
            //utilisateur.setTelephone(telephone);
        } catch ( Exception e ) {
            setErreur( CHAMP_TELEPHONE, e.getMessage() );
        }
        utilisateur.setTelephone(telephone);

        
        try {
            validationPseudonyme(pseudonyme);
        } catch ( Exception e ) {
            setErreur( CHAMP_PSEUDONYME, e.getMessage() );
        }
        utilisateur.setPseudonyme( pseudonyme );
        
        try {
            
        } catch ( Exception e ) {
            setErreur( CHAMP_NOM, e.getMessage() );
        }
        utilisateur.setNom( nom );
        
        try {
            validationNom( nom );
        } catch ( Exception e ) {
            setErreur( CHAMP_NOM, e.getMessage() );
        }
        utilisateur.setNom( nom );
        
        
        try {
            validationPrenom( prenom );
        } catch ( Exception e ) {
            setErreur( CHAMP_PRENOM, e.getMessage() );
        }
        utilisateur.setPrenom( prenom );
        
        
        try {
            validationVille(ville);
        } catch ( Exception e ) {
            setErreur( CHAMP_VILLE, e.getMessage() );
        }
        utilisateur.setVille(ville);
        
        
        utilisateur.setPorteMonnaie(0);
        java.util.Date d1 = new java.util.Date();
		java.sql.Date d2 = new java.sql.Date(d1.getTime());
        utilisateur.setDateInscription(d2);

        if ( erreurs.isEmpty() ) {
            resultat = "Succès de l'inscription.";
            
        } else {
            resultat = "Échec de l'inscription.";
        }
        System.out.print(resultat);
        //f.creerMembre(utilisateur);
        creerMembre(utilisateur);
        return utilisateur;
    }
    //////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////fonctions de validation////////////////////////////////////////////
    private void validationEmail( String email ) throws Exception {
        if ( email != null ) {
            if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
                throw new Exception( "Merci de saisir une adresse mail valide." );
            }
        } else {
            throw new Exception( "Merci de saisir une adresse mail." );
        }
    }

    private void validationMotsDePasse( String motDePasse, String confirmation ) throws Exception {
        if ( motDePasse != null && confirmation != null ) {
            if ( !motDePasse.equals( confirmation ) ) {
                throw new Exception( "Les mots de passe entrés sont différents, merci de les saisir à nouveau." );
            } else if ( motDePasse.length() < 3 ) {
                throw new Exception( "Les mots de passe doivent contenir au moins 3 caractères." );
            }
        } else {
            throw new Exception( "Merci de saisir et confirmer votre mot de passe." );
        }
    }

    private void validationNom( String nom ) throws Exception {
        if ( nom != null && nom.length() < 3 ) {
            throw new Exception( "Le nom d'utilisateur doit contenir au moins 3 caractères." );
        }
    }
    
    private void validationAdresse( String adresse ) throws Exception {
        if ( adresse != null && adresse.length() < 3 ) {
            throw new Exception( "Le nom d'utilisateur doit contenir au moins 3 caractères." );
        }
    }
    
    private void validationTelephone( String num ) throws Exception {
        if ( num != null ) {
            throw new Exception( "Le numéro inséré n'est pas valide." );
        }
//        try{
//        	int i = Integer.parseInt(num);
//        }catch(NumberFormatException e){
//        	throw new Exception( "Le numéro inséré n'est pas valide." );
//        }
    }
    
    private void validationPseudonyme( String pseudo ) throws Exception {
        if ( pseudo != null && pseudo.length() < 3 ) {
            throw new Exception( "Le pseudonyme doit contenir au moins 3 caractères." );
        }
        if(estDejaPresent(pseudo)){
        	throw new Exception("Le pseudonyme est déja enregistré");
        }
    }
    
    
    private void validationPrenom( String nom ) throws Exception {
        if ( nom != null && nom.length() < 3 ) {
            throw new Exception( "Le nom d'utilisateur doit contenir au moins 3 caractères." );
        }
    }
    
    private void validationVille( String nom ) throws Exception {
        if ( nom != null && nom.length() < 3 ) {
            throw new Exception( "Le nom d'utilisateur doit contenir au moins 3 caractères." );
        }
    }
    
//////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////
    /*
     * Ajoute un message correspondant au champ spécifié à la map des erreurs.
     */
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur.trim();
        }
    }
    
/////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////
    
    
/////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////
	
}
