### Getting started 
1. Run spring app 
2. run postgres db $`docker compose up`
3. view db on pgadmin `http://localhost:5050`

#### Get billboard posts for a union
`curl  http://localhost:8080/billboard/posts/SKOGSMARDEN`

---
#### Get announcement posts for a union
`curl  http://localhost:8080-nothingyet`

---

#### Get board posts for a union
`curl  http://localhost:8080-nothingyet`

---

#### Create billboard posts for a union

`curl -X POST http://localhost:8080/billboard/posts \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Free couch",
    "description": "Good condition, pickup only",
    "union": "LINDSDAL",
    "createdByUser": "1234"
  }'`
  

---

### Database 
##### Spin up db
`docker compose up -d `
##### close db
`docker compose down`
##### close db and wipe data
`docker compose down -v `
##### Inspect the db
`docker exec -it billboard-postgres psql -U birly_user -d birlydb`

#### Credentials
db: birlydb |
user: birly_user |
pass: birlypass

---