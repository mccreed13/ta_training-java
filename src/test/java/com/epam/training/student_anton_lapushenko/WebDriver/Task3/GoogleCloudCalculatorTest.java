package com.epam.training.student_anton_lapushenko.WebDriver.Task3;

import com.epam.training.student_anton_lapushenko.WebDriver.Task3.enums.GPUModels;
import com.epam.training.student_anton_lapushenko.WebDriver.Task3.enums.NumberOfGPUs;
import com.epam.training.student_anton_lapushenko.WebDriver.Task3.page.GoogleCloudCalculatorPage;
import com.epam.training.student_anton_lapushenko.WebDriver.Task3.page.GoogleCloudMainPage;
import com.epam.training.student_anton_lapushenko.WebDriver.Task3.page.GoogleCloudSearchPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GoogleCloudCalculatorTest extends BaseTest{

    @BeforeEach
    public void navigate() {
        driver.get("https://cloud.google.com/");
    }


    @Test
    public void testGoogleCloudCalculator(){
        GoogleCloudMainPage mainPage = new GoogleCloudMainPage(driver);
        GoogleCloudSearchPage googleCloudSearchPage = mainPage.searchCalculator();
        GoogleCloudCalculatorPage cloudCalculatorPage = googleCloudSearchPage.openCalculator();
        cloudCalculatorPage.setFreeOperatingSoftware();
        cloudCalculatorPage.setMachineFamily();
        cloudCalculatorPage.setSeries();
    }

    @Test
    public void testGoogleCalculator(){
        driver.get("https://cloud.google.com/products/calculator");
        GoogleCloudCalculatorPage calculatorPage = new GoogleCloudCalculatorPage(driver);
        calculatorPage.addComputerEngineToEstimate();
        calculatorPage.setInstances(4);
        calculatorPage.setFreeOperatingSoftware();
        calculatorPage.setProvisioningModelRegular();
        calculatorPage.setMachineFamily();
        calculatorPage.setSeries();
        calculatorPage.setMachineType();
        calculatorPage.addGPUs(GPUModels.TESLA_P100, NumberOfGPUs.ONE, 1);
    }
}
