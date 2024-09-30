package ui;

import org.testng.annotations.Test;
import page.CreateProjectPage;
import page.LoginPage;
import page.MainPage;
import utils.PropertyReader;
import java.util.UUID;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ProjectManagementTest extends BaseUiTest {
    public LoginPage loginPage = new LoginPage();
    public MainPage mainPage = new MainPage();
    public CreateProjectPage createProjectPage = new CreateProjectPage();
    String login = PropertyReader.LOGIN.get();
    String password = PropertyReader.PASSWORD.get();

    private String projectName;
    private String projectId;

    @Test
    public void createNewProjectTest() {
        // Логинимся
        projectName = "TestProject_" + UUID.randomUUID().toString().replace("-", "_");
        projectId = "TestProjectId_" + UUID.randomUUID().toString().replace("-", "_");

        loginPage.getLoginInput().shouldBe(visible).setValue(login);
        loginPage.getPasswordInput().shouldBe(visible).setValue(password);
        loginPage.getLoginButton().shouldBe(visible, enabled).click();

        mainPage.getCreateProjectHeaderButton().shouldBe(visible,enabled).click();
        createProjectPage.getCreateProjectManually().shouldBe(visible).click();

        $("#name").sendKeys(projectName);
        $("#externalId").sendKeys(projectId);
        $("#description").sendKeys("Project for automated testing");
        $("#createProject").click();

        $("#message_projectCreated").shouldHave(text(projectName));
    }
    @Test(dependsOnMethods = "createNewProjectTest")
    public void addBuildStepsAndTriggersTest() {

        $("#main-content-tag > div.editProjectPage > div.section.smallMargin > div:nth-child(5) > a").click();
        $("#parentProjectIdSelect > div > button > span > span > span.MiddleEllipsis__middleEllipsis--Ei.ProjectBuildTypeSelect__name--mp > span.MiddleEllipsis__searchable--uZ").shouldHave(text(projectName));

        $("#buildTypeName").setValue("buildName");
        $("#description").setValue("test");
        $("#createBuildTypeForm > div.saveButtonsBlock > input.btn.btn_primary.submitButton").click();

        $("#unprocessed_buildTypeCreated").shouldBe(visible).shouldHave(text("Build configuration successfully created. You can now configure VCS roots."));

        $("#vcsRootPropertiesInner > div:nth-child(6) > div > a").click();

        $("#runType_Tab > p > a").click();
        $("#buildStepsContainerInner > div > a").click();

        $("#select-runner-flatten > form > div.SelectBuildRunners__container--Lf > div > table > tbody > tr:nth-child(17) > td.SelectBuildRunners__title--Vf").click();
        $x("//*[contains(text(),'Maven')]").shouldBe(visible).click();
        $("#runnerParams > table > tbody:nth-child(3) > tr:nth-child(2) > td > span > button").shouldBe(visible).click();
        $("#ufd-container > div:nth-child(8) > div > div > ul > li:nth-child(3)").shouldBe(visible).click();
        $("#teamcity\\.coverage\\.idea\\.includePatterns").shouldBe(visible).setValue("org.apache.*");
        $("#saveButtons > input.btn.btn_primary.submitButton").shouldBe(visible).click();
        $("#unprocessed_buildRunnerSettingsUpdated").shouldHave(text("Build step settings updated."));

        $("#buildTriggers_Tab > p > a").click();
        $("#uiMode > div > div:nth-child(3) > a").click();
        $("#uiModeDialog > table > tbody > tr > td > span > button").click();
        $("#ufd-container > div:nth-child(2) > div > div > ul > li:nth-child(3)").click();
        $("#editTriggerSubmit").click();
        $("#unprocessed_buildTriggersUpdated").shouldHave(text("Triggers updated"));

        $("#buildTriggersTable > tbody > tr:nth-child(2) > td:nth-child(1) > div > div").shouldHave(text("VCS Trigger"));
    }
}