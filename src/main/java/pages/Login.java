package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {

    @FindBy(id = "inputEmail")
    WebElement inputEmail;

    @FindBy(id = "inputPassword")
    WebElement inputPassword;

    @FindBy(css = ".btn")
    WebElement submitButton;

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
