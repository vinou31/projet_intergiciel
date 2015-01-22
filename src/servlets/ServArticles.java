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

import facades.FacadeAccueil;
import facades.FacadeArticle;
import metier.Article;
import metier.Categorie;
import metier.Membre;

/**
 * Servlet implementation class ServArticles
 */
@WebServlet("/ServArticles")
public class ServArticles extends HttpServlet {
	@EJB
	FacadeArticle facadeArticle;
	
	@EJB
	FacadeAccueil facadeAccueil;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServArticles() {
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
		Collection<Article> articles = null;
		//Integer op = (Integer) request.getAttribute("op");
		HttpSession session = request.getSession();
		Membre m = (Membre) session.getAttribute("membre");
		String op = (String) request.getParameter("op");
		request.setAttribute("categorie", facadeAccueil.getCategories());
		request.setAttribute("membre", m);
		switch(op){
		case "articlesEnVente" :
			//Articles de l'utilisateur
			articles = facadeArticle.getArticles();
			request.setAttribute("articles", articles);
			request.getRequestDispatcher("/V2/synchronous/articles.jsp").forward(request, response);
			break;
		case "afficher":
			articles = (Collection<Article>)request.getAttribute("articles");
			request.setAttribute("articles", articles);
			request.getRequestDispatcher("/V2/synchronous/articles.jsp").forward(request, response);
			break;
		case "articlesEnVenteCat" :
			Integer idCat = Integer.parseInt((String)request.getParameter("idCat"));
			articles = facadeArticle.getArticlesFromCategories(idCat);
			request.setAttribute("articles", articles);
			request.getRequestDispatcher("/V2/synchronous/articles.jsp").forward(request, response);
			break;
		case "ajout" :
			request.getRequestDispatcher("/V2/synchronous/AjouterArticle.jsp").forward(request, response);
			break;
		case "mes articles" :
			request.setAttribute("articles", m.getPropose());
			request.getRequestDispatcher("/V2/synchronous/articles.jsp").forward(request, response);
			break;
		default :
			//Articles d'une categorie
			//int idCat = Integer.parseInt(request.getParameter("idCat"));
			//articles = facadeArticle.getCategories(idCat);
			request.setAttribute("articles", articles);
			request.getRequestDispatcher("/V2/synchronous/articles.jsp").forward(request, response);
		}

	}

}
