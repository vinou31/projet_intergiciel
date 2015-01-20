package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.Membre;
import connexion.FacadeConnexion;
import facades.FacadeCompte;

@WebServlet("/ServCompte")
public class ServCompte extends HttpServlet {

	@EJB
	FacadeCompte facadecompte;
	@EJB
	FacadeConnexion facadeconnexion;
	/**
	 * 
	 */
	private static final long serialVersionUID = -4842750767803720120L;

	public ServCompte() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String op = (String) req.getParameter("op");
		
		switch(op){
		case "gestionCompte" :
			HttpSession session = req.getSession();
			Membre m = (Membre)session.getAttribute("Membre");
			req.setAttribute("Membre", m);
			req.getRequestDispatcher("/GestionCompte.jsp").forward(req, resp);
			break;
			default : System.out.println("coucou");
		}
		
	}

	
}
