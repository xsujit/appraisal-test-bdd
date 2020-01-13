package step_definitions.register;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.Employee;
import pages.HomePage;
import pages.Register;
import step_definitions.BaseSteps;

import java.util.Map;

public class RegisterSteps {

    WebDriver driver;
    String baseUrl;
    HomePage homePage;
    Register register;
    Employee employee;

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
        employee = new Employee(userDetails);
        driver.get(baseUrl + "/register");
        register.enterRegistrationForm(userDetails);
        register.selectSecondProject();
    }

    @And("click on submit")
    public void clickOnSubmit() {
        register.submit();
    }

    @Then("I should be registered")
    public void iShouldBeRegistered() {
        String sessionId = RestAssured
                .post("http://localhost:8080/login?username=jack.bauer@mastek.com&password=password")
                .cookies()
                .get("SESSION");

        String email = RestAssured
                .given()
                .cookie("SESSION", sessionId)
                .get("http://localhost:8080/admin/user")
                .andReturn()
                .getBody()
                .htmlPath()
                .getString("html.body.main.div.div.form.table.tbody.tr.td[4]");

        Assert.assertEquals(email, employee.getEmail());
    }

    @And("click on Register link")
    public void clickOnRegisterLink() {
        homePage.clickRegisterLink();
    }
}
