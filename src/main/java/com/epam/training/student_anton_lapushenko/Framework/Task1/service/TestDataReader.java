package com.epam.training.student_anton_lapushenko.Framework.Task1.service;

import java.util.ResourceBundle;

public class TestDataReader {
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("environment"));

    public static String getTestData(String key){
        return  resourceBundle.getString(key);
    }
}
