package com.david.corp.step_definitions;

import java.util.ResourceBundle;

public class ReadPropertiesFile {

    private static ResourceBundle rb = ResourceBundle.getBundle("cucumber-test");

    public static String getProperty(String propertyName) {
        return rb.getString(propertyName);
    }

}
