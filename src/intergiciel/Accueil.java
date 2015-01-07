package intergiciel;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Accueil")
public class Accueil extends HttpServlet {
	
	@EJB
	FacadeAccueil facadeAccueil;
	
	@EJB
	FacadeCompte facadeCompte;
	
	public Accueil() {
		super();
	}

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.setAttribute("article", facadeAccueil.getArticles());
		req.getRequestDispatcher("Accueil.jsp").forward(req, resp);
		/*String op = req.getParameter("op");
		switch (op){
		case "compte": 
			Collection<Membre> listMembre = facadeCompte.getMembre();
			req.getRequestDispatcher("Compte.jsp").forward(req, resp);
			break;
		}*/
	}



}
