package com.david.corp.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features = {"src/test/resources/features/"},
        glue = "com.david.corp.step_definitions",
        plugin = {"pretty", "json:target/cucumber-reports/Cucumber.json",
                "testng:target/cucumber-reports/Cucumber.xml", "html:target/cucumber-reports"}

)

public class RunAllTests extends AbstractTestNGCucumberTests {

}
