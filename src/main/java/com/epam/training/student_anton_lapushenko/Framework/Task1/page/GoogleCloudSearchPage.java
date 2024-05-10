package com.epam.training.student_anton_lapushenko.Framework.Task1.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleCloudSearchPage {
    WebDriver driver;

    private final By searchCalculatorResultBy = By.xpath("//a[@track-type='search-result' and @track-metadata-eventdetail='cloud.google.com/products/calculator']");

    public GoogleCloudSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public GoogleCloudCalculatorPage openCalculator() {
        WebElement element = driver.findElement(searchCalculatorResultBy);
        element.click();
        return new GoogleCloudCalculatorPage(driver);
    }
}
