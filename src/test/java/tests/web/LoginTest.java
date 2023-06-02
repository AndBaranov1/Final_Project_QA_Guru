package tests.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Tags({@Tag("web")})
public class LoginTest extends TestBase {

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
            steamPoweredPage.setInputLogin("Autotester_qa_demo");
        });

        step("Fill in the password field", () -> {
            steamPoweredPage.setInputPassword("Db)cE*FUD3Dw98L");
        });

        step("Click login submit button", () -> {
            steamPoweredPage.clickSubmitButton();
        });
    }

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
            steamPoweredPage.setInputLogin("Autotester_qa_demo");
        });

        step("Fill in the password field", () -> {
            steamPoweredPage.setInputPassword("tests");
        });

        step("Click login submit button", () -> {
            steamPoweredPage.clickSubmitButton();
        });

        step("Verify text error", () -> {
            steamPoweredPage.verifyLoginUnsuccessful("Please check your password and account name and try again.");
        });
    }
}
