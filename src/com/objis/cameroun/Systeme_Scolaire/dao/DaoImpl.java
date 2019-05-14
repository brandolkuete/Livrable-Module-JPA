package com.objis.cameroun.Systeme_Scolaire.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import java.util.List;

import com.objis.cameroun.Systeme_Scolaire.domaine.Eleve;
import com.objis.cameroun.Systeme_Scolaire.domaine.Enseignant;

public class DaoImpl implements IDao {
	
	private EntityManager em;
	
		public DaoImpl(EntityManager em) {
			super();
			this.em = em;
		}

	/* (non-Javadoc)
	 * @see com.objis.cameroun.Systeme_Scolaire.dao.IDao#enregistrerEnseignantDao(com.objis.cameroun.Systeme_Scolaire.domaine.Enseignant)
	 * cette methode permet d'enregistrer un enseignant dans la base de données
	 */
	
	@Override
	public int enregistrerEnseignantDao(Enseignant enseig) {
		
		try {
			
			// 1 : Ouverture transaction 
			EntityTransaction tx =  em.getTransaction();
			tx.begin();
			
			// 2 : Persistance Objet/Relationnel : création d'un enregistrement d'un Objet métier en base
			em.persist(enseig);
			
			// 3 : Fermeture transaction 
			tx.commit();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			//System.out.println("Une erreur est survenue");
			return 0;
		}
		
		return 1;
	}

