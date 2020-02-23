package com.appraisal.pages;

import com.appraisal.context.ApplicantContext;
import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver webDriver;

    @FindBy(css = ".display-3")
    WebElement banner;

    @FindBy(linkText = "Register")
    WebElement registerLink;

    @FindBy(linkText = "LoginPage")
    WebElement loginLink;

    @Inject
    public HomePage(ApplicantContext applicantContext) {
        webDriver = applicantContext.getDriverManager().getDriver();
        PageFactory.initElements(webDriver, this);
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
