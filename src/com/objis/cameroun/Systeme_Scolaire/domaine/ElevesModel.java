package com.objis.cameroun.Systeme_Scolaire.domaine;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ElevesModel extends AbstractTableModel {
	
	private final String[] entetes= {"Matricule", "Nom", "Prenom","Sexe","Date de Naissance","Nationalité","Adresse","Age","Niveau","Filière"};
	private List<Eleve> eleves;
	
	public ElevesModel() {
		super();
	}

	public ElevesModel(List<Eleve> eleves) {
		super();
		this.eleves = eleves;
	}

	public List<Eleve> getEleves() {
		return eleves;
	}

	public void setEleves(List<Eleve> eleves) {
		this.eleves = eleves;
	}

	@Override
	public int getColumnCount() {
		return entetes.length;
	}

	@Override
	public int getRowCount() {
		return eleves.size();
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
			return eleves.get(rowIndex).getMatricule();
		case 1:
			return eleves.get(rowIndex).getNom();
		case 2:
			return eleves.get(rowIndex).getPrenom();
		case 3:
			return eleves.get(rowIndex).getSexe();
		case 4:
			return eleves.get(rowIndex).getDate_nais();
		case 5:
			return eleves.get(rowIndex).getNationalite();
		case 6:
			return eleves.get(rowIndex).getAddresse();
		case 7:
			return eleves.get(rowIndex).getAge();
		case 8:
			return eleves.get(rowIndex).getNiveau();
		case 9:
			return eleves.get(rowIndex).getFiliere();
		default:
            throw new IllegalArgumentException();
		}
	}
}