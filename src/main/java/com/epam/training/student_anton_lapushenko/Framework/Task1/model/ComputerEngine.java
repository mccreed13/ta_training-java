package com.epam.training.student_anton_lapushenko.Framework.Task1.model;

import com.epam.training.student_anton_lapushenko.Framework.Task1.enums.LocalSSD;
import com.epam.training.student_anton_lapushenko.Framework.Task1.enums.NumberOfGPUs;

public class ComputerEngine {
    private String instances;
    private String operatingSoftware;
    private String provisioningModel;
    private String machineFamily;
    private String series;
    private String machineType;
    private String gpuModel;
    private String numberOfGPUs;
    private String localSSD;
    private String location;
    private String commitedUsage;
    private String totalCost;

    public ComputerEngine() {
    }

    public ComputerEngine(String instances, String operatingSoftware, String provisioningModel, String machineFamily, String series, String machineType, String gpuModel, String numberOfGPUs, String localSSD, String location, String commitedUsage, String totalCost) {
        this.instances = instances;
        this.operatingSoftware = operatingSoftware;
        this.provisioningModel = provisioningModel;
        this.machineFamily = machineFamily;
        this.series = series;
        this.machineType = machineType;
        this.gpuModel = gpuModel;
        this.numberOfGPUs = numberOfGPUs;
        this.localSSD = localSSD;
        this.location = location;
        this.commitedUsage = commitedUsage;
        this.totalCost = totalCost;
    }

    public String getInstances() {
        return instances;
    }

    public void setInstances(String instances) {
        this.instances = instances;
    }

    public String getOperatingSoftware() {
        return operatingSoftware;
    }

    public void setOperatingSoftware(String operatingSoftware) {
        this.operatingSoftware = operatingSoftware;
    }

    public String getProvisioningModel() {
        return provisioningModel;
    }

    public void setProvisioningModel(String provisioningModel) {
        this.provisioningModel = provisioningModel;
    }

    public String getMachineFamily() {
        return machineFamily;
    }

    public void setMachineFamily(String machineFamily) {
        this.machineFamily = machineFamily;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public String getGpuModel() {
        return gpuModel;
    }

    public void setGpuModel(String gpuModel) {
        this.gpuModel = gpuModel;
    }

    public String getNumberOfGPUs() {
        return numberOfGPUs;
    }

    public void setNumberOfGPUs(String numberOfGPUs) {
        this.numberOfGPUs = numberOfGPUs;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    public void setLocalSSD(String localSSD) {
        this.localSSD = localSSD;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCommitedUsage() {
        return commitedUsage;
    }

    public void setCommitedUsage(String commitedUsage) {
        this.commitedUsage = commitedUsage;
    }

    public String getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(String totalCost) {
        this.totalCost = totalCost;
    }
}
