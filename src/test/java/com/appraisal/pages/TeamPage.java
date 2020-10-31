package com.appraisal.pages;

import com.appraisal.model.TeamTable;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.log4testng.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeamPage {

    private final WebDriver driver;
    private static final Logger logger = Logger.getLogger(LoginPage.class);

    @FindBy(css = "#myTable > tr:nth-child(1) > td:nth-child(5) > a:nth-child(1)")
    WebElement tableLink;

    @FindBy(css = ".table")
    WebElement table;

    @Inject
    public TeamPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
    }

    public void clickTableLink() {
        logger.info(driver.getTitle());
        tableLink.click();
    }

    public List<TeamTable> readTable() throws JsonProcessingException {
        List<Map<String, String>> tableList = new ArrayList<>();
        WebElement tBody = table.findElement(By.tagName("tbody"));
        List<WebElement> rows = tBody.findElements(By.tagName("tr"));
        List<WebElement> headers = table.findElements(By.tagName("th"));
        for (WebElement row : rows) {
            List<WebElement> columns = row.findElements(By.tagName("td"));
            Map<String, String> temp = new HashMap<>();
            for (WebElement column : columns)
                temp.put(headers.get(columns.indexOf(column)).getText(), column.getText());
            tableList.add(temp);
        }
        List<JSONObject> jsonObjects = new ArrayList<>();
        List<TeamTable> teamTables = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        for (Map<String, String> row : tableList)
            jsonObjects.add(new JSONObject(row));
        for (JSONObject jsonObject : jsonObjects) {
            teamTables.add(objectMapper.readValue(jsonObject.toString(), TeamTable.class));
        }
        return teamTables;
    }

    public List<TeamTable> readTableByXpath() throws JsonProcessingException {
        List<JSONObject> jsonObjects = new ArrayList<>();
        WebElement header = table.findElement(By.tagName("thead"));
        List<WebElement> headerCols = header.findElements(By.tagName("th"));
        int headerSize = headerCols.size();
        WebElement body = table.findElement(By.tagName("tbody"));
        List<WebElement> rows = body.findElements(By.tagName("tr"));
        int totalRows = rows.size();
        for (int i = 1; i <= totalRows; i++) {
            JSONObject jsonObject = new JSONObject();
            for (int j = 1; j <= headerSize; j++) {
                String path = "//tr/th[%d]";
                String key = header.findElement(By.xpath(String.format(path, j))).getText();
                path = "//tr[%d]/td[%d]";
                String value = body.findElement(By.xpath(String.format(path, i, j))).getText();
                jsonObject.put(key, value);
            }
            jsonObjects.add(jsonObject);
        }
        List<TeamTable> teamTables = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        for (JSONObject jsonObject : jsonObjects) {
            teamTables.add(objectMapper.readValue(jsonObject.toString(), TeamTable.class));
        }
        return teamTables;
    }

}
