package servlets;

	
import java.io.IOException;
import java.util.Collection;

	import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import facades.FacadeAvis;
import metier.Article;
import metier.Categorie;
import metier.Membre;
import metier.Avis;

	/**
	 * Servlet implementation class ServArticles
	 */
	@WebServlet("/ServAvis")
	public class ServAvis extends HttpServlet {
		@EJB
		FacadeAvis facadeAvis;
		
		private static final long serialVersionUID = 1L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public ServAvis() {
	        super();
	    }

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			this.doPost(request, response);
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String op = (String) request.getAttribute("op");
			if(op.equals("ajouterAvis")) {	
				request.getRequestDispatcher("/V2/synchronous/ajouterAvis.jsp").forward(request, response);
				
			}else if (op.equals("supprimerArticle")){
				Integer id = (Integer) request.getAttribute("idAvis");
				Avis avis = facadeAvis.findAvis(id);
				facadeAvis.supprimerAvis(avis);
				request.getRequestDispatcher("/V2/synchronous/avis.jsp").forward(request, response);
			}
			else if (op.equals("listeAvisPerso")){
				HttpSession session = request.getSession();
				Membre m = (Membre) session.getAttribute("session");
				Collection<Avis> avisM = facadeAvis.getAvis(m);
			}
			
			else if (op.equals("modifierArticle")){
				request.getRequestDispatcher("/V2/synchronous/ajouterAvis.jsp").forward(request, response);
			}

		}

}
