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

import metier.Article;
import metier.Membre;
import facades.FacadeAccueil;
import facades.FacadeArticle;

/**
 * Servlet implementation class ServRecherche
 */
@WebServlet("/ServRecherche")
public class ServRecherche extends HttpServlet {
	@EJB
	FacadeArticle facadeArticle;
	
	@EJB
	FacadeAccueil facadeAccueil;
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServRecherche() {
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
		HttpSession session = request.getSession();
		Membre m = (Membre) session.getAttribute("membre");
		request.setAttribute("categorie", facadeAccueil.getCategories());
		request.setAttribute("membre", m);
		String search = request.getParameter("search");
		Collection<Article> articles = facadeArticle.getArticlesNom(search);
		request.setAttribute("articles", articles);
		request.setAttribute("op", "afficher");
		request.getRequestDispatcher("/V2/synchronous/articles.jsp").forward(request, response);
	}

}
