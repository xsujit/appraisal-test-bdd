package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy(css = ".display-3")
    WebElement banner;

    @FindBy(linkText = "Register")
    WebElement registerLink;

    @FindBy(linkText = "Login")
    WebElement loginLink;

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
