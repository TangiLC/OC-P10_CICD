# 🎭 BOBAPP - Application Full-Stack

BOBAPP est une application full-stack permettant d'afficher une blague aléatoire par jour. Elle est développée avec un backend Java Spring Boot et un frontend Angular. Les deux parties sont conteneurisées avec Docker et intègrent un pipeline CI/CD via GitHub Actions.

Ce projet est réalisé dans le cadre du cursus **Full-Stack Java Angular d'OpenClassrooms**, visant à implémenter une chaîne complète d'intégration continue (CI) et de déploiement continu (CD).

![Java](https://img.shields.io/badge/Java-11%2B-orange?logo=coffeescript&logoColor=orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.5.4-green?logo=spring&logoColor=green)
![Angular](https://img.shields.io/badge/Angular-14-red?logo=angular&logoColor=red)
![JUnit5](https://img.shields.io/badge/Tested%20with-JUnit.5-green?logo=junit5&logoColor=green)
![Jasmine](https://img.shields.io/badge/Tested%20with-Jasmine-blue?logo=jasmine&logoColor=blue)
![GitHub Workflow Status](https://img.shields.io/github/actions/workflow/status/TangiLC/OC-P10_CICD/back-build-test.yml?branch=main)
![Docker](https://img.shields.io/badge/Docker-available-blue?logo=docker)

---

## 📦 Architecture

### **Backend (API REST)**
- Langage : Java 11 avec Spring Boot 2.5.4
- Endpoint principal : `GET /api/joke` – Renvoie une blague aléatoire
- Tests : JUnit 5
- Image Docker : `tangilecadre/bobapp-back`

### **Frontend (SPA Angular)**
- Framework : Angular 14
- Interface : Single Page App (SPA)
- Tests : Jasmine
- Image Docker : `tangilecadre/bobapp-front`

---

## 🚀 Installation

### **1. Installation locale (Développement)**

#### **Backend**
1. Cloner le projet :
```bash
git clone https://github.com/TangiLC/OC-P10_CICD.git
cd back
```
2. Construire le projet :
```bash
mvn clean install
```
3. Lancer l'API :
```bash
mvn spring-boot:run
```
API disponible sur [http://localhost:8080](http://localhost:8080)

#### **Frontend**
1. Accéder au dossier `front` :
```bash
cd front
```
2. Installer les dépendances :
```bash
npm install
```
3. Lancer l'application Angular :
```bash
ng serve
```
Frontend accessible sur [http://localhost:4200](http://localhost:4200)

### 2. Utilisation avec Docker🐋 
Assurez-vous que **Docker Desktop** est installé sur votre machine. Il inclut le moteur Docker et Docker Compose.

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

---

## 🔍 CI/CD - GitHub Actions

Des pipelines GitHub Actions assurent l'intégration et le déploiement continu :

1. **Code Analysis** :
   - Analyse statique pour Java (backend) et TypeScript (frontend)

2. **Build & Test** :
   - Compilation et tests unitaires (JUnit 5 et Jasmine)
   - Rapport de couverture SonarCloud

3. **Dockerize** :
   - Construction des images Docker

### **Rapports SonarCloud :**
- [Backend - SonarCloud](https://sonarcloud.io/summary/overall?id=tangilc_OC-P10_CICD%3Aback&branch=main)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=tangilc_OC-P10_CICD:back&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=tangilc_OC-P10_CICD:back)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=tangilc_OC-P10_CICD:back&metric=coverage)](https://sonarcloud.io/summary/new_code?id=tangilc_OC-P10_CICD:back)

- [Frontend - SonarCloud](https://sonarcloud.io/summary/overall?id=tangilc_OC-P10_CICD%3Afront&branch=main)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=tangilc_OC-P10_CICD:front&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=tangilc_OC-P10_CICD:front)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=tangilc_OC-P10_CICD:front&metric=coverage)](https://sonarcloud.io/summary/new_code?id=tangilc_OC-P10_CICD:front)

---

## 🤝 Contribuer
Les contributions sont les bienvenues ! N'hésitez pas à ouvrir une issue ou une pull request.

