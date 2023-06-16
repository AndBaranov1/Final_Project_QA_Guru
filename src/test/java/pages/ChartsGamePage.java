package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ChartsGamePage {

    private SelenideElement
            clickGame = $(".weeklytopsellers_TableRow_2-RN6");

    public ChartsGamePage clickGameInList() {
        clickGame.click();
        return this;
    }
}