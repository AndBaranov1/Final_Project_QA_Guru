package tests.web;

import config.AuthorizationConfig;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.BLOCKER;

@Owner("a.baranov")
@Severity(BLOCKER)
@Story("Autotests for UI")
@Tags({@Tag("web")})
public class LoginTest extends TestBase {

    static AuthorizationConfig authorizationConfig = ConfigFactory.create(AuthorizationConfig.class, System.getProperties());

    @DisplayName("Authorization user")
    @Test
    void successfulAuthorization() {
        step("Open form Steam", () -> {
            mainPage.openPage();
        });

        step("Click login Button", () -> {
            loginPage.clickLoginBtn();
        });

        step("Fill in the login field", () -> {
            loginPage.setInputLogin(authorizationConfig.login());
        });

        step("Fill in the password field", () -> {
            loginPage.setInputPassword(authorizationConfig.password());
        });

        step("Click login submit button", () -> {
            loginPage.clickSubmitButton();
        });
    }

    @DisplayName("Unsuccessful Login")
    @Test
    void unsuccessfulLogin() {
        step("Open form Steam", () -> {
            mainPage.openPage();
        });

        step("Click login Button", () -> {
            loginPage.clickLoginBtn();
        });

        step("Fill in the login field", () -> {
            loginPage.setInputLogin(authorizationConfig.login());
        });

        step("Fill in the wrong password field", () -> {
            loginPage.setInputPassword(authorizationConfig.wrongPassword());
        });

        step("Click login submit button", () -> {
            loginPage.clickSubmitButton();
        });

        step("Verify text error", () -> {
            loginPage.verifyLoginUnsuccessful("Please check your password and account name and try again.");
        });
    }
}