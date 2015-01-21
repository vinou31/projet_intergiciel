package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.Article;
import metier.Membre;

/**
 * Servlet implementation class ServArticles
 */
@WebServlet("/ServArticles")
public class ServArticles extends HttpServlet {
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
			
		}else{
			String categorie = (String) request.getParameter("categorie");
			String sousCategorie = (String) request.getParameter("sousCategorie");
			
		}
		
		Integer id = (Integer) request.getAttribute("idArticle");
		Article article = facadeArticle.findArticle(id);
		request.setAttribute("vendeur",article.getPossesseur().getNom());
		request.setAttribute("description",article.getDescription());
		HttpSession session = request.getSession();
		Membre m = (Membre) session.getAttribute("session");
		request.setAttribute("start",m.getVille());
		request.setAttribute("end",article.getPossesseur().getVille());
		request.getRequestDispatcher("article.jsp").forward(request, response);
	}

}
