package com.appraisal.driver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.log4testng.Logger;

import java.io.File;

public class ChromeDriverManager extends DriverManager {

    private ChromeDriverService service;
    private static final Logger logger = Logger.getLogger(ChromeDriverManager.class);

    @Override
    public void startService() {
        if (service == null) {
            try {
                service = new ChromeDriverService.Builder()
                        .usingDriverExecutable(new File("chromedriver.exe"))
                        .usingAnyFreePort()
                        .build();
                service.start();
            } catch (Exception e) {
                logger.error("Error starting the chrome driver service: ", e);
            }
        }
    }

    @Override
    public void stopService() {
        if (service != null && service.isRunning())
            service.stop();
    }

    @Override
    public void createDriver() {
        startService();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type");
        //options.setHeadless(true);
        //driver = new RemoteWebDriver(service.getUrl(), capabilities);
        options.setCapability("browserName", "firefox");
        options.setCapability("platform", "WINDOWS");
        logger.info(options.getPlatform());
        logger.info(options.getBrowserName());
        driver = new ChromeDriver(service, options);
        // com.appraisal.driver = new ChromeDriver(service, new ChromeOptions());
    }
}
