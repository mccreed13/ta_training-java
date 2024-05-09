package com.epam.training.student_anton_lapushenko.WebDriver.Task3;

import com.epam.training.student_anton_lapushenko.WebDriver.Task3.enums.GPUModels;
import com.epam.training.student_anton_lapushenko.WebDriver.Task3.enums.LocalSSD;
import com.epam.training.student_anton_lapushenko.WebDriver.Task3.enums.NumberOfGPUs;
import com.epam.training.student_anton_lapushenko.WebDriver.Task3.enums.Regions;
import com.epam.training.student_anton_lapushenko.WebDriver.Task3.page.GoogleCloudCalculatorPage;
import com.epam.training.student_anton_lapushenko.WebDriver.Task3.page.SummaryPage;
import com.epam.training.student_anton_lapushenko.WebDriver.Task3.steps.EstimateSteps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoogleCloudCalculatorTest extends BaseTest {

    @BeforeEach
    public void navigate() {
        driver.get("https://cloud.google.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testGoogleCloudCalculator() {
        String totalEstimatedCostExpected = "$5,413.26";
        int instanceNumber = 4;
        GPUModels gpuModel = GPUModels.TESLA_V100;
        NumberOfGPUs numberOfGPUs = NumberOfGPUs.ONE;
        LocalSSD localSSD = LocalSSD.TWOx375GB;
        Regions region = Regions.Iowa;
        EstimateSteps estimateSteps = new EstimateSteps(driver);
        GoogleCloudCalculatorPage calculatorPage = estimateSteps.addParametersToEstimate(instanceNumber, gpuModel,
                numberOfGPUs, localSSD, region);
        assertEquals(totalEstimatedCostExpected, calculatorPage.getTotalEstimatedCost());

        SummaryPage summaryPage = estimateSteps.openEstimateSummary();
        String operationSystems = "Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)";
        String provisionModel = "Regular";
        String machineType = "n1-standard-8";
        String commitedUsage = "1 year";
        assertEquals(instanceNumber, summaryPage.getInstanceNumber());
        assertEquals(gpuModel, summaryPage.getGPUType());
        assertEquals(numberOfGPUs, summaryPage.getNumberOfGPU());
        assertEquals(localSSD, summaryPage.getLocalSSD());
        assertEquals(region, summaryPage.getLocation());
        assertEquals(operationSystems, summaryPage.getOperatingSystem());
        assertEquals(provisionModel, summaryPage.getProvisioningModel());
        assertEquals(machineType, summaryPage.getMachineType());
        assertEquals(commitedUsage, summaryPage.getCommitedUsage());
    }
}
