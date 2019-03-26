package org.ibra.quickstart;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.h2.H2DatabaseTestResource;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@QuarkusTestResource(H2DatabaseTestResource.class)
public class TaskResourceTest {

    @Test
    public void testInsert() {
        
        given().post("/task").then().statusCode(200);
        given().post("/task").then().statusCode(200);
        given().post("/task").then().statusCode(200);
    }
}
