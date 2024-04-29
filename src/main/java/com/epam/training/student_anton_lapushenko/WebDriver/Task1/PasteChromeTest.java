package com.epam.training.student_anton_lapushenko.WebDriver.Task1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.jupiter.api.Test;

import java.util.List;

public class PasteChromeTest {
    WebDriver driver;

    private final By textAreaBy = By.id("postform-text");
    private final By selectsBy = By.className("select2-container");
    private final By optionsBy = By.className("select2-results__option");
    private final By pasteNameOrTitleAreaBy = By.id("postform-name");
    private final By submitButtonBy = By.xpath("//*[@class='form-group form-btn-container']/button");

    private final String pasteText = "Hello from WebDriver";
    private final String nameOrTitleText = "helloweb";

    @BeforeEach
    void setUpChromeDriver() {
        driver = new ChromeDriver();
        driver.get("https://pastebin.com/");
    }

    @Test
    public void testCreatePaste() {
        List<WebElement> textarea = driver.findElements(textAreaBy);
        textarea.get(0).sendKeys(pasteText);

        List<WebElement> selects = driver.findElements(selectsBy);
        WebElement selectTime = selects.get(2);
        selectTime.click();

        List<WebElement> options = driver.findElements(optionsBy);
        WebElement optionTenMin = options.get(2);
        optionTenMin.click();

        List<WebElement> pasteNameTitle = driver.findElements(pasteNameOrTitleAreaBy);
        pasteNameTitle.get(0).sendKeys(nameOrTitleText);

        List<WebElement> submitButton = driver.findElements(submitButtonBy);
        submitButton.get(0).click();

    }

    @AfterEach
    void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
