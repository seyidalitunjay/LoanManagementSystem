# Loan Management System

A backend service for banks or financial institutions to manage loan applications digitally. 
This system automatically tracks loan statuses and expires applications that aren't processed within 7 days.

## What This Project Does

A bank that receives hundreds of loan applications daily. This system:

- Lets customers submit applications online
- Allows loan officers to review and approve/reject applications
- Automatically marks stale applications as "Expired"
- Provides real-time status updates through an API
- Logs all actions for security and auditing

## 📌 How It Helps

✔ **For Banks**: Reduces manual work and paperwork  
✔ **For Customers**: Instant application tracking  
✔ **For Developers**: Easy-to-use API with clear documentation  

## 🚀 Quick Start  
```bash
git clone https://github.com/seyidalitunjay/LoanManagementSystem.git
cd LoanManagementSystem
./mvnw spring-boot:run
```

## 🛠️ Tech Stack

**Core Framework**  
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.1-green) 
![REST API](https://img.shields.io/badge/REST_API-✓-blue)

**Language & Tools**  
![Java](https://img.shields.io/badge/Java-17-blue) 
![Lombok](https://img.shields.io/badge/Lombok-✓-pink) 
![Maven](https://img.shields.io/badge/Maven-✓-orange)

**Database**  
![H2](https://img.shields.io/badge/H2_Database-✓-yellow) 
![Spring Data JPA](https://img.shields.io/badge/Spring_Data_JPA-✓-lightgrey)

**Testing**  
![JUnit5](https://img.shields.io/badge/JUnit5-✓-green) 
![Mockito](https://img.shields.io/badge/Mockito-✓-red)

**Monitoring & Logging**  
![SLF4J](https://img.shields.io/badge/SLF4J_Logging-✓-blueviolet) 
![Interceptors](https://img.shields.io/badge/HTTP_Interceptors-✓-ff69b4)

**Features**  
✔ Automated Scheduling  
✔ Exception Handling  
✔ Postman Tested  

## 📚 API Documentation  
| Endpoint          | Method | Description              |
|-------------------|--------|--------------------------|
| `/api/loans`      | POST   | Create new loan          |
| `/api/loans/{id}` | GET    | Get loan by ID           |


POSTMAN TEST CASES:


<img width="1025" alt="Screenshot 2025-06-23 at 11 05 57" src="https://github.com/user-attachments/assets/5f3a3715-87b6-4696-b2f9-4f647d9666c0" />

<img width="1025" alt="Screenshot 2025-06-23 at 11 06 49" src="https://github.com/user-attachments/assets/5209d7f0-2c62-46a4-8d52-93d5ac324adb" />

<img width="1025" alt="Screenshot 2025-06-23 at 11 07 08" src="https://github.com/user-attachments/assets/2baa83a1-2f86-444e-b815-30be9b3d1ab0" />

<img width="1025" alt="Screenshot 2025-06-23 at 11 21 27" src="https://github.com/user-attachments/assets/38c274dc-a41c-4d94-94b9-3089d99d1e2f" />

**Developed by @seyidalitunjay**
For any inquiries: seyidalitunjay@gmail.com


