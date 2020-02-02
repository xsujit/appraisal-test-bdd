package pages;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import conf.ConfigFileReader;
import driver.DriverManager;

import java.util.Properties;

public class PageUtil {

    private DriverManager driverManager;
    private Properties properties;

    @Inject
    public PageUtil(@Named("CHROME") DriverManager driverManager, ConfigFileReader configFileReader) {
        this.driverManager = driverManager;
        properties = configFileReader.getProp();
    }

    public String getBaseUrl() {
        return properties.getProperty("url") + ":" + properties.getProperty("port");
    }

    public DriverManager getDriverManager() {
        return driverManager;
    }
}
