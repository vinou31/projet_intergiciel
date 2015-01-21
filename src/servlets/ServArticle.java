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
import facades.FacadeArticle;
import facades.FacadeCompte;

/**
 * Servlet implementation class ServArticle
 */


@WebServlet("/ServArticle")
public class ServArticle extends HttpServlet {
	@EJB
	FacadeArticle facadeArticle;
	
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
		Integer id = (Integer) request.getAttribute("idArticle");
		Article article = facadeArticle.findArticle(id);
		request.setAttribute("vendeur",article.getPossesseur().getNom());
		request.setAttribute("description",article.getDescription());
		request.setAttribute("nom",article.getNom());
		request.setAttribute("img",article.getImage());
		request.setAttribute("prix", article.getPrixPropose());
		HttpSession session = request.getSession();
		Membre m = (Membre) session.getAttribute("session");
		request.setAttribute("start",m.getVille());
		request.setAttribute("end",article.getPossesseur().getVille());
		request.getRequestDispatcher("article.jsp").forward(request, response);
	}

}
