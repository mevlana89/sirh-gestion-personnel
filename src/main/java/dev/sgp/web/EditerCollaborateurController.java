package dev.sgp.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditerCollaborateurController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
	ServletException, IOException {
		// recupere la valeur d'un parametre dont le nom est avecPhoto
		String matricule = req.getParameter("matricule");
		if (matricule == null)
		{
			resp.setContentType("text/html");
			resp.sendError(400, "Un matricule est attendu");
			//resp.getWriter().write("<h1>Un matricule est attendu</h1>");
		}
		else 
		{
			resp.setContentType("text/html");
			resp.getWriter().write("<h1>Edition de collaborateur </h1><h2>Matricule : " + matricule + "</h2>" );
		// recupere la valeur d'un parametre dont le nom est departement
			
//			  String departementParam = req.getParameter("departement");
//			  resp.setContentType("text/html"); // code HTML ecrit dans le corps de la
//			  reponse resp.getWriter().write("<h1>Liste des collaborateurs</h1>" + "<ul>" +
//			  "<li>avecPhoto="+ avecPhotoParam + "</li>" + "<li>departement="+
//			  departementParam + "</li>" + "</ul>");
			 
		}
	}
	
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
        {
			String matricule = req.getParameter("matricule");
			String titre = req.getParameter("titre");
			String nom = req.getParameter("nom");
			String prenom = req.getParameter("prenom");
			String errorMessage = "Les paramètres suivants sont incorrects : ";
			if (matricule== null)
			{
				errorMessage += "-matricule ";
			}
			if (titre== null)
			{
				errorMessage += "-titre ";
			}
			if (nom== null)
			{
				errorMessage += "-nom ";
			}
			if (prenom== null)
			{
				errorMessage += "-prenom ";
			}
			if (matricule== null || titre == null|| nom == null|| titre == prenom)
			{
				resp.setContentType("text/html");
				resp.sendError(400, errorMessage);
			}
			else 
			{
				resp.setContentType("text/html");
				resp.setStatus(201);
				resp.getWriter().write("<h1>Creation d'un collaborateur avec les informations suivantes : </h2> <ul><li>matricule="+matricule+",titre="+titre+",nom="+nom+",prenom="+prenom+"</li></ul>" );
			}
		
		
//            String protocol = req.getProtocol();
//            String msg = lStrings.getString("http.method_post_not_supported");
//            if (protocol.endsWith("1.1")) {
//                resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, msg);
//            } else {
//                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, msg);
//            }
        }
	
}
