package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.Membre;
import facades.FacadeAccueil;


@WebServlet("/Accueil")
public class ServAccueil extends HttpServlet {
	public static int defaut = 0;
	@EJB
	FacadeAccueil facadeAccueil;

	
	public ServAccueil() {
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
		HttpSession session = req.getSession();
		Membre m = (Membre) session.getAttribute("membre");
		//req.getRequestDispatcher("V2/synchronous/AccueilVrai.jsp").forward(req, resp);
		if (defaut==0){
		facadeAccueil.initialiserBD();
		defaut++;}
		req.setAttribute("articles", facadeAccueil.getArticles());
		req.setAttribute("categorie", facadeAccueil.getCategories());
		req.setAttribute("membre", m);
		this.getServletContext().getRequestDispatcher("/V2/synchronous/AccueilVrai.jsp").forward(req, resp);
		//req.getRequestDispatcher("/V2/synchronous/AccueilVrai.jsp").forward(req, resp);
		/*String op = req.getParameter("op");
		switch (op){
		case "compte": 
			Collection<Membre> listMembre = facadeCompte.getMembre();
			req.getRequestDispatcher("Compte.jsp").forward(req, resp);
			break;
		}*/
	}



}
