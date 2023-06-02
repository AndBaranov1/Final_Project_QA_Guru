package tests.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import static io.qameta.allure.Allure.step;

@Tags({@Tag("web")})
public class StoreSteamPoweredWebTest extends TestBase {

    @DisplayName("Authorization user")
    @Test
    void userAuthorization() {
        step("Open form Steam", () -> {
            steamPoweredPage.openPage();
        });

        step("Click login Button", () -> {
            steamPoweredPage.clickLoginBtn();
        });

        step("Fill in the login field", () -> {
            steamPoweredPage.setInputLogin("Autotester_qa_demo");
        });

        step("Fill in the password field", () -> {
            steamPoweredPage.setInputPassword("Db)cE*FUD3Dw98L");
        });

        step("Click login submit button", () -> {
            steamPoweredPage.clickSubmitButton();
        });
    }

    @DisplayName("Add prime status game in basket")
    @Test
    void addPrimeStatusGameInBasket() {
        step("Open form Steam", () -> {
            steamPoweredPage.openPage();
        });

     /*   step("Click on language pull down", () -> {
            steamPoweredPage.clickLanguage();
        });

        step("Hover your mouse over language English", () -> {
            steamPoweredPage.mouseOverLanguage();
        });

        step("Click on language English", () -> {
            steamPoweredPage.chooseLanguageEnglish();
        });*/

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

    @DisplayName("Search and selection of the game dota 2")
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

    @DisplayName("steamGiftCards")
    @Test
    void steamGiftCards() {
        step("Open form Steam", () -> {
            steamPoweredPage.openPage();
        });

        step("Click steam gift cards", () -> {
            steamPoweredPage.clickGiftCards();
        });

        step("switchTo Window", () -> {
            switchTo().window(1);
        });

        step("Send through steam", () -> {
            steamPoweredPage.sendThroughSteam();
        });

        step("Verify digital gift cards", () -> {
            steamPoweredPage.verifyListGiftCardsSteam("DIGITAL GIFT CARDS");
        });

    }





}
