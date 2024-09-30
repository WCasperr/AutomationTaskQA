package ui;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utils.PropertyReader;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class LogoutPageTest extends BaseUiTest {
    String login = PropertyReader.LOGIN.get();
    String password = PropertyReader.PASSWORD.get();

    @Test
    public void LogoutFromTeamCity() {
        $("#username").setValue(login);
        $("#password").setValue(password);
        $("#loginForm > form > div.buttons > input").click();
        $("#userPanel > div:nth-child(4) > div > a").shouldHave(text("Administration"));
        $("#userPanel > div:nth-child(7) > div > button > span > span > svg > g").click();
        $(By.xpath("//a[contains(text(),'Logout')]")).click();
        $("#header").shouldHave(text("Log in to TeamCity"));
    }
}