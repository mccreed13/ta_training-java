package com.epam.training.student_anton_lapushenko.WebDriver.Task2;

import com.epam.training.student_anton_lapushenko.WebDriver.Task2.enums.ExpirationTime;
import com.epam.training.student_anton_lapushenko.WebDriver.Task2.pages.PastePage;
import com.epam.training.student_anton_lapushenko.WebDriver.Task2.steps.CreatePasteSteps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreatePasteTest extends BaseTest{
    @BeforeEach
    public void navigate() {
        driver.get("https://pastebin.com/");
    }

    @Test
    public void testCreatePaste() {
        String text = "git config --global user.name \"New Sheriff in Town\"" +
                "\ngit reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")" +
                "\ngit push origin master --force";

        String nameOrTitle = "how to gain dominance among developers";

        PastePage pastePage = new CreatePasteSteps(driver)
                .createPasteWithBashHighlighting(text, nameOrTitle, ExpirationTime.TenMin);

        assertEquals(nameOrTitle, pastePage.getNameOrTitle());
        assertEquals(ExpirationTime.TenMin.text, pastePage.getExpireTime());
        assertEquals("Bash", pastePage.getSyntaxHighlighting());
        assertEquals(text, pastePage.getText());
    }




}
