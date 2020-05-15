# maBibliotheque

Cette application est à destination de la ville pour la gestion de sa bibliothèque municipale

### Informations générales

Elle est articulé autour de 3 microservices:

- Bibliotheque
- Utilisateur
- ClientUI

### Pré-requis

Vous avez besoin d'installer:
•JDK 8  
•BDD Mysql pour 2 BDD
•Maven  

### Installation

1 - Initialiser les bases de données avec comme nom : maBibliMsBibliotheque et une autre maBibliMsUtilisateur (port 3306 - sinon à modifier dans application.properties une fois le code cloné)  
2 - Cloner le projet depuis le repository  
3 - Générer le war avec la commande suivante :  
```
mvn clean install
```
4 - Déployer le war sur un serveur Tomcat

Pour la base de données vous pouvez :

•la laisser déployer ses tables automatiquement au lancement de l'application grâce à hibernate et ensuite si vous le souhaitez, déployer le fichier: "TODO"

•déployer le schéma de BDD avec le fichier: "TODO" et ensuite si vous le souhaitez, déployer le fichier: "TODO"

•déployer schéma et jeux de données avec le fichier : "TODO" (avant de lancer l'application pour la première fois)

Si vous utilisez le jeux de données:

Plusieurs utilisateurs ont été créés :

Un administrateur:   
•Identifiant : admin Mot de passe : admin
