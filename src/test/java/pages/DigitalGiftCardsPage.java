package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class DigitalGiftCardsPage {

    private SelenideElement
            sendThrough = $(".btnv6_blue_hoverfade.btn_medium");

    public DigitalGiftCardsPage sendThroughSteam() {
        sendThrough.click();
        return this;
    }
}