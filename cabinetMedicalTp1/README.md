# TP1 – Application Monolithique
## Gestion d’un Cabinet Médical

Cours assuré par : **Jaouad OUHSSAINE**  
Contact : jaouad.ouhs@gmail.com | jaouad_ouhssaine@um5.ac.ma

---

## Contexte

Ce TP correspond à la **première phase** du projet pédagogique évolutif  
**Gestion d’un Cabinet Médical**, réalisé dans le cadre du module :

**Systèmes Distribués Basés sur les Microservices**  
Master IPS – Faculté des Sciences de Rabat

L’objectif est de mettre en place une **application Spring Boot monolithique** regroupant
les premiers services métiers du cabinet médical dans un **seul projet**.

---

## Objectifs du TP

- Créer une application Spring Boot unique (monolithe)
- Mettre en place une architecture en couches :
  - Controller
  - Service
  - Repository
  - Domaine
- Modéliser les premières entités métier
- Exposer des opérations de base via des APIs REST
- Préparer le terrain pour une future découpe SOA (TP2)

---

## Périmètre fonctionnel

### Gestion des patients
- Créer un patient
- Lister les patients

### Gestion des médecins
- Créer un médecin
- Lister les médecins

### Gestion des rendez-vous
- Créer un rendez-vous entre un patient et un médecin
- Lister les rendez-vous

### Gestion des consultations
- Enregistrer une consultation à partir d’un rendez-vous

---

## Modèle de données

Les entités principales sont :

- Patient (id, nom, dateNaissance, genre, telephone)
- Medecin (id, nom, specialite, email)
- RendezVous (id, dateRdv, statut, patient, medecin)
- Consultation (id, dateConsultation, rapport, rendezVous)

---

## Architecture

- Application monolithique
- Une seule base de données
- Une seule application Spring Boot
- Découpage logique par packages

---

## Technologies utilisées

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Base de données H2 (en mémoire)
- Maven
- Python / FastApi et/ou Django

---

## Tests

Les endpoints REST peuvent être testés via :
- Postman
- Bruno
- Navigateur web

---

## Livrables

- Code source complet
- README ou rapport décrivant :
  - Les endpoints REST
  - Les fonctionnalités implémentées
- Lien GitHub du projet
