package com.objis.cameroun.Systeme_Scolaire.service;

import java.util.List;

import com.objis.cameroun.Systeme_Scolaire.domaine.Eleve;
import com.objis.cameroun.Systeme_Scolaire.domaine.Enseignant;

public interface ITraitements {
	
	public int enregistrerEnseignant(Enseignant enseig);
	public int enregistrerEleve(Eleve eleve);
	public void afficherDetailsEnseignant(Enseignant enseig); // j'utilise cette methode pour afficher le resutat de la recherche d'un enseignant
	public void afficherDetailsEleve(Eleve elev); // j'utilise cette methode pour afficher le resutat de la recherche d'un eleve
	public void rechercherEleveService(String nom);
	public void rechercherEnseignantService(String nom);
	public List<Eleve> listerElevesService();
	public List<Enseignant> listerEnseignantsService();
	public List<Eleve> rechercherElevService(String matricule);
	public List<Enseignant> rechercherEnseigService(String matricule);

}
