package com.appraisal.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;

public class LogoutSuccess {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private static final Logger logger = Logger.getLogger(LogoutSuccess.class);

    @FindBy(linkText = "Return Home")
    WebElement returnLink;

    public LogoutSuccess(WebDriver driver) {
        logger.info("LogoutSuccess initialized");
        this.driver = driver;
        wait = new WebDriverWait(driver, 60);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,5), this);
    }

    public void clickReturn() {
        //wait.until(ExpectedConditions.visibilityOf(returnLink));
        returnLink.click();
    }
}
