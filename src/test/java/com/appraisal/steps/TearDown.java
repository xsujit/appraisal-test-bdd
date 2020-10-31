package com.appraisal.steps;

import com.google.inject.Inject;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;

public class TearDown {

    WebDriver driver;

    @Inject
    public TearDown(WebDriver driver) {
        this.driver = driver;
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}
