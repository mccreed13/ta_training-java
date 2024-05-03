package com.epam.training.student_anton_lapushenko.WebDriver.Task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

class CreateNewPastePage {
    protected WebDriver driver;

    private final By textAreaBy = By.id("postform-text");
    private final By selectsBy = By.className("select2-container");
    private final By optionsBy = By.className("select2-results__option");
    private final By pasteNameOrTitleAreaBy = By.id("postform-name");
    private final By submitButtonBy = By.xpath("//*[@class='form-group form-btn-container']/button");

    public CreateNewPastePage(WebDriver driver) {
        this.driver = driver;
        if (!driver.getCurrentUrl().equals("https://pastebin.com/")) {
            throw new IllegalStateException("This is not Create New Paste Page," +
                    " current page is: " + driver.getCurrentUrl());
        }
    }

    public PastePage createPaste(String text, String nameOrTitle, ExpirationTime expirationTime) {
        setText(text);
        List<WebElement> selects = driver.findElements(selectsBy);
        setExpirationTime(selects, expirationTime);
        setNameOrTitle(nameOrTitle);
        clickSubmit();
        return new PastePage(driver);
    }

    private void setText(String text) {
        List<WebElement> textarea = driver.findElements(textAreaBy);
        textarea.get(0).sendKeys(text);
    }

    private void setNameOrTitle(String nameOrTitle) {
        List<WebElement> pasteNameTitle = driver.findElements(pasteNameOrTitleAreaBy);
        pasteNameTitle.get(0).sendKeys(nameOrTitle);
    }

    private void setExpirationTime(List<WebElement> selects, ExpirationTime expirationTime) {
        selects.get(2).click();

        List<WebElement> options = driver.findElements(optionsBy);
        options.get(expirationTime.ordinal()).click();
    }

    private void clickSubmit() {
        WebElement submitButton = driver.findElement(submitButtonBy);
        submitButton.click();
    }
}
