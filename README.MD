# Atelier Spring Boot

**Spring boot** est un module spring permettant de concevoir rapidement une application web, autonome avec peu de configuration.
Son exécution se fait simplement en lançant le JAR, il n'est pas nécessaire d'installer un serveur comme Tomcat ou Jetty.

Nous allons créer, à partir de rien, un projet et ajouter les briques une par une.

* [Exercice 1 : Spring MVC](exo1_mvc.md)
* [Exercice 2 : Injection de dépendances](exo2_ioc.md)
* [Exercice 3 : Spring JPA](exo3_jpa.md)

* [Exercice : Documenter son API](exo5_swagger.md)

## Références

* [Liste des kits de démarrage](https://docs.spring.io/spring-boot/docs/current/reference/html/using.html#using.build-systems.starters)
* [Test controleur avec spring](https://spring.io/guides/gs/testing-web/)
* [Document spring mvc](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
* [Gestion des exceptions](https://spring.io/blog/2013/11/01/exception-handling-in-spring-mvc)
* [Configuration de la BDD](https://docs.spring.io/spring-cloud-dataflow/docs/1.1.2.RELEASE/reference/html/configuration-rdbms.html)
* [Connexion à la BDD](https://spring.io/guides/gs/accessing-data-mysql/)
* [Configuration H2](https://www.baeldung.com/spring-boot-h2-database)

## Aide

* Requête Curl POST
```shell
curl  -H "Content-Type:application/json"  -d "{\"title\":\"New book\"}" -X POST "http://localhost:8081/books"
```