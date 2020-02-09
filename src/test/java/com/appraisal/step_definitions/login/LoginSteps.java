package com.appraisal.step_definitions.login;

import com.appraisal.pages.HomePage;
import com.appraisal.pages.LoginPage;
import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

@ScenarioScoped
public class LoginSteps {

    LoginPage loginPage;
    HomePage homePage;

    @Inject
    public LoginSteps(LoginPage loginPage, HomePage homePage) {
        this.loginPage = loginPage;
        this.homePage = homePage;
    }

    @Given("I open the {string} page")
    public void iOpenThePage(String page) {
        switch (page) {
            case "register":
                // TODO
                break;
            case "login":
                loginPage.goTo();
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
        Assert.assertEquals(homePage.getBanner(), "Hello, welcome to appraisal 2018");
    }

}
