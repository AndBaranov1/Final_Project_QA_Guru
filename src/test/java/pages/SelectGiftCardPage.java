package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SelectGiftCardPage {

    private SelenideElement
            verifyListGiftCards = $(".pageheader:nth-child(2)");

    public SelectGiftCardPage verifyListGiftCardsSteam(String value) {
        verifyListGiftCards.shouldHave(text(value));
        return this;
    }
}