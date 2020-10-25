package com.appraisal.steps;

import com.appraisal.context.ApplicantContext;
import com.appraisal.model.TeamTable;
import com.appraisal.pages.TeamPage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.And;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.log4testng.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@ScenarioScoped
public class HomeSteps {

    private final ApplicantContext applicantContext;
    private static final Logger logger = Logger.getLogger(HomeSteps.class);

    @Inject
    public HomeSteps(ApplicantContext applicantContext) {
        logger.info("HomeSteps initialized");
        this.applicantContext = applicantContext;
    }

    @And("I click on view")
    public void iClickOnView() throws JsonProcessingException {
        List<TeamTable> actuates = new TeamPage(applicantContext).readTableByXpath();
        String jack = "{\"First Name\":\"George\",\"Employee Id\":\"11227\",\"Appraisal\":\"View\",\"My Vote\":\"\",\"Sr. No\":\"1\",\"Last Name\":\"Bauer\"}";
        String james = "{\"First Name\":\"James\",\"Employee Id\":\"11228\",\"Appraisal\":\"View\",\"My Vote\":\"\",\"Sr. No\":\"2\",\"Last Name\":\"Bond\"}";
        String stuart = "{\"First Name\":\"Stuart\",\"Employee Id\":\"11229\",\"Appraisal\":\"View\",\"My Vote\":\"\",\"Sr. No\":\"3\",\"Last Name\":\"Little\"}";
        String george = "{\"First Name\":\"George\",\"Employee Id\":\"11230\",\"Appraisal\":\"View\",\"My Vote\":\"\",\"Sr. No\":\"4\",\"Last Name\":\"Mason\"}";
        List<JSONObject> jsonObjects = new ArrayList<>();
        List<TeamTable> teamTables = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        jsonObjects.add(new JSONObject(james));
        jsonObjects.add(new JSONObject(stuart));
        jsonObjects.add(new JSONObject(george));
        jsonObjects.add(new JSONObject(jack));
        for (JSONObject jsonObject : jsonObjects) {
            teamTables.add(objectMapper.readValue(jsonObject.toString(), TeamTable.class));
        }
        for (TeamTable actual : actuates) {
            logger.info(actual);
        }
        for (TeamTable actual : teamTables) {
            logger.info(actual);
        }
        actuates.sort(Comparator.comparing(TeamTable::getFirstName));
        teamTables.sort(Comparator.comparing(TeamTable::getFirstName));
        actuates.sort(Comparator.comparing(TeamTable::getEmployeeId));
        teamTables.sort(Comparator.comparing(TeamTable::getEmployeeId));
        for (TeamTable actual : actuates) {
            logger.info(actual);
        }
        for (TeamTable actual : teamTables) {
            logger.info(actual);
        }
        logger.info(actuates.equals(teamTables));
        Assert.assertEquals(teamTables, actuates);
    }
}
