package com.objis.cameroun.Systeme_Scolaire.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import com.objis.cameroun.Systeme_Scolaire.dao.DaoImpl;
import com.objis.cameroun.Systeme_Scolaire.dao.IDao;
import com.objis.cameroun.Systeme_Scolaire.domaine.Eleve; // ces instructions créent un lien entre la couche service et la couche domaine
import com.objis.cameroun.Systeme_Scolaire.domaine.Enseignant;


/**
 * @author Brandol
 *Cette classe contient tous les savoir-faire du programme
 */
public class Traitement implements ITraitements {
	
	private IDao dao;
	
	public Traitement(EntityManager em) {
		
		dao = new DaoImpl(em);
	}
	
	/**
	 * @param enseig
	 * Cette methode permet d'enregistrer un enseignant dans la base de données
	 */
	public int enregistrerEnseignant(Enseignant enseig) {
		
		return dao.enregistrerEnseignantDao(enseig);
	}
	
	/**
	 * @param eleve
	 * Cette méthode permet d'enregistrer un eleve dans la base de données
	 */
	public int enregistrerEleve(Eleve eleve) {
		
		return dao.enregistrerEleveDao(eleve); 
	}
	
	/**
	 * @param enseig
	 * cette methode permet d'afficher le profil d'un enseignant 
	 */
	public void afficherDetailsEnseignant(Enseignant enseig) {
		
		System.out.println("  Vous avez ci-dessous la fiche presentant les details de l'enseignant "+ enseig.getNom());
		System.out.println("\n");
		
		System.out.println("      -----------------------------------------------------------");
		System.out.println("      --                FICHE ENSEIGNANT                      ---");
		System.out.println("      -----------------------------------------------------------");
		System.out.println("                          ");
		System.out.println("             Matricule de l'enseignant :  " +  enseig.getMatricule());
		System.out.println("             Nom(s) de l'enseignant :  " +  enseig.getNom());
		System.out.println("             Prenom(s) de l'enseignant :  " +  enseig.getPrenom());
		System.out.println("             Sexe :  " +  enseig.getSexe());
		System.out.println("             Date de Naissance :  " +  enseig.getDate_nais());
		System.out.println("             Nationalite:  " +  enseig.getNationalite());
		System.out.println("             Age :  " +  enseig.getAge()+" ans ");
		System.out.println("             Situation Matrimoniale :  " +  enseig.getSituationMat() );
		System.out.println("             Specialite :  " +  enseig.getSpecialite());
		System.out.println("             Grade :  " +  enseig.getGrade());
		System.out.println("             Email :  " +  enseig.getEmail());
		System.out.println("             Adresse :  " +  enseig.getAddresse());
		System.out.println("             Telephone :  " +  enseig.getTelephone());
		System.out.println("             Son salaire est de :  " +  enseig.getSalaire()+ " FCFA \n");
		System.out.println("      -----------------------------------------------------------");
	 
	}
	
	/**
	 * @param elev
	 * Cette méthode permet d'afficher le profil d'un eleve 
	 */
	public void afficherDetailsEleve(Eleve elev) {
		
		System.out.println("  Vous avez ci-dessous la fiche presentant les details de l'eleve "+ elev.getNom());
		System.out.println("\n");
		
		System.out.println("      -----------------------------------------------------------");
		System.out.println("      ---                FICHE ELEVE                          ---");
		System.out.println("      -----------------------------------------------------------");
		System.out.println("                          ");
		System.out.println("           Matricule de l'eleve :  " +  elev.getMatricule());
		System.out.println("           Nom(s) de l'eleve :  " +  elev.getNom());
		System.out.println("           Prenom(s) de l'eleve :  " +  elev.getPrenom());
		System.out.println("           Sexe :  " +  elev.getSexe());
		System.out.println("           Date de Naissance :  " +  elev.getDate_nais());
		System.out.println("           Nationalite :  " +  elev.getNationalite());
		System.out.println("           Age :  " +  elev.getAge()+" ans ");
		System.out.println("           Adresse :  " +  elev.getAddresse());
		System.out.println("           Niveau d'etude :  " +  elev.getNiveau());
		System.out.println("           Filiere :  " +  elev.getFiliere());
		System.out.println("      -----------------------------------------------------------");
		System.out.println("\n");
		
	}

