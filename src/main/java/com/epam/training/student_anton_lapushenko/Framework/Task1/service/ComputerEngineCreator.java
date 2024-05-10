package com.epam.training.student_anton_lapushenko.Framework.Task1.service;

import com.epam.training.student_anton_lapushenko.Framework.Task1.enums.GPUModels;
import com.epam.training.student_anton_lapushenko.Framework.Task1.enums.LocalSSD;
import com.epam.training.student_anton_lapushenko.Framework.Task1.enums.NumberOfGPUs;
import com.epam.training.student_anton_lapushenko.Framework.Task1.model.ComputerEngine;

public class ComputerEngineCreator {
//     public static final int INSTANCES = 4;
//     public static final String OPERATING_SOFTWARE = "Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)";
//     public static final String PROVISIONING_MODEL = "Regular";
//     public static final String MACHINE_FAMILY = "General Purpose";
//     public static final String SERIES = "N1";
//     public static final String MACHINE_TYPE = "n1-standard-8";
//     public static final GPUModels GPU_MODEL = GPUModels.TESLA_V100;
//     public static final NumberOfGPUs NUMBER_OF_GPUS = NumberOfGPUs.ONE;
//     public static final LocalSSD LOCAL_SSD = LocalSSD.TWOx375GB;
//     public static final String LOCATION = "Iowa (us-central1)";
//     public static final String COMMITED_USAGE = "1 year";
//     public static final String TOTAL_COST = "$5,413.26";
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

//    public static ComputerEngine withCredentialFromProperty() {
//        return new ComputerEngine(INSTANCES, OPERATING_SOFTWARE, PROVISIONING_MODEL,
//                MACHINE_FAMILY, SERIES, MACHINE_TYPE, GPU_MODEL, NUMBER_OF_GPUS, LOCAL_SSD, LOCATION, COMMITED_USAGE, TOTAL_COST);
//    }
    public static ComputerEngine withCredentialFromProperty() {
        return new ComputerEngine(TestDataReader.getTestData(INSTANCES), TestDataReader.getTestData(OPERATING_SOFTWARE), TestDataReader.getTestData(PROVISIONING_MODEL),
                TestDataReader.getTestData(MACHINE_FAMILY), TestDataReader.getTestData(SERIES), TestDataReader.getTestData(MACHINE_TYPE), TestDataReader.getTestData(GPU_MODEL), TestDataReader.getTestData(NUMBER_OF_GPUS),
                TestDataReader.getTestData(LOCAL_SSD), TestDataReader.getTestData(LOCATION), TestDataReader.getTestData(COMMITED_USAGE), TestDataReader.getTestData(TOTAL_COST));
    }

    public static ComputerEngine withEmptyGPU() {
        return new ComputerEngine(INSTANCES, OPERATING_SOFTWARE, PROVISIONING_MODEL,
                MACHINE_FAMILY, SERIES, MACHINE_TYPE, null, null, LOCAL_SSD, LOCATION, COMMITED_USAGE, "$852.22");
    }

    public static ComputerEngine empty() {
        return new ComputerEngine();
    }
}
