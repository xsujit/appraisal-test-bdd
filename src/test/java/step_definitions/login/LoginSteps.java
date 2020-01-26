package step_definitions.login;

import cucumber.runtime.java.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.Login;
import step_definitions.BaseSteps;

@ScenarioScoped
public class LoginSteps extends BaseSteps {

    Login login;
    HomePage homePage;

    public LoginSteps() {
        login = getInjector().getInstance(Login.class);
        homePage = getInjector().getInstance(HomePage.class);
    }

    @Given("I open the {string} page")
    public void iOpenThePage(String page) {
        switch (page) {
            case "register":
                // pending
                break;
            case "login":
                login.goTo();
                break;
            default:
                System.out.println("No matching page");
        }
    }

    @Given("I have valid {string} and {string}")
    public void iHaveValidAnd(String username, String password) {
        login.enterEmail(username);
        login.enterPassword(password);
    }

    @When("I click on login")
    public void iClickOnLogin() {
        login.clickSubmit();
    }

    @Then("I should be logged in")
    public void iShouldBeLoggedIn() {
        Assert.assertEquals(homePage.getBanner(), "Hello, welcome to appraisal 2018");
    }

}
