package org.ibra.quickstart;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class CountryResourceTest {

    @Test
    public void testJordan() {
        
        given().pathParam("name", "jordan")
               .when()
               .get("/country/{name}")
               .then()
               .statusCode(200)
               .body("$.size()", is(1),
                       "[0].alpha2Code", is("JO"),
                       "[0].capital", is("Amman"),
                       "[0].currencies.size()", is(1),
                       "[0].currencies[0].name", is("Jordanian dinar"));
    }
}
