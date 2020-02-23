package com.appraisal.steps;

import com.appraisal.context.ApplicantContext;
import com.google.inject.Inject;
import io.cucumber.java.After;

public class TearDown {

    ApplicantContext applicantContext;

    @Inject
    public TearDown(ApplicantContext applicantContext) {
        this.applicantContext = applicantContext;
    }

    @After
    public void closeBrowser() {
        applicantContext.getDriverManager().quitDriver();
    }
}
