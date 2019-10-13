package me.rogal.fibonacci;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationIntegrationAPITest {

    @Value("http://localhost:${local.server.port}/api/calculate")
    private String rootUrl;

    @Test
    public void testCalculate() {
        String param = rootUrl + "/10";

        given()
                .auth().basic("admin", "s3cr3t").
        when().
            get(param).
        then()
            .assertThat()
            .statusCode(HttpStatus.OK.value())
                .and()
                .body("size()", CoreMatchers.is(10))
                .body("[0]", equalTo(1))
                .header("Content-Type", MediaType.APPLICATION_JSON_VALUE);
    }

}
