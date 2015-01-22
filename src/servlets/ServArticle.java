package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connexion.FacadeConnexion;
import metier.Article;
import metier.Membre;
import facades.FacadeAccueil;
import facades.FacadeArticle;
import facades.FacadeCompte;

/**
 * Servlet implementation class ServArticle
 */


@WebServlet("/ServArticle")
public class ServArticle extends HttpServlet {
	@EJB
	FacadeArticle facadeArticle;
	
	@EJB	
	FacadeAccueil	facadeAccueil;
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServArticle() {
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
		String op = (String)request.getParameter("op");
		HttpSession session = request.getSession();
		Membre m = (Membre) session.getAttribute("membre");
		request.setAttribute("categorie", facadeAccueil.getCategories());
		request.setAttribute("membre", m);
		switch(op){
		case "articleEnVue" :
			Integer id = Integer.parseInt((String)request.getParameter("idArticle"));
			Article article = facadeArticle.findArticle(id);
			request.setAttribute("vendeur",article.getPossesseur());
			request.setAttribute("description",article.getDescription());
			request.setAttribute("nom",article.getNom());
			request.setAttribute("img",article.getImage());
			request.setAttribute("prix", article.getPrixPropose());
			request.setAttribute("start",m.getVille());
			request.setAttribute("end",article.getPossesseur().getVille());
			request.setAttribute("id", id);
			request.setAttribute("start", m.getVille());
			request.setAttribute("end", article.getPossesseur().getVille());
			request.getRequestDispatcher("/V2/synchronous/article.jsp").forward(request, response);
			break;
		case "supprimerArticle" :
			Integer idsupp = Integer.parseInt((String)request.getParameter("id"));
			facadeArticle.supprimerArticle(idsupp);
			request.getRequestDispatcher("/ServArticles?op=mes+articles").forward(request, response);
			break;
		case "modifierArticle" :
			Integer idmodif = Integer.parseInt((String)request.getParameter("id"));
			request.setAttribute("id", idmodif);
			request.getRequestDispatcher("/Accueil").forward(request, response);
			break;
		}

	}

}
