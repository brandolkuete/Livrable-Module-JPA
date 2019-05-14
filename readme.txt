							  DESCRIPTION DE L'APPLICATION
							
	SystemeScolaire est une application qui permet d'informatiser le systeme d'un établissement
	Cette application permettra de réaliser de multiples taches entre autres :
	
			L'accès à l’historique de l’établissement ainsi que toutes autres informations sur le fonctionnement de l’établissement  
			Un enseignant doit pouvoir choisir un thème pour sa page
			L’inscription des élèves et enseignants : il s’agit ici de l’enregistrement des nouveaux utilisateurs
			L’impression des fiches d’inscription des nouveaux membres
			La génération des pages personnelles d'un enseignant (où se trouvent toutes ses informations) : après s’être connecté, la page de l’enseignant est générée avec des propriétés que celui-ci a choisies
			La génération du profil d’un étudiant après son inscription
			L’application pourra proposer une plateforme pour les échanges entre les enseignants et les élèves
			L’enseignant pourra avoir son emploi de temps 
			L’enseignant pourra faire l’appel et justifier les absences  des élèves pendant son cours
			L’enseignant pourra enregistrer le cours qu’il a transmis (au lieu de remplir un cahier de texte) 
			L’ administration pourra ajouter ou rechercher un élève
			L’enseignant pourra monter un sujet de composition ou de travaux pratiques (avec un chrono, le nombre de points à chaque étape), puis l’imprimer
			L’enseignant pourra enregistrer et modifier les notes des élèves de chaque classe qu’il enseigne dans sa matière
			L’ administration pourra calculer la moyenne des élèves
			L’ enseignant pourra enregistrer la conduite des élèves
			L’ administration pourra imprimer le bulletin d’un élève à la fin de chaque séquence
		
								LES FONCTIONNALITES QUI MARCHENT POUR LE MOMENT
								
	Pour le moment, grace à l'application on peut:
		> enregistrer un nouveau enseignant dans la base de données
		> enregistrer un nouveau élève dans la base de données
		> afficher la liste de tous les eleves enregistrés
		> afficher la liste de tous les enseignants enregistrés
		
								LES PRE-REQUIS POUR EXECUTER L'APPLICATION

	1- pour executer cette application, il faut au préalable avoir installé un jdk ou au moins un jre sur son ordinateur
	
	pour le faire, voici les étapes à suivre :
				
		1- Rendez-vous sur la partie Java du site d’Oracle : http://www.oracle.com/technetwork/java
		2- Dans la zone de droite ’software downloads’, cliquez sur le lien ’Java SE’ (pour Java Standard Edition)
		3- Cliquez sur l’icône ’Java’ pour télécharger le JDK
		4- Accepter la licence
		5- De préférence choisir la version la plus récente (dernière sur la liste)
			> si votre machine est une 64 bit, choisir le jdk dont le nom a 'windows-X64' avant le '.exe'
			> si votre machine est une 32 bit, choisir le jdk dont le nom a 'windows-i586' avant le '.exe'
			> la version 32 bit fonctionne sur un Système Windows 32 bit ou 64 bit.
		6- Cliquez sur le bouton "Enregistrer le fichier". Le téléchargement commence
		7- Double cliquez sur le fichier téléchargé. L’assistant d’installation du JDK se lance
		8- Cliquez sur le bouton "Next" des fenêtre qui vont s'afficher
		9- Au moment d’installer un environnement d’exécution indépendant du JDK, l’assistant vous consulte. Acceptez les options par défaut et cliquez sur "Next"
			NB:  Même si vous supprimez par la suite le répertoire d’installation du JDK (qui contient aussi une JRE), vous pourrez tout de même exécuter des programmes Java sur votre ordinateur
		10- Vous arrivez à l’écran de fin d’installation, qui vous précise que l’installation s’est bien déroulée 
		11- Cliquez sur Close: L’installation du JDK est terminée.

		NB: la version du jdk utilisé pour cette application est la version 8

	2- Un serveur d'application web Tomcat (ce projet utilise la version 8.5)

	3- Avoir un serveur de données MySQL installé sur l'ordinateur ( le demarrer avant l'exécution de l'application)

		
								LES ETAPES POUR VOIR LA DOCUMENTATION DE L'APPLICATION
								
		> Ouvrir le dossier "Livrable ModuleJPA"
		> Ouvrir le repertoire "documentation"
		> Double-cliquer sur le fichier "index"
		
								
								LES ETAPES DE L'EXECUTION DE L'APPLICATION 
								
	Pour executer l'application, voici les etapes à suivre :
	
		> Si vous etes dans Windows 10:
		
		1- Demmarer le serveur Tomcat (au port 8080)
		2- Demmarer le serveur de données MySQL
		3- creer la base de données nommée "bdsysscjpa" sans toutefois creer les tables
		4- Creer le fichier persistence.xml dans lequel on ajoute les proprietés d'hibernate, on configure le Base de données, on Spécifie le 'dialecte' SQL utilisé pour communiquer avec la BDD et on Indique a Hibernate de (re-)créer la BDD au lancement de l'application
		5- Ajouter les librairies contenues dans le dossiers Librairies a la build Path
		2- Ouvrir le navigateur et saisir dans la barre de navigation l'url "http://localhost:8080/SystemeScolaire_web/index.jsp" 
