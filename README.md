# Enkel Webshop Backend med Java och Spring Boot

## Projektöversikt
Det här är ett backend-API för en enkel webshop som hanterar produkter och ordrar.  
API:t är byggt med Java och Spring Boot och använder in-memory lagring för enkelhet.

---

## Teknisk stack
- Java 17+
- Spring Boot
- In-memory lagring (Map)
- REST API med JSON
- Enhetstester med JUnit (valfritt)

---

## Kom igång

### 1. Klona repot
```bash
git clone https://github.com/ditt-anvandarnamn/webshop-backend.git
cd webshop-backend

./mvnw spring-boot:run


curl -X POST http://localhost:8080/api/products \
-H "Content-Type: application/json" \
-d '{
  "id": 1,
  "name": "Gaming Mouse",
  "description": "Wireless mouse",
  "price": 499.99,
  "imageUrl": "mouse.jpg",
  "stockQuantity": 50,
  "category": "Electronics"
}'


curl http://localhost:8080/api/products


curl http://localhost:8080/api/products/1


curl -X PUT http://localhost:8080/api/products/1 \
-H "Content-Type: application/json" \
-d '{
  "id": 1,
  "name": "laptop",
  "description": "macbook air m1",
  "price": 1399.99,
  "imageUrl": "laptop.jpg",
  "stockQuantity": 45,
  "category": "Electronics"
}'




curl -X DELETE http://localhost:8080/api/products/1


curl -X POST http://localhost:8080/api/orders \
-H "Content-Type: application/json" \
-d '{
  "customerInfo": {
    "name": "Amir Husseini",
    "email": "amir@example.com",
    "address": "Frihetsvägen 33"
  },
  "items": [
    {
      "productId": 1,
      "quantity": 2
    }
  ]
}'


curl http://localhost:8080/api/orders


curl -X POST http://localhost:8080/api/orders \
-H "Content-Type: application/json" \
-d '{
  "customerInfo": {
    "name": "Fel Test",
    "email": "fel@example.com",
    "address": "Testvägen 1"
  },
  "items": [
    {
      "productId": 1,
      "quantity": 1000
    }
  ]
}'




