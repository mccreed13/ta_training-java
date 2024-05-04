package com.epam.training.student_anton_lapushenko.WebDriver.Task2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public enum BrowserFactory {
    CHROME {
        @Override
        public WebDriver createDriver() {
            return new ChromeDriver();
        }
    },
    FIREFOX{
        @Override
        public WebDriver createDriver() {
            return new FirefoxDriver();
        }
    };

    public abstract WebDriver createDriver();

}
