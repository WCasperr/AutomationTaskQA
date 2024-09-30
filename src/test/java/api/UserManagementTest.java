package api;

import org.testng.annotations.Test;
import utils.PropertyReader;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class UserManagementTest extends BaseApiTest{

    private final String username = "user_" + System.currentTimeMillis();
    private final String password = "password123";
    private final String email = "email@fake.com";
    String adminUsername = PropertyReader.LOGIN.get();
    String adminPassword = PropertyReader.PASSWORD.get();

    @Test
    public void createUserTest() {

        String body = String.format(
                "{\"username\":\"%s\", \"password\":\"%s\", \"roles\": {\"role\": [{\"roleId\": \"PROJECT_ADMIN\", \"scope\": \"g\"}]}}",
                username, password
        );

        given()
                .auth().basic(adminUsername, adminPassword)
                .contentType("application/json")
                .body(body)
                .when()
                .post("/app/rest/users")
                .then()
                .statusCode(200)
                .body("username", equalTo(username));
    }

    @Test(dependsOnMethods = "createUserTest")
    public void updateUserTest() {
        // Формируем тело запроса для обновления пользователя
        String body = String.format(
                "{\"username\":\"%s\", \"password\":\"%s\", \"email\":\"%s\", \"roles\": {\"role\": [{\"roleId\": \"PROJECT_ADMIN\", \"scope\": \"g\"}]}}",
                username, password, email
        );

        given()
                .auth().basic(adminUsername, adminPassword)
                .contentType("application/json")
                .body(body)
                .when()
                .put("/app/rest/users/username:" + username)
                .then()
                .statusCode(200)
                .body("email", equalTo(email));
    }
    @Test(dependsOnMethods = {"createUserTest", "updateUserTest"})
    public void deleteUserTest() {

        given()
                .auth().basic(adminUsername, adminPassword)
                .when()
                .delete("/app/rest/users/username:" + username)
                .then()
                .statusCode(204);

        get("/app/rest/users/username:" + username)
                .then()
                .statusCode(404);
    }
}
