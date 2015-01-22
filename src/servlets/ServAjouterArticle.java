package servlets;

import java.io.File;
import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import metier.Membre;
import facades.FacadeAccueil;
import facades.FacadeArticle;
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
maxFileSize=1024*1024*10,      // 10MB
maxRequestSize=1024*1024*50)   // 50MB
@WebServlet("/ServAjouterArticle")
public class ServAjouterArticle extends HttpServlet{

	private static final long serialVersionUID = 1L;
	public static final String CHAMP_DESCRIPTION = "description";
	public static final String CHAMP_FICHIER = "fichier";
	public static final String VUE = "/formFichier.jsp";
	
	@EJB
	FacadeArticle fga;
	
	@EJB
	FacadeAccueil facadeAccueil;

	/**
	 * Name of the directory where uploaded files will be saved, relative to the
	 * web application directory.
	 */
	private static final String SAVE_DIR = "uploadFiles";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServAjouterArticle() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * handles file upload
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// gets absolute path of the web application
		HttpSession session = request.getSession();
		Membre m = (Membre) session.getAttribute("membre");
		String op = (String) request.getParameter("op");
		request.setAttribute("categorie", facadeAccueil.getCategories());
		request.setAttribute("membre", m);
		switch (op) {
		case "launch":
			request.getRequestDispatcher("/V2/synchronous/AjouterArticle.jsp")
					.forward(request, response);
			break;
		case "Ajouter l'article":
			String appPath = request.getServletContext().getRealPath(
					"/V2/synchronous/images");
			String savePath = appPath + File.separator;
			String copiePath = "/home/aboucher2/workspace_jee/intergiciel/WebContent/V2/synchronous/images/";

			String saveFile = null;
			String nomImage;
			String fileName = "";
			String chemin = "";

			for (Part part : request.getParts()) {
				fileName = extractFileName(part);
				if (!fileName.equals("")) {

					chemin = savePath + fileName;
					part.write(chemin);
					chemin = copiePath + fileName;
					part.write(chemin);
					saveFile = fileName;
				}
			}

			fga.ajouterArticle(request, m, saveFile);
			session.setAttribute("membre", m);
			request.setAttribute("message", "Votre article a bien été ajouté");
			request.getRequestDispatcher("/Accueil").forward(request, response);
			break;
		}
	}

	/**
	 * Extracts file name from HTTP header content-disposition
	 */
	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return "";
	}
}
