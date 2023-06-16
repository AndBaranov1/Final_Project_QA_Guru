package tests.web;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import help.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.CartPage;
import pages.ChartsGamePage;
import pages.DigitalGiftCardsPage;
import pages.GameDetailPage;
import pages.ListGamePage;
import pages.LoginPage;
import pages.MainPage;
import pages.PointsShopPage;
import pages.SelectGiftCardPage;

import java.util.HashMap;

public class TestBase {

    MainPage mainPage = new MainPage();
    ChartsGamePage chartsGamePage = new ChartsGamePage();
    CartPage cartPage = new CartPage();
    ListGamePage listGamePage = new ListGamePage();
    LoginPage loginPage = new LoginPage();
    DigitalGiftCardsPage digitalGiftCardsPage = new DigitalGiftCardsPage();
    SelectGiftCardPage selectGiftCardPage = new SelectGiftCardPage();
    PointsShopPage pointsShopPage = new PointsShopPage();
    GameDetailPage gameDetailPage = new GameDetailPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://store.steampowered.com";
        Configuration.browser =  System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("browser_version", "100.0");
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.remote = "https://user1:1234@" + System.getProperty("selenoid_url","selenoid.autotests.cloud/wd/hub");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", new HashMap<String, Object>() {{
            put("enableVNC", true);
            put("enableVideo", true);
        }});

    Configuration.browserCapabilities = capabilities;
}
    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterAll
    static void addAttachments () {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        Selenide.closeWebDriver();
    }
}