	/* (non-Javadoc)
	 * @see com.objis.cameroun.Systeme_Scolaire.service.ITraitements#rechercherEleveService(java.lang.String)
	 * cette methode permet de rechercher un eleve dans le base de données à partir de son nom
	 */
	@Override
	public void rechercherEleveService(String nom) {
		List<Eleve> listeEleve= new ArrayList<Eleve>();
		listeEleve=dao.rechercherEleveDao(nom);
		
		if(listeEleve.isEmpty()==true) {
			System.out.println("Aucun eleve de ce nom n'a ete trouve dans le base de données");
		}else {
			for(Eleve elev:listeEleve) {
				
				afficherDetailsEleve(elev);
				//System.out.println("\n");
			}
		}
	}

	/* (non-Javadoc)
	 * @see com.objis.cameroun.Systeme_Scolaire.service.ITraitements#rechercherEnseignantService(java.lang.String)
	 * cette methode permet de rechercher un enseignant dans la base de données à partir de son nom
	 */
	@Override
	public void rechercherEnseignantService(String nom) {
		
		List<Enseignant> listeEnseignant=new ArrayList<Enseignant>();
		listeEnseignant=dao.rechercherEnseignantDao(nom);
		
		if(listeEnseignant.isEmpty()==true) {
			System.out.println("Aucun enseignant de ce nom n'a ete trouve dans le base de données");
		}else {
			for(Enseignant ens:listeEnseignant) {
				
				afficherDetailsEnseignant(ens);
				//System.out.println("\n");
			}
		}
		
	}

	/* (non-Javadoc)
	 * @see com.objis.cameroun.Systeme_Scolaire.service.ITraitements#listerElevesService()
	 * cette methode retourne la liste de tous les eleves enregistrés
	 */
	@Override
	public List<Eleve> listerElevesService() {
		return dao.listerElevesDao();
	}

	/* (non-Javadoc)
	 * @see com.objis.cameroun.Systeme_Scolaire.service.ITraitements#listerEnseignantsService()
	 * cette methode retourne la liste de tous les enseignants enregistrés
	 */
	@Override
	public List<Enseignant> listerEnseignantsService() {
		/*List<Enseignant> maListe=new ArrayList<Enseignant>();
		maListe=dao.listerEnseignantsDao();
		
		if(maListe.isEmpty()==true) {
			System.out.println("Aucun enseignant n'a ete trouve dans le base de données");
		}else {
			System.out.println("Nous avons "+ maListe.size()+" enseignants enregistres \n");
			System.out.println("Voici la liste des enseignants enregistres: \n");
			for(Enseignant enseig:maListe) {
				
				System.out.println(enseig);
				//System.out.println("\n");
			}
		}
		
		
		
		*
		*/
		return dao.listerEnseignantsDao();
	}

	/* (non-Javadoc)
	 * @see com.objis.cameroun.Systeme_Scolaire.service.ITraitements#rechercherElevService(java.lang.String)
	 * cette methode permet de rechercher un eleve dans la base de données à partir de son matricule
	 */
	@Override
	public List<Eleve> rechercherElevService(String matricule) {
		
		/*List<Eleve> listeEleve=new ArrayList<Eleve>();
		listeEleve=dao.rechercherElevDao(matricule);
		
		if(listeEleve.isEmpty()==true) {
			System.out.println("Aucun eleve de ce matricule n'a ete trouve dans le base de données");
		}else {
			for(Eleve elev:listeEleve) {
				
				afficherDetailsEleve(elev);
				//System.out.println("\n");
			}
		}*/
		return dao.rechercherElevDao(matricule);
	}

	/* (non-Javadoc)
	 * @see com.objis.cameroun.Systeme_Scolaire.service.ITraitements#rechercherEnseigService(java.lang.String)
	 * cette methode permet de rechercher un enseignant dans la base de données à partir de son matricule
	 */
	@Override
	public List<Enseignant> rechercherEnseigService(String matricule) {
		
		/*List<Enseignant> listeEnseignant=new ArrayList<Enseignant>();
		listeEnseignant=dao.rechercherEnseigDao(matricule);
		
		if(listeEnseignant.isEmpty()==true) {
			System.out.println("Aucun enseignant de ce matricule n'a ete trouve dans le base de données");
		}else {
			for(Enseignant enseign:listeEnseignant) {
				
				afficherDetailsEnseignant(enseign);
				//System.out.println("\n");
			}
		}*/
		return dao.rechercherEnseigDao(matricule);
	}
		
}
