package inscription;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.Membre;
import facades.FacadeCompte;

/**
 * Servlet implementation class ServInscritpion
 */
@WebServlet("/ServInscription")
public class ServInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_MEMBERS = "membres"; // UNIQUEMENT POUR LES
														// TESTS
	public static final String ATT_USER = "membre";
	public static final String ATT_FORM = "form";
	// public static final String VUE = "/inscription.jsp"; //a modifier
	// public static final String VUE = "/index.html";
	// public static final String VUE = "/testResumeInscription.jsp";
	public static final String VUE = "/V2/synchronous/AccueilVrai.jsp";
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// String op = request.getParameter("op");
		// if(op.equals("liste")){
		// //Collection<Membre> lm = f.getMembres();
		// request.setAttribute(ATT_MEMBERS, f.getMembres());
		// this.getServletContext().getRequestDispatcher( "/listeMembres.jsp"
		// ).forward( request, response );
		// }
		// else{
		this.getServletContext()
				.getRequestDispatcher("/V2/synchronous/inscription.html")
				.forward(request, response);
		// }
		// getServletContext ou request ?
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/* Préparation de l'objet formulaire */

		/*
		 * Appel au traitement et à la validation de la requête, et récupération
		 * du bean en résultant
		 */
		Membre utilisateur = f.inscrireUtilisateur(request);
		// if(f.getErreurs().isEmpty()){
		HttpSession session = request.getSession();
		session.setAttribute("membre", utilisateur);
		request.setAttribute(ATT_FORM, f);
		request.setAttribute("membre", utilisateur);
		request.setAttribute("nbPseudoIdentiques", f.estDejaPresent("speedr"));
		String vue = "/V2/synchronous/AccueilVrai.jsp";
		// }else{
		// vue = "/V2/synchronous/Inscription.jsp";
		// }

		// Collection<Membre> lm = f.getMembre();

		/* Stockage du formulaire et du bean dans l'objet request */
		
		System.out.println("testInscription");
		if (this.getServletContext() == null) {
			System.out.println("servletcontext null");
		}
		if (request == null) {
			System.out.println("request null");
		}
		if (response == null) {
			System.out.println("response null");
		}

		this.getServletContext()
				.getRequestDispatcher("/V2/synchronous/AccueilVrai.jsp")
				.forward(request, response);
		// this.getServletContext().getRequestDispatcher(
		// "/V2/synchronous/AccueilVrai.jsp" ).forward( request, response );
		// request.getRequestDispatcher( vue ).forward( request, response );
	}

}
