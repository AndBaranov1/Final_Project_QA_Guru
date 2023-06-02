package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StoreSteamPoweredPage {
    private SelenideElement
    loginBtn =  $(".global_action_link:nth-child(2)"),
    setLogin = $(".newlogindialog_TextField_2KXGK:nth-child(1) > .newlogindialog_TextInput_2eKVn"),
    setPassword = $(".newlogindialog_TextField_2KXGK:nth-child(2) > .newlogindialog_TextInput_2eKVn"),
    submitBtn =  $(".newlogindialog_SubmitButton_2QgFE"),
    language  = $("#language_pulldown"),
    chooseLanguage = $(".popup_menu_item:nth-child(22)"),
    tabNewAndInrteresting = $("#noteworthy_tab .pulldown_desktop"),
    mostPlayed = $("#noteworthy_flyout .popup_menu_item:nth-child(3)"),
    clickGame =  $(".weeklytopsellers_TableRow_2-RN6"),
    addBasketBtn =  $("#btn_add_to_cart_54029 > span"),
    verifyPrimeStatus = $(".cart_item_desc > a"),
    setClickFieldSearch = $("#store_nav_search_term"),
    clickSearchBtn = $("#store_search_link > img"),
    chooseGameDota2 =  $(".search_result_row:nth-child(1) .search_name > div"),
    verifyNameGame = $("#appHubAppName"),
    giftCards = $(".valve_links > a:nth-child(6)"),
    sendThrough = $(".btnv6_blue_hoverfade.btn_medium"),
    verifyListGiftCards = $(".pageheader:nth-child(2)"),
    pointShop = $(".tab:nth-child(8) > span"),
    itemBundels = $(".padding-bottom-none:nth-child(1) > .loyaltyprimarynav_SecondaryNavItem_2mFH5:nth-child(4) > .loyaltyprimarynav_Label_2Cstp"),
    getItemBundel = $(".padding-top-large:nth-child(1) .bundle_ItemHand_2zFSr > .padding-left-small:nth-child(3)"),
    openBundel = $(".padding-top-large:nth-child(1) .rewarditem_ImageFrames_2MPpw"),
    verifyBundel = $(".redeempointsmodal_Header_1btwT");



    public StoreSteamPoweredPage openPage() {
        open("https://store.steampowered.com/");
        return this;
    }

    public StoreSteamPoweredPage clickLoginBtn() {
        loginBtn.click();
        return this;
    }

    public StoreSteamPoweredPage setInputLogin(String value) {
        setLogin.setValue(value);
        return this;
    }

    public StoreSteamPoweredPage setInputPassword(String value) {
        setPassword.setValue(value);
        return this;
    }

    public StoreSteamPoweredPage clickSubmitButton() {
        submitBtn.click();
        return this;
    }

    public StoreSteamPoweredPage clickLanguage() {
        language.click();
        return this;
    }

    public StoreSteamPoweredPage mouseOverLanguage() {
        chooseLanguage.hover();
        return this;
    }

    public StoreSteamPoweredPage chooseLanguageEnglish() {
        chooseLanguage.click();
        return this;
    }

    public StoreSteamPoweredPage changeNewAndInteresting() {
        tabNewAndInrteresting.hover();
        return this;
    }

    public StoreSteamPoweredPage clickTabMostPlayed() {
        mostPlayed.click();
        return this;
    }

    public StoreSteamPoweredPage clickGameInList() {
        clickGame.click();
        return this;
    }

    public StoreSteamPoweredPage clickAddBasketBtn() {
        addBasketBtn.click();
        return this;
    }

    public StoreSteamPoweredPage verifyBasketPrimeStatus(String value) {
        verifyPrimeStatus.shouldHave(text(value));
        return this;
    }

    public StoreSteamPoweredPage clickFieldSearch() {
        setClickFieldSearch.click();
        return this;
    }

    public StoreSteamPoweredPage setInputSearch(String value) {
        setClickFieldSearch.setValue(value);
        return this;
    }

    public StoreSteamPoweredPage clickSearchButton() {
        clickSearchBtn.click();
        return this;
    }

    public StoreSteamPoweredPage selectGameDota2() {
        chooseGameDota2.click();
        return this;
    }

    public StoreSteamPoweredPage verifyNameGameDota2(String value) {
        verifyNameGame.shouldHave(text(value));
        return this;
    }

    public StoreSteamPoweredPage clickGiftCards() {
        giftCards.click();
        return this;
    }

    public StoreSteamPoweredPage sendThroughSteam() {
        sendThrough.click();
        return this;
    }

    public StoreSteamPoweredPage verifyListGiftCardsSteam(String value) {
        verifyListGiftCards.shouldHave(text(value));
        return this;
    }

    public StoreSteamPoweredPage openPointShop() {
        pointShop.click();
        return this;
    }

    public StoreSteamPoweredPage allItemBundels() {
        itemBundels.click();
        return this;
    }

    public StoreSteamPoweredPage getOpenItemBundel() {
        getItemBundel.click();
        return this;
    }

    public StoreSteamPoweredPage openBundel() {
        openBundel.click();
        return this;
    }

    public StoreSteamPoweredPage verifyCartBundel(String value) {
        verifyBundel.shouldHave(text(value));
        return this;
    }
}
