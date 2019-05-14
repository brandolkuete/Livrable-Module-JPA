package com.objis.cameroun.Systeme_Scolaire.domaine;

import java.util.List;

import javax.swing.table.AbstractTableModel;


public class EnseignantModel extends AbstractTableModel {
	
	private final String[] entetes= {"Matricule", "Nom", "Prenom","Sexe","Date de Naissance","Nationalité","Adresse","Age","Statut Matrimonial","Spécialité","Grade","Email","Téléphone","Salaire"};
	private List<Enseignant> enseignants;
	
	public EnseignantModel() {
		super();
	}

	public EnseignantModel(List<Enseignant> enseignants) {
		super();
		this.enseignants = enseignants;
	}

	public List<Enseignant> getEnseignants() {
		return enseignants;
	}

	public void setEnseignants(List<Enseignant> enseignants) {
		this.enseignants = enseignants;
	}

	@Override
	public int getColumnCount() {
		return entetes.length;
	}

	@Override
	public int getRowCount() {
		return enseignants.size();
	}
	
	@Override
    // retourne le nom du champ d'une colonne
    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex) {
		case 0:
			return enseignants.get(rowIndex).getMatricule();
		case 1:
			return enseignants.get(rowIndex).getNom();
		case 2:
			return enseignants.get(rowIndex).getPrenom();
		case 3:
			return enseignants.get(rowIndex).getSexe();
		case 4:
			return enseignants.get(rowIndex).getDate_nais();
		case 5:
			return enseignants.get(rowIndex).getNationalite();
		case 6:
			return enseignants.get(rowIndex).getAddresse();
		case 7:
			return enseignants.get(rowIndex).getAge();
		case 8:
			return enseignants.get(rowIndex).getSituationMat();
		case 9: 
			return enseignants.get(rowIndex).getSpecialite();
		case 10:
			return enseignants.get(rowIndex).getGrade();
		case 11:
			return enseignants.get(rowIndex).getEmail();
		case 12:
			return enseignants.get(rowIndex).getTelephone();
		case 13:
			return enseignants.get(rowIndex).getSalaire();
		default:
			throw new IllegalArgumentException();
		}
			
	}
	
	
	
}
