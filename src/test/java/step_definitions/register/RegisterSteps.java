package step_definitions.register;

import com.google.inject.Inject;
import cucumber.runtime.java.guice.ScenarioScoped;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.Employee;
import pages.HomePage;
import pages.Register;
import step_definitions.BaseSteps;

import java.util.List;
import java.util.Map;

@ScenarioScoped
public class RegisterSteps {

    WebDriver driver;
    String baseUrl;
    HomePage homePage;
    Register register;
    Employee employee;

    @Inject
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
    public void iEnterMyDetailsOnTheRegistrationPage(List<Map<String, String>> userDetails) {
        driver.get(baseUrl + "/register");
        for (Map<String, String> userDetail : userDetails) {
            employee = new Employee(userDetail);
            register.enterRegistrationForm(userDetail);
            register.selectSecondProject();
        }
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

        XmlPath htmlPage = RestAssured
                .given()
                .cookie("SESSION", sessionId)
                .get("http://localhost:8080/admin/user")
                .andReturn()
                .getBody()
                .htmlPath();

        String form = htmlPage.getString("html.body.main.div.div.form");
        Assert.assertTrue(form.contains(employee.getEmail()));
    }

    @And("click on Register link")
    public void clickOnRegisterLink() {
        homePage.clickRegisterLink();
    }

    @Then("page should be redirected to {string}")
    public void pageShouldBeRedirectedTo(String path) {
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, baseUrl + path);
    }
}
