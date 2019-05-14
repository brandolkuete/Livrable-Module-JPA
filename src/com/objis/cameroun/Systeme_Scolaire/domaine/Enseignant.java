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
 *cette classe contient les informations d'un enseignant
 *Elle contient egalement les constructeurs, les getters/setters aux attributs d'un Enseignant
 */

@Entity
public class Enseignant extends Personne {
	
	//ceci sont les attributs de la classe Enseignant
	
	@Column(length=100)
	private String situationMat;
	
	@Column(length=100)
	private String specialite;
	
	@Column(length=100)
	private String grade;
	
	@Column(length=100)
	private String email;
	
	@Column(length=100)
	private String telephone;
	
	@Column(length=100)
	private double salaire;
	
	public Enseignant() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Enseignant(String matricule, String nom, String prenom, String sexe, String date_nais, String nationalite,
			String addresse, int age) {
		super(matricule, nom, prenom, sexe, date_nais, nationalite, addresse, age);
		// TODO Auto-generated constructor stub
	}
	
	public Enseignant(String situationMat, String specialite, String grade, String email,
			String telephone, double salaire) {
		super();
		this.situationMat = situationMat;
		this.specialite = specialite;
		this.grade = grade;
		this.email = email;
		this.telephone = telephone;
		this.salaire = salaire;
	}
	
	public String getSituationMat() {
		return situationMat;
	}
	
	public void setSituationMat(String situationMat) {
		this.situationMat = situationMat;
	}
	
	public String getSpecialite() {
		return specialite;
	}
	
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	
	public String getGrade() {
		return grade;
	}
	
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTelephone() {
		return telephone;
	}
	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public double getSalaire() {
		return salaire;
	}
	
	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}

	@Override
	public String toString() {
		return "Enseignant [situationMat=" + situationMat + ", specialite="
				+ specialite + ", grade=" + grade + ", email=" + email + ", telephone=" + telephone + ", salaire="
				+ salaire + "]";
	}
	
}
