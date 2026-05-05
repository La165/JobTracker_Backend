# 🛠️ Job Tracker Backend

A robust **Spring Boot Backend API** for the Job Tracker application. It provides secure authentication and job management features using JWT-based security and RESTful APIs.

---

## 🚀 Live API

🔗 https://jobtracker-backend-znvo.onrender.com

---

## 🛠️ Tech Stack

* ☕ Java (Spring Boot)
* 🌐 Spring Web
* 🔐 Spring Security (JWT Authentication)
* 🗄️ Spring Data JPA
* 🐬 MySQL (Hosted on Aiven Cloud)
* ⚡ Lombok
* ✅ Spring Validation
* 🔁 DevTools
* 🧑‍💻 VS Code / STS
* 🐳 Docker (for deployment)
* ☁️ Render (Deployment)

---

## 📂 Project Structure

```id="r5d7v8"
com.jobtracker
│
├── config/
│   └── SecurityConfig.java
│
├── controller/
│   ├── AuthController.java
│   ├── UserController.java
│   └── JobController.java
│
├── dto/
│   ├── JobRequestDTO.java
│   └── JobResponseDTO.java
│
├── entity/
│   ├── User.java
│   └── Job.java
│
├── enums/
│   └── JobStatus.java
│
├── exception/
│   └── GlobalExceptionHandler.java
│
├── repository/
│   ├── UserRepository.java
│   └── JobRepository.java
│
├── security/
│   ├── JwtUtil.java
│   └── JwtFilter.java
│
├── service/
│   ├── UserService.java
│   └── JobService.java
│
└── JobtrackerApplication.java
```

---

## ✨ Features

* 🔐 User Registration & Login
* 🔑 JWT-based Authentication & Authorization
* 📋 CRUD Operations for Job Tracking
* 📊 Job Status Management (Applied, Interview, Rejected, etc.)
* ⚠️ Global Exception Handling
* ✅ Input Validation using Spring Validation
* 🔒 Secured REST APIs

---

## 🗄️ Database

This application uses **MySQL** hosted on **Aiven Cloud**.

* Managed cloud database service
* Secure remote connection (SSL enabled)
* Used for storing user and job data

---

## 🔐 Authentication Flow

* User registers or logs in via `/auth/**`
* Backend generates a JWT token
* Token must be included in headers for protected APIs:

```id="k8x2m1"
Authorization: Bearer <token>
```

* Requests without token → ❌ Unauthorized

---

## 📌 API Endpoints

### 🔑 Auth APIs

```id="n9q7z2"
POST /auth/register   → Register new user
POST /auth/login      → Login and get JWT token
```

---

### 📋 Job APIs (Protected)

```id="b3v6p8"
GET    /jobs          → Get all jobs
POST   /jobs          → Add new job
PUT    /jobs/{id}     → Update job
DELETE /jobs/{id}     → Delete job
```

👉 Requires JWT token in headers

---

## ⚙️ Installation & Setup

1. Clone the repository:

   ```bash
   git clone https://github.com/La165/JobTracker_Backend
   cd jobtracker-backend
   ```

2. Configure database in `application.properties`:

```properties id="f4c2t9"
spring.datasource.url=jdbc:mysql://<aiven-host>:<port>/<database>?ssl-mode=REQUIRED
spring.datasource.username=<username>
spring.datasource.password=<password>

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

3. Run the application:

```bash id="z6r1x5"
mvn spring-boot:run
```

---

## 🌍 Environment Variables (Recommended)

For production, configure:

```env id="y5u8k3"
DB_URL=jdbc:mysql://<aiven-host>:<port>/<database>?ssl-mode=REQUIRED
DB_USERNAME=your_username
DB_PASSWORD=your_password
JWT_SECRET=your_secret_key
```

---

## 🐳 Docker Support

Dockerfile is included for containerized deployment.

To build and run:

```bash id="w2m9d7"
docker build -t jobtracker-backend .
docker run -p 9003:9003 jobtracker-backend
```

---

## 🚀 Deployment

This backend is deployed using **Render**:

* Connect GitHub repository
* Configure environment variables
* Deploy automatically

---

## 🔗 Frontend Repository

Frontend application:
👉 https://github.com/La165/JobTracker_Frontend

Live App:
👉 https://job-tracker-frontend-orpin.vercel.app

---

## 📌 Future Enhancements

* 👥 Role-based access control (Admin/User)
* 📊 Advanced analytics dashboard
* 🔔 Notifications
* 📁 File upload (Resume tracking)

---

## 👩‍💻 Author

**Lalitha**

---

## 📄 License

This project is open-source and available under the MIT License.
