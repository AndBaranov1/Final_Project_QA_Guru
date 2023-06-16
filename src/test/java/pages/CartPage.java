package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CartPage {

    private SelenideElement
            verifyPrimeStatus = $(".cart_item_desc > a");

    public CartPage verifyBasketPrimeStatus(String value) {
        verifyPrimeStatus.shouldHave(text(value));
        return this;
    }
}