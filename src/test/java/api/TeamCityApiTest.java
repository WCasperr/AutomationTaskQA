package api;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.when;

public class TeamCityApiTest extends BaseApiTest {

    @Test(description = "check getting all projects")
    public void checkGettingProjects(){
        when().get("/favorite/projects")
                .then()
                .statusCode(200);
    }
}