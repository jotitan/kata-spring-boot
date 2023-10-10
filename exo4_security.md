# Exercice 4 : Security

Spring Security va nous aider à sécuriser l'application : 
* Authentification
* Gestion de rôle
* Sécurisation des routes
* Gestion du CORS

## Configuration

* Ajouter la dépendance spring-boot-starter-security

### Schéma de données

### Du code

* Ajouter la dépendance de spring jpa (spring-boot-starter-data-jpa) et le driver Postgresql
* Créer le mapping JPA de la classe Book
* Configurer dans application.properties la connexion à la base de données
* Ajouter une nouvelle implémentation de BookService qui utilisera un repository jpa
* Tester ce nouveau repository en le branchant à une base mémoire H2

### Un peu loin
* Ajouter et tester une méthode recherchant les livres à partir de leur titre
* Ajouter et tester une méthode recherchant les livres commençant par un mot