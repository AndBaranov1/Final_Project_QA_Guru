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
import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.MINOR;
import static io.qameta.allure.SeverityLevel.NORMAL;

@Story("Autotests for UI")
@Tags({@Tag("web")})
public class SteamPoweredWebTest extends TestBase {

    @Owner("a.baranov")
    @Severity(CRITICAL)
    @DisplayName("Add prime status game in basket")
    @Test
    void addPrimeStatusGameInBasket() {
        step("Open form Steam", () -> {
            steamPoweredPage.openPage();
        });

        step("Hover your mouse over the section new and interesting", () -> {
            steamPoweredPage.changeNewAndInteresting();
        });

        step("Click tab most played", () -> {
            steamPoweredPage.clickTabMostPlayed();
        });

        step("Click game in list", () -> {
            steamPoweredPage.clickGameInList();
        });

        step("Click add basket button", () -> {
            steamPoweredPage.clickAddBasketBtn();
        });

        step("Verify in basket prime status", () -> {
            steamPoweredPage.verifyBasketPrimeStatus("Prime Status Upgrade");
        });
    }

    @Owner("a.baranov")
    @Severity(NORMAL)
    @DisplayName("Search and selection of the game Dota 2")
    @Test
    void searchGameDota2() {
        step("Open form Steam", () -> {
            steamPoweredPage.openPage();
        });

        step("Click search field", () -> {
            steamPoweredPage.clickFieldSearch();
        });

        step("Enter in search Dota 2", () -> {
            steamPoweredPage.setInputSearch("Dota 2");
        });

        step("Click search button", () -> {
            steamPoweredPage.clickSearchButton();
        });

        step("Select game Dota 2 from list page", () -> {
            steamPoweredPage.selectGameDota2();
        });

        step("Verify name game Dota 2", () -> {
            steamPoweredPage.verifyNameGameDota2("Dota 2");
        });
    }

    @Owner("a.baranov")
    @Severity(MINOR)
    @DisplayName("List of digital gift cards in Steam")
    @Test
    void steamGiftCards() {
        step("Open form Steam", () -> {
            steamPoweredPage.openPage();
        });

        step("Click steam gift cards", () -> {
            steamPoweredPage.clickGiftCards();
        });

        step("Switch to another tab in the browser", () -> {
            switchTo().window(1);
        });

        step("Send through steam", () -> {
            steamPoweredPage.sendThroughSteam();
        });

        step("Verify digital gift cards", () -> {
            steamPoweredPage.verifyListGiftCardsSteam("DIGITAL GIFT CARDS");
        });
    }

    @Owner("a.baranov")
    @Severity(NORMAL)
    @DisplayName("Open points shop")
    @Test
    void openPointShop() {
        step("Open form Steam", () -> {
            steamPoweredPage.openPage();
        });

        step("Open the items section for points", () -> {
            steamPoweredPage.openPointShop();
        });

        step("Open list of item sets", () -> {
            steamPoweredPage.allItemBundels();
        });

        step("Open item pack", () -> {
            steamPoweredPage.getOpenItemBundel();
        });

        step("Open item", () -> {
            steamPoweredPage.openBundel();
        });

        step("Check item name AKIHABARA", () -> {
            steamPoweredPage.verifyCartBundel("AKIHABARA");
        });
    }
}