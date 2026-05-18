# api-todolist

API Spring Boot pour gérer des tâches :
- création de tâches,
- assignation à une personne,
- suivi de l'évolution (historique des statuts).

## Lancer l'application

```bash
mvn spring-boot:run
```

## Exemples d'API

Créer une tâche :

```bash
curl -X POST http://localhost:8080/api/tasks \
  -H "Content-Type: application/json" \
  -d '{"title":"Préparer la release","description":"Version 1.0"}'
```

Assigner une tâche :

```bash
curl -X PATCH http://localhost:8080/api/tasks/1/assignee \
  -H "Content-Type: application/json" \
  -d '{"assignee":"DOHO"}'
```

Mettre à jour le statut :

```bash
curl -X PATCH http://localhost:8080/api/tasks/1/status \
  -H "Content-Type: application/json" \
  -d '{"status":"IN_PROGRESS"}'
```
