# digital-health-appointments-poc

Proof of Concept d’une application backend réactive pour la gestion de créneaux de rendez-vous avec Spring WebFlux et Angular.

## 🛠️ Stack

### Backend

- Java 17 | Spring Boot 3 (WebFlux) | R2DBC | PostgreSQL 16
- Spring Security (JWT + Guards)
- Flyway | Docker | Maven

### Frontend

- Angular 19 | TypeScript

## 🧱 Architecture 
![ArchitectureOverviewAngularSpring](https://github.com/user-attachments/assets/ec4da15b-1c34-4c74-b0f1-b1ec14b0a3fb)

## 🔐 Sécurité

- Authentification JWT
- Guards pour la protection des routes

## API REST

| Méthode | Endpoint                | Description         |
| ------- | ----------------------- | ------------------- |
| POST    | /api/admin/slots        | Créer un créneau    |
| GET     | /api/slots              | Lister les créneaux |
| POST    | /api/slots/{id}/reserve | Réserver un créneau |

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

```bash
# 1. PostgreSQL
docker compose up -d

# 2. Backend (port 8080)
cd backend && ./mvnw spring-boot:run

# 3. Frontend (port 4200)
cd frontend && npm install && ng serve
```

## Fonctionnalités actuelles

- Création de créneaux
- Liste des créneaux triés par date et heure
- Affichage de la durée des créneaux
- Réservation d’un créneau côté client
