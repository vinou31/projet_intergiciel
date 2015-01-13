package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import facades.FacadeAccueil;

@WebServlet("/Accueil")
public class ServAccueil extends HttpServlet {
	
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
		req.setAttribute("article", facadeAccueil.getArticles());
		req.getRequestDispatcher("Accueil.jsp").forward(req, resp);
	}



}
