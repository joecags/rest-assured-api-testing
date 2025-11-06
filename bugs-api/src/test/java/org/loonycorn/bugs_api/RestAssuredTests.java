package org.loonycorn.bugs_api;

// import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;




@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RestAssuredTests {

    @LocalServerPort
    int port;

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
}
