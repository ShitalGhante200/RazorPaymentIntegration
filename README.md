Razorpay Payment Gateway Integration - Spring Boot

📌 Overview

This is a Spring Boot backend project that demonstrates the integration of Razorpay Payment Gateway. The project includes APIs for creating orders, capturing payments, and fetching payment status.

🏗️ Tech Stack

Java 17

Spring Boot 3+

Spring Data JPA

MySQL

Razorpay SDK

🎯 Features

✅ Create an order in Razorpay

✅ Capture payment once a user completes the transaction

✅ Fetch payment status using payment ID

✅ Store order details in the database (MySQL)




⚙️ Project Setup

1️⃣ Clone the Repository
git clone https://github.com/ShitalGhante200/RazorPaymentIntegration.git
cd Razor_Payment_Integration

2️⃣ Configure Database (MySQL)

Update application.properties with your MySQL credentials:

server.port=8081

# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/razor_payment
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=1234
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true


Or Add Razorpay API Credentials

Get your API Key ID and Secret from Razorpay Dashboard and set them in application.properties:

razorpay.key_id=your_api_key
razorpay.key_secret=your_api_secret


4️⃣ Install Dependencies & Run the Application
mvn clean install
mvn spring-boot:run

🔗 API Endpoints

1️⃣ Create Order

Endpoint: POST /payment/createOrder

Request Body:
{
  "amount": 500
}

Response:
{
  "orderId": "order_ABC123",
  "amount": 500,
  "currency": "INR",
  "status": "CREATED"
}

2️⃣ Capture Payment

Endpoint: POST /payment/capture

Request Body:
{
  "paymentId": "pay_XYZ456",
  "orderId": "order_ABC123"
}

Response:
"Payment Captured Successfully!"


3️⃣ Get Payment Status

Endpoint: GET /payment/status/{paymentId}

Response:
{
  "id": "pay_XYZ456",
  "status": "captured",
  "amount": 50000,
  "currency": "INR"
}

🎯 Notes

Payment ID is generated only after a successful transaction.

Use Postman or any API client to test the endpoints.

The project does not include frontend integration.

📜 License

This project is licensed under the MIT License.

🤝 Contributing

Feel free to open a pull request if you'd like to improve this project!
