package tests.api;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import tests.specs.Specs;

import static io.qameta.allure.SeverityLevel.NORMAL;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

@Owner("a.baranov")
@Severity(NORMAL)
@Story("Autotests for API")
@Tags({@Tag("api")})
public class OpenGameSectionApiTest {

    @Test
    @DisplayName("Opening of the 'Survival' games section")
    void openSurvivalGamesApi() {
        given()
                .spec(Specs.requestSpec)
                .queryParam("cc", "RU")
                .queryParam("l", "english")
                .queryParam("start", "32")
                .queryParam("flavor", "popularpurchased")
                .queryParam("strContentHubType", "category")
                .queryParam("strContentHubCategory", "survival")
                .when()
                .get("/saleaction/ajaxgetsaledynamicappquery?cc=RU&l=english")
                .then()
                .spec(Specs.responseSpec)
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("schemes/openSection.json"));
    }
}