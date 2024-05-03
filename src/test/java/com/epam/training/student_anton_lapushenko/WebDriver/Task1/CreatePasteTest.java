package com.epam.training.student_anton_lapushenko.WebDriver.Task1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CreatePasteTest extends BaseChromeTest {

    @BeforeEach
    public void navigate() {
        driver.get("https://pastebin.com/");
    }

    @Test
    public void testCreatePaste() {
        CreateNewPastePage createNewPastePage = new CreateNewPastePage(driver);

        String text = "Hello from WebDriver";

        String nameOrTitle = "helloweb";

        PastePage pastePage = createNewPastePage.createPaste(text, nameOrTitle, ExpirationTime.TenMin);

        assertEquals(nameOrTitle, pastePage.getNameOrTitle());
        assertEquals(ExpirationTime.TenMin.text, pastePage.getExpireTime());
        assertEquals(text, pastePage.getText());
    }
}
