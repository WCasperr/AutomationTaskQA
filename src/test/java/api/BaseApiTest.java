package api;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;

public abstract class BaseApiTest {

    @BeforeTest
    public void setUpApiConfigurations() {
        RestAssured.baseURI = "http://localhost:8111";

        RestAssured.requestSpecification = RestAssured.given()
                .auth().basic("admin", "password")
                .header("Accept", "application/json")
                .contentType("application/json")
                .log().all();
    }
}
