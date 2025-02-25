# 🎭 BobApp Backend_

Cette API permet d'afficher une blague aléatoire à chaque appel, tirée d'un fichier JSON situé dans les ressources de l'application. Le projet est développé en Java 11 avec Spring Boot, et utilise Docker pour la conteneurisation. Les modifications sont supervisées par un pipeline CI/CD via GitHub Actions.

Ce projet est développé dans un cadre prédagogique pour le cursus **Full-Stack Java Angular d'OpenClassrooms**. Le but est de mettre en place **l'intégration continue (CI) et le déploiement continu (CD) du backend**.
Le repository original est [https://github.com/OpenClassrooms-Student-Center/Gerez-un-projet-collaboratif-en-int-grant-une-demarche-CI-CD](https://github.com/OpenClassrooms-Student-Center/Gerez-un-projet-collaboratif-en-int-grant-une-demarche-CI-CD)

![Java](https://img.shields.io/badge/Java-11%2B-orange?logo=coffeescript&logoColor=orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.5.4-green?logo=spring&logoColor=green)
![JUnit5](https://img.shields.io/badge/Tested%20with-JUnit.5-green?logo=junit5&logoColor=green)
![GitHub Workflow Status](https://img.shields.io/github/actions/workflow/status/TangiLC/OC-P10_CICD/back-build-test.yml?branch=main)


## 🚀 Prérequis
- [Java 11](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)
- [Docker](https://www.docker.com/)
- [Maven](https://maven.apache.org/)
- [Git](https://git-scm.com/)

## 🛠️ Installation

1. Cloner le projet :
```bash
 git clone https://github.com/TangiLC/OC-P10_CICD.git
 cd back
```
2. Construire le projet avec Maven :
```bash
mvn clean install
```
3. Lancer l'application :
```bash
mvn spring-boot:run
```
4. L'API est disponible sur le port `8080` du localhost
---
1. Alternativement, une **image Docker** est disponible sur DockerHub :
#### **Pull des images dockerhub (dernière version)**
Récupération des dernières versions des images Docker pour le backend et le frontend :
```bash
docker pull tangilecadre/bobapp-back:latest
docker pull tangilecadre/bobapp-front:latest
```
Un fichier `docker-compose.yml` est présent à la racine du projet pour faciliter le déploiement.

Pour lancer les conteneurs (frontend et backend) dans un projet conjoint :
```bash
docker-compose up -d
```

Le front-end de l'application sera disponible sur [http://localhost:4200](http://localhost:4200)

Pour arrêter les services et libérer les ports :
```bash
docker-compose down
```



## 📚 Architecture

### **API REST Endpoint**
Le endpoint `GET /api/joke` renvoie une blague aléatoire au format json de type :
```json
{"joke":"Que fait un geek quand il descend du métro ?",
"response":"Il libère la RAM"}
```

### **Ressources :**
- **Fichier JSON :** `src/main/resources/json/jokes.json` contenant la liste des blagues.

### **Sécurité**
Les appels API ne sont pas sécurisés.

## 🧪 Tests
Les tests sont basés sur JUnit 5 et peuvent être lancés avec :
```bash
mvn test
```

## ⚙️ CI/CD - GitHub Actions
Trois workflows sont configurés pour le back-end:

1. **Code Analysis :**
   - Valide la syntaxe Java.

2. **Back-Build-Test :**
   - Compile l'API.
   - Lance les tests JUnit 5.
   - Génère un rapport de qualité SonarCloud.

[https://sonarcloud.io/summary/overall?id=tangilc_OC-P10_CICD%3Aback&branch=main](https://sonarcloud.io/summary/overall?id=tangilc_OC-P10_CICD%3Aback&branch=main) pour obtenir le rapport.

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=tangilc_OC-P10_CICD:back&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=tangilc_OC-P10_CICD:back)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=tangilc_OC-P10_CICD:back&metric=coverage)](https://sonarcloud.io/summary/new_code?id=tangilc_OC-P10_CICD:back)

3. **Dockerize :**
   - Construit l'image Docker.


## 🤝 Contribuer
toutes les contributions sont les bienvenues ! N'hésitez pas à ouvrir une issue ou une pull request.


