package step_definitions.register;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.HomePage;
import pages.Register;
import step_definitions.BaseSteps;

import java.util.Map;

public class RegisterSteps {

    WebDriver driver;
    String baseUrl;
    HomePage homePage;
    Register register;

    // dependency injection
    public RegisterSteps(BaseSteps baseSteps) {
        driver = baseSteps.getDriver();
        baseUrl = baseSteps.getBaseUrl();
        homePage = baseSteps.getHomePage();
        register = PageFactory.initElements(driver, Register.class);
    }

    @Given("I open the appraisal application")
    public void iOpenTheAppraisalApplication() {
        driver.get(baseUrl);
    }

    @When("I enter my details on the registration page")
    public void iEnterMyDetailsOnTheRegistrationPage(Map<String, String> userDetails) {
        driver.get(baseUrl + "/register");
        register.enterRegistrationForm(userDetails);
        register.selectFirstProject();
    }

    @And("click on submit")
    public void clickOnSubmit() {
        register.submit();
    }

    @Then("I should be registered")
    public void iShouldBeRegistered() {
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "/login");
    }

    @And("click on Register link")
    public void clickOnRegisterLink() {
        homePage.clickRegisterLink();
    }
}
