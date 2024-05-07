package com.epam.training.student_anton_lapushenko.WebDriver.Task3.page;

import com.epam.training.student_anton_lapushenko.WebDriver.Task3.enums.GPUModels;
import com.epam.training.student_anton_lapushenko.WebDriver.Task3.enums.NumberOfGPUs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class GoogleCloudCalculatorPage {
    WebDriver driver;

    public GoogleCloudCalculatorPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By addToEstimateButtonBy = By.className("UywwFc-vQzf8d");
    private final By computerEngineBy = By.xpath("(//*[@class='VobRQb'])[1]");

    public void addComputerEngineToEstimate(){
        WebElement estimateButton = driver.findElement(addToEstimateButtonBy);
        estimateButton.click();
//        new WebDriverWait(driver, Duration.ofSeconds(10))
//                .until(ExpectedConditions
//                        .elementToBeClickable(computerEngineBy)).click();
        WebElement computerEngineButton = driver.findElement(computerEngineBy);
        computerEngineButton.click();
    }

    private final By countInstancesBy = By.xpath("(//*[@class='qdOxv-fmcmS-yrriRe qdOxv-fmcmS-yrriRe-OWXEXe-INsAgc qdOxv-fmcmS-yrriRe-OWXEXe-di8rgd-V67aGc qdOxv-fmcmS-yrriRe-OWXEXe-V67aGc-NLUYnc'])[1]");

    public void setInstances(int instances){
        WebElement countInstances = driver.findElement(countInstancesBy);
        countInstances.sendKeys(String.valueOf(instances));
    }

    private final By operatingSoftwareOpenListBy = By.id("c21");
    private final By freeOperatingSoftwareBy = By.xpath("//li//*[contains(text(),'Free')]");

    public void setFreeOperatingSoftware(){
        WebElement operatingSoftwareList = driver.findElement(operatingSoftwareOpenListBy);
        operatingSoftwareList.click();
        WebElement freeOperatingSoftware = driver.findElement(freeOperatingSoftwareBy);
        freeOperatingSoftware.click();
    }

    private final By provisioningModelRegularBy = By.xpath("//*[@class='zT2df' and text()='Regular']");

    public void setProvisioningModelRegular(){
        WebElement provisioningModelRegular = driver.findElement(provisioningModelRegularBy);
        provisioningModelRegular.click();
    }

    private final By machineFamilyListBy = By.id("c25");
    private final By machineFamilyGeneralPurposeBy = By.xpath("//li//*[contains(text(),'General Purpose')]");

    public void setMachineFamily(){
        WebElement machineFamilyList = driver.findElement(machineFamilyListBy);
        machineFamilyList.click();
        WebElement machineFamilyGeneralPurpose = driver.findElement(machineFamilyGeneralPurposeBy);
        machineFamilyGeneralPurpose.click();
    }

    private final By seriasListBy = By.id("c29");
    private final By seriasN1By = By.xpath("//li//*[contains(text(),'N1')]");

    public void setSeries(){
        WebElement seriesList = driver.findElement(seriasListBy);
        seriesList.click();
        WebElement seriesN1 = driver.findElement(seriasN1By);
        seriesN1.click();
    }

    private final By machineTypeListBy = By.xpath("(//*[@class='VfPpkd-O1htCb VfPpkd-O1htCb-OWXEXe-INsAgc VfPpkd-O1htCb-OWXEXe-ztc6md FkS5nd'])[2]");
    private final By machineTypeN1_8By = By.xpath("//li//*[contains(text(),'n1-standard-8')]");

    public void setMachineType(){
        WebElement machineTypeList = driver.findElement(machineTypeListBy);
        machineTypeList.click();
        WebElement machineTypeN1_8 = driver.findElement(machineTypeN1_8By);
        machineTypeN1_8.click();
    }

    public void addGPUs(GPUModels gpuModel, NumberOfGPUs numberOfGPUs, int localSSD){
        turnOnAddGPUs();
        setGPUModel(gpuModel);
        setNumberOfGPUs(numberOfGPUs);
//        setNumberOfLocalSSDs();
    }

    private final By checkboxAddGPUsBy = By.xpath("(//*[@class='MSEcuf']//*[@class='eBlXUe-scr2fc eBlXUe-scr2fc-OWXEXe-uqeOfd'])[3]");

    private void turnOnAddGPUs(){
        WebElement checkboxAddGPUs = driver.findElement(checkboxAddGPUsBy);
        checkboxAddGPUs.click();
    }

    private final By GPUModelListBy = By.xpath("//*[@class='VfPpkd-TkwUic VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe VfPpkd-ksKsZd-mWPk3d']");
    private final By optionalsGPUModelsBy = By.xpath("//*[@class='VfPpkd-xl07Ob-XxIAqe VfPpkd-xl07Ob-XxIAqe-OWXEXe-tsQazb VfPpkd-xl07Ob VfPpkd-YPmvEd IWDrLe VfPpkd-xl07Ob-XxIAqe-OWXEXe-uxVfW-FNFY6c-uFfGwd VfPpkd-xl07Ob-XxIAqe-OWXEXe-FNFY6c']//li");

    private void setGPUModel(GPUModels gpuModel){
        WebElement GPUModelList = driver.findElement(GPUModelListBy);
        GPUModelList.click();
        List<WebElement> options = driver.findElements(optionalsGPUModelsBy);
        options.get(gpuModel.ordinal()).click();
    }

    private final By listNumberOfGPUs = By.xpath("//*[@class='VfPpkd-TkwUic VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe VfPpkd-ksKsZd-mWPk3d']");
    private final By optionalsNumberOfGPUs = By.xpath("//*[@class='VfPpkd-xl07Ob-XxIAqe VfPpkd-xl07Ob-XxIAqe-OWXEXe-tsQazb VfPpkd-xl07Ob VfPpkd-YPmvEd IWDrLe VfPpkd-xl07Ob-XxIAqe-OWXEXe-uxVfW-FNFY6c-uFfGwd VfPpkd-xl07Ob-XxIAqe-OWXEXe-FNFY6c']//li");

    private void setNumberOfGPUs(NumberOfGPUs numberOfGPUs){
        WebElement numberOfGPUsList = driver.findElement(listNumberOfGPUs);
        numberOfGPUsList.click();
        List<WebElement> options = driver.findElements(optionalsNumberOfGPUs);
        options.get(numberOfGPUs.ordinal()).click();
    }

    private final By listNumberOfLocalSSDsBy = By.xpath("//*[@class='VfPpkd-TkwUic VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe VfPpkd-ksKsZd-mWPk3d']");
    private void setNumberOfLocalSSDs(int localSSDs){

    }
}

