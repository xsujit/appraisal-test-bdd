package step_definitions.login;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.HomePage;
import pages.Login;

public class LoginSteps {

    WebDriver driver = new ChromeDriver();
    HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    Login login = PageFactory.initElements(driver, Login.class);

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
