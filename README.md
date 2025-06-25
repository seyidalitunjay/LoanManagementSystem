[LoanMS_Environment.json](https://github.com/user-attachments/files/20898645/LoanMS_Environment.json)[LoanMS_Environment.json](https://github.com/user-attachments/files/20898630/LoanMS_Environment.json)[LoanMS_Postman_Collection.json](https://github.com/user-attachments/files/20898627/LoanMS_Postman_Collection.json)# Loan Management System

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


## 📬 Postman Integration Testing

> Make sure your server is running at `http://localhost:8080`

- 👉 [Download Postman Collection]

[Uploading Lo{
	"info": {
		"_postman_id": "d9045a37-03c3-470e-9910-e950c4b2f40a",
		"name": "Loan Management Integration Tests",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json",
		"_exporter_id": "45868998"
	},
	"item": [
		{
			"name": "Create a new loan",
			"request": {
				"method": "GET",
				"header": []
			},
			"response": []
		},
		{
			"name": "Get all loans",
			"request": {
				"method": "GET",
				"header": []
			},
			"response": []
		},
		{
			"name": "Get loan by ID",
			"request": {
				"method": "GET",
				"header": []
			},
			"response": []
		},
		{
			"name": "Update loan status",
			"request": {
				"method": "GET",
				"header": []
			},
			"response": []
		}
	]
}anMS_Postman_Collection.json…]()


- 🌍 [Download Postman Environment]

  
[Uploading Lo{
	"id": "70745108-69b1-4fad-a938-b08f32b133b5",
	"name": "LoanMS Local",
	"values": [
		{
			"key": "loanId",
			"value": "",
			"type": "any",
			"enabled": true
		}
	],
	"_postman_variable_scope": "environment",
	"_postman_exported_at": "2025-06-25T07:25:07.578Z",
	"_postman_exported_using": "Postman/11.51.3"
}anMS_Environment.json…]()



**Developed by @seyidalitunjay**


For any inquiries: seyidalitunjay@gmail.com


