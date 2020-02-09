package com.appraisal.driver;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {

    protected WebDriver driver;

    protected abstract void startService();

    protected abstract void stopService();

    protected abstract void createDriver();

    public void quitDriver() {
        if (null != driver) {
            driver.quit();
            driver = null;
            stopService();
        }
    }

    public WebDriver getDriver() {
        if (null == driver) {
            createDriver();
        }
        return driver;
    }
}
