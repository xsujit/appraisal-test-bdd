package com.appraisal.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;

public class BasePage {

    private static final int TIMEOUT = 5;
    private static final int POLLING = 1000;
    private final WebDriverWait wait;
    protected WebDriver driver;
    private static final Logger logger = Logger.getLogger(BasePage.class);

    public BasePage(WebDriver driver) {
        logger.info("Base Page initialized");
        this.driver = driver;
        wait = new WebDriverWait(driver, TIMEOUT, POLLING);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
    }


}
