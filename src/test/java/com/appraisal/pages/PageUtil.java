package com.appraisal.pages;

import com.appraisal.conf.ConfigFileReader;
import com.appraisal.driver.DriverManager;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import java.util.Properties;

public class PageUtil {

    private DriverManager driverManager;
    private Properties properties;

    @Inject
    public PageUtil(@Named("CHROME") DriverManager driverManager, ConfigFileReader configFileReader) {
        this.driverManager = driverManager;
        properties = configFileReader.getProp();
    }

    public String getBaseUrl() {
        return properties.getProperty("url") + ":" + properties.getProperty("port");
    }

    public DriverManager getDriverManager() {
        return driverManager;
    }
}
