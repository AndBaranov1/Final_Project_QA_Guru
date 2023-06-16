package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class PointsShopPage {

    private SelenideElement
            itemBundels = $("div#points_shop_root div:nth-child(1) > a:nth-child(4)"),
            getItemBundel = $(".padding-top-large:nth-child(1) .bundle_ItemHand_2zFSr > .padding-left-small:nth-child(3)"),
            openBundel = $(".padding-top-large:nth-child(1) .rewarditem_ImageFrames_2MPpw"),
            verifyBundel = $(".redeempointsmodal_Header_1btwT");

    public PointsShopPage allItemBundels() {
        itemBundels.click();
        return this;
    }

    public PointsShopPage getOpenItemBundel() {
        getItemBundel.click();
        return this;
    }

    public PointsShopPage openBundel() {
        openBundel.click();
        return this;
    }

    public PointsShopPage verifyCartBundel(String value) {
        verifyBundel.shouldHave(text(value));
        return this;
    }
}