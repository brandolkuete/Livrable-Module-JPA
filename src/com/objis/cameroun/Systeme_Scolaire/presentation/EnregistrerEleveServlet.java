package com.objis.cameroun.Systeme_Scolaire.presentation;

import java.io.IOException;

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
 * Servlet implementation class EnregistrerEleveServlet
 */
@WebServlet("/EnregistrerEleveServlet")
public class EnregistrerEleveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnregistrerEleveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// recuperation des valeurs saisies par l'utilisateur
		
		String matricule= request.getParameter("matricule");
		String nom=request.getParameter("nom");
		String prenom= request.getParameter("prenom");
		String sexe=request.getParameter("sexe");
		String date=request.getParameter("date_nais");
		String nationalite= request.getParameter("nationalite");
		String adresse= request.getParameter("adresse");
		int age= Integer.parseInt(request.getParameter("age"));
		String niveau= request.getParameter("niveau");
		String filiere= request.getParameter("filiere");
		
		// creation d'un objet Eleve et innitialisation de ses attributs
		
		Eleve elev= new Eleve();
		
		elev.setMatricule(matricule);
		elev.setNom(nom);
		elev.setPrenom(prenom);
		elev.setSexe(sexe);
		elev.setDate_nais(date);
		elev.setNationalite(nationalite);
		elev.setAddresse(adresse);
		elev.setAge(age);
		elev.setNiveau(niveau);
		elev.setFiliere(filiere);
		
		// Enregistrement de l'élève dans la BD via la couche service
		
		// Obtention de EntityManagerFactory enregistrÃ© dans le contexte de l'application via le Listener
		 EntityManagerFactory emf = (EntityManagerFactory)getServletContext().getAttribute("emf");
		 
		//Création de l'entity manager
	    EntityManager em = emf.createEntityManager();
	    
	    //appel de la couche service
	    ITraitements service= new Traitement(em);
		
		int status;
		status=service.enregistrerEleve(elev);
		
		request.getRequestDispatcher("/ListerElevesServlet").forward(request, response);
	}

}
