package com.appraisal.context;

import com.appraisal.conf.ConfigFileReader;
import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;

import java.util.Properties;

@ScenarioScoped
public class ApplicantContext {

    private final Properties properties;
    private String username;
    private String password;

    @Inject
    public ApplicantContext(ConfigFileReader configFileReader) {
        this.properties = configFileReader.getProp();
    }

    public String getBaseUrl() {
        return properties.getProperty("url") + ":" + properties.getProperty("port");
    }

    public String getUsername() {
        return username;
    }

    public ApplicantContext setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
