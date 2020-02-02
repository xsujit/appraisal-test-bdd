package runner;

import gherkin.events.PickleEvent;
import gherkin.pickles.PickleStep;
import io.cucumber.testng.CucumberFeatureWrapper;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.PickleEventWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

@CucumberOptions(
        features = "classpath:features",
        glue = "step_definitions.login",
        tags = "@LoginTest"
)
public class LoginPageTest {

    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(
            groups = "Cucumber",
            description = "Runs Cucumber Feature",
            dataProvider = "scenarios"
    )
    public void scenario(PickleEventWrapper pickleEvent, CucumberFeatureWrapper cucumberFeature) throws Throwable {
        System.out.println("Feature: " + cucumberFeature.toString());
        PickleEvent event = pickleEvent.getPickleEvent();
        System.out.println("Scenario:  " + event.pickle.getName());
        List<PickleStep> steps = event.pickle.getSteps();
        for (PickleStep step : steps) {
            System.out.println(step.getText());
        }
        testNGCucumberRunner.runScenario(event);
    }

    @DataProvider
    public Object[][] scenarios() {
        return this.testNGCucumberRunner == null ? new Object[0][0] : this.testNGCucumberRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        if (this.testNGCucumberRunner != null) {
            this.testNGCucumberRunner.finish();
        }
    }
}
