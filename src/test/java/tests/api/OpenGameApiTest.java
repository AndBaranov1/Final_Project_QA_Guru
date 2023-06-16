package tests.api;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import models.AddCartBodyModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import tests.specs.Specs;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Owner("a.baranov")
@Severity(CRITICAL)
@Story("Autotests for API")
@Tags({@Tag("api")})
public class OpenGameApiTest {

    @DisplayName("Open game Dota 2")
    @Test
    void openGameApi() {
        AddCartBodyModel data = given()
                .spec(Specs.requestSpec)
                .queryParam("cc", "RU")
                .queryParam("id", "1549189928")
                .when()
                .get("/dynamicstore/saledata")
                .then()
                .spec(Specs.responseSpec)
                .log().status()
                .statusCode(200)
                .extract().as(AddCartBodyModel.class);
        assertEquals(true, data.isbAllowAppImpressions());
    }
}