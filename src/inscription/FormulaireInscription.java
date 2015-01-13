package inscription;

import intergiciel.Membre;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
@Stateful
public class FormulaireInscription {
	private static final String CHAMP_NOM    = "nom";
	private static final String CHAMP_MAIL  = "mail";
    private static final String CHAMP_PASS   = "motdepasse";
    private static final String CHAMP_CONF   = "confirmation";
    
	private static final String CHAMP_ADRESSE    = "adresse";
	private static final String CHAMP_TELEPHONE    = "telephone";
	private static final String CHAMP_PSEUDONYME    = "pseudonyme";
	private static final String CHAMP_PORTEMONNAIE    = "portemonnaie";
	
//	@EJB
//	private FacadeCompte f;
	
	@PersistenceContext (unitName="cours")
	EntityManager em;
	
//	@PersistenceUnit 
//	EntityManagerFactory emf;
    
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
    

    public Membre inscrireUtilisateur( HttpServletRequest request ) {
    //public void inscrireUtilisateur( HttpServletRequest request ) {
    	
    	
    	String nom = getValeurChamp( request, CHAMP_NOM );
    	String mail = getValeurChamp( request, CHAMP_MAIL );
        String motDePasse = getValeurChamp( request, CHAMP_PASS );
        String confirmation = getValeurChamp( request, CHAMP_CONF );
        
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
        
        utilisateur.setPorteMonnaie(0);

        if ( erreurs.isEmpty() ) {
            resultat = "Succès de l'inscription.";
            
        } else {
            resultat = "Échec de l'inscription.";
        }
        System.out.print(resultat);
        //f.creerMembre(utilisateur);
        em.persist(utilisateur);
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
    
    private void validationPseudonyme( String nom ) throws Exception {
        if ( nom != null && nom.length() < 3 ) {
            throw new Exception( "Le pseudonyme doit contenir au moins 3 caractères." );
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
    
    public boolean estDanslaBD(String pseudo){
    	return true;
    }

}
