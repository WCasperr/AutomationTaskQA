package page;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class LoginPage {
    private final SelenideElement loginInput = $("#username");
    private final SelenideElement passwordInput = $("#password");
    private final SelenideElement loginButton = $("#loginForm > form > div.buttons > input");
    private final SelenideElement rememberMeButton = $("#remember");
    private final SelenideElement resetPasswordButton = $("#resetPasswordContainer > a");
    private final SelenideElement errorMessage = $("#errorMessage");

}
