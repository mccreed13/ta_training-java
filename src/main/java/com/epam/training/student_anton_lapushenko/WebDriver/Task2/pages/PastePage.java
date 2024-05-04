package com.epam.training.student_anton_lapushenko.WebDriver.Task2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PastePage {
    WebDriver driver;

    private final By nameOrTitleBy = By.xpath("//*[@class='info-top']/h1");
    private final By expireTimeBy = By.className("expire");
    private final By textBy = By.className("source");
    private final By syntaxHighlightingBy = By.xpath("//*[@class='left']/a[1]");

    public PastePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getNameOrTitle() {
        WebElement nameOrTitle = driver.findElement(nameOrTitleBy);
        return nameOrTitle.getText();
    }

    public String getExpireTime() {
        WebElement expireTime = driver.findElement(expireTimeBy);
        return expireTime.getText();
    }

    public String getSyntaxHighlighting() {
        WebElement syntaxHighlighting = driver.findElement(syntaxHighlightingBy);
        return syntaxHighlighting.getText();
    }

    public String getText() {
        WebElement text = driver.findElement(textBy);
        return text.getText();
    }
}
