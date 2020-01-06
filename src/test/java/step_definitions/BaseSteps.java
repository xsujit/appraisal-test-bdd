package step_definitions;

import conf.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;

public class BaseSteps {

    private WebDriver driver = new ChromeDriver();
    private ConfigFileReader configFileReader = new ConfigFileReader();
    private String baseUrl = configFileReader.getProp().getProperty("url") + ":" + configFileReader.getProp().getProperty("port");
    private HomePage homePage = PageFactory.initElements(driver, HomePage.class);

    public WebDriver getDriver() {
        return driver;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public HomePage getHomePage() {
        return homePage;
    }
}
