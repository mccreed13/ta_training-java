package com.epam.training.student_anton_lapushenko.WebDriver.Task2;

import com.epam.training.student_anton_lapushenko.WebDriver.Task2.enums.ExpirationTime;
import com.epam.training.student_anton_lapushenko.WebDriver.Task2.pages.CreateNewPastePage;
import com.epam.training.student_anton_lapushenko.WebDriver.Task2.pages.PastePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreatePasteTest {
    protected WebDriver driver;

    @BeforeEach
    public void navigate() {
        driver = BrowserFactory.CHROME.createDriver();
        driver.get("https://pastebin.com/");
    }

    @Test
    public void testCreatePaste() {
        String text = "git config --global user.name \"New Sheriff in Town\"" +
                "\ngit reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")" +
                "\ngit push origin master --force";

        String nameOrTitle = "how to gain dominance among developers";

        PastePage pastePage = createPasteWithBashHighlighting(text, nameOrTitle, ExpirationTime.TenMin);

        assertEquals(nameOrTitle, pastePage.getNameOrTitle());
        assertEquals(ExpirationTime.TenMin.text, pastePage.getExpireTime());
        assertEquals("Bash", pastePage.getSyntaxHighlighting());
        assertEquals(text, pastePage.getText());
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

    @AfterEach
    void quitDriver() {
        if(driver != null) {
            driver.quit();
        }
    }
}
