package com.appraisal.pages;

import com.appraisal.context.ApplicantContext;
import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private String pageUrl;
    private WebDriver webDriver;

    @FindBy(id = "inputEmail")
    WebElement inputEmail;

    @FindBy(id = "inputPassword")
    WebElement inputPassword;

    @FindBy(css = ".btn")
    WebElement submitButton;

    @Inject
    public LoginPage(ApplicantContext applicantContext) {
        webDriver = applicantContext.getDriverManager().getDriver();
        pageUrl = applicantContext.getBaseUrl() + "/login";
        PageFactory.initElements(webDriver, this);
    }

    public void goTo() {
        webDriver.get(pageUrl);
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
