package com.epam.training.student_anton_lapushenko.WebDriver.Task3;

import com.epam.training.student_anton_lapushenko.WebDriver.Task2.factory.DriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

class BaseTest {
    protected WebDriver driver;
    Properties properties = new Properties();
    private final String CONFIG_FILE_PATH = "./src/test/resources/general.properties";

    @BeforeEach
    public void setUp() {
        String browser;
        try (Reader reader = new FileReader(CONFIG_FILE_PATH)) {
            properties.load(reader);
            browser = properties.getProperty("browser");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        driver = new DriverFactory().createInstance(browser);
    }
//
//    @AfterEach
//    void quitDriver() {
//        if(driver != null) {
//            driver.quit();
//        }
//    }
}
