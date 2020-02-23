package com.appraisal.context;

import com.appraisal.conf.ConfigFileReader;
import com.appraisal.driver.DriverManager;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import io.cucumber.guice.ScenarioScoped;

import java.util.Properties;

@ScenarioScoped
public class ApplicantContext {

    private DriverManager driverManager;
    private Properties properties;

    @Inject
    public ApplicantContext(@Named("CHROME") DriverManager driverManager, ConfigFileReader configFileReader) {
        this.driverManager = driverManager;
        this.properties = configFileReader.getProp();
    }

    public DriverManager getDriverManager() {
        return driverManager;
    }

    public Properties getProperties() {
        return properties;
    }

    public String getBaseUrl() {
        return properties.getProperty("url") + ":" + properties.getProperty("port");
    }

}
