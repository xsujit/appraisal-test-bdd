package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

@CucumberOptions(
        features = "classpath:features",
        glue = "step_definitions.register",
        tags = "@RegistrationTest"
)
public class RegisterTest extends AbstractTestNGCucumberTests {

    @BeforeMethod
    public void setup(ITestContext scenario) {
        System.out.println("Starting scenario " + scenario.getName());
    }

    @AfterTest
    public void tearDown(ITestContext scenario) {
        System.out.println("Status " + scenario.getPassedTests().toString());
    }

}

