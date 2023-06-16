package tests.web;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.NORMAL;

@Owner("a.baranov")
@Severity(NORMAL)
@Story("Autotests for UI")
@Tags({@Tag("web")})
public class GameDetailTest extends TestBase {

    @DisplayName("Search and selection of the game Dota 2")
    @Test
    void searchAndDetailGameDota2() {
        step("Open form Steam", () -> {
            mainPage.openPage();
        });

        step("Click search field", () -> {
            mainPage.clickFieldSearch();
        });

        step("Enter in search Dota 2", () -> {
            mainPage.setInputSearch("Dota 2");
        });

        step("Click search button", () -> {
            mainPage.clickSearchButton();
        });

        step("Select game Dota 2 from list page", () -> {
            listGamePage.selectGameDota2();
        });

        step("Verify name game Dota 2", () -> {
            gameDetailPage.verifyNameGameDota2("Dota 2");
        });
    }
}