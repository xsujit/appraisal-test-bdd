package com.appraisal.pages;

import com.appraisal.context.ApplicantContext;
import com.google.inject.Inject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.log4testng.Logger;

import java.util.List;
import java.util.Map;

public class Register extends BasePage {

    private final String baseUrl;
    private final String pageUrl;
    private static final Logger logger = Logger.getLogger(Register.class);

    @FindBy(css = ".form-signin")
    WebElement registrationForm;

    @FindBy(id = "projectId")
    WebElement projectDropDown;

    @FindBy(css = ".btn")
    WebElement submit;

    @Inject
    public Register(ApplicantContext applicantContext, WebDriver driver) {
        super(driver);
        logger.info("Register Page initialized");
        pageUrl = applicantContext.getBaseUrl() + "/register";
        baseUrl = applicantContext.getBaseUrl();
    }

    public Register goTo() {
        driver.get(pageUrl);
        return this;
    }

    public Register enterRegistrationForm(Map<String, String> userDetails) {
        List<WebElement> inputElements = registrationForm.findElements(By.tagName("input"));
        for (WebElement element : inputElements)
            if (userDetails.containsKey(element.getAttribute("id")))
                element.sendKeys(userDetails.get(element.getAttribute("id")));
        return this;
    }

    public Register selectSecondProject() {
        Select project = new Select(projectDropDown);
        project.selectByIndex(2);
        return this;
    }

    public void submit() {
        submit.click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getBaseUrl() {
        return baseUrl;
    }
}
