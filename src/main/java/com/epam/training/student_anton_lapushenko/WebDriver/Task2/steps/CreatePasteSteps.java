package com.epam.training.student_anton_lapushenko.WebDriver.Task2.steps;

import com.epam.training.student_anton_lapushenko.WebDriver.Task2.enums.ExpirationTime;
import com.epam.training.student_anton_lapushenko.WebDriver.Task2.pages.CreateNewPastePage;
import com.epam.training.student_anton_lapushenko.WebDriver.Task2.pages.PastePage;
import org.openqa.selenium.WebDriver;

public class CreatePasteSteps {
    WebDriver driver;

    public CreatePasteSteps(WebDriver driver) {
        this.driver = driver;
    }

    public PastePage createPasteWithBashHighlighting(String text, String nameOrTitle, ExpirationTime expirationTime) {
        CreateNewPastePage createNewPastePage = new CreateNewPastePage(driver);
        createNewPastePage.setText(text);
        createNewPastePage.setBashHighlighting();
        createNewPastePage.setExpirationTime(expirationTime);
        createNewPastePage.setNameOrTitle(nameOrTitle);
        createNewPastePage.clickSubmit();
        return new PastePage(driver);
    }
}
