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
		Integer op = (Integer) request.getAttribute("op");
		if(op==0) {
			HttpSession session = request.getSession();
			Membre m = (Membre) session.getAttribute("session");
			Collection<Article> articles = facadeArticle.getArticles(m.getID());
			
		}else{
			String categorie = (String) request.getParameter("categorie");
			String sousCategorie = (String) request.getParameter("sousCategorie");
			Collection<Categorie> categories = facadeArticle.getCategories();
			facadeArticle.getSousCategorie(sousCategorie);
		}
		

	}

}
