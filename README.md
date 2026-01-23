# digital-health-appointments-poc

Proof of Concept d’une application backend réactive pour la gestion de créneaux de rendez-vous.

## 🛠️ Stack

### Backend

- **Java 17**
- **Spring Boot 3 (WebFlux)**
- **Spring Data R2DBC**
- **Spring Security (WebFlux)**
- **PostgreSQL 16**
- **Flyway (migrations SQL)**
- **Docker / Docker Compose**
- **Maven**

### Frontend

- **Angular 19**
- **TypeScript**

## 🧱 Architecture backend

Architecture en couches, conforme aux standards des applications Spring :

```
controller → exposition de l’API REST
service → logique métier
repository → accès aux données (R2DBC)
model → entités persistées
dto → objets API
exception → gestion centralisée des erreurs
```

## 🔗 Endpoints exposés

### ➤ Créer un créneau

```
POST /api/slots
```

```json
{
	"startTime": "2026-01-22T09:00:00",
	"endTime": "2026-01-22T09:30:00"
}
```

### ➤ Lister les créneaux

```
GET /api/slots
```

### ➤ Réserver un créneau

```
POST /api/slots/{id}/reserve
```

## ⚠️ Validation & gestion des erreurs

Règles métier appliquées dans la couche service  
Gestion centralisée des exceptions avec @RestControllerAdvice

## Base de données

- PostgreSQL est exécutée via Docker Compose.
- Les migrations SQL sont gérées par Flyway :

```
src/main/resources/db/migration
```

## ▶️ Lancer le projet

### 1️⃣ Démarrer PostgreSQL

```bash
docker compose up -d
```

### 2️⃣ Démarrer l’application Spring

```bash
cd backend
./mvnw spring-boot:run
```

L’API est disponible à l’adresse suivante :

```
http://localhost:8080
```

### 3️⃣ Démarrer l’application Angular

```bash
cd frontend
npm install
ng serve
```

Frontend disponible à l’adresse :
http://localhost:4200

## Fonctionnalités actuelles

- Création de créneaux
- Liste des créneaux triés par date et heure
- Affichage de la durée des créneaux
- Réservation d’un créneau côté client
