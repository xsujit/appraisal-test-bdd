package pages;

import com.google.inject.Inject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(css = ".display-3")
    WebElement banner;

    @FindBy(linkText = "Register")
    WebElement registerLink;

    @FindBy(linkText = "LoginPage")
    WebElement loginLink;

    @Inject
    public HomePage(PageUtil pageUtil) {
        PageFactory.initElements(pageUtil.getDriver(), this);
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
