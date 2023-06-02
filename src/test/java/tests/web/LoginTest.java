package tests.web;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.BLOCKER;

@Story("Autotests for UI")
@Tags({@Tag("web")})
public class LoginTest extends TestBase {

    @Owner("a.baranov")
    @Severity(BLOCKER)
    @DisplayName("Authorization user")
    @Test
    void successfulAuthorization() {
        step("Open form Steam", () -> {
            steamPoweredPage.openPage();
        });

        step("Click login Button", () -> {
            steamPoweredPage.clickLoginBtn();
        });

        step("Fill in the login field", () -> {
            steamPoweredPage.setInputLogin();
        });

        step("Fill in the password field", () -> {
            steamPoweredPage.setInputPassword();
        });

        step("Click login submit button", () -> {
            steamPoweredPage.clickSubmitButton();
        });
    }

    @Owner("a.baranov")
    @Severity(BLOCKER)
    @DisplayName("Unsuccessful Login")
    @Test
    void unsuccessfulLogin() {
        step("Open form Steam", () -> {
            steamPoweredPage.openPage();
        });

        step("Click login Button", () -> {
            steamPoweredPage.clickLoginBtn();
        });

        step("Fill in the login field", () -> {
            steamPoweredPage.setInputLogin();
        });

        step("Fill in the wrong password field", () -> {
            steamPoweredPage.setInputWrongPassword();
        });

        step("Click login submit button", () -> {
            steamPoweredPage.clickSubmitButton();
        });

        step("Verify text error", () -> {
            steamPoweredPage.verifyLoginUnsuccessful("Please check your password and account name and try again.");
        });
    }
}
