package com.appraisal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class AdminUserPage {

    @FindBy(tagName = "form")
    protected WebElement userForm;

    public List<String> getPendingUsers() {
        List<String> users = new ArrayList<>();
        WebElement table = userForm.findElements(By.tagName("table")).get(0);
        List<WebElement> userRows = table.findElements(By.tagName("tr"));
        for (WebElement userRow : userRows) {
            List<WebElement> userRecord = userRow.findElements(By.tagName("td"));
            users.add(userRecord.get(4).getText());
        }
        return users;
    }
}
