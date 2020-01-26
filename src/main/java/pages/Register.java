package pages;

import annotations.ChromeBrowser;
import com.google.inject.Inject;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class Register extends BasePage {

    private String url;

    @FindBy(css = ".form-signin")
    WebElement registrationForm;

    @FindBy(id = "projectId")
    WebElement projectDropDown;

    @FindBy(css = ".btn")
    WebElement submit;

    @Inject
    public Register(@ChromeBrowser DriverManager driverManager) {
        super(driverManager);
        url = getBaseUrl() + "/register";
        PageFactory.initElements(driverManager.getDriver(), this);
    }

    public void goTo() {
        navigateTo(url);
    }

    public void enterRegistrationForm(Map<String, String> userDetails) {
        List<WebElement> inputElements = registrationForm.findElements(By.tagName("input"));
        for (WebElement element : inputElements)
            if (userDetails.containsKey(element.getAttribute("id")))
                element.sendKeys(userDetails.get(element.getAttribute("id")));
    }

    public void selectSecondProject() {
        Select project = new Select(projectDropDown);
        project.selectByIndex(2);
    }

    public void submit() {
        submit.click();
    }
}
