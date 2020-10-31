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

        if (System.getProperty("browser").equalsIgnoreCase("CHROME"))
            bind(DriverManager.class)
                    .to(ChromeDriverManager.class)
                    .in(Scopes.SINGLETON);
        else
            bind(DriverManager.class)
                    .to(FirefoxDriverManager.class)
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
