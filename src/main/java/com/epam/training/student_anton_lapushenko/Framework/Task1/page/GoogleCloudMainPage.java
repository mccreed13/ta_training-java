package com.epam.training.student_anton_lapushenko.Framework.Task1.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleCloudMainPage {
    WebDriver driver;
    private final String PAGE_URL = "https://cloud.google.com/";
    private final By searchOpenButtonBy = By.className("YSM5S");
    private final By searchFieldBy = By.id("i4");
    private final By searchButtonBy = By.xpath("//i[@aria-label='Search']");

    public GoogleCloudMainPage(WebDriver driver) {
        this.driver = driver;
    }

    public GoogleCloudMainPage openPage(){
        driver.get(PAGE_URL);
        return this;
    }

    public GoogleCloudSearchPage searchCalculator() {
        WebElement searchOpenButton = driver.findElement(searchOpenButtonBy);
        searchOpenButton.click();
        WebElement searchField = driver.findElement(searchFieldBy);
        String calculatorSearchText = "Google Cloud Platform Pricing Calculator";
        searchField.sendKeys(calculatorSearchText);
        WebElement searchButton = driver.findElement(searchButtonBy);
        searchButton.click();
        return new GoogleCloudSearchPage(driver);
    }
}