	/* (non-Javadoc)
	 * @see com.objis.cameroun.Systeme_Scolaire.dao.IDao#enregistrerEleveDao(com.objis.cameroun.Systeme_Scolaire.domaine.Eleve)
	 * Cette methode permet d'enregistrer un eleve dans la base de données
	 */
	@Override
	public int enregistrerEleveDao(Eleve eleve) {
		
		try {
			
			// 1 : Ouverture transaction 
			EntityTransaction tx =  em.getTransaction();
			tx.begin();
			
			// 2 : Persistance Objet/Relationnel : création d'un enregistrement d'un Objet métier en base
			em.persist(eleve);
			
			// 3 : Fermeture transaction 
			tx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	/* (non-Javadoc)
	 * @see com.objis.cameroun.Systeme_Scolaire.dao.IDao#rechercherEleveDao(java.lang.String)
	 * Cette methode permet de rechercher un eleve dans le base de données à partir de son nom
	 
	@Override
	public List<Eleve> rechercherEleveDao(String nom) {
		
	
		List<Eleve> maListe=new ArrayList<Eleve>();
		
		try {
			// recuperation de la connection
			Connection cn = ConnectionMYSQL.getInstance();
			
			// preparation de la requete
			
			String sql="SELECT * FROM eleve WHERE nom='"+nom+"'";
			
			// creation d'un objet statement
			Statement st = cn.createStatement();
			
			// Excécution de la requete
			
			ResultSet rs = st.executeQuery(sql); // ResultSet recupere les elements ligne par ligne
			
			while (rs.next()) {
				
				Eleve elev=new Eleve();
				
				elev.setMatricule(rs.getString("matricule"));
				elev.setNom(rs.getString("nom"));
				elev.setPrenom(rs.getString("prenom"));
				elev.setSexe(rs.getString("sexe"));
				elev.setDate_nais(rs.getString("date_nais"));
				elev.setNationalite(rs.getString("nationalite"));
				elev.setAddresse(rs.getString("addresse"));
				elev.setAge(rs.getInt("age"));
				elev.setNiveau(rs.getString("niveau"));
				elev.setFiliere(rs.getString("filiere"));
				
				//ajout de l'eleve  ayec ce nom dans la liste maListe
				
				maListe.add(elev);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return maListe;
	}*/

	/* (non-Javadoc)
	 * @see com.objis.cameroun.Systeme_Scolaire.dao.IDao#rechercherEnseignantDao(java.lang.String)
	 * Cette methode permet de rechercher un enseignant dans le base de données à partir de son nom
	 
	@Override
	public List<Enseignant> rechercherEnseignantDao(String nom) {
		
		List<Enseignant> maListeEns=new ArrayList<Enseignant>();
		
		try {
			// recuperation de la connection
			Connection cn = ConnectionMYSQL.getInstance();
			
			// preparation de la requete
			
			String sql="SELECT * FROM enseignant WHERE nom='"+nom+"'";
			
			// creation d'un objet statement
			Statement st = cn.createStatement();
			
			// Excécution de la requete
			
			ResultSet rs = st.executeQuery(sql); // ResultSet recupere les elements ligne par ligne
			
			while (rs.next()) {
				
				Enseignant enseig=new Enseignant();
				
				enseig.setMatricule(rs.getString("matricule"));
				enseig.setNom(rs.getString("nom"));
				enseig.setPrenom(rs.getString("prenom"));
				enseig.setSexe(rs.getString("sexe"));
				enseig.setDate_nais(rs.getString("date_nais"));
				enseig.setNationalite(rs.getString("nationalite"));
				enseig.setAddresse(rs.getString("addresse"));
				enseig.setAge(rs.getInt("age"));
				enseig.setSituationMat(rs.getString("situationMat"));
				enseig.setSpecialite(rs.getString("specialite"));
				enseig.setGrade(rs.getString("grade"));
				enseig.setEmail(rs.getString("email"));
				enseig.setTelephone(rs.getString("telephone"));
				enseig.setSalaire(rs.getDouble("salaire"));
				
				//ajout de l'eleve  ayec ce nom dans la liste maListe
				
				maListeEns.add(enseig);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return maListeEns;
	}*/

	/* (non-Javadoc)
	 * @see com.objis.cameroun.Systeme_Scolaire.dao.IDao#listerElevesDao()
	 * Cette methode permet de recuperer tous les eleves présents dans la base de données
	 */
	@Override
	public List<Eleve> listerElevesDao() {
		
		List<Eleve> maListeEleves=new ArrayList<Eleve>();
		
		try {
			
			// 1 : Ouverture transaction 
			EntityTransaction tx =  em.getTransaction();
			tx.begin();
			
			// 2 :obtention de la liste des eleves via EntityManager
			maListeEleves= em.createQuery("from Eleve", Eleve.class).getResultList();
			
			// 4 : Fermeture transaction 
			tx.commit();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return maListeEleves;
	}

	/* (non-Javadoc)
	 * @see com.objis.cameroun.Systeme_Scolaire.dao.IDao#listerEnseignantsDao()
	 * Cette methode permet de lister tous les enseignants présents dans la base de données
	 */
	@Override
	public List<Enseignant> listerEnseignantsDao() {
		
		List<Enseignant> maListeEns=new ArrayList<Enseignant>();
		
		try {
			
			// 1 : Ouverture transaction 
			EntityTransaction tx =  em.getTransaction();
			tx.begin();
			
			// 2 :obtention de la liste des eleves via EntityManager
			maListeEns= em.createQuery("from Enseignant", Enseignant.class).getResultList();
			
			// 4 : Fermeture transaction 
			tx.commit();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return maListeEns;
	}

	@Override
	public List<Eleve> rechercherEleveDao(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Enseignant> rechercherEnseignantDao(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Eleve> rechercherElevDao(String matricule) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Enseignant> rechercherEnseigDao(String matricule) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.objis.cameroun.Systeme_Scolaire.dao.IDao#rechercherElevDao(java.lang.String)
	 * Cette methode permet de rechercher un eleve dans le base de données à partir de son matricule
	 
	@Override
	public List<Eleve> rechercherElevDao(String matricule) {
		List<Eleve> liste=new ArrayList<Eleve>();
		
		try {
			// recuperation de la connection
			Connection cn = ConnectionMYSQL.getInstance();
			
			// preparation de la requete
			
			String sql="SELECT * FROM eleve WHERE matricule='"+matricule+"'";
			
			// creation d'un objet statement
			Statement st = cn.createStatement();
			
			// Excécution de la requete
			
			ResultSet rs = st.executeQuery(sql); // ResultSet recupere les elements ligne par ligne
			
			while (rs.next()) {
				
				Eleve elev=new Eleve();
				
				elev.setMatricule(rs.getString("matricule"));
				elev.setNom(rs.getString("nom"));
				elev.setPrenom(rs.getString("prenom"));
				elev.setSexe(rs.getString("sexe"));
				elev.setDate_nais(rs.getString("date_nais"));
				elev.setNationalite(rs.getString("nationalite"));
				elev.setAddresse(rs.getString("addresse"));
				elev.setAge(rs.getInt("age"));
				elev.setNiveau(rs.getString("niveau"));
				elev.setFiliere(rs.getString("filiere"));
				
				liste.add(elev);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return liste;
	}

	/* (non-Javadoc)
	 * @see com.objis.cameroun.Systeme_Scolaire.dao.IDao#rechercherEnseigDao(java.lang.String)
	 * Cette methode permet de rechercher un enseignant dans le base de données à partir de son matricule
	 
	@Override
	public List<Enseignant> rechercherEnseigDao(String matricule) {
		
		List<Enseignant> liste=new ArrayList<Enseignant>();
		
		try {
			// recuperation de la connection
			Connection cn = ConnectionMYSQL.getInstance();
			
			// preparation de la requete
			
			String sql="SELECT * FROM enseignant WHERE matricule='"+matricule+"'";
			
			// creation d'un objet statement
			Statement st = cn.createStatement();
			
			// Excécution de la requete
			
			ResultSet rs = st.executeQuery(sql); // ResultSet recupere les elements ligne par ligne
			
			while (rs.next()) {
				
				Enseignant enseig=new Enseignant();
				
				enseig.setMatricule(rs.getString("matricule"));
				enseig.setNom(rs.getString("nom"));
				enseig.setPrenom(rs.getString("prenom"));
				enseig.setSexe(rs.getString("sexe"));
				enseig.setDate_nais(rs.getString("date_nais"));
				enseig.setNationalite(rs.getString("nationalite"));
				enseig.setAddresse(rs.getString("addresse"));
				enseig.setAge(rs.getInt("age"));
				enseig.setSituationMat(rs.getString("situationMat"));
				enseig.setSpecialite(rs.getString("specialite"));
				enseig.setGrade(rs.getString("grade"));
				enseig.setEmail(rs.getString("email"));
				enseig.setTelephone(rs.getString("telephone"));
				enseig.setSalaire(rs.getDouble("salaire"));
				
				liste.add(enseig);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return liste;
	}*/

}
