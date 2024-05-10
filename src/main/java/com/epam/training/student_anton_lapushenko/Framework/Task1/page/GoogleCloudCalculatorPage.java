package com.epam.training.student_anton_lapushenko.Framework.Task1.page;

import com.epam.training.student_anton_lapushenko.Framework.Task1.model.ComputerEngine;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class GoogleCloudCalculatorPage {
    WebDriver driver;

    private final static String PAGE_URL = "https://cloud.google.com/products/calculator";
    private final Logger logger = LogManager.getRootLogger();

    private final By addToEstimateButtonBy = By.xpath("//span[contains(text(), 'Add to estimate')]");
    private final By computerEngineBy = By.xpath("//div[@class='VobRQb' and contains(.,'Compute Engine')]");
    private final By countInstancesBy = By.id("c11");
    private final By operatingSoftwareOpenListBy = By.xpath("//div[@class='qUa9tb' and contains(.,'Operating System / Software')]//div[@class='VfPpkd-aPP78e']");
    private final By operatingSoftwareOptionsBy = By.xpath("//ul[@aria-label='Operating System / Software']/li");
    private final By provisioningModelRegularBy = By.xpath("//*[@class='zT2df' and text()='Regular']");
    private final By machineFamilyOpenListBy = By.xpath("//div[@class='O1htCb-H9tDt PPUDSe t8xIwc' and contains(.,'Machine Family')]//div[@class='VfPpkd-aPP78e']");
    private final By machineFamilyOptionsBy = By.xpath("//ul[@aria-label='Machine Family']/li");
    private final By seriasListOpenBy = By.xpath("//div[@class='O1htCb-H9tDt PPUDSe t8xIwc' and contains(.,'Series')]//div[@class='VfPpkd-aPP78e']");
    private final By seriasOptionsBy = By.xpath("//ul[@aria-label='Series']/li");
    private final By machineTypeListOpenBy = By.xpath("//div[@class='O1htCb-H9tDt PPUDSe t8xIwc' and contains(.,'Machine type')]//div[@class='VfPpkd-aPP78e']");
    private final By machineTypeOptionsBy = By.xpath("//ul[@aria-label='Machine type']/li");
    private final By checkboxAddGPUsBy = By.xpath("//button[@aria-label='Add GPUs']");
    private final By GPUModelListBy = By.xpath("//div[@class='qUa9tb' and contains(.,'GPU Model')]//div[@class='VfPpkd-aPP78e']");
    private final By GPUModelsOptionsBy = By.xpath("//ul[@aria-label='GPU Model']/li");
    private final By numberOfGPUsListBy = By.xpath("//div[@class='qUa9tb' and contains(.,'Number of GPUs')]//div[@class='VfPpkd-aPP78e']");
    private final By numberOfGPUsOptionsBy = By.xpath("//ul[@aria-label='Number of GPUs']/li");
    private final By numberOfLocalSSDsListOpenBy = By.xpath("//div[@class='qUa9tb' and contains(.,'Local SSD')]//div[@class='VfPpkd-aPP78e']");
    private final By numberOfLocalSSDsOptionsBy = By.xpath("//ul[@aria-label='Local SSD']/li");
    private final By regionsListButtonBy = By.xpath("//div[@class='qUa9tb' and contains(.,'Region')]//div[@class='VfPpkd-aPP78e']");
    private final By regionsOptionsBy = By.xpath("//ul[@aria-label='Region']/li");
    private final By committedUsageOneYearBy = By.xpath("//label[text()='1 year']");
    private final By totalEstimatedCostBy = By.xpath("//div[@class='KDVqKe']//label");
    private final By costBy = By.xpath("//div[@class='Z7Qi9d HY0Uh']");
    private final By shareButtonBy = By.xpath("//button[@aria-label='Open Share Estimate dialog']");
    private final By openEstimateSummaryBy = By.xpath("//a[@track-name='open estimate summary']");

    public GoogleCloudCalculatorPage(WebDriver driver) {
        this.driver = driver;
    }

    public GoogleCloudCalculatorPage openPage(){
        driver.get(PAGE_URL);
        return this;
    }

    public static String getPageURL(){
        return PAGE_URL;
    }

    public void setComputerEngine(ComputerEngine computerEngine){
        addComputerEngineToEstimate();
        setInstances(computerEngine.getInstances());
        setOperatingSoftware(computerEngine.getOperatingSoftware());
        setProvisioningModel(computerEngine.getProvisioningModel());
        setMachineFamily(computerEngine.getMachineFamily());
        setSeries(computerEngine.getSeries());
        setMachineType(computerEngine.getMachineType());
        if(computerEngine.getGpuModel() != null && computerEngine.getNumberOfGPUs() != null){
            addGPUs(computerEngine.getGpuModel(), computerEngine.getNumberOfGPUs());
        }
        setNumberOfLocalSSDs(computerEngine.getLocalSSD());
        setRegion(computerEngine.getLocation());
        setCommittedUsage(computerEngine.getCommitedUsage());
        logger.info("Estimated computer engine");
    }

    public void addComputerEngineToEstimate() {
        WebElement estimateButton = driver.findElement(addToEstimateButtonBy);
        estimateButton.click();
        WebElement computerEngineButton = driver.findElement(computerEngineBy);
        computerEngineButton.click();
    }

    public void setInstances(String instances) {
        WebElement countInstances = driver.findElement(countInstancesBy);
        countInstances.clear();
        countInstances.sendKeys(instances);
    }

    public void setOperatingSoftware(String operatingSoftware){
        WebElement operatingSoftwareListButton = driver.findElement(operatingSoftwareOpenListBy);
        operatingSoftwareListButton.click();
        List<WebElement> operatingSoftwareList = driver.findElements(operatingSoftwareOptionsBy);
        operatingSoftwareList.stream()
                .filter(webElement -> webElement.getText().contains(operatingSoftware))
                .findAny()
                .get()
                .click();
    }

    public void setProvisioningModel(String provisioningModel) {
        String xpath = String.format("//*[@class='zT2df' and text()='%s']", provisioningModel);
        WebElement provisioningModelElement = driver.findElement(By.xpath(xpath));
        provisioningModelElement.click();
    }

    public void setMachineFamily(String machineFamily) {
        WebElement machineFamilyListButton = driver.findElement(machineFamilyOpenListBy);
        machineFamilyListButton.click();
        List<WebElement> machineFamilyList = driver.findElements(machineFamilyOptionsBy);
        machineFamilyList.stream()
                .filter(webElement -> webElement.getText().contains(machineFamily))
                .findAny()
                .get()
                .click();
    }

    public void setSeries(String series) {
        WebElement seriesListButton = driver.findElement(seriasListOpenBy);
        seriesListButton.click();
        List<WebElement> seriesList = driver.findElements(seriasOptionsBy);
        seriesList.stream()
                .filter(webElement -> webElement.getText().contains(series))
                .findAny()
                .get()
                .click();
    }

    public void setMachineType(String machineType) {
        WebElement machineTypeListButton = driver.findElement(machineTypeListOpenBy);
        machineTypeListButton.click();
        List<WebElement> machineTypeList = driver.findElements(machineTypeOptionsBy);
        machineTypeList.stream()
                .filter(webElement -> webElement.getText().contains(machineType))
                .findAny()
                .get()
                .click();
    }

    public void addGPUs(String gpuModel, String  numberOfGPUs) {
        turnOnAddGPUs();
        setGPUModel(gpuModel);
        setNumberOfGPUs(numberOfGPUs);
    }

    private void turnOnAddGPUs() {
        WebElement addGPUsButton = driver.findElement(checkboxAddGPUsBy);
        addGPUsButton.click();
    }

    private void setGPUModel(String gpuModel) {
        WebElement gpuModelList = driver.findElement(GPUModelListBy);
        gpuModelList.click();
        List<WebElement> options = driver.findElements(GPUModelsOptionsBy);
        options.stream()
                .filter(webElement -> webElement.getText().contains(gpuModel))
                .findAny()
                .get()
                .click();
    }

    private void setNumberOfGPUs(String numberOfGPUs) {
        WebElement numberOfGPUsList = driver.findElement(numberOfGPUsListBy);
        numberOfGPUsList.click();
        List<WebElement> options = driver.findElements(numberOfGPUsOptionsBy);
        options.stream()
                .filter(webElement -> webElement.getText().contains(numberOfGPUs))
                .findAny()
                .get()
                .click();
    }

    public void setNumberOfLocalSSDs(String localSSDs) {
        WebElement listNumberOfLocalSSDs = driver.findElement(numberOfLocalSSDsListOpenBy);
        listNumberOfLocalSSDs.click();
        List<WebElement> options = driver.findElements(numberOfLocalSSDsOptionsBy);
        options.stream()
                .filter(webElement -> webElement.getText().contains(localSSDs))
                .findAny()
                .get()
                .click();
    }

    public void setRegion(String region) {
        WebElement listRegionButton = driver.findElement(regionsListButtonBy);
        listRegionButton.click();
        List<WebElement> listRegion = driver.findElements(regionsOptionsBy);
        listRegion.stream()
                .filter(webElement -> webElement.getText().contains(region))
                .findAny()
                .get()
                .click();
    }

    public void setCommittedUsage(String committedUsage) {
        String xpath = String.format("//label[text()='%s']", committedUsage);
        WebElement committedUsageElement = driver.findElement(By.xpath(xpath));
        committedUsageElement.click();
    }

    public String getTotalEstimatedCost() {
        waitUntilCostStable();
        WebElement totalEstimatedCost = driver.findElement(totalEstimatedCostBy);
        return totalEstimatedCost.getText();
    }

    public SummaryPage openEstimateSummaryPage() {
        clickShare();
        clickOpenEstimateSummary();
        for (String window : driver.getWindowHandles()) {
            if(!window.equals(driver.getWindowHandle())){
                driver.switchTo().window(window);
                break;
            }
        }
        return new SummaryPage(driver);
    }

    public void clickShare() {
        waitUntilCostStable();
        WebElement shareButton = driver.findElement(shareButtonBy);
        shareButton.click();
    }

    public void waitUntilCostStable(){
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.invisibilityOfElementLocated(costBy));
    }

    public void clickOpenEstimateSummary() {
        WebElement shareButton = driver.findElement(openEstimateSummaryBy);
        shareButton.click();
    }
}

