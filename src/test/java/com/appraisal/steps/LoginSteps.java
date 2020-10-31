package com.appraisal.steps;

import com.appraisal.context.ApplicantContext;
import com.appraisal.pages.HomePage;
import com.appraisal.pages.LoginPage;
import com.appraisal.pages.Register;
import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.log4testng.Logger;

import java.util.List;

@ScenarioScoped
public class LoginSteps {

    private final LoginPage loginPage;
    private final HomePage homePage;
    private final ApplicantContext appContext;
    private Register register;

    private static final Logger logger = Logger.getLogger(LoginSteps.class);

    @Inject
    public LoginSteps(ApplicantContext appContext, HomePage homePage, LoginPage loginPage) {
        logger.info("LoginSteps initialized");
        this.homePage = homePage;
        this.loginPage = loginPage;
        this.appContext = appContext;
    }

    @Given("I am an appraisal app user")
    public void iAmAAppraisalAppUser(List<String> credentials) {
        appContext
                .setUsername(credentials.get(0))
                .setPassword(credentials.get(1));
    }

    @And("I login to the appraisal application")
    public void iLoginToTheAppraisalApplication() {
        homePage
                .goTo()
                .clickLoginLink();
        loginPage.enterEmail(appContext.getUsername())
                .enterPassword(appContext.getPassword())
                .clickSubmit();
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

    @When("I click on logout")
    public void iClickOnLogout() {
        homePage.clickLogoutLink();
    }

    @When("I click on Team")
    public void iClickOnTeam() {
        homePage.goToTeam();
    }

}
