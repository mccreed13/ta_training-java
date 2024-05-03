package com.epam.training.student_anton_lapushenko.WebDriver.Task1;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;

class BaseChromeTest extends BaseTest {

    @BeforeEach
    void setUpChromeDriver() {
        driver = new ChromeDriver();
    }
}
