package com.epam.training.student_anton_lapushenko.Framework.Task1;

import com.epam.training.student_anton_lapushenko.Framework.Task1.model.ComputerEngine;
import com.epam.training.student_anton_lapushenko.Framework.Task1.page.GoogleCloudCalculatorPage;
import com.epam.training.student_anton_lapushenko.Framework.Task1.page.GoogleCloudMainPage;

import com.epam.training.student_anton_lapushenko.Framework.Task1.page.SummaryPage;
import com.epam.training.student_anton_lapushenko.Framework.Task1.service.ComputerEngineCreator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class GoogleCloudCalculatorTest extends CommonConditions{

    @BeforeEach
    public void manage() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testFindCalculatorFromMain(){
        new GoogleCloudMainPage(driver)
                .openPage()
                .searchCalculator()
                .openCalculator();
        assertEquals(GoogleCloudCalculatorPage.getPageURL(), driver.getCurrentUrl());
    }

    @Test
    public void testCalculatorTotalCost(){
        ComputerEngine computerEngine = ComputerEngineCreator.withCredentialFromProperty();
        GoogleCloudCalculatorPage calculatorPage = new GoogleCloudCalculatorPage(driver)
                .openPage();
        calculatorPage.setComputerEngine(computerEngine);
        assertEquals(computerEngine.getTotalCost(), calculatorPage.getTotalEstimatedCost());
    }

    @Test
    public void testSummaryPageOfCalculator(){
        ComputerEngine computerEngine = ComputerEngineCreator.withCredentialFromProperty();
        GoogleCloudCalculatorPage calculatorPage = new GoogleCloudMainPage(driver)
                .openPage()
                .searchCalculator()
                .openCalculator();
        calculatorPage.setComputerEngine(computerEngine);
        SummaryPage summaryPage = calculatorPage.openEstimateSummaryPage();
        assertEquals(computerEngine.getInstances(), summaryPage.getInstanceNumber());
        assertEquals(computerEngine.getGpuModel(), summaryPage.getGPUType());
        assertEquals(computerEngine.getNumberOfGPUs(), summaryPage.getNumberOfGPU());
        assertEquals(computerEngine.getLocalSSD(), summaryPage.getLocalSSD());
        assertEquals(computerEngine.getLocation(), summaryPage.getLocation());
        assertEquals(computerEngine.getOperatingSoftware(), summaryPage.getOperatingSystem());
        assertEquals(computerEngine.getProvisioningModel(), summaryPage.getProvisioningModel());
        assertEquals(computerEngine.getMachineType(), summaryPage.getMachineType());
        assertEquals(computerEngine.getCommitedUsage(), summaryPage.getCommitedUsage());
    }
}
