package com.objis.cameroun.Systeme_Scolaire.presentation;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.objis.cameroun.Systeme_Scolaire.domaine.Enseignant;
import com.objis.cameroun.Systeme_Scolaire.service.ITraitements;
import com.objis.cameroun.Systeme_Scolaire.service.Traitement;

/**
 * Servlet implementation class EnregistrerEnseignantServlet
 */
@WebServlet("/EnregistrerEnseignantServlet")
public class EnregistrerEnseignantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnregistrerEnseignantServlet() {
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
		String nom= request.getParameter("nom");
		String prenom= request.getParameter("prenom");
		String sexe=request.getParameter("sexe");
		String date=request.getParameter("date_nais");
		String nationalite= request.getParameter("nationalite");
		String adresse= request.getParameter("adresse");
		int age= Integer.parseInt(request.getParameter("age"));
		String statutMat= request.getParameter("status");
		String specialite= request.getParameter("specialite");
		String grade= request.getParameter("grade");
		String email=request.getParameter("email");
		String telephone= request.getParameter("telephone");
		double salaire= Double.parseDouble(request.getParameter("salaire"));
		
		// creation d'un objet Enseignant et innitialisation de ses attributs
		
		Enseignant enseign=new Enseignant();
		
		enseign.setMatricule(matricule);
		enseign.setNom(nom);
		enseign.setPrenom(prenom);
		enseign.setSexe(sexe);
		enseign.setDate_nais(date);
		enseign.setNationalite(nationalite);
		enseign.setAddresse(adresse);
		enseign.setAge(age);
		enseign.setSituationMat(statutMat);
		enseign.setSpecialite(specialite);
		enseign.setGrade(grade);
		enseign.setEmail(email);
		enseign.setTelephone(telephone);
		enseign.setSalaire(salaire);
		
		// Obtention de EntityManagerFactory enregistrÃ© dans le contexte de l'application via le Listener
		EntityManagerFactory emf = (EntityManagerFactory)getServletContext().getAttribute("emf");
				 
		//Création de l'entity manager
		EntityManager em = emf.createEntityManager();
		
		// Enregistrement de l'enseignant dans la BD via la couche service
		
		ITraitements service= new Traitement(em);
		
		int status;
		status=service.enregistrerEnseignant(enseign);
		
		request.getRequestDispatcher("/ListerEnseignantsServlet").forward(request, response);
	}

}
