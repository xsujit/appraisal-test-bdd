package step_definitions;

import com.google.inject.Guice;
import com.google.inject.Injector;
import conf.ConfigFileReader;
import driver.AppModule;

public class BaseSteps {

    private Injector injector;
    private String baseUrl;

    public BaseSteps() {
        injector = Guice.createInjector(new AppModule());
        ConfigFileReader configFileReader = new ConfigFileReader();
        baseUrl = configFileReader.getProp().getProperty("url") + ":" + configFileReader.getProp().getProperty("port");
    }

    public Injector getInjector() {
        return injector;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

}
