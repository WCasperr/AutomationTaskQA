package api;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.UUID;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ProjectManagementTest extends BaseApiTest {
    private String projectName;
    private String projectId;

    @Test
    public void createProjectTest() {
        projectName = "TestProject_" + UUID.randomUUID().toString().replace("-", "_");
        projectId = "TestProjectId_" + UUID.randomUUID().toString().replace("-", "_");

        String body = String.format(
                "<newProjectDescription name=\"%s\" id=\"%s\" />",
                projectName, projectId
        );

        given()
                .contentType("application/xml")
                .body(body)
                .when()
                .post("/app/rest/projects")
                .then()
                .statusCode(200)
                .body("name", equalTo(projectName));

        Response response = get("/app/rest/projects/id:" + projectId);
        response.then()
                .statusCode(200)
                .body("id", equalTo(projectId));
    }

    @Test(dependsOnMethods = "createProjectTest")
    public void deleteProjectTest() {

        delete("/app/rest/projects/id:" + projectId)
                .then()
                .statusCode(204);

        get("/app/rest/projects/id:" + projectId)
                .then()
                .statusCode(404);
    }
}