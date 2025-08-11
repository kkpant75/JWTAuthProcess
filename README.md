# 🔐 Spring Boot JWT Authentication API (Dockerized)

A minimal Spring Boot REST API demonstrating stateless authentication using JSON Web Tokens (JWT), built and deployed with Docker.

---

## ⚙️ How It Works

1. **Token Issuance**:
   - Clients send a request to `/token?username=<username>`.
   - The server generates a signed JWT and returns it to the client.

2. **Token Usage**:
   - Clients include the JWT in the `Authorization` header (`Bearer <token>`) when accessing protected resources.
   - The server validates the token before allowing access.

3. **Stateless Authentication**:
   - No session or cookies are used.
   - JWT is validated on every request using a custom security filter.
   - If the token is valid, the request is authenticated.


4. **API available at**:
   `http://localhost:8080`

---
## 🚀 How to Run with Docker
   ```
  docker compose up -d 
  or 
  docker compose up --build
```

## 🎯 How to Operate

### 1. Generate a Token

* **Endpoint**: `POST /token?username=testuser`
* **Returns**: A JWT token as plain text

### 2. Access Protected Endpoint

* **Endpoint**: `GET /protected`
* **Header**:

  ```
  Authorization: Bearer <your-token>
  ```

---

## 🔄 Application Flow

1. **Client calls `/token?username=testuser`**

   * Server creates and signs a JWT with the username and expiration.
   * Token is returned to the client.

2. **Client calls `/protected` with JWT in `Authorization` header**

   * A custom JWT filter intercepts the request.
   * Token is extracted and validated.
   * If valid, user is authenticated in Spring Security context.
   * Controller returns response (e.g., “Hello, testuser”).

3. **If the token is missing, expired, or invalid**

   * Server responds with `403 Forbidden` or `401 Unauthorized`.

---

## 📌 Notes

* This example is for demo/testing purposes only.
* In a real-world application, you'd add password authentication, role-based access, and more robust token handling.
* Token expiration is currently set to 1 hour.

---

## 🧹 Cleanup

To stop and remove the container:

```
docker compose down
```

---

## 📚 License

MIT – Free to use for learning and experimentation.

```
