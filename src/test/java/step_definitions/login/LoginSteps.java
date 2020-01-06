package step_definitions.login;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.HomePage;
import pages.Login;
import step_definitions.BaseSteps;

public class LoginSteps {

    WebDriver driver;
    HomePage homePage;
    Login login;
    String baseUrl;

    // dependency injection
    public LoginSteps(BaseSteps baseSteps) {
        driver = baseSteps.getDriver();
        baseUrl = baseSteps.getBaseUrl();
        homePage = baseSteps.getHomePage();
        login = PageFactory.initElements(driver, Login.class);
    }

    @Given("I open the appraisal application")
    public void iOpenTheAppraisalApplication() {
        driver.get(baseUrl);
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

    @And("click on Login link")
    public void clickOnLoginLink() {
        homePage.clickLoginLink();
    }
}
