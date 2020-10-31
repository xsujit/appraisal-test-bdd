package com.appraisal.driver;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;

public class FirefoxDriverManager extends DriverManager {

    private static GeckoDriverService service;

    @Override
    public void startService() {
        if (null == service) {
            try {
                service = new GeckoDriverService.Builder()
                        .usingDriverExecutable(new File("geckodriver.exe"))
                        .usingAnyFreePort()
                        .build();
                service.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void stopService() {
        if (null != service && service.isRunning())
            service.stop();
    }

    @Override
    public void createDriver() {
        startService();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("test-type");
        driver = new RemoteWebDriver(service.getUrl(), options);
        // com.appraisal.driver = new ChromeDriver(service, new ChromeOptions());
    }
}
