package com.epam.training.student_anton_lapushenko.WebDriver.Task1.pages;

import com.epam.training.student_anton_lapushenko.WebDriver.Task1.enums.ExpirationTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CreateNewPastePage {
    protected WebDriver driver;

    private final By textAreaBy = By.id("postform-text");
    private final By optionsBy = By.className("select2-results__option");
    private final By pasteNameOrTitleAreaBy = By.id("postform-name");
    private final By submitButtonBy = By.xpath("//*[@class='form-group form-btn-container']/button");
    private final By selectExpirationBy = By.xpath("//div[@class='form-group field-postform-expiration']//*[@class='selection']");

    public CreateNewPastePage(WebDriver driver) {
        this.driver = driver;
    }

    public void setText(String text) {
        WebElement textarea = driver.findElement(textAreaBy);
        textarea.sendKeys(text);
    }

    public void setNameOrTitle(String nameOrTitle) {
        WebElement pasteNameTitle = driver.findElement(pasteNameOrTitleAreaBy);
        pasteNameTitle.sendKeys(nameOrTitle);
    }

    public void setExpirationTime(ExpirationTime expirationTime) {
        WebElement selectExpiration = driver.findElement(selectExpirationBy);
        selectExpiration.click();

        List<WebElement> options = driver.findElements(optionsBy);
        options.get(expirationTime.ordinal()).click();
    }

    public void clickSubmit() {
        WebElement submitButton = driver.findElement(submitButtonBy);
        submitButton.click();
    }
}
