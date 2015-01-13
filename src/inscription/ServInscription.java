package inscription;

import intergiciel.FacadeCompte;
import intergiciel.Membre;

import java.io.IOException;
import java.util.Collection;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServInscritpion
 */
@WebServlet("/ServInscription")
public class ServInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_MEMBERS = "membres"; //UNIQUEMENT POUR LES TESTS
	public static final String ATT_USER = "utilisateur";
    public static final String ATT_FORM = "form";
    //public static final String VUE = "/inscription.jsp";  //a modifier 
    //public static final String VUE = "/index.html"; 
    public static final String VUE = "/testResumeInscription.jsp";
    /**
     * @see HttpServlet#HttpServlet()
     */
    @EJB
    FacadeCompte f;
    
    public ServInscription() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String op = request.getParameter("op");
		if(op.equals("liste")){
			//Collection<Membre> lm = f.getMembres();
			request.setAttribute(ATT_MEMBERS, f.getMembres());
			this.getServletContext().getRequestDispatcher( "/listeMembres.jsp" ).forward( request, response );
		}
		 //getServletContext ou request ?
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/* Préparation de l'objet formulaire */

		
        /* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */
        Membre utilisateur = f.inscrireUtilisateur( request );
        
        //Collection<Membre> lm = f.getMembre();
		
        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute( ATT_FORM, f );
        request.setAttribute( ATT_USER, utilisateur );
        request.setAttribute("nbPseudoIdentiques", f.estDejaPresent("speedr"));
        
        
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

}
