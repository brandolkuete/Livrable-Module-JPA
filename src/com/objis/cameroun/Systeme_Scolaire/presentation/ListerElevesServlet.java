package com.objis.cameroun.Systeme_Scolaire.presentation;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.objis.cameroun.Systeme_Scolaire.domaine.Eleve;
import com.objis.cameroun.Systeme_Scolaire.service.ITraitements;
import com.objis.cameroun.Systeme_Scolaire.service.Traitement;

/**
 * Servlet implementation class ListerElevesServlet
 */
@WebServlet("/ListerElevesServlet")
public class ListerElevesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListerElevesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Obtention de EntityManagerFactory enregistrÃ© dans le contexte de l'application via le Listener
		EntityManagerFactory emf = (EntityManagerFactory)getServletContext().getAttribute("emf");
				 
		//Création de l'entity manager
		EntityManager em = emf.createEntityManager();
		
		// recuperation de la liste des Elèves avec la couche service
		ITraitements service= new Traitement(em);
		List<Eleve> listeEleves= service.listerElevesService();
		
		
		//enregistrement de l'objet liste dans l'objet request pour la page listEleves.jsp
		request.setAttribute("listeEleve", listeEleves);
		
		//redirection vers la page listeEleves.jsp
		request.getRequestDispatcher("listeEleves.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
