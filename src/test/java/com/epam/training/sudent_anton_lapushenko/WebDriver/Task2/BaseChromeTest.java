package com.epam.training.sudent_anton_lapushenko.WebDriver.Task2;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseChromeTest extends BaseTest{

    @BeforeEach
    void setUpChromeDriver() {
        driver = new ChromeDriver();
    }
}
