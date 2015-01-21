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
import connexion.FacadeConnexion;
import facades.FacadeCompte;
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
maxFileSize=1024*1024*10,      // 10MB
maxRequestSize=1024*1024*50)   // 50MB
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
		String op = (String)req.getParameter("op");
		HttpSession session = req.getSession();
		Membre m = (Membre)session.getAttribute("membre");
		
		if(op==null){
			System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			System.out.println("operateur null");
			System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		}
		switch(op){
		case "gestionCompte" :
			req.setAttribute("membre", m);
			req.getRequestDispatcher("/V2/synchronous/GestionCompte.jsp").forward(req, resp);
			break;
		case "Enregistrer Modification" :

			String inter = (String) req.getParameter("pseudo");
			facadecompte.modifierPseudo(m, inter);
			inter = (String) req.getParameter("telephone");
			facadecompte.modifierTel(m, inter);
			inter = (String) req.getParameter("mail");
			facadecompte.modifierMail(m, inter);
			inter = (String) req.getParameter("adresse");
			facadecompte.modifierAdresse(m, inter);
			inter = (String) req.getParameter("mdp");
			facadecompte.modifierMotDePasse(m, inter);
			
			///////////gestion de la photo de profil///////////
			String appPath = req.getServletContext().getRealPath("");
			// constructs path of the directory to save uploaded file
			String savePath = appPath + File.separator + m.getPseudonyme();

			// creates the save directory if it does not exists
			File fileSaveDir = new File(savePath);
			if (!fileSaveDir.exists()) {
				fileSaveDir.mkdir();
			}
			//creation du chemin absolu
			String chemin = "";
			String fileName =  "";
			for (Part part : req.getParts()) {
				fileName = extractFileName(part);
				if (!fileName.equals("")) {	
					chemin = savePath + File.separator + fileName;
					part.write(chemin);
				}
			}
			if(true){
				System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
				System.out.println("chemin = "+chemin);
				System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			}
			m.setPhotoProfil(chemin);
			facadecompte.modifierPhoto(m, chemin);
			m = facadecompte.getMembre(m);
			
			///////////////////////////////////////////////
			
			
			req.setAttribute("membre", m);
			session.setAttribute("membre", m);
			req.getRequestDispatcher("/V2/synchronous/GestionCompte.jsp").forward(req, resp);
			break;
		case "proposer un article" :
			req.getRequestDispatcher("/ServArticle").forward(req, resp);
			break;
		case "mes articles" :
			req.setAttribute(op, op);
			req.getRequestDispatcher("/ServArticles").forward(req, resp);
			
			default : System.out.println("coucou");
		}
		
	}
	
	
	////////special pour recuperer le nom de l'image
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
