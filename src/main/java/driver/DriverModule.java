package driver;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.name.Names;

public class DriverModule extends AbstractModule {

    @Override
    protected void configure() {

        bind(DriverManager.class)
                .annotatedWith(Names.named("CHROME"))
                .to(ChromeDriverManager.class)
                .in(Scopes.SINGLETON);
    }

    /*@Provides
    public WebDriver getDriver(@ChromeBrowser DriverManager driverManager) {
        System.out.println("getDriver");
        return driverManager.getDriver();
    }

    @Provides
    @ChromeBrowser
    @Singleton
    public DriverManager getChromeDriverManager() {
        return new ChromeDriverManager();
    }*/

}
