package com.objis.cameroun.Systeme_Scolaire.domaine;

public class Note {
	
	private Eleve eleve;
	private Matiere matiere;
	private float valeur;
	private String appreciation;
	
	public Note(Eleve eleve, Matiere matiere, float valeur, String appreciation) {
		super();
		this.eleve = eleve;
		this.matiere = matiere;
		this.valeur = valeur;
		this.appreciation = appreciation;
	}

	public Eleve getEleve() {
		return eleve;
	}

	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public float getValeur() {
		return valeur;
	}

	public void setValeur(float valeur) {
		this.valeur = valeur;
	}

	public String getAppreciation() {
		return appreciation;
	}

	public void setAppreciation(String appreciation) {
		this.appreciation = appreciation;
	}

	@Override
	public String toString() {
		return "Note [eleve=" + eleve + ", matiere=" + matiere + ", valeur=" + valeur + ", appreciation=" + appreciation
				+ "]";
	}
	
	
	
	
	
}
