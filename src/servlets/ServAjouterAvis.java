package servlets;

import java.io.File;
import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import metier.Membre;
import facades.FacadeGestionArticles;

public class ServAjouterAvis {
	private static final long serialVersionUID = 1L;
	public static final String CHAMP_DESCRIPTION = "description";
	public static final String CHAMP_FICHIER = "fichier";
	public static final String VUE = "/formFichier.jsp";
	
	@EJB
	FacadeGestionArticles fga;
	/**
	 * Name of the directory where uploaded files will be saved, relative to the
	 * web application directory.
	 */
	private static final String SAVE_DIR = "uploadFiles";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServAjouterAvis() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * handles file upload
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// gets absolute path of the web application
		HttpSession session = request.getSession();
		Membre m = (Membre)session.getAttribute("membre");
		
		request.setAttribute("message", "Votre avis a bien été ajouté");
		//getServletContext().getRequestDispatcher("/resultUpload.jsp").forward(request, response);
		request.getRequestDispatcher("/ServAccueil").forward(request, response);
	}

	/**
	 * Extracts file name from HTTP header content-disposition
	 */

}
