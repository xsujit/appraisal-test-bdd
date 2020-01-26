package pages;

import annotations.ChromeBrowser;
import com.google.inject.Inject;
import driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends BasePage {

    private String url;

    @FindBy(id = "inputEmail")
    WebElement inputEmail;

    @FindBy(id = "inputPassword")
    WebElement inputPassword;

    @FindBy(css = ".btn")
    WebElement submitButton;

    @Inject
    public Login(@ChromeBrowser DriverManager driverManager) {
        super(driverManager);
        url = getBaseUrl() + "/login";
        PageFactory.initElements(driverManager.getDriver(), this);
    }

    public void goTo() {
        navigateTo(url);
    }

    public void enterEmail(String email) {
        inputEmail.sendKeys(email);
    }

    public void enterPassword(String password) {
        inputPassword.sendKeys(password);
    }

    public void clickSubmit() {
        submitButton.click();
    }
}
