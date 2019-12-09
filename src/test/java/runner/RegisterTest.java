package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "classpath:features",
        glue = "step_definitions.register",
        tags = "@RegistrationTest"
)
public class RegisterTest extends AbstractTestNGCucumberTests {
}
