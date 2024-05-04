package com.epam.training.student_anton_lapushenko.WebDriver.Task2;

import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;

public abstract class BaseTest {
    protected WebDriver driver;

    @AfterEach
    void quitDriver() {
        if(driver != null) {
            driver.quit();
        }
    }
}
