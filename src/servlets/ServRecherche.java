package servlets;

import java.io.IOException;
import java.util.Collection;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Article;
import facades.FacadeArticle;

/**
 * Servlet implementation class ServRecherche
 */
@WebServlet("/ServRecherche")
public class ServRecherche extends HttpServlet {
	@EJB
	FacadeArticle facadeArticle;
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
		String search = request.getParameter("search");
		Collection<Article> articles = facadeArticle.getArticles();
		request.setAttribute("articles", articles);
		request.getRequestDispatcher("/V2/synchronous/articles.jsp").forward(request, response);
	}

}
