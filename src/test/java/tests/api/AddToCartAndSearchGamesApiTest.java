package tests.api;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import io.restassured.http.ContentType;
import models.AddCartBodyModel;
import models.SearchResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import tests.specs.Specs;

import static io.qameta.allure.SeverityLevel.NORMAL;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Owner("a.baranov")
@Severity(NORMAL)
@Story("Autotests for API")
@Tags({@Tag("api")})
public class AddToCartAndSearchGamesApiTest {

    @Test
    @DisplayName("Game search Warface")
    void searchGameApi() {
        SearchResponseModel data = given()
                .queryParam("start", "3")
                .queryParam("cc", "RU")
                .queryParam("term", "Warface")
                .queryParam("supportedlang", "russian")
                .queryParam("infinite", "1")
                .spec(Specs.requestSpec)
                .when()
                .get("/search/results/?query")
                .then()
                .spec(Specs.responseSpec)
                .extract().as(SearchResponseModel.class);
        assertEquals(1, data.getSuccess());
        assertEquals( 1, data.getTotalCount());
    }

    @Test
    @DisplayName("Add game to cart")
    void potentialBuyGamesApi() {
        AddCartBodyModel data = given()
                .contentType(ContentType.JSON)
                .queryParam("cc", "RU")
                .spec(Specs.requestSpec)
                .when()
                .get("/dynamicstore/saledata/")
                .then()
                .spec(Specs.responseSpec)
                .extract().as(AddCartBodyModel.class);
        assertEquals(true, data.isbAllowAppImpressions());
    }
}