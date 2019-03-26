package org.ibra.quickstart;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.UUID;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(equalTo("Hello Ibrahim!!!"));
    }

    @Test
    public void testGreetingEndpoint() {
    	
    	String uuid = UUID.randomUUID().toString();
    	
        given()
          .pathParam("name", uuid)
          .when().get("/hello/greet/{name}")
          .then()
             .statusCode(200)
             .body(equalTo("Hello ".concat(uuid)));
    }
}