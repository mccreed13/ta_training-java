package com.epam.training.student_anton_lapushenko.Framework.Task1.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class SummaryPage {
    WebDriver driver;

    private final By instanceNumbersBy = By.xpath("//*[preceding-sibling::span[contains(text(), 'Number of Instances')]]");
    private final By operationSystemBy = By.xpath("//span[preceding-sibling::span[contains(text(), 'Operating System')]]");
    private final By provisioningModelBy = By.xpath("//span[preceding-sibling::span[contains(text(), 'Provisioning Model')]]");
    private final By machineTypeBy = By.xpath("//span[preceding-sibling::span[contains(text(), 'Machine type')]]");
    private final By GPUTypeBy = By.xpath("//span[preceding-sibling::span[contains(text(), 'GPU Model')]]");
    private final By NumberOfGPUBy = By.xpath("//span[preceding-sibling::span[contains(text(), 'Number of GPUs')]]");
    private final By localSSDBy = By.xpath("//span[preceding-sibling::span[contains(text(), 'Local SSD')]]");
    private final By locationBy = By.xpath("//span[preceding-sibling::span[contains(text(), 'Region')]]");
    private final By commitedUsageBy = By.xpath("//span[preceding-sibling::span[contains(text(), 'Committed use discount options')]]");

    public SummaryPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getInstanceNumber() {
        WebElement instanceNumber = driver.findElement(instanceNumbersBy);
        return instanceNumber.getText();
    }

    public String getOperatingSystem() {
        WebElement operationSystem = driver.findElement(operationSystemBy);
        return operationSystem.getText();
    }

    public String getProvisioningModel() {
        WebElement provisioningModel = driver.findElement(provisioningModelBy);
        return provisioningModel.getText();
    }

    public String getMachineType() {
        WebElement machineType = driver.findElement(machineTypeBy);
        return machineType.getText().split(",")[0];
    }

    public String getGPUType() {
        WebElement GPUType = driver.findElement(GPUTypeBy);
        return GPUType.getText();
    }

    public String getNumberOfGPU() {
        WebElement numberOfGPU = driver.findElement(NumberOfGPUBy);
        return numberOfGPU.getText();
    }

    public String getLocalSSD() {
        WebElement localSSD = driver.findElement(localSSDBy);
        return localSSD.getText();
    }

    public String getLocation() {
        WebElement location = driver.findElement(locationBy);
        return location.getText();
    }

    public String getCommitedUsage() {
        WebElement commitedUsage = driver.findElement(commitedUsageBy);
        return commitedUsage.getText();
    }
}
