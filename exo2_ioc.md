# Exercice 2 : injection de dépendences


Utilisons la puissance de Spring pour créer des services et les ajouter
* Créer une interface BookService avec les méthodes get et create
* Créer une implémentation où les données sont stockées en liste
* Renommer les précédents endpoint de books en fakebooks
* Créer un nouveau endpoint qui exploite ce service
* Rajouter des tests pour ce nouveau endpoint

Maintenant, imaginons que nous voulions changer notre implémentation de BookService :
* Créer une implémentation où les données sont stockées dans une map
* Faire passer les tests :)

Note : avec deux implémentations, vous aller devoir configurer quelle version il faut utiliser.

Mockons les tests :
* Créer un nouveau test du controleur, mais en mockant le service qui effectue le traitement, afin d'avoir un test vraiment unitaire
