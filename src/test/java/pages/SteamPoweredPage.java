package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import config.AuthorizationConfig;
import org.aeonbits.owner.ConfigFactory;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SteamPoweredPage {

    static AuthorizationConfig config = ConfigFactory.create(AuthorizationConfig.class, System.getProperties());
    private SelenideElement
    loginBtn =  $(".global_action_link:nth-child(2)"),
    setLogin = $(".newlogindialog_TextField_2KXGK:nth-child(1) > .newlogindialog_TextInput_2eKVn"),
    setPassword = $(".newlogindialog_TextField_2KXGK:nth-child(2) > .newlogindialog_TextInput_2eKVn"),
    submitBtn =  $(".newlogindialog_SubmitButton_2QgFE"),
    verifyTextError = $(".newlogindialog_FormError_1Mcy9"),
    tabNewAndInrteresting = $("#noteworthy_tab .pulldown_desktop"),
    mostPlayed = $("#noteworthy_flyout .popup_menu_item:nth-child(3)"),
    clickGame =  $(".weeklytopsellers_TableRow_2-RN6"),
    addBasketBtn =  $("#btn_add_to_cart_54029 > span"),
    verifyPrimeStatus = $(".cart_item_desc > a"),
    setClickFieldSearch = $("#store_nav_search_term"),
    clickSearchBtn = $("#store_search_link > img"),
    chooseGameDota2 =  $(".search_result_row:nth-child(1) .search_name > div"),
    verifyNameGame = $("#appHubAppName"),
    verifyResulSearchGame = $(".search_result_row .title"),
    giftCards = $(".valve_links > a:nth-child(6)"),
    sendThrough = $(".btnv6_blue_hoverfade.btn_medium"),
    verifyListGiftCards = $(".pageheader:nth-child(2)"),
    pointShop = $(".tab:nth-child(8) > span"),
    itemBundels = $(".padding-bottom-none:nth-child(1) > .loyaltyprimarynav_SecondaryNavItem_2mFH5:nth-child(4) > .loyaltyprimarynav_Label_2Cstp"),
    getItemBundel = $(".padding-top-large:nth-child(1) .bundle_ItemHand_2zFSr > .padding-left-small:nth-child(3)"),
    openBundel = $(".padding-top-large:nth-child(1) .rewarditem_ImageFrames_2MPpw"),
    verifyBundel = $(".redeempointsmodal_Header_1btwT");



    public SteamPoweredPage openPage() {
        open("https://store.steampowered.com/");
        return this;
    }

    public SteamPoweredPage clickLoginBtn() {
        loginBtn.click();
        return this;
    }

    public SteamPoweredPage setInputLogin() {
        setLogin.setValue(config.login());
        return this;
    }

    public SteamPoweredPage setInputPassword() {
        setPassword.setValue(config.password());
        return this;
    }

    public SteamPoweredPage setInputWrongPassword() {
        setPassword.setValue(config.wrong_password());
        return this;
    }

    public SteamPoweredPage clickSubmitButton() {
        submitBtn.click();
        return this;
    }

    public SteamPoweredPage verifyLoginUnsuccessful(String value) {
        verifyTextError.shouldHave(text(value));
        return this;
    }

    public SteamPoweredPage changeNewAndInteresting() {
        tabNewAndInrteresting.hover();
        return this;
    }

    public SteamPoweredPage clickTabMostPlayed() {
        mostPlayed.click();
        return this;
    }

    public SteamPoweredPage clickGameInList() {
        clickGame.click();
        return this;
    }

    public SteamPoweredPage clickAddBasketBtn() {
        addBasketBtn.click();
        return this;
    }

    public SteamPoweredPage verifyBasketPrimeStatus(String value) {
        verifyPrimeStatus.shouldHave(text(value));
        return this;
    }

    public SteamPoweredPage clickFieldSearch() {
        setClickFieldSearch.click();
        return this;
    }

    public SteamPoweredPage setInputSearch(String value) {
        setClickFieldSearch.setValue(value);
        return this;
    }

    public SteamPoweredPage clickSearchButton() {
        clickSearchBtn.click();
        return this;
    }

    public SteamPoweredPage selectGameDota2() {
        chooseGameDota2.click();
        return this;
    }

    public SteamPoweredPage verifyNameGameDota2(String value) {
        verifyNameGame.shouldHave(text(value));
        return this;
    }

    public SteamPoweredPage verifyResultSearch(String expectedResult) {
        verifyResulSearchGame.shouldHave(Condition.text(expectedResult));
        return this;
    }

    public SteamPoweredPage clickGiftCards() {
        giftCards.click();
        return this;
    }

    public SteamPoweredPage sendThroughSteam() {
        sendThrough.click();
        return this;
    }

    public SteamPoweredPage verifyListGiftCardsSteam(String value) {
        verifyListGiftCards.shouldHave(text(value));
        return this;
    }

    public SteamPoweredPage openPointShop() {
        pointShop.click();
        return this;
    }

    public SteamPoweredPage allItemBundels() {
        itemBundels.click();
        return this;
    }

    public SteamPoweredPage getOpenItemBundel() {
        getItemBundel.click();
        return this;
    }

    public SteamPoweredPage openBundel() {
        openBundel.click();
        return this;
    }

    public SteamPoweredPage verifyCartBundel(String value) {
        verifyBundel.shouldHave(text(value));
        return this;
    }
}
