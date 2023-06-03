package tests.web;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.CRITICAL;

@Owner("a.baranov")
@Story("Autotests for UI")
public class SearchResultsTest extends TestBase{

    @CsvSource(value  = {
            "Tekken, TEKKEN 8",
            "Need for Speed, Need for Speed™ Unbound"
    })
    @Severity(CRITICAL)
    @ParameterizedTest(name = "When you search for a {0} game, you will see {1}")
    @DisplayName("Game Search:")
    @Tags({
            @Tag("BLOCKER"),
            @Tag("web")
    })
    void mainPageSearchGame(String testData, String expectedResult) {
        step("Open form Steam", () -> {
            steamPoweredPage.openPage();
        });

        step("Click search field", () -> {
            steamPoweredPage.clickFieldSearch();
        });

        step("Enter in search name Game", () -> {
            steamPoweredPage.setInputSearch(testData);
        });

        step("Click search button", () -> {
            steamPoweredPage.clickSearchButton();
        });

        step("Verify name result search", () -> {
            steamPoweredPage.verifyResultSearch(expectedResult);
        });
    }
}