# Application de Petite pause culture

## Description

Cette application est conçue pour redonner le moral aux employés d'une entreprise spécialisée dans la vente d'ours en peluche. Elle permet aux utilisateurs de discuter avec un chatbot qui répond avec des citations inspirantes. Les conversations sont enregistrées dans une base de données MySQL, et un administrateur peut consulter l'historique des messages.

## Fonctionnalités

- **Chatbot inspirant** : Les utilisateurs peuvent envoyer des messages et recevoir des citations motivantes en réponse.
- **Enregistrement des conversations** : Toutes les conversations sont enregistrées dans une base de données MySQL.
- **Espace administrateur** : Un administrateur peut consulter la liste des utilisateurs et afficher l'historique de leurs messages.
- **Design moderne** : Une interface utilisateur attrayante et réactive, avec des animations fluides.

## Technologies utilisées

- **Backend** : Spring Boot (Java)
- **Frontend** : Thymeleaf (HTML, CSS)
- **Base de données** : MySQL
- **API** : RestTemplate pour interagir avec l'API de citations
- **Build tool** : Maven

---

## Prérequis

Avant de lancer l'application, assurez-vous d'avoir installé les éléments suivants :

- **Java 17** : [Télécharger Java](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- **MySQL** : [Télécharger MySQL](https://dev.mysql.com/downloads/installer/)
- **Eclipse IDE** : [Télécharger Eclipse](https://www.eclipse.org/downloads/)
- **Maven** : [Télécharger Maven](https://maven.apache.org/download.cgi) (intégré à Eclipse)

---

## Configuration

### 1. Base de données MySQL

1. Créez une base de données nommée `Echange` dans MySQL.
2. Inserer les données de tests (A faire après lancement du projet citation via Workbench).
```bash
INSERT INTO citation (texte, auteur) VALUES 
('Le succès, c’est tomber sept fois, se relever huit.', 'Proverbe japonais'),
('La seule façon de faire du bon travail, c’est d’aimer ce que vous faites.', 'Steve Jobs'),
('Croyez en vos rêves et ils se réaliseront peut-être. Croyez en vous et ils se réaliseront sûrement.', 'Martin Luther King'),
('L’échec est simplement l’opportunité de recommencer, cette fois d’une manière plus intelligente.', 'Henry Ford'),
('Il faut toujours viser la lune, car même en cas d’échec, on atterrit dans les étoiles.', 'Oscar Wilde'),
('Votre temps est limité, alors ne le gâchez pas en vivant la vie de quelqu’un d’autre.', 'Steve Jobs'),
('Tout semble toujours impossible jusqu’à ce qu’on le fasse.', 'Nelson Mandela'),
('N’attendez pas d’avoir tout pour profiter de la vie, vous avez déjà la vie pour en profiter.', 'Confucius'),
('Agissez comme s’il était impossible d’échouer.', 'Winston Churchill'),
('La vie est un mystère qu’il faut vivre, et non un problème à résoudre.', 'Gandhi');

```
3. Configurez les informations de connexion dans le fichier `application.properties` :

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/Echange
spring.datasource.username=root
spring.datasource.password=VotreMotDePasse
spring.jpa.hibernate.ddl-auto=update
```

### 2. API de citations

Assurez-vous que l'API de citations est en cours d'exécution sur http://localhost:8080. Si ce n'est pas le cas, démarrez-la.
 
 ---

## Installation et lancement avec Eclipse

### 1. Importation du projet :
- Ouvrez Eclipse.
- Allez dans `File > Import > Maven > Existing Maven Projects`.
- Sélectionnez le dossier racine du projet et cliquez sur Finish.
### 2. Configuration de Maven :
- Assurez-vous que Maven est correctement configuré dans Eclipse.
- Cliquez droit sur le projet, puis sélectionnez Maven > Update Project.
### 3. Lancement de l'application :
- Cliquez droit sur le projet.
- Allez dans Run As > Spring Boot App.
- L'application devrait démarrer sur le port 8081.
### 4. Accès à l'application :
- Page de conversation : `http://localhost:8081`
- Espace administrateur : `http://localhost:8081/admin`

### Structure du projet
```
src/
├── main/
│   ├── java/
│   │   └── api/
│   │       └── application/
│   │           ├── controller/
│   │           ├── model/
│   │           ├── repository/
│   │           └── service/
│   ├── resources/
│   │   ├── static/
│   │   │   └── css/
│   │   │       └── styles.css
│   │   ├── templates/
│   │   │   ├── index.html
│   │   │   ├── admin.html
│   │   │   └── conversation.html
│   │   └── application.properties
│   └── webapp/
└── test/

```

---

## Utilisation

### 1. Page de conversation (/)

- Entrez votre nom d'utilisateur et un message.
- Cliquez sur "Envoyer" pour recevoir une citation inspirante.
- La citation s'affiche sous le formulaire.

### 2. Espace administrateur (/admin)

- Consultez la liste des utilisateurs ayant posté des messages.
- Cliquez sur "Voir la conversation" pour afficher l'historique des messages d'un utilisateur.

---

## Bonnes pratiques suivies

- Modularité : Séparation claire des couches (controller, service, repository).
- Validation : Utilisation de la validation des entrées utilisateur.
- Sécurité : Configuration sécurisée de la base de données.
- Documentation : Code commenté et README détaillé.
- Tests : Tests unitaires et d'intégration (à ajouter).