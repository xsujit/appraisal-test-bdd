package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class Register {

    @FindBy(css = ".form-signin")
    WebElement registrationForm;

    @FindBy(id = "projectId")
    WebElement projectDropDown;

    @FindBy(css = ".btn")
    WebElement submit;

    public void enterRegistrationForm(Map<String, String> userDetails) {
        List<WebElement> inputElements = registrationForm.findElements(By.tagName("input"));
        for (WebElement element : inputElements)
            if (userDetails.containsKey(element.getAttribute("id")))
                element.sendKeys(userDetails.get(element.getAttribute("id")));
    }

    public void selectFirstProject() {
        Select project = new Select(projectDropDown);
        project.selectByIndex(1);
    }

    public void submit() {
        submit.click();
    }
}
