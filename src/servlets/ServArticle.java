package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Article;
import metier.Membre;
import facades.FacadeCompte;

/**
 * Servlet implementation class ServArticle
 */

@EJB
FacadeArticle facadeArticle;

@WebServlet("/ServArticle")
public class ServArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServArticle() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = request.getAttribute("idArticle");
		Article article = facadeArticle.findArticle(id);
		request.setAttribute("vendeur",article.getPossesseur().getNom());
		request.setAttribute("description",article.getDescription());
		Membre m = (Membre) session.getAttribute("session");
		request.setAttribute("start",m.getVille());
		request.setAttribute("end",article.getPossesseur().getVille());
		req.getRequestDispatcher("article.jsp").forward(request, response);
	}

}
