# maBibliotheque

Cette application est un site communautaire autour de l'escalade. Elle a été réalisé dans le cadre d'un parcours de formation Java sur le site Openclassrooms pour reconversion professionnelle.

### Pré-requis

Vous avez besoin d'installer:
•JDK 13  
•BDD Mysql  
•Maven  

### Installation

1 - Initialiser la base de données avec comme nom : ladedb (port 3306 - sinon à modifier dans application.properties une fois le code cloné)  
2 - Cloner le projet depuis le repository  
3 - Générer le war avec la commande suivante :  
```
mvn clean install
```
4 - Déployer le war sur un serveur Tomcat

Pour la base de données vous pouvez :

•la laisser déployer ses tables automatiquement au lancement de l'application grâce à hibernate et ensuite si vous le souhaitez, déployer le fichier: "ladedb - données seules.sql"

•déployer le schéma de BDD avec le fichier: "ladedb - structure seule.sql" et ensuite si vous le souhaitez, déployer le fichier: "ladedb - données seules.sql"

•déployer schéma et jeux de données avec le fichier : "ladedb - structure et données.sql" (avant de lancer l'application pour la première fois)

Si vous utilisez le jeux de données:

Plusieurs utilisateurs ont été créés :

Un administrateur:   
•Identifiant : admin Mot de passe : admin
