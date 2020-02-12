package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ExampleResourceTest {



    @Test
    public void testHelloEndpoint() {

        try {

            given()
                    .when().post("/transaction-test")
                    .then()
                    .statusCode(200);

            MyEntity entity = (MyEntity) MyEntity.findAll().list().get(0);

            MatcherAssert.assertThat(entity.id, CoreMatchers.notNullValue());
            MatcherAssert.assertThat(entity.name, CoreMatchers.equalTo("Name"));
            MatcherAssert.assertThat(entity.startingTime, CoreMatchers.notNullValue());

            MatcherAssert.assertThat(entity.endingTime, CoreMatchers.notNullValue()); // In this point the value is present.


        } catch (Exception e) {
            e.printStackTrace();
            Assertions.fail(e.getMessage());
        }



    }

}