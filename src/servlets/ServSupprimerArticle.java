package servlets;

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
import facades.FacadeArticle;
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
maxFileSize=1024*1024*10,      // 10MB
maxRequestSize=1024*1024*50)   // 50MB
@WebServlet("/ServSupprimerArticle")
public class ServSupprimerArticle extends HttpServlet{

	private static final long serialVersionUID = 1L;
	public static final String CHAMP_DESCRIPTION = "description";
	public static final String CHAMP_FICHIER = "fichier";
	public static final String VUE = "/formFichier.jsp";
	
	@EJB
	FacadeArticle fga;
	/**
	 * Name of the directory where uploaded files will be saved, relative to the
	 * web application directory.
	 */
	private static final String SAVE_DIR = "uploadFiles";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServSupprimerArticle() {
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
		
		fga.supprimerArticle(request);

		request.setAttribute("message", "Votre article a bien été ajouté");
		//getServletContext().getRequestDispatcher("/resultUpload.jsp").forward(request, response);
		request.getRequestDispatcher("/Accueil").forward(request, response);
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
