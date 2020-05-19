# maBibliotheque

Cette application est à destination de la ville pour la gestion de sa bibliothèque municipale

### Informations générales

Elle est articulé autour de 3 microservices:

- Bibliotheque
- Utilisateur
- ClientUI

Et des EDGE Service suivant:

- Spring Cloud Config
- Eureka
- ZUUL
- Zipkin

### Pré-requis

Vous avez besoin d'installer:
- JDK 8  
- BDD Mysql pour 2 BDD
- Maven  

### Installation

1 - Initialiser les bases de données avec comme nom : maBibliMsBibliotheque et une autre maBibliMsUtilisateur (port 3306 - sinon à modifier dans application.properties une fois le code cloné)  
2 - Cloner le projet depuis le repository  
3 - Générer le war avec la commande suivante :  
```
mvn clean install
```
4 - Déployer le war sur un serveur Tomcat

Pour la base de données vous pouvez :

- la laisser déployer ses tables automatiquement au lancement de l'application grâce à hibernate et ensuite si vous le souhaitez, déployer le fichier: "TODO"

- déployer le schéma de BDD avec le fichier: "TODO" et ensuite si vous le souhaitez, déployer le fichier: "TODO"

- déployer schéma et jeux de données avec le fichier : "TODO" (avant de lancer l'application pour la première fois)

Si vous utilisez le jeux de données:

Plusieurs utilisateurs ont été créés :

Un administrateur:   
- Identifiant : admin Mot de passe : admin

Un Utilisateur:  
- Identifiant : util Mot de passe : util

Si vous n'utilisez pas le jeux de données:  
Vous pouvez inscrire un nouvel utilisateur une fois l'application lancée en passant par swagger grâce à l'API (vous devez hasher le MDP avec https://www.bcrypt.fr/ pour que cela fonctionne)
Vous pourrez ensuite faire une élévation de privilèges grâces à l'API avec swagger.

###Ordre de lancement:

Lancer en premier les edges services et ensuite le microservice bibliotheque puis le microservice utilisateur en enfin clientUi

## Construit avec:
* [Maven](https://maven.apache.org/)
* [SpringBoot](https://spring.io/projects/spring-boot)

## Auteur
Ludovic SOUPLET - Pour reconversion professionnelle via OpenclassRooms
