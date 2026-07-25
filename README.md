#### Get billboard posts for a union
$ curl  http://localhost:8080/billboard/posts/SKOGSMARDEN

---
#### Get announcement posts for a union
$ curl  http://localhost:8080-nothingyet

---

#### Get board posts for a union
$ curl  http://localhost:8080-nothingyet

---

#### Create billboard posts for a union

curl -X POST http://localhost:8080/billboard/posts \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Free couch",
    "description": "Good condition, pickup only",
    "union": "LINDSDAL",
    "createdByUser": "1234"
  }'
  
---