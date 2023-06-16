package tests.web;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.CRITICAL;

@Owner("a.baranov")
@Severity(CRITICAL)
@Story("Autotests for UI")
@Tags({@Tag("web")})
public class BasketTest extends TestBase {

    @DisplayName("Add prime status game in basket")
    @Test
    void addPrimeStatusGameInBasket() {
        step("Open form Steam", () -> {
            mainPage.openPage();
        });

        step("Hover your mouse over the section new and interesting", () -> {
            mainPage.changeNewAndInteresting();
        });

        step("Click tab most played", () -> {
            mainPage.clickTabMostPlayed();
        });

        step("Click game in list", () -> {
            chartsGamePage.clickGameInList();
        });

        step("Click add basket button", () -> {
            gameDetailPage.clickAddBasketBtn();
        });

        step("Verify in basket prime status", () -> {
            cartPage.verifyBasketPrimeStatus("Prime Status Upgrade");
        });
    }
}