package com.epam.training.student_anton_lapushenko.Framework.Task1;

import com.epam.training.student_anton_lapushenko.Framework.Task1.driver.DriverSingleton;
import com.epam.training.student_anton_lapushenko.Framework.Task1.util.ScreenshotWatcher;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.WebDriver;

public class CommonConditions {
    protected WebDriver driver;

    @RegisterExtension
    ScreenshotWatcher screenshotWatcher = new ScreenshotWatcher("target/screenshots");

    @BeforeEach
    public void setUp() {
        driver = DriverSingleton.getDriver();
    }

    @AfterEach
    public void stopBrowser() {
        DriverSingleton.closeDriver();
    }
}
