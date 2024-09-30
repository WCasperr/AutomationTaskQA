package ui;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import static com.codeborne.selenide.Selenide.*;

public abstract class BaseUiTest {

    @BeforeClass
    public void setUp() {
        Configuration.browser = "chrome";

        Configuration.baseUrl = "http://localhost:8111";

        open("/login.html");
    }
}