package com.epam.training.student_anton_lapushenko.WebDriver.Task3.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class GoogleCloudSearchPage {
    WebDriver driver;

    private final By searchCalculatorResultBy = By.xpath("/html/body/c-wiz[2]/div/div/div/div/div/div[3]/c-wiz/div[1]/div[1]/div/div");

    public GoogleCloudSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public GoogleCloudCalculatorPage openCalculator() {
        List<WebElement> element = driver.findElements(searchCalculatorResultBy);
        System.out.println(element.size());
        element.get(0).click();
        return new GoogleCloudCalculatorPage(driver);
    }
}
