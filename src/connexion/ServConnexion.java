package connexion;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.Membre;

/**
 * Servlet implementation class ServConnexion
 */
@WebServlet("/ServConnexion")
public class ServConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SESSION = "session";
	private String vue;
       
	@EJB
	FacadeConnexion f;
	
   

	/**
     * @see HttpServlet#HttpServlet()
     */
    public ServConnexion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean connexion = f.connecter(request);
		request.setAttribute("connect", connexion);
		HttpSession session = request.getSession();
		if (connexion) {
			Membre m = f.getMembre(request);
			request.setAttribute("membre", f.getMembre(request));
			request.setAttribute(SESSION, m);
			session.setAttribute(SESSION, m);
			//vue = "/testResumeConnexion.jsp";
			vue = "/V2/synchronous/AccueilVrai.jsp";
		} else {
			request.setAttribute(SESSION, null);
			session.setAttribute(SESSION, null);
			vue = "/V2/synchronous/Connexion.jsp";
		}
		request.setAttribute("erreurs", f.getErreurs());
		
		
		
		this.getServletContext().getRequestDispatcher( vue ).forward( request, response );
	}

}
