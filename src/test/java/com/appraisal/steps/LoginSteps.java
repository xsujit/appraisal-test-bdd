package com.appraisal.steps;

import com.appraisal.context.ApplicantContext;
import com.appraisal.pages.HomePage;
import com.appraisal.pages.LoginPage;
import com.appraisal.pages.Register;
import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.log4testng.Logger;

import java.util.List;

@ScenarioScoped
public class LoginSteps {

    private LoginPage loginPage;
    private HomePage homePage;
    private Register register;
    private final ApplicantContext applicantContext;
    private static final Logger logger = Logger.getLogger(LoginSteps.class);

    @Inject
    public LoginSteps(ApplicantContext applicantContext) {
        logger.info("LoginSteps initialized");
        this.applicantContext = applicantContext;
    }

    @Given("I open the {string} page")
    public void iOpenThePage(String page) {
        switch (page) {
            case "register":
                logger.info("Navigating to register page");
                register.goTo();
                break;
            case "login":
                logger.info("Navigating to login page");
                loginPage.goTo();
                break;
            case "home":
                logger.info("Navigating to home page");
                homePage.goTo();
                break;
            default:
                System.out.println("No matching page");
        }
    }

    @Given("I have valid {string} and {string}")
    public void iHaveValidAnd(String username, String password) {
        loginPage.enterEmail(username);
        loginPage.enterPassword(password);
    }

    @When("I click on login")
    public void iClickOnLogin() {
        loginPage.clickSubmit();
    }

    @Then("I should be logged in")
    public void iShouldBeLoggedIn() {
        logger.info("Verifying home page banner after successful login");
        Assert.assertEquals(homePage.getBanner(), "Hello, welcome to appraisal 2018");
    }

    @Given("I open the application and login using the following")
    public void iOpenTheApplicationAndLoginUsingTheFollowing(List<String> credentials) {
        /*homePage = new HomePage(applicantContext)
                .goTo()
                .clickLoginLink()
                .enterEmail(credentials.get(0))
                .enterPassword(credentials.get(1))
                .clickSubmit();*/
        new HomePage(applicantContext)
                .goTo()
                .clickLoginLink();
        homePage = new LoginPage(applicantContext).enterEmail(credentials.get(0))
                .enterPassword(credentials.get(1))
                .clickSubmit();

    }

    @When("I click on logout")
    public void iClickOnLogout() {
        homePage
                .clickLogoutLink()
                .clickReturn();
    }
}
