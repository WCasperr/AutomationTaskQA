package ui;

import org.testng.annotations.Test;
import page.LoginPage;
import page.MainPage;
import utils.PropertyReader;

import static com.codeborne.selenide.Condition.*;

public class LoginPageTest extends BaseUiTest {

    public LoginPage loginPage = new LoginPage();
    public MainPage mainPage = new MainPage();
    String login = PropertyReader.LOGIN.get();
    String password = PropertyReader.PASSWORD.get();

    @Test(description = "Check login using valid credentials")
    public void loginTest() {
        loginPage.getLoginInput().shouldBe(visible).setValue(login);
        loginPage.getPasswordInput().shouldBe(visible).setValue(password);
        loginPage.getLoginButton().shouldBe(visible, enabled).click();
        mainPage.getAdministrationButton().shouldBe(visible).shouldHave(text("Administration"));
    }

    @Test(description = "Check when user enter invalid credentials")
    public void failedLoginTest(){
        loginPage.getLoginInput().shouldBe(visible).setValue(login+"1");
        loginPage.getPasswordInput().shouldBe(visible).setValue(password+"1");
        loginPage.getLoginButton().shouldBe(visible, enabled).click();
        loginPage.getErrorMessage().shouldBe(visible).shouldHave(text("Incorrect username or password."));
    }

}