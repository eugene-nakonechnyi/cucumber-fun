package com.david.corp.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features = {"src/test/resources/features/LoginUITest.feature", "src/test/resources/features/ActionUITest.feature"},
        glue = "com.david.corp.step_definitions",
        tags = {"@Smoke"},
        plugin = {"pretty", "json:target/cucumber-reports/Cucumber.json",
                "testng:target/cucumber-reports/Cucumber.xml", "html:target/cucumber-reports"}

)

public class RunSmokeTests extends AbstractTestNGCucumberTests {

}