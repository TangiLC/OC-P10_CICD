# 🎭 BOBAPP Frontend

Cette application Angular 14 est une **single-page app (SPA)** permettant d'afficher une blague aléatoire à chaque clic. Le projet est conteneurisé avec Docker, et les modifications sont supervisées par un pipeline CI/CD via GitHub Actions.

Ce projet est développé dans un cadre pédagogique pour le cursus **Full-Stack Java Angular d'OpenClassrooms**. Le but est de mettre en place **l'intégration continue (CI) et le déploiement continu (CD) du frontend**.
Le repository original est [https://github.com/OpenClassrooms-Student-Center/Gerez-un-projet-collaboratif-en-int-grant-une-demarche-CI-CD](https://github.com/OpenClassrooms-Student-Center/Gerez-un-projet-collaboratif-en-int-grant-une-demarche-CI-CD)

![Angular](https://img.shields.io/badge/Angular-14-red?logo=angular&logoColor=red)
![Jasmine](https://img.shields.io/badge/Tested%20with-Jasmine-blue?logo=jasmine&logoColor=blue)
![GitHub Workflow Status](https://img.shields.io/github/actions/workflow/status/TangiLC/OC-P10_CICD/front-build-test.yml?branch=main)

## 🚀 Prérequis
- [Node.js](https://nodejs.org/en/download/) (version 18+)
- [Angular CLI](https://angular.io/cli)
- [Docker](https://www.docker.com/)
- [Git](https://git-scm.com/)

## 🛠️ Installation

1. Cloner le projet :
```bash
 git clone https://github.com/TangiLC/OC-P10_CICD.git
 cd front
```

2. Installer les dépendances :
```bash
npm install
```

3. Lancer l'application en local :
```bash
ng serve
```

4. L'application est disponible sur le port `4200` par défaut.

---

1. **Alternativement, une image Docker est disponible sur DockerHub :**
```bash
docker pull tangilecadre/bobapp-front
```

2. **Lancer le conteneur Docker depuis l'image :**
```bash
docker run -p 8080:80 tangilecadre/bobapp-front
```

L'application sera accessible sur [http://localhost:8080](http://localhost:8080).

## 📚 Fonctionnalités

- **Blague aléatoire par jour :** L'interface affiche une blague unique récupérée depuis l'API backend.
- **SPA :** L'application est une single-page app sans authentification ni sécurité spécifique.

## 🧪 Tests

Les tests sont basés sur Jasmine et peuvent être lancés avec :
```bash
ng test
```

## ⚙️ CI/CD - GitHub Actions

Trois workflows sont configurés pour le front-end :

1. **Code Analysis :**
   - Valide la syntaxe TypeScript.

2. **Front-Build-Test :**
   - Compile l'application Angular.
   - Lance les tests Jasmine.
   - Génère un rapport de qualité SonarCloud.

[https://sonarcloud.io/summary/overall?id=tangilc_OC-P10_CICD%3Afront&branch=main](https://sonarcloud.io/summary/overall?id=tangilc_OC-P10_CICD%3Afront&branch=main) pour obtenir le rapport.

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=tangilc_OC-P10_CICD:front&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=tangilc_OC-P10_CICD:front)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=tangilc_OC-P10_CICD:front&metric=coverage)](https://sonarcloud.io/summary/new_code?id=tangilc_OC-P10_CICD:front)

3. **Dockerize :**
   - Construit l'image Docker.

## 🤝 Contribuer

Les contributions sont les bienvenues ! N'hésitez pas à ouvrir une issue ou une pull request.

