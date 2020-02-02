package pages;

import com.google.inject.Inject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class Register {

    private String url;
    private WebDriver webDriver;
    private PageUtil pageUtil;

    @FindBy(css = ".form-signin")
    WebElement registrationForm;

    @FindBy(id = "projectId")
    WebElement projectDropDown;

    @FindBy(css = ".btn")
    WebElement submit;

    @Inject
    public Register(PageUtil pageUtil) {
        this.pageUtil = pageUtil;
        this.webDriver = pageUtil.getDriverManager().getDriver();
        url = pageUtil.getBaseUrl() + "/register";
        PageFactory.initElements(webDriver, this);
    }

    public void goTo() {
        webDriver.get(url);
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

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    public String getBaseUrl() {
        return pageUtil.getBaseUrl();
    }
}
