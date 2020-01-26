package pages;

import conf.ConfigFileReader;
import driver.DriverManager;
import org.openqa.selenium.WebDriver;

public class BasePage {

    private String baseUrl;
    private WebDriver driver;
    protected String pageTitle;

    public BasePage(DriverManager driver) {
        this.driver = driver.getDriver();
        ConfigFileReader configFileReader = new ConfigFileReader();
        baseUrl = configFileReader.getProp().getProperty("url") + ":" + configFileReader.getProp().getProperty("port");
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public WebDriver getDriver() {
        return driver;
    }

}
