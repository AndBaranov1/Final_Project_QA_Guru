package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private SelenideElement
            loginBtn = $(".global_action_link:nth-child(2)"),
            setLogin = $(".newlogindialog_TextField_2KXGK:nth-child(1) > .newlogindialog_TextInput_2eKVn"),
            setPassword = $(".newlogindialog_TextField_2KXGK:nth-child(2) > .newlogindialog_TextInput_2eKVn"),
            submitBtn = $(".newlogindialog_SubmitButton_2QgFE"),
            verifyTextError = $(".newlogindialog_FormError_1Mcy9");

    public LoginPage clickLoginBtn() {
        loginBtn.click();
        return this;
    }

    public LoginPage setInputLogin(String login) {
        setLogin.setValue(login);
        return this;
    }

    public LoginPage setInputPassword(String password) {
        setPassword.setValue(password);
        return this;
    }

    public LoginPage clickSubmitButton() {
        submitBtn.click();
        return this;
    }

    public LoginPage verifyLoginUnsuccessful(String value) {
        verifyTextError.shouldHave(text(value));
        return this;
    }
}