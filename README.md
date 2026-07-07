# 🍽️ Food Donation Platform

<div align="center">

### **Connecting Food Donors with NGOs to Reduce Food Waste and Fight Hunger**

[![Java](https://img.shields.io/badge/Java-17-orange.svg)](https://adoptium.net/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.0-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)
[![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg)](http://makeapullrequest.com)

**A full-stack Java application that connects restaurants, hotels, and individuals with NGOs to reduce food waste and support communities in need.**

</div>

---

# 📖 Table of Contents

- About
- Features
- Use Cases
- Tech Stack
- Installation
- Running the Project
- API Documentation
- Example Request
- cURL Examples
- Project Structure
- Database
- Screenshots
- Future Enhancements
- Contributing
- License
- Acknowledgments
- Contact

---

# 📌 About

Every year, nearly **one-third of all food produced globally goes to waste**, while millions of people struggle with hunger.

The **Food Donation Platform** is designed to bridge this gap by allowing food donors—including restaurants, hotels, caterers, and individuals—to donate surplus food that can be claimed by NGOs and food banks.

The application provides a simple and efficient platform for posting, discovering, and claiming food donations in real time.

### Built With

- Java 17
- Spring Boot 3.2
- Spring Data JPA
- Thymeleaf
- H2 Database
- Maven
- HTML5
- CSS3
- JavaScript

---

# ✨ Features

## 🍽️ Donor Features

- Create food donations easily
- View donation history
- Share surplus food instantly
- Update donation details
- Delete donations

---

## 🏥 NGO Features

- Browse available food donations
- Search donations by location
- Claim available food
- View live donation statistics
- Track claimed donations

---

## ⚙️ Technical Features

- RESTful APIs
- Spring Boot architecture
- H2 in-memory database
- Responsive UI
- Auto-refresh statistics
- Flash notifications
- Location-based search
- Clean MVC architecture

---

# 🎯 Use Cases

### Restaurants

Donate leftover food instead of wasting it.

### Hotels

Share surplus meals with nearby NGOs.

### Individuals

Help people by donating extra food.

### NGOs

Locate and claim available food quickly.

### Society

Reduce food waste and fight hunger.

---

# 🛠 Tech Stack

## Backend

| Technology | Purpose |
|------------|---------|
| Java 17 | Programming Language |
| Spring Boot | Backend Framework |
| Spring Data JPA | Database ORM |
| Maven | Dependency Management |
| H2 Database | Database |

---

## Frontend

| Technology | Purpose |
|------------|---------|
| HTML5 | Structure |
| CSS3 | Styling |
| JavaScript | Interactivity |
| Thymeleaf | Server-side Rendering |

---

## Development Tools

- VS Code
- Git
- GitHub
- Postman

---

# 🚀 Installation

## Clone Repository

```bash
git clone https://github.com/krishnapopat130324-art/food-donation-platform.git
cd food-donation-platform
```

---

## Build Project

```bash
mvn clean install
```

---

## Run Application

```bash
mvn spring-boot:run
```

---

## Open Browser

```
http://localhost:8080
```

---

# 📌 API Documentation

## Base URL

```
http://localhost:8080/api
```

---

## Endpoints

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | /donations | Create Donation |
| GET | /donations | Get All Donations |
| GET | /donations/{id} | Get Donation by ID |
| GET | /donations/available | Available Donations |
| GET | /donations/location/{location} | Search by Location |
| PUT | /donations/{id}/claim | Claim Donation |
| PUT | /donations/{id}/status | Update Status |
| DELETE | /donations/{id} | Delete Donation |
| GET | /donations/stats | Donation Statistics |

---

# 📤 Example Request

```http
POST /api/donations
Content-Type: application/json
```

```json
{
  "foodType": "Rice & Vegetables",
  "quantity": 50,
  "location": "Mumbai",
  "donorName": "Hotel Taj",
  "donorPhone": "+91-9876543210",
  "description": "Fresh vegetarian meals",
  "expiryDate": "2026-07-20"
}
```

---

# 📥 Example Response

```json
{
  "id": 1,
  "foodType": "Rice & Vegetables",
  "quantity": 50,
  "location": "Mumbai",
  "donorName": "Hotel Taj",
  "status": "AVAILABLE"
}
```

---

# 🧪 Testing with cURL

## Create Donation

```bash
curl -X POST http://localhost:8080/api/donations \
-H "Content-Type: application/json" \
-d '{
"foodType":"Rice",
"quantity":50,
"location":"Mumbai",
"donorName":"Hotel Taj",
"expiryDate":"2026-07-20"
}'
```

---

## Get All Donations

```bash
curl http://localhost:8080/api/donations
```

---

## Get Available Donations

```bash
curl http://localhost:8080/api/donations/available
```

---

## Claim Donation

```bash
curl -X PUT http://localhost:8080/api/donations/1/claim
```

---

## Get Statistics

```bash
curl http://localhost:8080/api/donations/stats
```

---

# 📁 Project Structure

```text
food-donation-platform/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── fooddonation/
│   │   │           ├── controller/
│   │   │           ├── entity/
│   │   │           ├── repository/
│   │   │           ├── service/
│   │   │           └── FoodDonationApplication.java
│   │
│   ├── resources/
│   │   ├── templates/
│   │   ├── static/
│   │   └── application.properties
│
├── pom.xml
├── README.md
└── LICENSE
```

---

# 🗄 Database

## H2 Console

```
http://localhost:8080/h2-console
```

### Configuration

```
JDBC URL : jdbc:h2:mem:fooddb

Username : sa

Password : (leave empty)
```

---

# 📸 Screenshots

Replace these placeholders with actual screenshots.

| Dashboard | Donation Form |
|------------|---------------|
| dashboard.png | donation-form.png |

| API Testing | Statistics |
|-------------|------------|
| postman.png | stats.png |

---

# 🚀 Future Enhancements

- User Authentication
- Role-Based Access
- Google Maps Integration
- Email Notifications
- SMS Alerts
- Image Upload Support
- Cloud Database Support
- Admin Dashboard
- Mobile Application
- Docker Deployment

---

# 🤝 Contributing

Contributions are always welcome.

1. Fork the repository

2. Create your feature branch

```bash
git checkout -b feature/amazing-feature
```

3. Commit your changes

```bash
git commit -m "Add amazing feature"
```

4. Push to GitHub

```bash
git push origin feature/amazing-feature
```

5. Open a Pull Request

---



# 📞 Author

**Krishna Popat**

---

# ⭐ Support

If you found this project useful,

please consider giving it a **⭐ Star** on GitHub.

Your support motivates future development and improvements.

---

<div align="center">

### 🍽️ Reducing Food Waste • Feeding Communities • Building a Better Tomorrow

**Made with ❤️ using Java & Spring Boot**

</div>
