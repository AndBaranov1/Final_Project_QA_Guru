package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    private SelenideElement
            tabNewAndInrteresting = $("#noteworthy_tab .pulldown_desktop"),
            mostPlayed = $("#noteworthy_flyout .popup_menu_item:nth-child(3)"),
            setClickFieldSearch = $("#store_nav_search_term"),
            clickSearchBtn = $("#store_search_link > img"),
            verifyResulSearchGame = $(".search_result_row .title"),
            giftCards = $(".valve_links > a:nth-child(6)"),
            pointShop = $(".tab:nth-child(8) > span");

    public MainPage openPage() {
        open("https://store.steampowered.com/");
        return this;
    }

    public MainPage changeNewAndInteresting() {
        tabNewAndInrteresting.hover();
        return this;
    }

    public MainPage clickTabMostPlayed() {
        mostPlayed.click();
        return this;
    }

    public MainPage clickFieldSearch() {
        setClickFieldSearch.click();
        return this;
    }

    public MainPage setInputSearch(String value) {
        setClickFieldSearch.setValue(value);
        return this;
    }

    public MainPage clickSearchButton() {
        clickSearchBtn.click();
        return this;
    }

    public MainPage verifyResultSearch(String expectedResult) {
        verifyResulSearchGame.shouldHave(Condition.text(expectedResult));
        return this;
    }

    public MainPage clickGiftCards() {
        giftCards.click();
        return this;
    }

    public MainPage openPointShop() {
        pointShop.click();
        return this;
    }
}