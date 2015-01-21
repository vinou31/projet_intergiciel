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
		Collection<Article> articles;
		//Integer op = (Integer) request.getAttribute("op");
		String op = (String) request.getAttribute("op");
		if(op.equals("mes articles")) {
			//Articles de l'utilisateur
			HttpSession session = request.getSession();
			Membre m = (Membre) session.getAttribute("session");
			articles = facadeArticle.getArticles(m.getID());
		}else{
			//Articles d'une categorie
			int idCat = Integer.parseInt(request.getParameter("idCat"));
			articles = facadeArticle.getCategories(idCat);
		}
		request.setAttribute("articles", articles);
		request.getRequestDispatcher("articles.jsp").forward(request, response);
	}

}
