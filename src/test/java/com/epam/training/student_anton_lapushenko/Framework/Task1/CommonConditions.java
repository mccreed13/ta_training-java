package com.epam.training.student_anton_lapushenko.Framework.Task1;

import com.epam.training.student_anton_lapushenko.Framework.Task1.driver.DriverSingleton;
import com.epam.training.student_anton_lapushenko.Framework.Task1.util.Screenshotter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

@ExtendWith(Screenshotter.class)
public class CommonConditions {
    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = DriverSingleton.getDriver();
    }

    @AfterEach
    public void stopBrowser() {
        DriverSingleton.closeDriver();
    }
}
