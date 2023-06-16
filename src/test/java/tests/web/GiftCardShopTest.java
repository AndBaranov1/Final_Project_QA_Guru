package tests.web;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.switchTo;
import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.NORMAL;

@Owner("a.baranov")
@Severity(NORMAL)
@Story("Autotests for UI")
@Tags({@Tag("web")})
public class GiftCardShopTest extends TestBase {

    @DisplayName("List of digital gift cards in Steam")
    @Test
    void steamGiftCards() {
        step("Open form Steam", () -> {
            mainPage.openPage();
        });

        step("Click steam gift cards", () -> {
            mainPage.clickGiftCards();
        });

        step("Switch to another tab in the browser", () -> {
            switchTo().window(1);
        });

        step("Send through steam", () -> {
            digitalGiftCardsPage.sendThroughSteam();
        });

        step("Verify digital gift cards", () -> {
            selectGiftCardPage.verifyListGiftCardsSteam("DIGITAL GIFT CARDS");
        });
    }


    @DisplayName("Open points shop")
    @Test
    void openPointShop() {
        step("Open form Steam", () -> {
            mainPage.openPage();
        });

        step("Open the items section for points", () -> {
            mainPage.openPointShop();
        });

        step("Open list of item sets", () -> {
            pointsShopPage.allItemBundels();
        });

        step("Open item pack", () -> {
            pointsShopPage.getOpenItemBundel();
        });

        step("Open item", () -> {
            pointsShopPage.openBundel();
        });

        step("Check item name AKIHABARA", () -> {
            pointsShopPage.verifyCartBundel("AKIHABARA");
        });
    }
}
