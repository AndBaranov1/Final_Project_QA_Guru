package tests.api;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import help.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static config.WebDriverProvider.config;

public class TestBase {
    @BeforeAll
    static void setUp() {
        config();
        RestAssured.baseURI = "https://allure.autotests.cloud";
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last step screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        if (config.isRemote()) {
            Attach.addVideo();
        }
        Selenide.closeWebDriver();
    }
}
