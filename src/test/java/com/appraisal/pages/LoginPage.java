package com.appraisal.pages;

import com.appraisal.context.ApplicantContext;
import com.google.inject.Inject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;

public class LoginPage {

    private final ApplicantContext applicantContext;
    private final String page;
    private final WebDriver driver;
    private final WebDriverWait wait;
    HomePage homePage;
    private static final Logger logger = Logger.getLogger(LoginPage.class);

    @FindBy(id = "inputEmail")
    WebElement inputEmail;

    @FindBy(id = "inputPassword")
    WebElement inputPassword;

    @FindBy(css = ".btn")
    WebElement submitButton;

    @Inject
    public LoginPage(ApplicantContext applicantContext, WebDriver driver) {
        logger.info("LoginPage initialized");
        this.applicantContext = applicantContext;
        this.driver = driver;
        page = applicantContext.getBaseUrl() + "/login";
        wait = new WebDriverWait(driver, 60);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
    }

    public void goTo() {
        driver.get(page);
    }

    public LoginPage enterEmail(String email) {
        //driver.get(page);
        //driver.navigate().refresh();
        wait.until(ExpectedConditions.elementToBeClickable(inputEmail));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(inputEmail)));
        /*await()
                .atMost(5, TimeUnit.SECONDS)
                .until(() ->inputEmail.isDisplayed());
        wait.until(ExpectedConditions.elementToBeClickable(inputEmail));*/
        /*JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView()", inputEmail);
        jse.executeScript("arguments[0].click();", inputEmail);*/
        /*wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(inputEmail)));
        wait.until(ExpectedConditions.elementToBeClickable(inputEmail));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", inputEmail);*/
        /*Actions actions = new Actions(driver);
        actions.moveToElement(inputEmail).sendKeys(email).build().perform();*/
        inputEmail.sendKeys(email);
        if (!inputEmail.getAttribute("value").equalsIgnoreCase(email)) {
            logger.info("Entering value through javascript");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            String test = "arguments[0].setAttribute('value','" + email + "')";
            js.executeScript(test, inputEmail);
        }
        logger.info(inputEmail.getAttribute("value"));
        /*inputEmail.click();
        inputEmail.clear();
        inputEmail.sendKeys(email);*/
        return this;
    }

    public LoginPage enterPassword(String password) {
        logger.info("Entering password");
        // wait.until(ExpectedConditions.visibilityOf(inputPassword));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        String test = "arguments[0].setAttribute('value','"+password+"')";
        js.executeScript(test, inputPassword);
        //inputPassword.sendKeys(password);
        return this;
    }

    public void clickSubmit() {
        logger.info("Clicking on submit button");
        // wait.until(ExpectedConditions.visibilityOf(submitButton));
        //submitButton.click();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", submitButton);
    }
}
