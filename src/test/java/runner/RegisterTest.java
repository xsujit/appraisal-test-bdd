package runner;

import io.cucumber.core.api.Scenario;
import io.cucumber.core.event.Status;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.util.Arrays;

@CucumberOptions(
        features = "classpath:features",
        glue = "step_definitions",
        tags = "@RegistrationTest"
)
public class RegisterTest extends AbstractTestNGCucumberTests {

    private TestNGCucumberRunner testNGCucumberRunner;
    // private ITestContext iTestContext;

    public RegisterTest() {
        this.testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @BeforeMethod
    public void setup() {

        System.out.println("Starting scenario " + Arrays.deepToString(provideScenarios()));
    }

    @AfterTest
    public void tearDown() {
        System.out.println("Status ");
    }

    @DataProvider
    public Object[][] provideScenarios() {
        return testNGCucumberRunner.provideScenarios();
    }

    @DataProvider
    public Object[] getName(Scenario scenario) {
        return new Status[]{scenario.getStatus()};
    }
}

