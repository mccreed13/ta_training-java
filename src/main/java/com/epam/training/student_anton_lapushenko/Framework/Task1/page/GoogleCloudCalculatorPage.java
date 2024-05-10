package com.epam.training.student_anton_lapushenko.Framework.Task1.page;

import com.epam.training.student_anton_lapushenko.Framework.Task1.enums.GPUModels;
import com.epam.training.student_anton_lapushenko.Framework.Task1.enums.LocalSSD;
import com.epam.training.student_anton_lapushenko.Framework.Task1.enums.NumberOfGPUs;
import com.epam.training.student_anton_lapushenko.Framework.Task1.model.ComputerEngine;
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

    private final By addToEstimateButtonBy = By.xpath("//span[contains(text(), 'Add to estimate')]");
    private final By computerEngineBy = By.xpath("//div[@class='VobRQb' and contains(.,'Compute Engine')]");
    private final By countInstancesBy = By.id("c11");
    private final By operatingSoftwareOpenListBy = By.xpath("//div[@class='qUa9tb' and contains(.,'Operating System / Software')]//div[@class='VfPpkd-aPP78e']");
    private final By freeOperatingSoftwareBy = By.xpath("//li[contains(.,'Free: Debian')]");
    private final By operatingSoftwareListBy = By.xpath("//ul[@aria-label='Operating System / Software']");
    private final By provisioningModelRegularBy = By.xpath("//*[@class='zT2df' and text()='Regular']");
    private final By machineFamilyOpenListBy = By.xpath("//div[@class='O1htCb-H9tDt PPUDSe t8xIwc' and contains(.,'Machine Family')]//div[@class='VfPpkd-aPP78e']");
    private final By machineFamilyListBy = By.xpath("//ul[@aria-label='Machine Family']");
    private final By machineFamilyGeneralPurposeBy = By.xpath("//li[contains(.,'General Purpose')]");
    private final By seriasListOpenBy = By.xpath("//div[@class='O1htCb-H9tDt PPUDSe t8xIwc' and contains(.,'Series')]//div[@class='VfPpkd-aPP78e']");
    private final By seriasListBy = By.xpath("//ul[@aria-label='Series']");
    private final By seriasN1By = By.xpath("//li[contains(.,'N1')]");
    private final By machineTypeListOpenBy = By.xpath("//div[@class='O1htCb-H9tDt PPUDSe t8xIwc' and contains(.,'Machine type')]//div[@class='VfPpkd-aPP78e']");
    private final By machineTypeListBy = By.xpath("//ul[@aria-label='Machine type']");
    private final By machineTypeN1_8By = By.xpath("//li[contains(.,'n1-standard-8')]");
    private final By checkboxAddGPUsBy = By.xpath("//button[@aria-label='Add GPUs']");
    private final By GPUModelListBy = By.xpath("//div[@class='qUa9tb' and contains(.,'GPU Model')]//div[@class='VfPpkd-aPP78e']");
    private final By optionalsGPUModelsBy = By.xpath("//ul[@aria-label='GPU Model']/li");
    private final By numberOfGPUsListBy = By.xpath("//div[@class='qUa9tb' and contains(.,'Number of GPUs')]//div[@class='VfPpkd-aPP78e']");
    private final By optionalsNumberOfGPUsBy = By.xpath("//ul[@aria-label='Number of GPUs']/li");
    private final By numberOfLocalSSDsListOpenBy = By.xpath("//div[@class='qUa9tb' and contains(.,'Local SSD')]//div[@class='VfPpkd-aPP78e']");
    private final By numberOfLocalSSDsListBy = By.xpath("//ul[@aria-label='Machine type']");
    private final By optionalsNumberOfLocalSSDsBy = By.xpath("//ul[@aria-label='Local SSD']/li");
    private final By regionsListButtonBy = By.xpath("//div[@class='qUa9tb' and contains(.,'Region')]//div[@class='VfPpkd-aPP78e']");
    private final By regionsListBy = By.xpath("//ul[@aria-label='Region']");
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
    }

    public void addComputerEngineToEstimate() {
        WebElement estimateButton = driver.findElement(addToEstimateButtonBy);
        estimateButton.click();
        WebElement computerEngineButton = driver.findElement(computerEngineBy);
        computerEngineButton.click();
    }

    public void setInstances(int instances) {
        WebElement countInstances = driver.findElement(countInstancesBy);
        countInstances.clear();
        countInstances.sendKeys(String.valueOf(instances));
    }

    public void setInstances(String instances) {
        WebElement countInstances = driver.findElement(countInstancesBy);
        countInstances.clear();
        countInstances.sendKeys(instances);
    }

    public void setFreeOperatingSoftware() {
        WebElement operatingSoftwareListButton = driver.findElement(operatingSoftwareOpenListBy);
        operatingSoftwareListButton.click();
        WebElement freeOperatingSoftware = driver.findElement(freeOperatingSoftwareBy);
        freeOperatingSoftware.click();
    }

    public void setOperatingSoftware(String operatingSoftware){
        WebElement operatingSoftwareListButton = driver.findElement(operatingSoftwareOpenListBy);
        operatingSoftwareListButton.click();
        WebElement operatingSoftwareList = driver.findElement(operatingSoftwareListBy);
        String xpath = String.format("//li[contains(.,'%s')]", operatingSoftware);
        operatingSoftwareList.findElement(By.xpath(xpath)).click();
    }

    public void setProvisioningModelRegular() {
        WebElement provisioningModelRegular = driver.findElement(provisioningModelRegularBy);
        provisioningModelRegular.click();
    }

    public void setProvisioningModel(String provisioningModel) {
        String xpath = String.format("//*[@class='zT2df' and text()='%s']", provisioningModel);
        WebElement provisioningModelElement = driver.findElement(By.xpath(xpath));
        provisioningModelElement.click();
    }

    public void setMachineFamilyGeneralPurpose() {
        WebElement machineFamilyList = driver.findElement(machineFamilyOpenListBy);
        machineFamilyList.click();
        WebElement machineFamilyGeneralPurpose = driver.findElement(machineFamilyGeneralPurposeBy);
        machineFamilyGeneralPurpose.click();
    }

    public void setMachineFamily(String machineFamily) {
        WebElement machineFamilyListButton = driver.findElement(machineFamilyOpenListBy);
        machineFamilyListButton.click();
        WebElement machineFamilyList = driver.findElement(machineFamilyListBy);
        String xpath = String.format("//li[contains(.,'%s')]", machineFamily);
        machineFamilyList.findElement(By.xpath(xpath)).click();
    }

    public void setSeriesN1() {
        WebElement seriesList = driver.findElement(seriasListOpenBy);
        seriesList.click();
        WebElement seriesN1 = driver.findElement(seriasN1By);
        seriesN1.click();
    }

    public void setSeries(String series) {
        WebElement seriesListButton = driver.findElement(seriasListOpenBy);
        seriesListButton.click();
        WebElement seriesList = driver.findElement(seriasListBy);
        String xpath = String.format("//li[contains(.,'%s')]", series);
        seriesList.findElement(By.xpath(xpath)).click();
    }

    public void setMachineTypeN1Standard8() {
        WebElement machineTypeList = driver.findElement(machineTypeListOpenBy);
        machineTypeList.click();
        WebElement machineTypeN1 = driver.findElement(machineTypeN1_8By);
        machineTypeN1.click();
    }

    public void setMachineType(String machineType) {
        WebElement machineTypeListButton = driver.findElement(machineTypeListOpenBy);
        machineTypeListButton.click();
        WebElement machineTypeList = driver.findElement(machineTypeListBy);
        String xpath = String.format("//li[contains(.,'%s')]", machineType);
        machineTypeList.findElement(By.xpath(xpath)).click();
    }

    public void addGPUs(GPUModels gpuModel, NumberOfGPUs numberOfGPUs) {
        turnOnAddGPUs();
        setGPUModel(gpuModel);
        setNumberOfGPUs(numberOfGPUs);
    }

    private void turnOnAddGPUs() {
        WebElement addGPUsButton = driver.findElement(checkboxAddGPUsBy);
        addGPUsButton.click();
    }

    private void setGPUModel(GPUModels gpuModel) {
        WebElement gpuModelList = driver.findElement(GPUModelListBy);
        gpuModelList.click();
        List<WebElement> options = driver.findElements(optionalsGPUModelsBy);
        options.get(gpuModel.ordinal()).click();
    }

    private void setNumberOfGPUs(NumberOfGPUs numberOfGPUs) {
        WebElement numberOfGPUsList = driver.findElement(numberOfGPUsListBy);
        numberOfGPUsList.click();
        List<WebElement> options = driver.findElements(optionalsNumberOfGPUsBy);
        options.get(numberOfGPUs.ordinal()).click();
    }

    public void setNumberOfLocalSSDs(LocalSSD localSSDs) {
        WebElement listNumberOfLocalSSDs = driver.findElement(numberOfLocalSSDsListOpenBy);
        listNumberOfLocalSSDs.click();
        List<WebElement> options = driver.findElements(optionalsNumberOfLocalSSDsBy);
//        options.stream().filter(webElement -> webElement.getText().equals("22")).findAny().get().click();
        options.get(localSSDs.ordinal()).click();
    }

    public void setNumberOfLocalSSDs(String localSSDs) {
        WebElement listNumberOfLocalSSDsButton = driver.findElement(numberOfLocalSSDsListOpenBy);
        listNumberOfLocalSSDsButton.click();
        WebElement listNumberOfLocalSSDs = driver.findElement(numberOfLocalSSDsListBy);
        String xpath = String.format("//li[contains(.,'%s')]", localSSDs);
        listNumberOfLocalSSDs.findElement(By.xpath(xpath)).click();

    }

    public void setRegion(String region) {
        WebElement listRegionButton = driver.findElement(regionsListButtonBy);
        listRegionButton.click();
        WebElement listRegion = driver.findElement(regionsListBy);
        String xpath = String.format("//li[contains(.,'%s')]", region);
        listRegion.findElement(By.xpath(xpath)).click();
    }

    public void setCommittedUsageOneYear() {
        WebElement committedUsageOneYear = driver.findElement(committedUsageOneYearBy);
        committedUsageOneYear.click();
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

