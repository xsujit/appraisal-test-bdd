package com.appraisal.pages;

import com.appraisal.context.ApplicantContext;
import com.google.inject.Inject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;

public class HomePage {

    private final WebDriver driver;
    private final String page;
    private final ApplicantContext applicantContext;
    private final WebDriverWait wait;
    private static final Logger logger = Logger.getLogger(HomePage.class);

    @FindBy(css = ".display-3")
    WebElement banner;

    @FindBy(linkText = "Register")
    WebElement registerLink;

    @FindBy(linkText = "Login")
    WebElement loginLink;

    @FindBy(linkText = "Team")
    WebElement teamLink;

    @FindBy(linkText = "Logout")
    WebElement logoutLink;

    @FindBy(css = "li.nav-item:nth-child(1) > a:nth-child(1)")
    WebElement homeLink;

    @Inject
    public HomePage(ApplicantContext applicantContext) {
        logger.info("HomePage initialized");
        this.applicantContext = applicantContext;
        driver = applicantContext.getDriverManager().getDriver();
        page = applicantContext.getBaseUrl();
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,5), this);
    }

    public HomePage goTo() {
        driver.get(page);
        return new HomePage(applicantContext);
    }

    public String getBanner() {
        return banner.getText();
    }

    public void clickRegisterLink() {
        registerLink.click();
    }

    public void clickLoginLink() {
        /*homeLink.click();
        logger.info("homeLink start");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", loginLink);
        loginLink.click();
        logger.info("loginLink start");
        homeLink.click();
        logger.info("homeLink start");*/
        loginLink.click();
        logger.info("loginLink start");
        logger.info("JavascriptExecutor start");
        wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));
        logger.info("JavascriptExecutor complete");
        //wait.until(ExpectedConditions.stalenessOf(banner));
        //return new LoginPage(applicantContext);
    }

    public LogoutSuccess clickLogoutLink() {
        //wait.until(ExpectedConditions.visibilityOf(logoutLink));
        logoutLink.sendKeys(Keys.ENTER);
        //logoutLink.click();
        return new LogoutSuccess(applicantContext);
    }

    public TeamPage goToTeam() {
        teamLink.click();
        return new TeamPage(applicantContext);
    }

}
