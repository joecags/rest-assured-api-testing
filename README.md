# 🧪 REST Assured API Testing

A practical project demonstrating **API testing with Rest Assured** and **Spring Boot**, built as part of my software testing and Java learning journey.  
This project includes a working `bugs-api` service for managing and testing mock bug reports using various HTTP methods (`GET`, `POST`, `PUT`, `PATCH`, `DELETE`).

---

## 📁 Project Structure

rest-assured-api-testing/
├── bugs-api/ # Spring Boot application
│ ├── src/main/java/org/loonycorn/bugs_api/
│ │ ├── BugsApiApplication.java
│ │ ├── controller/ # Contains REST controllers (BugController, PingController)
│ │ └── model/ # Contains POJO models (Bug.java)
│ └── src/test/java/org/loonycorn/bugs_api/
│ └── BugsApiApplicationTests.java
│ └── RestAssuredTests.java
├── .gitignore
├── LICENSE
└── README.md

---

## 🧠 Tech Stack

- **Java 21**
- **Spring Boot 3.5**
- **Maven**
- **Rest Assured**
- **TestNG**
- **Hamcrest Matchers**

---

## ⚙️ Running the Project

1. **Clone the repository**

   git clone https://github.com/joecags/rest-assured-api-testing.git
   cd rest-assured-api-testing/bugs-api

2. **Run the Spring Boot app**

   mvn spring-boot:run

3. **The API will start on:**

   http://localhost:8090/

## 🚀 API Endpoints

### Ping Endpoint

***_Verify service health_***

curl -X GET http://localhost:8090/ping

**_Response:_**
OK

### Create a New Bug (POST)

curl -X POST -H "Content-Type: application/json" \
-d '{"title":"Login fails","severity":"High"}' \
http://localhost:8090/bugs

### Get All Bugs (GET)

curl -X GET http://localhost:8090/bugs

### Update a Bug (PUT)

curl -X PUT http://localhost:8090/bugs/{bugId} \
-H "Content-Type: application/json" \
-d '{"createdBy":"John Doe"}'

### Partial Update (PATCH)

curl -X PATCH http://localhost:8090/bugs/{bugId} \
-H "Content-Type: application/json" \
-d '{"title":"UI overlap fixed","severity":"Low"}'

### Delete a Bug (DELETE)

curl -X DELETE http://localhost:8090/bugs/{bugId}

🧩 Example Test (RestAssuredTests.java)
@Test
void ping_returns_ok() {
given()
.port(port)
.when()
.get("/ping")
.then()
.statusCode(200)
.body(equalTo("OK"));
}

💡 Key Learning Areas

- Designing RESTful endpoints with Spring Boot
- Validating API responses with Rest Assured
- Writing TestNG test cases
- Using Hamcrest matchers for assertions
- Managing JSON payloads and response validation
- End-to-end CRUD API testing workflow

🧰 VS Code Setup (Optional)
If you want to open and run this project in VS Code:

1. Install the following extensions:
   📦 Extension Pack for Java (Microsoft)
   🧪 TestNG Runner or JUnit Support
   ☕ Maven for Java
2. Open the project folder (bugs-api)
3. Use the integrated terminal to build and run:
   ./mvnw spring-boot:run
4. To run tests:
   ./mvnw test

🪪 License
This project is licensed under the MIT License
. See the LICENSE file for details.

👨‍💻 Author
Joseph Cagney
GitHub: joecags

Part of my ongoing journey in backend development and API testing.
