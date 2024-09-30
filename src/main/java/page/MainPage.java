package page;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Getter
public class MainPage {
    //header
    private final SelenideElement projectsButton = $("#header-portal > div > header > div:nth-child(2) > a.ring-link-link.Links__link--eg.ring-link-active.RouterLink__link--VM.Link__link--ZK");
    private final SelenideElement createProjectHeaderButton = $("#header-portal > div > header > div:nth-child(2) > a.ring-link-link.LinkWithIcon__link--jt.Links__addProject--cL.Link__link--ZK > div > span");
    private final SelenideElement createProjectButton = $("#main-content-tag > div.MainPanel__content--lE > div > div > div > div.UIPlaceholder__infoContainer--xa > div > a.ring-button-button.FavoriteProjectsPage__button--wS.ring-button-heightM.ring-button-primary > span");
    private final SelenideElement changesButton = $("#header-portal > div > header > div:nth-child(3) > a");
    private final SelenideElement agentsButton = $("#header-portal > div > header > div:nth-child(4) > a");
    private final SelenideElement queueButton = $("#header-portal > div > header > div:nth-child(4) > a");
    private final SelenideElement themeButton = $("#userPanel > div:nth-child(2) > div > button > span");
    private final SelenideElement administrationButton = $("#userPanel > div:nth-child(4) > div > a");
    private final SelenideElement helpButton = $("#userPanel > div:nth-child(5) > div > button > span > span > span");
    private final SelenideElement headerSearchButton = $("#SAKURA_HEADER_RIGHT > div > div > span > a > span > svg");
    private final SelenideElement userPanelButton = $("#userPanel > div:nth-child(7) > div > button > span > span > svg > g");
    private final SelenideElement logoutButton = $x("//a[contains(text(),'Logout')]");
}