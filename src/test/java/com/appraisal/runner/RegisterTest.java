package com.appraisal.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "classpath:features",
        glue = "com/appraisal/step_definitions",
        tags = "@RegistrationTest"
)
public class RegisterTest extends AbstractTestNGCucumberTests {

}

