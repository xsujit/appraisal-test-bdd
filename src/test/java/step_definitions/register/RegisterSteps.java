package step_definitions.register;

import conf.ConfigFileReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.HomePage;
import pages.Register;

import java.util.Map;

public class RegisterSteps {

    WebDriver driver = new ChromeDriver();
    Register register = PageFactory.initElements(driver, Register.class);
    HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    ConfigFileReader configFileReader = new ConfigFileReader();
    String baseUrl = configFileReader.getProp().getProperty("url") + ":" + configFileReader.getProp().getProperty("port");

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
