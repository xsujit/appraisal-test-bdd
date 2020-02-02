package pages;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import conf.ConfigFileReader;
import driver.DriverManager;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class PageUtil {

    private WebDriver driver;
    private Properties prop;

    @Inject
    public PageUtil(@Named("CHROME") DriverManager driverManager) {
        this.driver = driverManager.getDriver();
        ConfigFileReader configFileReader = new ConfigFileReader();
        prop = configFileReader.getProp();
    }

    public String getBaseUrl() {
        return prop.getProperty("url") + ":" + prop.getProperty("port");
    }

    public WebDriver getDriver() {
        return driver;
    }

}
