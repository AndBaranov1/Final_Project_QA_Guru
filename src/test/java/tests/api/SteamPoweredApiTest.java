package tests.api;

import com.codeborne.selenide.logevents.SelenideLogger;
import models.AddCartBodyModel;
import models.SearchResponseModel;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import tests.Specs;

import static help.CustomApiListener.withCustomTemplates;
import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.NORMAL;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Story("Autotests for API")
@Tags({@Tag("api")})
public class SteamPoweredApiTest {

    @Owner("a.baranov")
    @Severity(NORMAL)
    @Test
    @DisplayName("Game search Warface")
    void searchGameApi() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        SearchResponseModel data = given()
                .filter(withCustomTemplates())
                .log().uri()
                .contentType(ContentType.JSON)
                .queryParam("start", "3")
                .queryParam("cc", "RU")
                .queryParam("term", "Warface")
                .queryParam("supportedlang", "russian")
                .queryParam("infinite", "1")
                .spec(Specs.requestSearch)
                .when()
                .get("/results/?query")
                .then()
                .spec(Specs.responseSpec)
                .log().body()
                .extract().as(SearchResponseModel.class);
        assertEquals(1, data.getSuccess());
        assertEquals( 1, data.getTotal_count());
    }

    @Owner("a.baranov")
    @Severity(CRITICAL)
    @DisplayName("Open game Dota 2")
    @Test
    void openGameApi() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        AddCartBodyModel data = given()
                .filter(withCustomTemplates())
                .log().uri()
                .contentType(ContentType.JSON)
                .spec(Specs.requestAddCart)
                .queryParam("cc", "RU")
                .queryParam("id", "1549189928")
                .when()
                .get()
                .then()
                .spec(Specs.responseSpec)
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().as(AddCartBodyModel.class);
        assertEquals(true, data.isbAllowAppImpressions());

    }

    @Owner("a.baranov")
    @Severity(NORMAL)
    @Test
    @DisplayName("Opening of the 'Survival' games section")
    void openSurvivalGamesApi() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        given()
                .filter(withCustomTemplates())
                .log().uri()
                .contentType(ContentType.JSON)
                .queryParam("cc", "RU")
                .queryParam("l", "english")
                .queryParam("start", "32")
                .queryParam("flavor", "popularpurchased")
                .queryParam("strContentHubType", "category")
                .queryParam("strContentHubCategory", "survival")
                .spec(Specs.requestOpen)
                .when()
                .get("cc=RU&l=english")
                .then()
                .spec(Specs.responseSpec)
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("schemes/openSection.json"));
    }

    @Owner("a.baranov")
    @Severity(CRITICAL)
    @Test
    @DisplayName("Add game to cart")
    void potentialBuyGamesApi() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        AddCartBodyModel data = given()
                .filter(withCustomTemplates())
                .log().uri()
                .contentType(ContentType.JSON)
                .queryParam("cc", "RU")
                .spec(Specs.requestAddCart)
                .when()
                .get()
                .then()
                .spec(Specs.responseSpec)
                .extract().as(AddCartBodyModel.class);
        assertEquals(true, data.isbAllowAppImpressions());
    }
}