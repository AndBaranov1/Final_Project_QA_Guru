package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ListGamePage {

    private SelenideElement
            chooseGameDota2 = $(".search_result_row:nth-child(1) .search_name > div");

    public ListGamePage selectGameDota2() {
        chooseGameDota2.click();
        return this;
    }
}