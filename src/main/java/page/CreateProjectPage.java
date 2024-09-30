package page;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Getter
public class CreateProjectPage {
    private final SelenideElement createProjectManually = $x("//a[@href='#createManually']");
    private final SelenideElement createProjectFromUrl = $x("//a[@href='#createFromUrl']");
}
