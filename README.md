Vehicle Management API
A Spring Boot application to manage vehicle data with RESTful APIs for CRUD operations.
Prerequisites

Java 17 or later
Maven
h2 in memory database

Setup

Clone the Repository:
git clone <repository-url>
cd vehicle-management


Configure the Database:


Build the Project:
mvn clean install



Running the Application

Run the Spring Boot application:
mvn spring-boot:run

Alternatively, run the main class VehicleApplication from your IDE.

The application will start on http://localhost:8080 or 8082 if 8080 running

Testing the APIs
Use the following cURL commands to test the APIs. The base URL is http://localhost:8080/v1/api/vehicles.
1. Create a Vehicle (POST)
curl -X POST http://localhost:8080/api/vehicles \
-H "Content-Type: application/json" \
-d '{
    "plateNumber": "ABC123",
    "model": "Civic EX",
    "manufacturer": "Honda",
    "year": 2021,
    "ownerName": "Ahmed Basheer"
}'

2. Get All Vehicles (GET)
curl -X GET http://localhost:8080/api/v1/vehicles

3. Get a Vehicle by ID (GET)
curl -X GET http://localhost:8080/api/v1/vehicles/1

4. Delete a Vehicle (DELETE)
curl -X DELETE http://localhost:8080/api/v1/vehicles/1

Swagger UI

Access Swagger UI at http://localhost:8080/swagger-ui.html.

Notes

Ensure making test using postman, browser fail in some cases.



