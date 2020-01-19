package driver;

import annotations.ChromeBrowser;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;

public class DriverModule extends AbstractModule {

    @Override
    protected void configure() {

        /*bind(DriverManager.class)
                .to(ChromeDriverManager.class)
                .in(Scopes.SINGLETON);*/
    }

    /*@Provides
    public WebDriver getDriver(@ChromeBrowser DriverManager driverManager) {
        System.out.println("getDriver");
        return driverManager.getDriver();
    }*/

    @Provides
    @ChromeBrowser
    public DriverManager getChromeDriverManager() {
        System.out.println("ChromeDriverManager");
        return new ChromeDriverManager();
    }
}
