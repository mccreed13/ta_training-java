package com.epam.training.student_anton_lapushenko.Framework.Task1.service;


import com.epam.training.student_anton_lapushenko.Framework.Task1.model.ComputerEngine;

public class ComputerEngineCreator {
     public static final String INSTANCES = "testdata.instances";
     public static final String OPERATING_SOFTWARE = "testdata.operating.software";
     public static final String PROVISIONING_MODEL = "testdata.provisioning.model";
     public static final String MACHINE_FAMILY = "testdata.machine.family";
     public static final String SERIES = "testdata.series";
     public static final String MACHINE_TYPE = "testdata.machine.type";
     public static final String GPU_MODEL = "testdata.GPU.model";
     public static final String NUMBER_OF_GPUS = "testdata.number_of_gpus";
     public static final String LOCAL_SSD = "testdata.localSSD";
     public static final String LOCATION = "testdata.location";
     public static final String COMMITED_USAGE = "testdata.commited_usage";
     public static final String TOTAL_COST = "testdata.totalcost";

    public static ComputerEngine withCredentialFromProperty() {
        return new ComputerEngine(TestDataReader.getTestData(INSTANCES), TestDataReader.getTestData(OPERATING_SOFTWARE), TestDataReader.getTestData(PROVISIONING_MODEL),
                TestDataReader.getTestData(MACHINE_FAMILY), TestDataReader.getTestData(SERIES), TestDataReader.getTestData(MACHINE_TYPE), TestDataReader.getTestData(GPU_MODEL), TestDataReader.getTestData(NUMBER_OF_GPUS),
                TestDataReader.getTestData(LOCAL_SSD), TestDataReader.getTestData(LOCATION), TestDataReader.getTestData(COMMITED_USAGE), TestDataReader.getTestData(TOTAL_COST));
    }

    public static ComputerEngine withEmptyGPU() {
        return new ComputerEngine(TestDataReader.getTestData(INSTANCES), TestDataReader.getTestData(OPERATING_SOFTWARE), TestDataReader.getTestData(PROVISIONING_MODEL),
                TestDataReader.getTestData(MACHINE_FAMILY), TestDataReader.getTestData(SERIES), TestDataReader.getTestData(MACHINE_TYPE), null, null,
                TestDataReader.getTestData(LOCAL_SSD), TestDataReader.getTestData(LOCATION), TestDataReader.getTestData(COMMITED_USAGE), TestDataReader.getTestData(TOTAL_COST));
    }

    public static ComputerEngine empty() {
        return new ComputerEngine();
    }
}
