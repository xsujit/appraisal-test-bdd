package pages;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import conf.ConfigFileReader;
import driver.DriverManager;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class PageUtil {

    private WebDriver driver;
    private Properties properties;

    @Inject
    public PageUtil(@Named("CHROME") DriverManager driverManager, ConfigFileReader configFileReader) {
        this.driver = driverManager.getDriver();
        properties = configFileReader.getProp();
    }

    public String getBaseUrl() {
        return properties.getProperty("url") + ":" + properties.getProperty("port");
    }

    public WebDriver getDriver() {
        return driver;
    }

}
