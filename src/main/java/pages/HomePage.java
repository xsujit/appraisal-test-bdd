package pages;

import annotations.ChromeBrowser;
import com.google.inject.Inject;
import driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(css = ".display-3")
    WebElement banner;

    @FindBy(linkText = "Register")
    WebElement registerLink;

    @FindBy(linkText = "Login")
    WebElement loginLink;

    @Inject
    public HomePage(@ChromeBrowser DriverManager driver) {
        super(driver);
        PageFactory.initElements(driver.getDriver(), this);
    }

    public String getBanner() {
        return banner.getText();
    }

    public void clickRegisterLink() {
        registerLink.click();
    }

    public void clickLoginLink() {
        loginLink.click();
    }
}
