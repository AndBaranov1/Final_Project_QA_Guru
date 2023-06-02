package tests.web;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static io.qameta.allure.Allure.step;

public class SearchResultsTest extends TestBase{


    @CsvSource(value  = {
            "Tekken, TEKKEN 8",
            "Need for Speed, Need for Speed™ Unbound"
    })
    @ParameterizedTest(name = "When searching on the site {0} text will be displayed {1}")
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

        step("Enter in search Dota 2", () -> {
            steamPoweredPage.setInputSearch(testData);
        });

        step("Click search button", () -> {
            steamPoweredPage.clickSearchButton();
        });

        step("Verify name ", () -> {
            steamPoweredPage.verifyResultSearch(expectedResult);
        });

    }

}
