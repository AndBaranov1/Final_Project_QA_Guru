package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class GameDetailPage {

    private SelenideElement
            verifyNameGame = $("#appHubAppName"),
            addBasketBtn = $("#btn_add_to_cart_54029 > span");

    public GameDetailPage verifyNameGameDota2(String value) {
        verifyNameGame.shouldHave(text(value));
        return this;
    }

    public GameDetailPage clickAddBasketBtn() {
        addBasketBtn.click();
        return this;
    }
}