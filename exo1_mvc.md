# Exercice 1 : Spring MVC

##1 - Un serveur simple : hello world

Nous allons utiliser Spring MVC pour créer un serveur.

* Créer un nouveau projet maven
* Ajouter les dépendances de base
```xml
 <parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>3.1.4</version>
</parent>
```
* Créer une classe de démarrage avec une méthode main
* Démarrer le projet : l'application doit démarrer sur le port 8080
* Ajouter une route /hello qui affiche Hello World
* Avec maven, créer un jar du projet que vous pourrez exécuter avec java

### Explications

Quand vous ajouter @SpringBootApplication, cette annotation regroupe plusieurs annotations dont @ScanPackage qui va détecter automatiquement tous les controllers, services...

### Un peu plus loin

Nous allons commencer à jouer avec la configuration :
* Démarrer le serveur sur le port 8081
* Utiliser une implémentation Jetty pour le server embarqué
* Créer deux tests pour vérifier que le contrôleur fonctionne :
    * En appelant directement un serveur qui est lancé
    * En mockant le serveur lors de l'appel

## Spring MVC : ajoutons des routes

Nous allons parcourir les possibilités de Spring MVC : création de routes plus complexe

Pour chaque ajout de route, prévoir le test associé
* GET /books/:id qui renvoie un livre si l'id est entre 5 et 15, une 404 sinon. Le titre est généré au hasard.
* POST /books qui créé un nouveau livre et le renvoie

## A noter

Spring Boot propose [des aides (_starters_)](https://docs.spring.io/spring-boot/docs/3.1.0/reference/htmlsingle/#using.build-systems.starters) pour intégrer rapidement les modules usuels de Spring.