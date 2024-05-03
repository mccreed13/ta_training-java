package com.epam.training.sudent_anton_lapushenko.WebDriver.Task2;

import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    protected WebDriver driver;

    @AfterEach
    void quitDriver() {
        if(driver != null) {
            driver.quit();
        }
    }
}
