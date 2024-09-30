package ui;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import page.LoginPage;
import page.MainPage;
import utils.PropertyReader;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class LogoutPageTest extends BaseUiTest {
    String login = PropertyReader.LOGIN.get();
    String password = PropertyReader.PASSWORD.get();
    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();

    @Test
    public void LogoutFromTeamCity() {
        loginPage.getLoginInput().shouldBe(visible).setValue(login);
        loginPage.getPasswordInput().shouldBe(visible).setValue(password);
        loginPage.getLoginButton().shouldBe(visible, enabled).click();
        mainPage.getAdministrationButton().shouldBe(visible).shouldHave(text("Administration"));
        mainPage.getUserPanelButton().shouldBe(visible).click();
        mainPage.getLogoutButton().shouldBe(visible).click();
        $("#header").shouldHave(text("Log in to TeamCity"));
    }
}