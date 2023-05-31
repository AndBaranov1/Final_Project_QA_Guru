package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties"
})
public interface LocalConfig extends Config {

    @Key("deviceName")
    @DefaultValue("Samsung Galaxy S22 Ultra")
        String deviceName();

    @Key("osVersion")
    @DefaultValue("12.0")
    String osVersion();

    @Key("url")
    String url();
}
