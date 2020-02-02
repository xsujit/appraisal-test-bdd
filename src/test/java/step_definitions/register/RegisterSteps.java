package step_definitions.register;

import com.google.inject.Inject;
import cucumber.runtime.java.guice.ScenarioScoped;
import domain.Employee;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import org.testng.Assert;
import pages.Register;
import step_definitions.utils.StepUtil;

import java.util.List;
import java.util.Map;

@ScenarioScoped
public class RegisterSteps {

    Register register;
    Employee employee;

    @Inject
    public RegisterSteps(StepUtil stepUtil) {
        register = stepUtil.getRegisterPage();
    }

    /*
    @Given("I open the {string} page")
    public void iOpenThePage(String page) {
        switch (page) {
            case "register":
                register.goTo();
                break;
            case "login":
                // pending
                break;
            default:
                System.out.println("No matching page");
        }
    }
    */

    @When("I enter my details on the registration page")
    public void iEnterMyDetailsOnTheRegistrationPage(List<Map<String, String>> userDetails) {
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

    @Then("page should be redirected to {string}")
    public void pageShouldBeRedirectedTo(String path) {
        Assert.assertEquals(register.getCurrentUrl(), register.getBaseUrl() + path);
    }

}
