package com.appraisal.guice;

import com.appraisal.driver.ChromeDriverManager;
import com.appraisal.driver.DriverManager;
import com.appraisal.driver.FirefoxDriverManager;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Scopes;
import org.openqa.selenium.WebDriver;
import org.testng.log4testng.Logger;

public class AppModule extends AbstractModule {

    private static final Logger logger = Logger.getLogger(AppModule.class);

    @Override
    protected void configure() {

        String browser = System.getProperty("browser").toUpperCase();
        Class<? extends DriverManager> driver;
        switch (browser) {
            case "CHROME":
                driver = ChromeDriverManager.class;
                break;
            case "FIREFOX":
                driver = FirefoxDriverManager.class;
                break;
            default:
                throw new IllegalArgumentException("Browser should be chrome or firefox");
        }
        bind(DriverManager.class)
                .to(driver)
                .in(Scopes.SINGLETON);

    }

    @Provides
    public WebDriver getDriver(DriverManager driverManager) {
        logger.info("getDriver");
        return driverManager.getDriver();
    }

    /*@Provides
    @ChromeBrowser
    @Singleton
    public DriverManager getChromeDriverManager() {
        return new ChromeDriverManager();
    }
*/
}
