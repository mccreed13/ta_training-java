package com.epam.training.student_anton_lapushenko.Framework.Task1.util;

import com.epam.training.student_anton_lapushenko.Framework.Task1.driver.DriverSingleton;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Screenshotter implements AfterTestExecutionCallback {
    Logger logger = LogManager.getRootLogger();
    String path = "target/screenshots";
    @Override
    public void afterTestExecution(ExtensionContext context){
        if(context.getExecutionException().isPresent()){
            File screenCapture = ((TakesScreenshot) DriverSingleton
                    .getDriver())
                    .getScreenshotAs(OutputType.FILE);
            try {
                new File(path).mkdirs();
                FileUtils.copyFile(screenCapture, new File(path +
                        "/" +
                        getCurrentTimeAsString() +
                        ".png"));
                logger.info("Screenshot captured ");
            } catch (IOException | WebDriverException e) {
                logger.error("Screenshot failed:" + e.getMessage());
            }
        }
    }
    private String getCurrentTimeAsString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd_HH-mm-ss");
        return ZonedDateTime.now().format(formatter);
    }
}
