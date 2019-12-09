package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "classpath:features",
        glue = "step_definitions.login",
        tags = "@LoginTest"
)
public class LoginTest extends AbstractTestNGCucumberTests {

}
