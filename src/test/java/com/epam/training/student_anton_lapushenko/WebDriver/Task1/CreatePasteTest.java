package com.epam.training.student_anton_lapushenko.WebDriver.Task1;

import com.epam.training.student_anton_lapushenko.WebDriver.Task1.enums.ExpirationTime;
import com.epam.training.student_anton_lapushenko.WebDriver.Task1.factory.BrowserFactory;
import com.epam.training.student_anton_lapushenko.WebDriver.Task1.pages.CreateNewPastePage;
import com.epam.training.student_anton_lapushenko.WebDriver.Task1.pages.PastePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CreatePasteTest{
    protected WebDriver driver;

    @BeforeEach
    public void navigate() {
        driver = BrowserFactory.CHROME.createDriver();
        driver.get("https://pastebin.com/");
    }

    @Test
    public void testCreatePaste() {
        String text = "Hello from WebDriver";

        String nameOrTitle = "helloweb";

        PastePage pastePage = createPaste(text, nameOrTitle, ExpirationTime.TenMin);

        assertEquals(nameOrTitle, pastePage.getNameOrTitle());
        assertEquals(ExpirationTime.TenMin.text, pastePage.getExpireTime());
        assertEquals(text, pastePage.getText());
    }

    public PastePage createPaste(String text, String nameOrTitle, ExpirationTime expirationTime) {
        CreateNewPastePage createNewPastePage = new CreateNewPastePage(driver);
        createNewPastePage.setText(text);
        createNewPastePage.setExpirationTime(expirationTime);
        createNewPastePage.setNameOrTitle(nameOrTitle);
        createNewPastePage.clickSubmit();
        return new PastePage(driver);
    }

    @AfterEach
    void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
