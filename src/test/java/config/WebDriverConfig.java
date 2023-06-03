package config;

import org.aeonbits.owner.Config;

public interface WebDriverConfig extends Config {
    @Config.Key("browser")
    @DefaultValue("chrome")
    String getBrowser();

    @Key("browserVersion")
    String getBrowserVersion();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String getBrowserSize();

    @Key("baseUrl")
    @DefaultValue("https://allure.autotests.cloud")
    String getBaseUrl();

    @Key("isRemote")
    @DefaultValue("false")
    Boolean isRemote();

    @Key("remoteUrl")
    String getRemoteUrl();
}
