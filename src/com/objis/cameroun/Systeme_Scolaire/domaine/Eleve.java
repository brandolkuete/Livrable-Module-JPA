package com.objis.cameroun.Systeme_Scolaire.domaine;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * @author Brandol
 * Cette classe contient les propriétés et les savoir-faire d'un élève
 *la classe Eleve hérite de la classe Personne
 */

@Entity
public class Eleve extends Personne {
	
	@Column(length=100)
	private String niveau;
	
	@Column(length=100)
	private String filiere;
	
	
	/**
	 * ceci est le constructeur qui ne prend rien en parametre
	 */
	public Eleve() {
		super();
	}

	

	public Eleve(String matricule, String nom, String prenom, String sexe, String date_nais, String nationalite,
			String addresse, int age) {
		super(matricule, nom, prenom, sexe, date_nais, nationalite, addresse, age);
		// TODO Auto-generated constructor stub
	}



	public Eleve( String niveau, String filiere) {
		super();
		this.niveau = niveau;
		this.filiere = filiere;
	}



	public String getNiveau() {
		return niveau;
	}



	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}



	public String getFiliere() {
		return filiere;
	}



	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}



	@Override
	public String toString() {
		return "Eleve [ niveau=" + niveau + ", filiere=" + filiere + "]";
	}

	

	/**
	 * @param niveau
	 * @param filiere
	 * Ce constructeur prend en parametre toutes les propriétés d'un élève
	 */
	
}
